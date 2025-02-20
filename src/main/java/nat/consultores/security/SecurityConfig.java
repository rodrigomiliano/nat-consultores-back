package nat.consultores.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable()) // Deshabilitar CSRF si no usas autenticación basada en formularios
            .authorizeHttpRequests(auth -> auth
            		.antMatchers(
            	            "/api/tasks/**",  // Permitir acceso a la API de tareas
            	            "/swagger-ui/**", // Permitir acceso a Swagger UI
            	            "/swagger-ui.html",            	            
            	            "/v2/api-docs/**" // Permitir acceso a la documentación generada
            	        ).permitAll()
                .anyRequest().authenticated() // Restringe cualquier otro endpoint
            )
            .build();
    }
}

