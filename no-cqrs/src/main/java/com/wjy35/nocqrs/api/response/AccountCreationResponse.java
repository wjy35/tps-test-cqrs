package com.wjy35.nocqrs.api.response;

import lombok.Data;

@Data
public class AccountCreationResponse {
    private Long accountId;
    private String nickname;
    private String name;
}
