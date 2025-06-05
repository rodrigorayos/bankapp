package com.uab.taller.store.service.imp;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.repository.AccountRepository;
import com.uab.taller.store.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImp implements IAccountService {
    @Autowired
    AccountRepository repository;

    public AccountServiceImp(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Account> getAll() {
        return repository.findAll();}

    @Override
    public Account getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cuenta no encontrada"));
    }

    @Override
    public Account save(Account account) {
        return repository.save(account);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Account update(Long id, Account account) {
        Account oldAccount = repository.findById(id).orElse(null);
        if (oldAccount != null) {
            oldAccount.setAccountNumber(account.getAccountNumber());
            oldAccount.setBalance(account.getBalance());
            oldAccount.setCurrencyType(account.getCurrencyType());
            return repository.save(oldAccount);
        }
        return null;
    }
}
