package com.example.Integrador.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Integrador.DTOs.HistorialPagoDTO;
import com.example.Integrador.Entidades.Maquinaria;
import com.example.Integrador.Entidades.PlanMantenimiento;
import com.example.Integrador.Entidades.RelacionMantenimiento;
import com.example.Integrador.Repositorios.MantenimientoRepository;
import com.example.Integrador.Repositorios.PlanMantenimientoRepository;
import com.example.Integrador.Repositorios.RelacionMantenimientoRepository;

@Service
// Servicio relaciones
public class RelacionServicio {

    @Autowired
    // Repo relaciones
    private RelacionMantenimientoRepository relacionRepository;

    @Autowired
    // Repo planes
    private PlanMantenimientoRepository planRepository;

    // Crear y guardar relaciones
    public void guardarRelacion(Integer idMaquinaria, Integer idTecnico, List<Long> tiposSeleccionados, LocalDate fechaSalida) {
        System.out.println("=== GUARDANDO RELACIÓN ===");
        System.out.println("ID Maquinaria: " + idMaquinaria);
        System.out.println("ID Técnico: " + idTecnico);
        System.out.println("Tipos seleccionados: " + tiposSeleccionados);
        System.out.println("Fecha salida: " + fechaSalida);
        
        for (Long idPlan : tiposSeleccionados) {
            // Buscar plan por id
            Optional<PlanMantenimiento> optionalPlan = planRepository.findById(idPlan);
            if (optionalPlan.isPresent()) {
                PlanMantenimiento plan = optionalPlan.get();

                // Crear relación
                RelacionMantenimiento relacion = new RelacionMantenimiento();
                relacion.setIdMaquinaria(idMaquinaria);
                relacion.setIdTecnico(idTecnico);
                relacion.setIdPlan(plan.getId());
                relacion.setFechaSalida(fechaSalida);
                relacion.setEstado("PENDIENTE"); // Establecer estado inicial

                // Guardar en BD
                RelacionMantenimiento guardada = relacionRepository.save(relacion);
                System.out.println("Relación guardada con ID: " + guardada.getId());
                System.out.println("Estado: " + guardada.getEstado());
            } else {
                System.out.println("Plan no encontrado para ID: " + idPlan);
            }
        }
        System.out.println("=== FIN GUARDADO ===");
    }
    // Obtener todas las relaciones
    public List<RelacionMantenimiento> obtenerTodos() {
        return relacionRepository.findAll();
    }
    
    // Obtener última relación
    public RelacionMantenimiento obtenerUltimaMaquinaria() {
        return relacionRepository.findTopByOrderByIdDesc();
    }
    
    // Generar historial de pagos
    public List<HistorialPagoDTO> obtenerHistorialPagos(List<Maquinaria> maquinarias, List<PlanMantenimiento> planes) {
        List<RelacionMantenimiento> relaciones = relacionRepository.findAll();
        List<HistorialPagoDTO> historial = new ArrayList<>();

       // Iterar relaciones
       for (RelacionMantenimiento rel : relaciones) {
            // Buscar maquinaria
            Maquinaria maq = maquinarias.stream()
                    .filter(m -> Integer.valueOf(rel.getIdMaquinaria()).equals(m.getId()))
                    .findFirst().orElse(null);

            // Buscar plan
            PlanMantenimiento plan = planes.stream()
                    .filter(p -> rel.getIdPlan() != null && Integer.valueOf(rel.getIdPlan()).equals(p.getId()))                        
                    .findFirst().orElse(null);

            if (maq != null && plan != null) {
                // Calcular totales
                double subtotal = plan.getPrecio();
                double total = subtotal * 1.18;

                // Crear DTO
                HistorialPagoDTO dto = new HistorialPagoDTO(
                    maq.getId(),
                    maq.getNombre(),
                    maq.getModelo(),
                    rel.getFechaSalida(),
                    plan.getNombre(),
                    subtotal,
                    total
                        );
                historial.add(dto);
            }
        }

        return historial;
    }
}
