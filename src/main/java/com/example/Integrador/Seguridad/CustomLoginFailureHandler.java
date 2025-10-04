package com.example.Integrador.Seguridad;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.security.core.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Maneja los fallos de autenticación en el login.
 * Registra intentos fallidos y redirige al usuario.
 */
@Component
public class CustomLoginFailureHandler implements AuthenticationFailureHandler {

    // Logger para registrar intentos de login fallidos
    private static final Logger logger = LoggerFactory.getLogger(CustomLoginFailureHandler.class);

    /**
     * Se ejecuta cuando falla la autenticación.
     * Registra el intento y redirige a la página de login con error.
     */
    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception
    ) throws IOException, ServletException {

        String username = request.getParameter("username");

        // Registra el intento fallido en los logs
        logger.warn("⚠️ Intento de login fallido para el usuario: {}", username);

        // Redirige al login con parámetro de error
        response.sendRedirect("/login?error");
    }
}
