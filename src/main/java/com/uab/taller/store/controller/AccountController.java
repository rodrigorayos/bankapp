package com.uab.taller.store.controller;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.domain.dto.request.AccountRequest;
import com.uab.taller.store.service.IAccountService;
import com.uab.taller.store.usecase.account.usecases.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/accountes")
public class AccountController {
    @Autowired
    IAccountService accountService;
    @Autowired
    CreateAccountUseCase createAccountUseCase;
    @Autowired
    GetAllAccountUseCase getAllAccountUseCase;
    @Autowired
    GetAccountByIdUseCase getAccountByIdUseCase;
    @Autowired
    DeleteAccountUseCase deleteAccountUseCase;
    @Autowired
    private UpdateAccountUseCase updateAccountUseCase;

    @PostMapping("")
    public Account save(@RequestBody AccountRequest accountRequest) {
        return createAccountUseCase.execute(accountRequest);
    }

    @GetMapping()
    public List<Account> getAllAccounts() {
        return getAllAccountUseCase.execute();
    }

    @GetMapping(value="/{accountId}")
    public Account getAccountById(@PathVariable Long accountId) {
        return getAccountByIdUseCase.execute(accountId);
    }

    @PutMapping("/{accountId}")
    public Account updateAccount(@PathVariable Long accountId, @RequestBody AccountRequest accountRequest) {
        return updateAccountUseCase.execute(accountId, accountRequest);
    }

    @DeleteMapping("/{accountId}")
    public void deleteAccount(@PathVariable Long accountId) {
        deleteAccountUseCase.execute(accountId);
    }
}
