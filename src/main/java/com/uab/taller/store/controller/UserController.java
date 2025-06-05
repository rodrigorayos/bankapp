package com.uab.taller.store.controller;


import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.CreateFullUserRequest;
import com.uab.taller.store.domain.dto.request.UserRequest;
import com.uab.taller.store.service.IUserService;
import com.uab.taller.store.usecase.user.usecases.*;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(value = "/users")

public class  UserController {

    @Autowired
    IUserService userService;

    @Autowired
    GetAllUsersUseCase getAllUsersUseCase;
    @Autowired
    GetUserByIdUseCase getUserByIdUseCase;
    @Autowired
    CreateUserUseCase createUserUseCase;
    @Autowired
    DeleteUserUseCase deleteUserUseCase;
    @Autowired
    UpdateUserUseCase updateUserUseCase;
    @Autowired
    GetUserByEmailUseCase getUserByEmailUserCase;


    @GetMapping()
    public List<User> getAll() {
        return getAllUsersUseCase.execute();
    }


    @GetMapping(value = "/{userId}")
    public User getById(@PathVariable Long userId) {
        return getUserByIdUseCase.execute(userId);
    }

    @GetMapping(value = "/email/{email:.+}")
    public User getByEmail(@PathVariable String email) {
        return getUserByEmailUserCase.execute(email)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
    }
    @DeleteMapping("/{userId}")
    public void deleteById(@PathVariable Long userId) {
        deleteUserUseCase.execute(userId);
    }

    @PostMapping("")
    public User save(@RequestBody CreateFullUserRequest createUserRequest) {
        return createUserUseCase.execute(createUserRequest);
    }

    @PutMapping("/{userId}")
    public User update(@PathVariable Long userId, @RequestBody UserRequest userRequest) {
        return updateUserUseCase.execute(userId, userRequest);
    }
}