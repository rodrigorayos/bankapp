package com.uab.taller.store.usecases.user.usecases;

import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.UserRequest;
import com.uab.taller.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateUserUseCase {

    @Autowired
    IUserService userService;

    public User execute(Long id, UserRequest request) {
        User user = new User();
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return userService.update(id, user);
    }
}
