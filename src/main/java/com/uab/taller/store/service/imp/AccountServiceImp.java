package com.uab.taller.store.service.imp;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.domain.User;
import com.uab.taller.store.repository.AccountRepository;
import com.uab.taller.store.service.IAccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImp implements IAccountService {

    private final AccountRepository accountRepository;

    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account getById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Long id, Account account) {
        Account existing = accountRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setCurrencyType(account.getCurrencyType());
            existing.setType(account.getType());
            existing.setBalance(account.getBalance());
            existing.setStatus(account.getStatus());
            return accountRepository.save(existing);
        }
        return null;
    }

    @Override
    public List<Account> getByUser(User user) {
        return accountRepository.findByUser(user);
    }
}
