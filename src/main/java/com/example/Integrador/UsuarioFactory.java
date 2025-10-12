package com.example.Integrador;

import com.example.Integrador.Entidades.Tecnico;

// Fábrica para crear usuarios
public class UsuarioFactory {

    // Crea usuario según tipo
    public static TipoUsuario crearUsuario(String tipo, String usuario, String contraseña) {
        if (tipo == null) return null;

        switch (tipo.toLowerCase()) {
            case "admin":
                return new Admin(usuario, contraseña);
            case "tecnico":
                return new Tecnico(usuario, contraseña);
            default:
                return null;
        }
    }
}