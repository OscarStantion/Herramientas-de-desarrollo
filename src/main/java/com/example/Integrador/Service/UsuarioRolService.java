package com.example.Integrador.Service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.example.Integrador.Entidades.UsuariosRoles;
import com.example.Integrador.Repositorios.UsuarioRolesRepository;


@Service
// Servicio roles usuario
public class UsuarioRolService {
    @Autowired
    // Repositorio usuarios roles
    private UsuarioRolesRepository urRepository;

    public void crearUsuarioConRol(Integer a) {
    	// Crea usuario rol
    	UsuariosRoles u = new UsuariosRoles();
    	// Instancia UsuariosRoles
    	u.setIdUsuario(a);
    	u.setIdRol(1);
    	urRepository.save(u);
    }
}