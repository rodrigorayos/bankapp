package com.uab.taller.store.usecases.account.usecases;

import com.uab.taller.store.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteAccountUseCase {
    @Autowired
    IAccountService accountService;

    public void execute(Long accountId) {
        accountService.deleteById(accountId);
    }
}
