package com.wjy35.nocqrs.api.request;

import lombok.Data;

@Data
public class AccountUpdateRequest {
    private Long accountId;
    private String nickname;
    private String name;
}
