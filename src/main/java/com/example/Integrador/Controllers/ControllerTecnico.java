package com.example.Integrador.Controllers;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Integrador.Entidades.Tecnico;
import com.example.Integrador.Repositorios.TecnicoRepository;
import com.example.Integrador.Service.TecnicoService;
import com.example.Integrador.Service.UsuarioRolService;
@Controller
public class ControllerTecnico {

	@Autowired
	private TecnicoService tecnicoservice;
	@Autowired
	private UsuarioRolService uRoles;
	//optener tecnicos
	@GetMapping("/gestionar_tecnico.html")
	public String gestionarTecnico(Model modelo) {	
		List<Tecnico> listaTecnicos = tecnicoservice.Cargar();
		listaTecnicos.sort(Comparator.comparing(Tecnico::getId));
		modelo.addAttribute("tecnicos", listaTecnicos);
		modelo.addAttribute("modoEdicion",false);
		return "gestionar_tecnico";
	}
	
	//agregar nuevos tecnicos
  	@PostMapping("/agregar-tecnico")
  	public String agregarTecnico(@ModelAttribute Tecnico dto, Model modelo) {
  		 boolean hayError = false;

   	    if (tecnicoservice.existeUsuario(dto.getUsuario())) {
   	        modelo.addAttribute("errorUsuario", "El usuario ya existe. Elija otro.");
   	        hayError = true;
   	    }

   	    if (tecnicoservice.existeUsuarioCorreo(dto.getEmail()) != null) {
   	        modelo.addAttribute("errorCorreo", "El correo ya existe. Elija otro.");
   	        hayError = true;
   	    }

   	    if (hayError) {
   	        //Esta parte se ejecuta siempre que haya un error (usuario o correo)
   	        modelo.addAttribute("actualizarTecnico", dto);
   	        List<Tecnico> listaTecnicos = tecnicoservice.Cargar();
   	        listaTecnicos.sort(Comparator.comparing(Tecnico::getId));
   	        modelo.addAttribute("tecnicos", listaTecnicos);
   	        modelo.addAttribute("modoEdicion", false);
   	        return "gestionar_tecnico";
   	    }
  	    
  	  Tecnico tec = tecnicoservice.guardar(dto);
	    uRoles.crearUsuarioConRol(tec.getId());
  	    return "redirect:/gestionar_tecnico.html";
  	}
  	
  	//Eliminar tecnico
  	@PostMapping("/eliminar-tecnico")
  	public String eliminarTecnico(@RequestParam(name="id-tecnico") Integer id) {
  		tecnicoservice.eliminar(id);
  		return "redirect:/gestionar_tecnico.html";
  	}
  	
  	//Actualizar tecnico
  	@PostMapping("/actualizar-tecnico")
  	public String ActualizarTecnico(@RequestParam(name="id-tecnico") Integer id, Model modelo) {
  		Tecnico tecnico = tecnicoservice.buscarPorId(id);
  		modelo.addAttribute("actualizarTecnico", tecnico);
  		modelo.addAttribute("modoEdicion",true);
  		return "gestionar_tecnico.html";
  	}	
  	@PostMapping("/actualizar-tecnico-final")
  	public String ActualizarTecnicoFinal(@ModelAttribute Tecnico dto) {
  		Tecnico tec = tecnicoservice.buscarPorId(dto.getId());
  		tec.setNombre(dto.getNombre());
  		tec.setApellido(dto.getApellido());
  		tec.setUsuario(dto.getUsuario());
  		tec.setContraseña(dto.getContraseña());
  		tec.setEspecialidad(dto.getEspecialidad());
  		tec.setTelefono(dto.getTelefono());
  		tec.setEmail(dto.getEmail());
  		tecnicoservice.guardar(tec);
  		return "redirect:/gestionar_tecnico.html";
  	}
  	
  	@Autowired
  	private TecnicoRepository tecnicoRepository;
  	@GetMapping("/seleccionar_tecnico")
  	public String mostrarTecnicos(Model model) {
  	    List<Tecnico> tecnicos = tecnicoRepository.findAll();
  	    model.addAttribute("tecnicos", tecnicos);
  	    return "SelecTecnico"; // nombre de tu vista HTML (sin extensión si usas Thymeleaf)
  	}
    // Mostrar tareas pendientes del técnico logueado
    @GetMapping("/index.html")
    public String mostrarTareasPendientes(Model model) {
        System.out.println("=== ACCESO A TAREAS PENDIENTES ===");
        Integer idTecnico = obtenerIdTecnicoLogueado();
        System.out.println("ID Técnico obtenido: " + idTecnico);
        
        if (idTecnico != null) {
            List<Map<String, Object>> tareasPendientes = tecnicoservice.obtenerTareasPendientes(idTecnico);
            System.out.println("Tareas pendientes obtenidas: " + tareasPendientes.size());
            model.addAttribute("tareas", tareasPendientes);
        } else {
            System.out.println("No se pudo obtener el ID del técnico");
        }
        System.out.println("=== FIN ACCESO ===");
        return "index";
    }
    
    // Mostrar tareas completadas del técnico logueado
    @GetMapping("/realizados.html")
    public String mostrarTareasCompletadas(Model model) {
        Integer idTecnico = obtenerIdTecnicoLogueado();
        if (idTecnico != null) {
            List<Map<String, Object>> tareasCompletadas = tecnicoservice.obtenerTareasCompletadas(idTecnico);
            model.addAttribute("tareas", tareasCompletadas);
        }
        return "realizados";
    }
    
    // Completar una tarea
    @PostMapping("/completar-tarea")
    public String completarTarea(@RequestParam("idTarea") Integer idTarea) {
        boolean completada = tecnicoservice.completarTarea(idTarea);
        if (completada) {
            return "redirect:/index.html";
        } else {
            return "redirect:/index.html?error=true";
        }
    }
    
    // Método auxiliar para obtener el ID del técnico logueado
    private Integer obtenerIdTecnicoLogueado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated()) {
            String username = authentication.getName();
            System.out.println("=== OBTENIENDO ID TÉCNICO ===");
            System.out.println("Username de autenticación: " + username);
            
            // Primero intentar buscar por campo 'usuario'
            System.out.println("Buscando por campo 'usuario'...");
            Optional<Tecnico> tecnicoPorUsuario = tecnicoRepository.findByUsuario(username);
            if (tecnicoPorUsuario.isPresent()) {
                System.out.println("Técnico encontrado por usuario: " + tecnicoPorUsuario.get().getId());
                System.out.println("=== FIN OBTENCIÓN ID TÉCNICO ===");
                return tecnicoPorUsuario.get().getId();
            }
            System.out.println("No encontrado por 'usuario', intentando por 'nombre'...");
            
            // Si no lo encuentra, intentar buscar por campo 'nombre' (fallback para compatibilidad)
            Tecnico tecnicoPorNombre = tecnicoRepository.findByNombre(username);
            if (tecnicoPorNombre != null) {
                System.out.println("Técnico encontrado por nombre: " + tecnicoPorNombre.getId());
                System.out.println("=== FIN OBTENCIÓN ID TÉCNICO ===");
                return tecnicoPorNombre.getId();
            }
            
            System.out.println("No se encontró técnico con username: " + username);
            System.out.println("=== FIN OBTENCIÓN ID TÉCNICO ===");
            return null;
        }
        System.out.println("No hay autenticación activa");
        System.out.println("=== FIN OBTENCIÓN ID TÉCNICO ===");
        return null;
    }

}