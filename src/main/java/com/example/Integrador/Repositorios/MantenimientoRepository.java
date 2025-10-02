package com.example.Integrador.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Integrador.Entidades.MantenimientoSeleccionado;

/**
 * Repositorio para la entidad MantenimientoSeleccionado.
 * Proporciona métodos para acceder y manipular datos de mantenimientos seleccionados en la base de datos.
 * Extiende JpaRepository para obtener operaciones CRUD básicas.
 */
public interface MantenimientoRepository extends JpaRepository<MantenimientoSeleccionado, Integer> {

	/**
	 * Encuentra el mantenimiento seleccionado con el ID más alto (el más recientemente agregado).
	 * Útil para obtener el último mantenimiento programado en el sistema.
	 * 
	 * @return El mantenimiento seleccionado con el ID más alto, o null si no hay mantenimientos
	 */
	MantenimientoRepository findTopByOrderByIdDesc();
	

}
