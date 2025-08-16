package com.vedalvi.jwt_auth.exeption.dao;

import lombok.*;

@AllArgsConstructor
@ToString
@Getter
@Setter
@Builder
public class UserResponse {
    private int status;
    private String message;
}
