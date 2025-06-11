package com.uab.taller.store.usecases.user.usecases;

import com.uab.taller.store.domain.User;
import com.uab.taller.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUserByIdUseCase {
    @Autowired
    IUserService userService;

    public User execute(Long id) {
        return userService.getById(id);
    }
}
