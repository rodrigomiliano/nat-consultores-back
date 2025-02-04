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
                .requestMatchers("/api/tasks/**").permitAll() // Permitir acceso sin autenticación a los endpoints de tareas
                .anyRequest().authenticated() // Restringe cualquier otro endpoint
            )
            .build();
    }
}
