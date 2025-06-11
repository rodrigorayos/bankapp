package com.uab.taller.store.service;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.domain.User;

import java.util.List;

public interface IAccountService {
    List<Account> getAll();
    Account getById(Long id);
    void deleteById(Long id);
    Account save(Account account);
    Account update(Long id, Account account);
    List<Account> getByUser(User user);
}
