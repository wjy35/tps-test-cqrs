package com.wjy35.nocqrs.service.impl;

import com.wjy35.nocqrs.db.entity.Account;
import com.wjy35.nocqrs.db.repository.AccountRepository;
import com.wjy35.nocqrs.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;

    @Override
    @Transactional
    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    @Transactional
    public Account updateAccount(Account account) {
        Account selectedAccount = accountRepository.findById(account.getAccountId())
                .orElseThrow(()->new RuntimeException());

        selectedAccount.updateNickname(account.getNickname());
        return account;
    }

    @Override
    public Account detailAccount(Long id) {
        Account account;
        account = accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException());

        return account;
    }
}
