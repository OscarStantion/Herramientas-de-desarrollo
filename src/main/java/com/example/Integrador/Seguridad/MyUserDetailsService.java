package com.example.Integrador.Seguridad;

import java.util.ArrayList;


import java.util.List;
// dependencias
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.Integrador.Entidades.Roles;
import com.example.Integrador.Entidades.Tecnico;
import com.example.Integrador.Entidades.UsuariosRoles;
import com.example.Integrador.Repositorios.TecnicoRepository;
import com.example.Integrador.Repositorios.UsuarioRolesRepository;
// Codigo de seguridad
public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	private TecnicoRepository usuariosRepository;
	@Autowired
	private RolesRepository rolesRepository;
	@Autowired
	private UsuarioRolesRepository urRepository;
	//carga de usuario y roles desde la base de datos
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Tecnico usuario = usuariosRepository.findByUsuario(username)
			    .orElseThrow(() -> new UsernameNotFoundException(username));
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		usuario.setContraseña("{noop}" + usuario.getContraseña());
		List<UsuariosRoles> lst = urRepository.findByIdUsuario(usuario.getId());
		List<String> roles = new ArrayList<String>();
		System.out.println("usuario: " + usuario.getNombre());
		for (UsuariosRoles ur : lst) {
			Roles rol = rolesRepository.findById(ur.getIdRol()).get();
			roles.add(rol.getNombre());
			System.out.println("rol: " + rol.getNombre());
		}
		return new MyUserPrincipal(usuario, roles);
	}
	//validacion de credenciales 
	
}