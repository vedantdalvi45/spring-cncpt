package com.vedalvi.jwt_auth.exception.dao;

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
