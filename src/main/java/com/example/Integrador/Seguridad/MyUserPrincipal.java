package com.example.Integrador.Seguridad;


import java.util.ArrayList;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.Integrador.Entidades.Tecnico;

public class MyUserPrincipal implements UserDetails {
	
	private Tecnico usuario;
	private List<String> roles;

	public MyUserPrincipal(Tecnico usuario, List<String> roles) {
		this.usuario = usuario;
		this.roles = roles;
	}

	@Override
	public String getPassword() {
		return usuario.getContraseña();
	}

	@Override
	public String getUsername() {
		return usuario.getNombre();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> lst = new ArrayList<GrantedAuthority>();
		for (String rol : roles) {
			lst.add(new SimpleGrantedAuthority(rol));
		}
		return lst;
	}
}

