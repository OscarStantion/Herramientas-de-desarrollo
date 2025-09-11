package com.example.Integrador.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Integrador.Entidades.PlanMantenimiento;
import com.example.Integrador.Entidades.RelacionMantenimiento;
import com.example.Integrador.Repositorios.PlanMantenimientoRepository;

public class PlanMantenimientoService {

	@Autowired
    private PlanMantenimientoRepository PlanMantenimiento;

	public PlanMantenimientoRepository obtenerUltimaplanMantenimiento() {
        return (PlanMantenimientoRepository) PlanMantenimiento.findTopByOrderByIdDesc();
    }
	
	 public List<PlanMantenimiento> obtenerTodos() {
	        return PlanMantenimiento.findAll();
	    }
}
