package com.example.Integrador.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Integrador.Entidades.Roles;
import com.example.Integrador.Entidades.Tecnico;
import com.example.Integrador.Entidades.UsuariosRoles;
import com.example.Integrador.Repositorios.TecnicoRepository;
import com.example.Integrador.Repositorios.UsuarioRolesRepository;
import com.example.Integrador.Seguridad.RolesRepository;
// Servicio para autenticación de usuarios
@Service
public class AutenticacionService {

    @Autowired
    private TecnicoRepository tecnicoRepository;
    
    @Autowired
    private UsuarioRolesRepository usuariosRolesRepository;
    
    @Autowired
    private RolesRepository rolesRepository;

    /**
     * Autentica un usuario y retorna su información con rol
     */
    public UsuarioAutenticado autenticar(String usuario, String contraseña) {
        System.out.println("=== AUTENTICACIÓN DINÁMICA ===");
        System.out.println("Intentando autenticar usuario: " + usuario);
        
        // Buscar técnico por nombre (compatibilidad con sistema actual)
        Tecnico tecnico = tecnicoRepository.findByNombre(usuario);
        if (tecnico == null) {
            // Si no se encuentra por nombre, buscar por usuario
            Optional<Tecnico> tecnicoOpt = tecnicoRepository.findByUsuario(usuario);
            if (tecnicoOpt.isPresent()) {
                tecnico = tecnicoOpt.get();
            }
        }
        
        if (tecnico == null) {
            System.out.println("Usuario no encontrado: " + usuario);
            return null;
        }
        
        // Verificar contraseña
        if (!tecnico.getContraseña().equals(contraseña)) {
            System.out.println("Contraseña incorrecta para usuario: " + usuario);
            return null;
        }
        
        System.out.println("Usuario encontrado: " + tecnico.getNombre() + " (ID: " + tecnico.getId() + ")");
        
        // Buscar rol del usuario
        UsuariosRoles usuarioRol = usuariosRolesRepository.findFirstByIdUsuario(tecnico.getId());
        if (usuarioRol == null) {
            System.out.println("No se encontró rol para el usuario: " + usuario);
            return null;
        }
        
        Roles rol = rolesRepository.findById(usuarioRol.getIdRol()).orElse(null);
        if (rol == null) {
            System.out.println("Rol no válido para el usuario: " + usuario);
            return null;
        }
        
        System.out.println("Rol encontrado: " + rol.getNombre());
        System.out.println("=== AUTENTICACIÓN EXITOSA ===");
        
        return new UsuarioAutenticado(tecnico, rol);
    }

    /**
     * Clase interna para representar un usuario autenticado con su rol
     */
    public static class UsuarioAutenticado {
        private final Tecnico tecnico;
        private final Roles rol;
        
        public UsuarioAutenticado(Tecnico tecnico, Roles rol) {
            this.tecnico = tecnico;
            this.rol = rol;
        }
        
        public Tecnico getTecnico() {
            return tecnico;
        }
        
        public Roles getRol() {
            return rol;
        }
        
        public String getTipoUsuario() {
            return rol.getNombre();
        }
        
        public String getRedireccion() {
            switch (rol.getNombre().toUpperCase()) {
                case "ADMINISTRADOR":
                case "ADMIN":
                    return "Inicio";
                case "TECNICO":
                    return "index";
                default:
                    return "login";
            }
        }
        
        public boolean esAdministrador() {
            return "ADMINISTRADOR".equalsIgnoreCase(rol.getNombre()) || 
                   "ADMIN".equalsIgnoreCase(rol.getNombre());
        }
        
        public boolean esTecnico() {
            return "TECNICO".equalsIgnoreCase(rol.getNombre());
        }
    }
}
