package com.example.Integrador;

// Usuario con credenciales de acceso
public interface UsuarioConCredenciales extends TipoUsuario {
    // Obtiene nombre de usuario
    String getUsuario();
    // Obtiene contraseña
    String getContraseña();
}