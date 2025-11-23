package com.example.Integrador.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Integrador.Entidades.PlanMantenimiento;
import com.example.Integrador.Entidades.RelacionMantenimiento;
import com.example.Integrador.Repositorios.PlanMantenimientoRepository;

// Servicio plan mantenimiento
public class PlanMantenimientoService {

	@Autowired
    // Repositorio planes
    private PlanMantenimientoRepository PlanMantenimiento;

	// Obtener último plan
	public PlanMantenimientoRepository obtenerUltimaplanMantenimiento() {
	        return (PlanMantenimientoRepository) PlanMantenimiento.findTopByOrderByIdDesc();
	    }
	
	 // Obtener todos
	 public List<PlanMantenimiento> obtenerTodos() {
	        return PlanMantenimiento.findAll();
	    }
}
