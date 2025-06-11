package com.uab.taller.store.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse {
    private Long userId;
    private String email;
    private Long profileId;
}
