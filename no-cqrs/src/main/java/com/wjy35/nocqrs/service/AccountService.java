package com.wjy35.nocqrs.service;

import com.wjy35.nocqrs.db.entity.AccountEntity;

public interface AccountService {
    AccountEntity join(AccountEntity accountEntity);
    AccountEntity update(AccountEntity accountEntity);
    AccountEntity detail(Long accountId);
}
