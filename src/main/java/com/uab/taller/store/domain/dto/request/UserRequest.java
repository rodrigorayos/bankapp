package com.uab.taller.store.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private String email;
    private String password;
    private Long profileId; // si ya existe un perfil
}
