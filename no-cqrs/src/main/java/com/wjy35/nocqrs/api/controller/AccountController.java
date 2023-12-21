package com.wjy35.nocqrs.api.controller;

import com.wjy35.nocqrs.api.mapper.AccountMapper;
import com.wjy35.nocqrs.api.request.AccountCreationRequest;
import com.wjy35.nocqrs.api.request.AccountUpdateRequest;
import com.wjy35.nocqrs.api.response.AccountCreationResponse;
import com.wjy35.nocqrs.api.response.AccountReadResponse;
import com.wjy35.nocqrs.api.response.AccountUpdateResponse;
import com.wjy35.nocqrs.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;
    private final AccountMapper accountMapper = AccountMapper.INSTANCE;
    @GetMapping("/{accountId}")
    AccountReadResponse detail(@PathVariable Long accountId){
        return accountMapper.toReadResponse(accountService.detailAccount(accountId));
    }

    @PostMapping("/")
    AccountCreationResponse join(@RequestBody AccountCreationRequest accountCreationRequest){
        return accountMapper.toCreationResponse(accountService.createAccount(AccountMapper.INSTANCE.toEntity(accountCreationRequest)));
    }

    @PutMapping("/")
    AccountUpdateResponse update(@RequestBody AccountUpdateRequest accountUpdateRequest){
        return accountMapper.toUpdateResponse(accountService.updateAccount(AccountMapper.INSTANCE.toEntity(accountUpdateRequest)));
    }
}
