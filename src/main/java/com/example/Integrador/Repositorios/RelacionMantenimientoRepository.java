package com.example.Integrador.Repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Integrador.Entidades.RelacionMantenimiento;

public interface RelacionMantenimientoRepository extends JpaRepository<RelacionMantenimiento, Integer> {
    
    // Encuentra tareas pendientes para un técnico específico
    List<RelacionMantenimiento> findByIdTecnicoAndEstado(Integer idTecnico, String estado);
    
    // Encuentra tareas completadas para un técnico específico
    List<RelacionMantenimiento> findByIdTecnicoAndEstadoOrderByFechaSalidaDesc(Integer idTecnico, String estado);
    
    // Query personalizada para obtener datos completos con join
    @Query("SELECT r FROM RelacionMantenimiento r WHERE r.idTecnico = :idTecnico AND r.estado = :estado")
    List<RelacionMantenimiento> findTareasByTecnicoAndEstado(@Param("idTecnico") Integer idTecnico, @Param("estado") String estado);
	
	RelacionMantenimiento findTopByOrderByIdDesc();
}
