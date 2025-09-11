package com.example.Integrador.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.example.Integrador.Entidades.PlanMantenimiento;
import com.example.Integrador.Repositorios.PlanMantenimientoRepository;

@Controller
public class PlanMantenimientoController {

    @Autowired
    private PlanMantenimientoRepository planRepository;

    @GetMapping("/seleccionar_planes")
    public String mostrarPlanes(Model model) {
        List<PlanMantenimiento> planes = planRepository.findAll();
        model.addAttribute("planes", planes);
        return "SelectMantenimiento"; // Nombre del archivo HTML
    }
}
