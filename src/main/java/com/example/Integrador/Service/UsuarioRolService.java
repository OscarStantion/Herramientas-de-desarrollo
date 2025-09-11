package com.example.Integrador.Service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.example.Integrador.Entidades.UsuariosRoles;
import com.example.Integrador.Repositorios.UsuarioRolesRepository;


@Service
public class UsuarioRolService {
    @Autowired
    private UsuarioRolesRepository urRepository;

    public void crearUsuarioConRol(Integer a) {
    	UsuariosRoles u = new UsuariosRoles();	
    	u.setIdUsuario(a);
    	u.setIdRol(1);   	
    	urRepository.save(u);
    }
}