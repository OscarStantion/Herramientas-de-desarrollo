package com.example.Integrador.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Integrador.Entidades.Maquinaria;
import com.example.Integrador.Entidades.PlanMantenimiento;
import com.example.Integrador.Entidades.RelacionMantenimiento;
import com.example.Integrador.Entidades.Tecnico;
import com.example.Integrador.Repositorios.MaquinariaRepository;
import com.example.Integrador.Repositorios.PlanMantenimientoRepository;
import com.example.Integrador.Repositorios.RelacionMantenimientoRepository;
import com.example.Integrador.Repositorios.TecnicoRepository;

// Servicio para gestionar las operaciones relacionadas con los técnicos
@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    
    @Autowired
    private RelacionMantenimientoRepository relacionRepository;
    
    @Autowired
    private MaquinariaRepository maquinariaRepository;
    
    @Autowired
    private PlanMantenimientoRepository planRepository;

    public Tecnico buscarPorId(Integer id) {
        return tecnicoRepository.findById(id).get();
    }
    public Tecnico existeUsuarioCorreo(String correo) {
	    return tecnicoRepository.findByEmail(correo).orElse(null);
	}
    
public Tecnico guardar(Tecnico tecnico) {
    	
        return tecnicoRepository.save(tecnico);
    }
    public List<Tecnico> Cargar() {
    	return tecnicoRepository.findAll();
    }

	public void eliminar(Integer id) {
		tecnicoRepository.deleteById(id);
		
	}
	public boolean existeUsuario(String usuario) {
	    return tecnicoRepository.findByUsuario(usuario).isPresent();
	}
	
	// Obtener tareas pendientes para un técnico específico
    public List<Map<String, Object>> obtenerTareasPendientes(Integer idTecnico) {
        System.out.println("=== CONSULTANDO TAREAS PENDIENTES ===");
        System.out.println("ID Técnico: " + idTecnico);
        
        List<RelacionMantenimiento> relaciones = relacionRepository.findByIdTecnicoAndEstado(idTecnico, "PENDIENTE");
        System.out.println("Relaciones encontradas: " + relaciones.size());
        
        for (RelacionMantenimiento rel : relaciones) {
            System.out.println("Relación ID: " + rel.getId() + ", Maquinaria: " + rel.getIdMaquinaria() + 
                             ", Plan: " + rel.getIdPlan() + ", Estado: " + rel.getEstado());
        }
        
        List<Map<String, Object>> resultado = convertirAMapaTareas(relaciones, false);
        System.out.println("Tareas convertidas: " + resultado.size());
        System.out.println("=== FIN CONSULTA ===");
        
        return resultado;
    }
    
    // Obtener tareas completadas para un técnico específico
    public List<Map<String, Object>> obtenerTareasCompletadas(Integer idTecnico) {
        List<RelacionMantenimiento> relaciones = relacionRepository.findByIdTecnicoAndEstadoOrderByFechaSalidaDesc(idTecnico, "COMPLETADO");
        return convertirAMapaTareas(relaciones, true);
    }
    
    // Marcar una tarea como completada
    public boolean completarTarea(Integer idTarea) {
        Optional<RelacionMantenimiento> optionalRelacion = relacionRepository.findById(idTarea);
        if (optionalRelacion.isPresent()) {
            RelacionMantenimiento relacion = optionalRelacion.get();
            relacion.setEstado("COMPLETADO");
            relacion.setFechaSalida(LocalDate.now()); // Actualizar fecha de realización
            relacionRepository.save(relacion);
            return true;
        }
        return false;
    }
    
    // Método auxiliar para convertir RelacionMantenimiento a Map
    private List<Map<String, Object>> convertirAMapaTareas(List<RelacionMantenimiento> relaciones, boolean esCompletada) {
        List<Map<String, Object>> tareas = new ArrayList<>();
        
        for (RelacionMantenimiento relacion : relaciones) {
            // Obtener datos de la maquinaria
            Optional<Maquinaria> optionalMaquinaria = maquinariaRepository.findById(relacion.getIdMaquinaria());
            if (!optionalMaquinaria.isPresent()) continue;
            
            Maquinaria maquinaria = optionalMaquinaria.get();
            
            // Obtener datos del plan de mantenimiento
            Optional<PlanMantenimiento> optionalPlan = planRepository.findById(Long.valueOf(relacion.getIdPlan()));
            if (!optionalPlan.isPresent()) continue;
            
            PlanMantenimiento plan = optionalPlan.get();
            
            // Crear Map con los datos
            Map<String, Object> tarea = new HashMap<>();
            tarea.put("id", relacion.getId());
            tarea.put("idMaquinaria", relacion.getIdMaquinaria());
            tarea.put("maquina", maquinaria.getTipoMaquinaria());
            tarea.put("modelo", maquinaria.getModelo());
            tarea.put("tipoMantenimiento", plan.getNombre());
            tarea.put("estado", relacion.getEstado());
            
            if (esCompletada) {
                tarea.put("fechaRealizada", relacion.getFechaSalida());
            } else {
                tarea.put("fechaLimite", relacion.getFechaSalida());
            }
            
            tareas.add(tarea);
        }
        
        return tareas;
    }
    
    // Métodos adicionales segn lógica de negocio
}