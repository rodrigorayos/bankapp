package com.uab.taller.store;

import com.uab.taller.store.domain.Rol;
import com.uab.taller.store.repository.RolRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:4200")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }

    @Bean
    public CommandLineRunner seedRoles(RolRepository rolRepository) {
        return args -> {
            boolean hasAdmin = rolRepository.findAll()
                    .stream()
                    .anyMatch(r -> r.getName().equalsIgnoreCase("ADMIN"));
            boolean hasUser = rolRepository.findAll()
                    .stream()
                    .anyMatch(r -> r.getName().equalsIgnoreCase("USER"));

            if (!hasAdmin) {
                Rol admin = new Rol();
                admin.setName("ADMIN");
                admin.setDescription("Administrador del sistema");
                rolRepository.save(admin);
                System.out.println("Rol ADMIN creado");
            }

            if (!hasUser) {
                Rol user = new Rol();
                user.setName("USER");
                user.setDescription("Usuario estándar");
                rolRepository.save(user);
                System.out.println("Rol USER creado");
            }
        };
    }
}