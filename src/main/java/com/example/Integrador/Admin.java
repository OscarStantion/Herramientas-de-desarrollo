package com.example.Integrador;
// Clase que representa a un administrador del sistema
public class Admin implements UsuarioConCredenciales {
    private String usuario;
    private String contraseña;

    public Admin() {
    	
    }
    
    public Admin(String usuario, String contraseña) {
		this.usuario = usuario;
		this.contraseña = contraseña;
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


	@Override
    public String redirigir() {
        return "Inicio"; // Nombre de la vista o ruta
    }
}