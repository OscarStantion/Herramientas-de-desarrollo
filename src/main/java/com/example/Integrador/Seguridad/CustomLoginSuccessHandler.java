package com.example.Integrador.Seguridad;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication)
            throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        for (GrantedAuthority authority : authorities) {
            String rol = authority.getAuthority();

            if (rol.equals("ADMINISTRADOR")) {
                response.sendRedirect("/Inicio.html");
                return;
            } else if (rol.equals("TECNICO")) {
                response.sendRedirect("/menu-trabjador.html");
                return;
            } 
        }

        // Redirección por defecto si no coincide ningún rol
        //response.sendRedirect("/login.html?error=sin_autorizacion");
    }
}
