package com.uab.taller.store.service.imp;

import com.uab.taller.store.domain.AdminUser;
import com.uab.taller.store.repository.AdminUserRepository;
import com.uab.taller.store.service.IAdminUserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminUserServiceImp implements IAdminUserService {
    private final AdminUserRepository repo;

    public AdminUserServiceImp(AdminUserRepository repo) {
        this.repo = repo;
    }

    @Override
    public Optional<AdminUser> findByEmail(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public AdminUser save(AdminUser adminUser) {
        return repo.save(adminUser);
    }
}
