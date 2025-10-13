package com.example.Integrador.Seguridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
// Clase de configuración de seguridad web
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	  @Autowired
	  private CustomLoginSuccessHandler successHandler;
	  @Autowired
	  private CustomLoginFailureHandler failureHandler;


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.authorizeHttpRequests((requests) -> requests
                .requestMatchers("/", "/todos", "/*.css","/img/**", "/correo.html","/nueva-contraseña","/actualizar-contraseña").permitAll()
                .requestMatchers("/menu-trabjador.html","/index.html","/realizados.html","/completar-tarea").hasAuthority("TECNICO")
                .requestMatchers("/Inicio.html","/registro_maquinaria.html","/gestionar_tecnico.html","/Historial-pago.html","/registrar","/procesar-mantenimiento","/tecnico-seleccionado","/actualizar-tecnico").hasAuthority("ADMINISTRADOR")
                .anyRequest().authenticated())
            .formLogin(form -> form
                .loginPage("/login")             
                .successHandler(successHandler) // <- Aquí va el handler
                .failureHandler(failureHandler)
                .permitAll())
            
            
            .logout(logout -> logout
            	    .logoutUrl("/logout")                      // endpoint de logout
            	    .logoutSuccessUrl("/Login.html")          // Página a la que redirige después de logout
            	    .invalidateHttpSession(true)              // Invalida la sesión
            	    .clearAuthentication(true)                // Limpia la autenticación
            	    .permitAll() 
            	    )   
            .exceptionHandling(ex -> ex
                    .accessDeniedPage("/acceso-denegado") // <--- esta es la ruta que usará en errores 403
                );
        return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {

//		UserDetails user = User.withDefaultPasswordEncoder().username("demo").password("demo").roles("USER").build();
//		InMemoryUserDetailsManager um = new InMemoryUserDetailsManager();
//		um.createUser(user);
//		return um;
		return new MyUserDetailsService();
	}
}
