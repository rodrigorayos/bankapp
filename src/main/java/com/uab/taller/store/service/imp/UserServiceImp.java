package com.uab.taller.store.service.imp;

import com.uab.taller.store.domain.User;
import com.uab.taller.store.repository.UserRepository;
import com.uab.taller.store.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(Long id, User user) {
        User existing = userRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setEmail(user.getEmail());
            existing.setPassword(user.getPassword());
            return userRepository.save(existing);
        }
        return null;
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
