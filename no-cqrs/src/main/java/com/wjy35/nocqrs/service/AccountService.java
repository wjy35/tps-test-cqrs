package com.wjy35.nocqrs.service;

import com.wjy35.nocqrs.db.entity.Account;

public interface AccountService {
    Account createAccount(Account account);
    Account updateAccount(Account account);
    Account detailAccount(Long accountId);
}
