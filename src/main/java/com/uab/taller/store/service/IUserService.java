package com.uab.taller.store.service;

import com.uab.taller.store.domain.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAll();
    User getById(Long id);
    void deleteById(Long id);
    User save(User user);
    User update(Long id, User user);
    Optional<User> getUserByEmail(String email);
}
