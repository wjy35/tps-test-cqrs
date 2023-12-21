package com.wjy35.nocqrs.api.request;

import lombok.Data;

@Data
public class AccountCreationRequest {
    private String nickname;
    private String name;
}
