package com.uab.taller.store.controller;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.domain.dto.request.AccountRequest;
import com.uab.taller.store.usecases.account.usecases.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    @Autowired
    private CreateAccountUseCase createAccountUseCase;

    @Autowired
    private GetAllAccountUseCase getAllAccountUseCase;

    @Autowired
    private GetAccountByIdUseCase getAccountByIdUseCase;

    @Autowired
    private UpdateAccountUseCase updateAccountUseCase;

    @Autowired
    private DeleteAccountUseCase deleteAccountUseCase;

    @PostMapping
    public Account create(@RequestBody AccountRequest request) {
        return createAccountUseCase.execute(request);
    }

    @GetMapping
    public List<Account> getAll() {
        return getAllAccountUseCase.execute();
    }

    @GetMapping("/{id}")
    public Account getById(@PathVariable Long id) {
        return getAccountByIdUseCase.execute(id);
    }

    @PutMapping("/{id}")
    public Account update(@PathVariable Long id, @RequestBody AccountRequest request) {
        return updateAccountUseCase.execute(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        deleteAccountUseCase.execute(id);
    }
}
