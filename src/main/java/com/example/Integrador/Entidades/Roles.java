package com.example.Integrador.Entidades;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Roles {

	@Id
	// Clave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
	// Nombre del rol
	private String nombre;
    
	// Obtener id
	public int getId() {
		return id;
	}

	// Asignar id
	public void setId(int id) {
		this.id = id;
	}

	// Obtener nombre
	public String getNombre() {
		return nombre;
	}

	// Asignar nombre
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
    
}
