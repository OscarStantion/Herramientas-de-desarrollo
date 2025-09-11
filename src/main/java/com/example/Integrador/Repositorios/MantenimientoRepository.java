package com.example.Integrador.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Integrador.Entidades.MantenimientoSeleccionado;


public interface MantenimientoRepository extends JpaRepository<MantenimientoSeleccionado, Integer> {

	MantenimientoRepository findTopByOrderByIdDesc();
	

}
