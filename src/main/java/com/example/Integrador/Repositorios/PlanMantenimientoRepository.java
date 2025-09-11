package com.example.Integrador.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Integrador.Entidades.Maquinaria;
import com.example.Integrador.Entidades.PlanMantenimiento;

@Repository
public interface PlanMantenimientoRepository extends JpaRepository<PlanMantenimiento, Long> {
    // Aquí puedes agregar métodos personalizados si los necesitas
	 PlanMantenimiento findByNombre(String nombre);
	 PlanMantenimiento findTopByOrderByIdDesc();
}
