package com.uab.taller.store.controller;

import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.CreateFullUserRequest;
import com.uab.taller.store.domain.dto.request.UserRequest;
import com.uab.taller.store.usecases.user.usecases.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @Autowired
    private GetAllUsersUseCase getAllUserUseCase;

    @Autowired
    private GetUserByIdUseCase getUserByIdUseCase;

    @Autowired
    private UpdateUserUseCase updateUserUseCase;

    @Autowired
    private DeleteUserUseCase deleteUserUseCase;

    @PostMapping
    public User create(@RequestBody CreateFullUserRequest request) {
        return createUserUseCase.execute(request);
    }

    @GetMapping
    public List<User> getAll() {
        return getAllUserUseCase.execute();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return getUserByIdUseCase.execute(id);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody UserRequest request) {
        return updateUserUseCase.execute(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteUserUseCase.execute(id);
    }
}
