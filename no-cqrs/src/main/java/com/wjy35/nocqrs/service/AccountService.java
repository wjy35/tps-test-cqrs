package com.wjy35.nocqrs.service;

import com.wjy35.nocqrs.db.entity.AccountEntity;

public interface AccountService {
    AccountEntity createAccount(AccountEntity accountEntity);
    AccountEntity updateAccount(AccountEntity accountEntity);
    AccountEntity detailAccount(Long accountId);
}
