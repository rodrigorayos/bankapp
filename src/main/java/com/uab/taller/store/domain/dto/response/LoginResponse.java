package com.uab.taller.store.domain.dto.response;

import com.uab.taller.store.domain.Account;
import com.uab.taller.store.domain.Profile;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LoginResponse {
    private String email;
    private String role;
    private Profile profile;
    private List<Account> accounts;
}
