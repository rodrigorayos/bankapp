    package com.uab.taller.store.usecases.account.usecases;

    import com.uab.taller.store.domain.Account;
    import com.uab.taller.store.domain.User;
    import com.uab.taller.store.domain.dto.request.AccountRequest;
    import com.uab.taller.store.repository.UserRepository;
    import com.uab.taller.store.service.IAccountService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;

    @Service
    public class CreateAccountUseCase {
        @Autowired
        IAccountService accountService;

        @Autowired
        UserRepository userRepository;

        public Account execute(AccountRequest accountRequest) {
            User user = userRepository.findById(accountRequest.getUserId())
                    .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

            Account accountToCreate = new Account();
            accountToCreate.setBalance(accountRequest.getBalance());
            accountToCreate.setCurrencyType(accountRequest.getCurrencyType());
            accountToCreate.setUser(user);
            return accountService.save(accountToCreate);
        }
    }
