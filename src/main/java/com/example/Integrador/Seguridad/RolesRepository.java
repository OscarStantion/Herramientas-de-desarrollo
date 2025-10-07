package com.example.Integrador.Seguridad;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.Integrador.Entidades.Roles;

// Repositorio de roles
public interface RolesRepository extends JpaRepository<Roles, Integer> {
	// Métodos CRUD de roles
}
