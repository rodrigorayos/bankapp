package com.uab.taller.store.usecase.user.usecases;

import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.UserRequest;
import com.uab.taller.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserUseCase {

    @Autowired
    IUserService userService;

    public User execute(Long userId, UserRequest userRequest) {
        User userToUpdate = new User();
        userToUpdate.setId(userId);
        userToUpdate.setEmail(userRequest.getEmail());
        userToUpdate.setPassword(userRequest.getPassword());
        return userService.save(userToUpdate);
    }
}