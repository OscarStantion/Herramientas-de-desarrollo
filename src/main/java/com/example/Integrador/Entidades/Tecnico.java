package com.example.Integrador.Entidades;
import com.example.Integrador.UsuarioConCredenciales;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// Entidad técnico del sistema
@Entity
public class Tecnico implements UsuarioConCredenciales{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; // ID único
	
    private String nombre; // Nombre del técnico
    private String apellido; // Apellido del técnico
    private String usuario; // Usuario para login
    private String contraseña; // Contraseña de acceso
    private String especialidad; // Área de especialización
    private String telefono; // Número de contacto
    private String email; // Correo electrónico // Correo electrónico

    // Constructor vacío
    public Tecnico() {
    	
    }
    // Constructor para login
    public Tecnico(String usuario, String contraseña) {
    	this.usuario=usuario;
    	this.contraseña=contraseña;
    }
    
	// Constructor completo
	public Tecnico(String nombre, String apellido, String usuario, String contraseña, String especialidad,
			String telefono, String email) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.contraseña = contraseña;
		this.especialidad = especialidad;
		this.telefono = telefono;
		this.email = email;
	}
	
    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	// Redirecciona al menú técnico
	@Override
    public String redirigir() {
		 return "menu-trabjador";
	}
	

}