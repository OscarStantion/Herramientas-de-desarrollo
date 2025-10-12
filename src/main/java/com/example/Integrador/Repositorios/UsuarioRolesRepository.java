package com.example.Integrador.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Integrador.Entidades.UsuariosRoles;
// acceso a datos de la tabla usuarios_roles
public interface UsuarioRolesRepository extends JpaRepository<UsuariosRoles, Integer> {

	public List<UsuariosRoles> findByIdUsuario(int idUsuario);
	
	// Método para obtener el primer rol de un usuario (asumiendo un rol por usuario)
	public UsuariosRoles findFirstByIdUsuario(int idUsuario);
	
}