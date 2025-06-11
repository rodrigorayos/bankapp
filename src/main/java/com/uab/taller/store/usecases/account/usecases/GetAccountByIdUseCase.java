package com.uab.taller.store.usecases.account.usecases;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAccountByIdUseCase {
    @Autowired
    IAccountService accountService;
    public Account execute(Long accountId){
        return accountService.getById(accountId);
    }
}
