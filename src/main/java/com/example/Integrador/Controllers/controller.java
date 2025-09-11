package com.example.Integrador.Controllers;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.Integrador.DTOs.DTOMaquinaria;
import com.example.Integrador.DTOs.DtoTecnico;
import com.example.Integrador.DTOs.HistorialPagoDTO;
import com.example.Integrador.DTOs.SeleccionMantenimientoDTO;
import com.example.Integrador.Entidades.Maquinaria;
import com.example.Integrador.Entidades.PlanMantenimiento;
import com.example.Integrador.Entidades.Tecnico;
import com.example.Integrador.Repositorios.MantenimientoRepository;
import com.example.Integrador.Repositorios.MaquinariaRepository;
import com.example.Integrador.Repositorios.PlanMantenimientoRepository;
import com.example.Integrador.Repositorios.RelacionMantenimientoRepository;
import com.example.Integrador.Repositorios.TecnicoRepository;
import com.example.Integrador.ExcelGenerator;
import com.example.Integrador.LoggerHelper;
import com.example.Integrador.RegistroServicioFacade;
import com.example.Integrador.Service.AutenticacionService;
import com.example.Integrador.Service.AutenticacionService.UsuarioAutenticado;
import com.example.Integrador.Service.MantenimientoService;
import com.example.Integrador.Service.MaquinariaService;
import com.example.Integrador.Service.RelacionServicio;
import com.example.Integrador.Service.TecnicoService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class controller {
	private static final String FACADE_SESSION_KEY = "registroServicio";
	@Autowired
	private MaquinariaRepository maquinariaRepository;
	@Autowired
	private MantenimientoRepository mantenimientoReopository;
	@Autowired
    private RelacionMantenimientoRepository relacionRepository;
	
	@Autowired
    private PlanMantenimientoRepository PlanMantenimiento;


	
	@GetMapping("/acceso-denegado")
    public String accesoDenegado() {
        return "acceso-denegado"; 
    }

	@GetMapping("/login")
	public String login() {
		System.out.println("ejecutando login");
		return "login";
	}
	
	//navegacion por el menu del administrador
	@GetMapping("/registro_maquinaria.html")
	public String Inicio() {
		return "registro_maquinaria";
	}	
	@GetMapping("/Pago(1).html")
	public String Pago(Model model) {
		 
	/*	model.addAttribute("ultimaMaquinaria", maquinariaRepository.findTopByOrderByIdDesc()); 
	    model.addAttribute("ultimoMantenimiento", relacionRepository.findTopByOrderByIdDesc()); 
	    model.addAttribute("ultimoPago", PlanMantenimiento.findTopByOrderByIdDesc()); */
	
	    return "Pago(1)";
	    
	}

	//navegacion por el menu del tecnico	
	@GetMapping("/correo.html")
	public String recuperarCorreo() {
	    return "correo"; 
	}
	/*@GetMapping("/nueva-contraseña")
	public String nuevaContraseña() {
	    return "recuperar-contra"; 
	}*/
	/*@PostMapping("/actualizar-contraseña")
	public String actualizarContraseña() {
		return "Login";
	}*/
	
	@GetMapping("/menu-trabjador.html")
	public String menuTrabajador() {
	    return "menu-trabjador"; 
	}
	//navegacion
	@GetMapping("/Inicio.html")
	public String ini() {
		return "Inicio";
	}
	@GetMapping("/Historial-pago.html")
	public String historialPago(Model model) {
		List<HistorialPagoDTO> historial = new ArrayList<>();
		 // Listas completas
	    List<Maquinaria> maquinarias = maquinariaService.obtenerTodos();
	    List<PlanMantenimiento> planes = PlanMantenimiento.findAll();

	    // Historial combinado
	    List<HistorialPagoDTO> historialPagos = relacionServicio.obtenerHistorialPagos(maquinarias, planes);
	    model.addAttribute("historialPagos", historialPagos);
		return "Historial-pago";
	}
	@GetMapping("/empezar-administrador")
	public String empezar() {
		return "registro_maquinaria";
	}
	@GetMapping("/Empezar-trabajador")
	public String empezarTrabajador() {
		return "index";
	}

	//navegacion
	@GetMapping("/")
	public String login1() {
		System.out.println("ejecutando todos");

	    return "inicio-integrador"; // 
	}
	/*
	@GetMapping("/Login.html")
	public String loginNav() {
	    return"Login";// 
	}*/
	//SISTEMA DE AUTENTICACIÓN DINÁMICO - BASADO EN BASE DE DATOS
	//validar tipo de usuario
	    @PostMapping("/procesar-login")
	    public String procesarLogin(
	            @RequestParam(name = "usuario") String usuario,
	            @RequestParam(name = "contra") String contraseña
	    ) {
	        System.out.println("=== PROCESANDO LOGIN DINÁMICO ===");
	        System.out.println("Usuario: " + usuario);
	        
	        // Usar el servicio de autenticación dinámico
	        UsuarioAutenticado usuarioAuth = autenticacionService.autenticar(usuario, contraseña);
	        
	        if (usuarioAuth != null) {
	            System.out.println("Autenticación exitosa para: " + usuario);
	            System.out.println("Tipo de usuario: " + usuarioAuth.getTipoUsuario());
	            System.out.println("Redirigiendo a: " + usuarioAuth.getRedireccion());
	            return usuarioAuth.getRedireccion();
	        } else {
	            System.out.println("Autenticación fallida para: " + usuario);
	            return "login"; // Vista de error si no encuentra usuario o contraseña incorrecta
	        }
	    }
	//USA el facade
	/*
		@PostMapping("/registrar")
		public String registrarDatos(@ModelAttribute DTOMaquinaria maquinaria, HttpSession session) {
		    RegistroServicioFacade facade = new RegistroServicioFacade();
		    facade.registrarMaquinaria(maquinaria);

		    session.setAttribute(FACADE_SESSION_KEY, facade); // guardamos el facade en la sesión

		    return "SelectMantenimiento";
		}*/
	@Autowired
	private MaquinariaService maquinariaService;
	
	@Autowired
	private AutenticacionService autenticacionService;
		@PostMapping("/registrar")
		public String registrarDatos(@ModelAttribute DTOMaquinaria maquinaria, HttpSession session) {
		    try {
		        RegistroServicioFacade facade = new RegistroServicioFacade();
		        facade.registrarMaquinaria(maquinaria);

		        // Guardar maquinaria y recuperar la entidad con ID autogenerado
		        Maquinaria entidadGuardada = maquinariaService.guardarMaquinaria(maquinaria);

		        // Guardar el facade y el ID de maquinaria en la sesión
		        session.setAttribute(FACADE_SESSION_KEY, facade);
		        session.setAttribute("idMaquinaria", entidadGuardada.getId());

		        // Log
		        LoggerHelper.logInfo(
		            "Registro de maquinaria:\n" +
		            "Nombre: " + maquinaria.getNombre() + "\n" +
		            "Apellido: " + maquinaria.getApellido() + "\n" +
		            "Celular: " + maquinaria.getNumeroCelular() + "\n" +
		            "Correo: " + maquinaria.getGmail() + "\n" +
		            "Marca: " + maquinaria.getMarca() + "\n" +
		            "Modelo: " + maquinaria.getModelo() + "\n" +
		            "Número de Serie: " + maquinaria.getNumeroSerie() + "\n" +
		            "Tipo Maquinaria: " + maquinaria.getTipoMaquinaria() + "\n" +
		            "Año de Fabricación: " + maquinaria.getAnioFabricacion() + "\n" +
		            "Número de Motor: " + maquinaria.getNumeroMotor() + "\n" +
		            "Horas de Operación: " + maquinaria.getHorasOperacion() + "\n" +
		            "Kilometraje: " + maquinaria.getKilometraje()
		        );

		        return "redirect:/seleccionar_planes";
		    } catch (Exception e) {
		        LoggerHelper.logError("Error inesperado al registrar maquinaria", e);
		        return "ErrorPage";
		    }
		}

	//navegacion
	 @GetMapping("/SelectMantenimiento")
	 public String mantenimiento() {
		 return "SelectMantenimiento";
	 }
 
	@GetMapping("/fecha-seleccionada")
	public String fechaSeleccionada() {
	    return "SelecTecnico"; 
	}
	//navegacion
	@GetMapping("/registro-exitoso")
	public String registroExitoso() {
	    return "Pago(1)"; 
	}
	/*
	//navegacion
	@GetMapping("/pagar")
	public String procesarPago() {
	    return "Inicio";
	}*/
	/*@GetMapping("/pagar")
	public void procesarPago(HttpServletResponse response) {
	    // Aquí se usa información real de la sesión o del modelo; a modo de ejemplo se define la tabla fija.
	    String[][] tableData = {
	        {"ID Pago", "Cliente", "Maquinaria ID", "Fecha de Registro", "Tipo de Mantenimiento", "Subtotal", "IGV", "Total a Pagar"},
	        
	        {"001", "Juan Pérez", "CAT 320D", "05/04/2025", "Predictivo", "800$", "144$", "944$"}
	    };

	    try {
	        byte[] excelBytes = ExcelGenerator.generateExcel(tableData);
	        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	        response.setHeader("Content-Disposition", "attachment; filename=\"pago.xlsx\"");
	        response.getOutputStream().write(excelBytes);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    
	}*/
	
	@GetMapping("/pagar")
	public void procesarPago(HttpServletResponse response) {
	    try {
	        List<Maquinaria> maquinarias = maquinariaService.obtenerTodos();
	        List<PlanMantenimiento> planes = PlanMantenimiento.findAll(); // o usa tu servicio

	        // Obtener historial completo
	        List<HistorialPagoDTO> historialCompleto = relacionServicio.obtenerHistorialPagos(maquinarias, planes);

	        // Obtener solo la última fila (último registro)
	        HistorialPagoDTO dto = historialCompleto.isEmpty()
	                ? null
	                : historialCompleto.get(historialCompleto.size() - 1); // Último elemento

	        if (dto == null) {
	            response.setContentType("text/plain");
	            response.getWriter().write("No hay datos para exportar.");
	            return;
	        }

	        // Armar la tabla con solo una fila de datos
	        String[][] tableData = new String[2][];
	        tableData[0] = new String[]{
	            "ID Pago", "Cliente", "Maquinaria ID", "Fecha de Registro",
	            "Tipo de Mantenimiento", "Subtotal", "IGV", "Total a Pagar"
	        };
	        tableData[1] = new String[]{
	            String.valueOf(dto.getId()),
	            dto.getNombre(),
	            dto.getModelo(),
	            String.valueOf(dto.getFechaSalida()),
	            dto.getTipo(),
	            String.format("%.2f", dto.getSubtotal()) + " $",
	            String.format("%.2f", dto.getSubtotal() * 0.18) + " $",
	            String.format("%.2f", dto.getTotal()) + " $"
	        };

	        // Generar Excel
	        byte[] excelBytes = ExcelGenerator.generateExcel(tableData);
	        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
	        response.setHeader("Content-Disposition", "attachment; filename=\"pago.xlsx\"");
	        response.getOutputStream().write(excelBytes);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	//Usa el facade
    @Autowired
	private MantenimientoService manService;
		@PostMapping("/procesar-mantenimiento")
		public String procesarMantenimiento(@ModelAttribute SeleccionMantenimientoDTO seleccion,
		                                    HttpSession session, Model model) {
		    RegistroServicioFacade facade = (RegistroServicioFacade) session.getAttribute(FACADE_SESSION_KEY);
		    if (facade == null) return "redirect:/Login"; // manejo de error básico

		    //facade.seleccionarTiposMantenimiento(seleccion.getTiposSeleccionados(), seleccion);
		    facade.establecerFecha(seleccion.getFechaSalida());
		    
		    Integer idMaquinaria = (Integer) session.getAttribute("idMaquinaria");
		    if (idMaquinaria == null) return "redirect:/registro_maquinaria.html"; // por si se pierde el ID
		    
		    session.setAttribute("tiposSeleccionados", seleccion.getTiposSeleccionados());
		    session.setAttribute("fechaSalida", seleccion.getFechaSalida());
		    
		    seleccion.setIdMaquinaria(idMaquinaria);


		    //model.addAttribute("tecnicos", listaTecnicos); // aún necesitas mostrar técnicos
		    return "redirect:/seleccionar_tecnico";
		}
		/*
	@PostMapping("/procesar-mantenimiento")
  	public String procesarMantenimiento(@ModelAttribute SeleccionMantenimientoDTO seleccion, Model model, HttpSession session) {
  		System.out.println("Tipos seleccionados: " + seleccion.getTiposSeleccionados());
  	    System.out.println("Fecha de salida: " + seleccion.getFechaSalida());
  	    // Crea una lista de mantenimeintos 
  	    List<Mantenimiento> mantenimientos = MantenimientoFactory.crearMantenimientos(seleccion.getTiposSeleccionados()); 
  	    // Puedes almacenar esta lista en la sesión, o pasarla al modelo
  	    model.addAttribute("mantenimientos", mantenimientos);
  	    model.addAttribute("fechaSalida", seleccion.getFechaSalida());

  	    return "SelecTecnico"; // Pasas los datos a la siguiente vista
  	}*/
	
		private List<Tecnico> listaTecnicos = new ArrayList<>();

		@Autowired
		private RelacionServicio relacionServicio;

		@PostMapping("/tecnico-seleccionado")
		public String recibirTecnicoSeleccionado(@ModelAttribute DtoTecnico tecnicoSeleccionado,
		                                         HttpSession session, Model model) {

			  Integer idTecnico = tecnicoSeleccionado.getId();
			    System.out.println("Técnico seleccionado ID: " + idTecnico);
		    // Recuperar datos de la sesión
		    Integer idMaquinaria = (Integer) session.getAttribute("idMaquinaria");
		    List<Long> tiposSeleccionados = (List<Long>) session.getAttribute("tiposSeleccionados");
		    LocalDate fechaSalida = (LocalDate) session.getAttribute("fechaSalida");

		    if (idMaquinaria == null || tiposSeleccionados == null || fechaSalida == null) {
		        return "redirect:/registro_maquinaria.html";
		    }

		    // Guardar relación
		    relacionServicio.guardarRelacion(idMaquinaria, idTecnico, tiposSeleccionados, fechaSalida);
		    
		    model.addAttribute("ultimaMaquinaria", maquinariaRepository.findTopByOrderByIdDesc()); 
		    model.addAttribute("ultimoMantenimiento", relacionRepository.findTopByOrderByIdDesc()); 
		    model.addAttribute("ultimoPago", PlanMantenimiento.findTopByOrderByIdDesc()); 

		    return "Pago(1)";
		}


		@Autowired
		private TecnicoService tecnicoservice;
		@PostMapping("/nueva-contraseña")
		public String nuevaContraseña(@RequestParam(name="email") String email, HttpSession sec, Model modelo) {
			Tecnico tec = tecnicoservice.existeUsuarioCorreo(email);
		    if (tec != null) {
		    	sec.setAttribute("tecnico", tec);
		        return "recuperar-contra";
		    }
		    modelo.addAttribute("errorGmail", "Correo inválido o no registrado.");
		    return "correo";   
		}
		@PostMapping("/actualizar-contraseña")
		public String actualizarContraseña(
				@RequestParam(name="contra1")String contra1,
				@RequestParam(name="contra2")String contra2,
				HttpSession sec, Model modelo)
		{
			System.out.println(contra1);
			System.out.println(contra2);
			
			if(contra1.equals(contra2)) {
				Tecnico Tecnico = (Tecnico) sec.getAttribute("tecnico");
				Tecnico.setContraseña(contra1);
				System.out.println("Contraseña antigua: " + Tecnico.getContraseña());
				System.out.println("Contraseña nueva: " + contra1);
				tecnicoservice.guardar(Tecnico);
				return "Login";
			}
			modelo.addAttribute("errorContra", "Las contraseñas no coinciden.");
			return "recuperar-contra";
			
		}
		
}
