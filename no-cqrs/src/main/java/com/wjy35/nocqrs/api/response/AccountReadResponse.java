package com.wjy35.nocqrs.api.response;

import lombok.Data;

@Data
public class AccountReadResponse {
    private Long accountId;
    private String nickname;
    private String name;
}
