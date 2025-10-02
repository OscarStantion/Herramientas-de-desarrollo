package com.example.Integrador.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Integrador.Entidades.Maquinaria;

/**
 * Repositorio para la entidad Maquinaria.
 * Proporciona métodos para acceder y manipular datos de maquinarias en la base de datos.
 * Extiende JpaRepository para obtener operaciones CRUD básicas.
 */
public interface MaquinariaRepository extends JpaRepository<Maquinaria, Integer> {

	/**
	 * Encuentra la maquinaria con el ID más alto (la más recientemente agregada).
	 * Útil para obtener la última maquinaria registrada en el sistema.
	 * 
	 * @return La maquinaria con el ID más alto, o null si no hay maquinarias
	 */
	Maquinaria findTopByOrderByIdDesc();

}
