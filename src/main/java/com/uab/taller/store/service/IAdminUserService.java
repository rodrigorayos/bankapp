package com.uab.taller.store.service;

import com.uab.taller.store.domain.AdminUser;

import java.util.Optional;

public interface IAdminUserService {
    Optional<AdminUser> findByEmail(String email);
    AdminUser save(AdminUser adminUser);
}
