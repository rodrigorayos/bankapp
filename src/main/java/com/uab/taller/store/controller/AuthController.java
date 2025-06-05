package com.uab.taller.store.controller;

import com.uab.taller.store.domain.AdminUser;
import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.CreateFullUserRequest;
import com.uab.taller.store.domain.dto.request.LoginRequest;
import com.uab.taller.store.service.IAdminUserService;
import com.uab.taller.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    IUserService userService;

    @Autowired
    IAdminUserService adminService;

    @PostMapping("/register")
    public User register(@RequestBody CreateFullUserRequest request) {
        // reutiliza CreateUserUseCase si quieres
        // código de creación ya lo tienes
        // se puede delegar o escribir aquí directamente
        return userService.save(new User(/* mapear de request */));
    }

    @PostMapping("/login")
    public Object login(@RequestBody LoginRequest loginRequest) {
        Optional<User> user = userService.getUserByEmail(loginRequest.getEmail());
        if (user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword())) {
            return user.get(); // puedes devolver DTO en lugar de entidad
        }

        Optional<AdminUser> admin = adminService.findByEmail(loginRequest.getEmail());
        if (admin.isPresent() && admin.get().getPassword().equals(loginRequest.getPassword())) {
            return admin.get(); // mismo comentario
        }

        throw new RuntimeException("Credenciales inválidas");
    }
}
