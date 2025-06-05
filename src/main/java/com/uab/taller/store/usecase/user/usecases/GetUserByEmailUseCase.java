package com.uab.taller.store.usecase.user.usecases;

import com.uab.taller.store.domain.User;
import com.uab.taller.store.service.IUserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Log4j2
public class GetUserByEmailUseCase {

    private final IUserService userService;

    public GetUserByEmailUseCase(IUserService userService) {
        this.userService = userService;
    }

    public Optional<User> execute(String email) {
        log.info("Buscando usuario con email: {}", email);
        return userService.getUserByEmail(email);
    }
}
