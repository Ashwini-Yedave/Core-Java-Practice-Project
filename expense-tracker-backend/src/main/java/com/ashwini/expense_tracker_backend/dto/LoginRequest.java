package com.ashwini.expense_tracker_backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class LoginRequest {

    private String email;
    private String password;//for api request and response
}
