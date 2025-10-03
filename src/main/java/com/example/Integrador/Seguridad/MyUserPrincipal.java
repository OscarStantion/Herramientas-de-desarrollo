package com.example.Integrador.Seguridad;


import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.Integrador.Entidades.Tecnico;

/**
 * Implementación personalizada de UserDetails para Spring Security.
 * Representa un usuario autenticado en el sistema con sus roles y credenciales.
 * Esta clase actúa como wrapper para la entidad Tecnico adaptándola al formato requerido por Spring Security.
 */
public class MyUserPrincipal implements UserDetails {
	
	/**
	 * El usuario técnico asociado a este principal.
	 */
	private Tecnico usuario;
	
	/**
	 * Lista de roles asignados al usuario.
	 */
	private List<String> roles;

	/**
	 * Constructor que inicializa el principal con un usuario técnico y sus roles.
	 * 
	 * @param usuario El técnico que será representado por este principal
	 * @param roles Lista de roles asignados al usuario
	 */
	public MyUserPrincipal(Tecnico usuario, List<String> roles) {
		this.usuario = usuario;
		this.roles = roles;
	}

	/**
	 * Obtiene la contraseña del usuario para autenticación.
	 * 
	 * @return La contraseña cifrada del técnico
	 */
	@Override
	public String getPassword() {
		return usuario.getContraseña();
	}

	/**
	 * Obtiene el nombre de usuario para identificación.
	 * En este caso retorna el nombre del técnico.
	 * 
	 * @return El nombre del técnico
	 */
	@Override
	public String getUsername() {
		return usuario.getNombre();
	}

	/**
	 * Obtiene las autoridades (roles) asignadas al usuario.
	 * Convierte la lista de roles en objetos GrantedAuthority que Spring Security puede usar
	 * para verificar permisos y autorización.
	 * 
	 * @return Colección de autoridades del usuario
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> lst = new ArrayList<GrantedAuthority>();
		for (String rol : roles) {
			lst.add(new SimpleGrantedAuthority(rol));
		}
		return lst;
	}
}

