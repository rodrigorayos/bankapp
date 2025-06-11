package com.uab.taller.store.usecases.account.usecases;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.domain.User;
import com.uab.taller.store.domain.dto.request.AccountRequest;
import com.uab.taller.store.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateAccountUseCase {

    @Autowired
    IAccountService accountService;

    public Account execute(Long accountId, AccountRequest accountRequest) {
        Account accountToUpdate = accountService.getById(accountId);

        accountToUpdate.setBalance(accountRequest.getBalance());
        accountToUpdate.setCurrencyType(accountRequest.getCurrencyType());

        if (accountRequest.getUserId() != null) {
            User user = new User();
            user.setId(accountRequest.getUserId());
            accountToUpdate.setUser(user);
        }

        return accountService.save(accountToUpdate);
    }
}

