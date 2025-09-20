package com.example.Integrador.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UsuariosRoles {
// Identificador único de la relación usuario-rol (clave primaria) 
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	// Identificador del usuario asociado
	private int idUsuario;
	// Identificador del rol asociado
	private int idRol;
	
	// Métodos getter y setter para cada campo
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public int getIdRol() {
		return idRol;
	}
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	
	
}