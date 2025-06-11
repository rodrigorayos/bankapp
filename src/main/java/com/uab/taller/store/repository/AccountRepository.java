package com.uab.taller.store.repository;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUser(User user);
}
