package com.uab.taller.store.usecase.user.usecases;

import com.uab.taller.store.domain.User;
import com.uab.taller.store.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeleteUserUseCase {
    @Autowired
    IUserService userService;

    public void execute(Long userId) {
        userService.deleteById(userId);
    }
}
