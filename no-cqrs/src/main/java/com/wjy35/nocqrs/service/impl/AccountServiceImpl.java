package com.wjy35.nocqrs.service.impl;

import com.wjy35.nocqrs.db.entity.AccountEntity;
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
    public AccountEntity join(AccountEntity accountEntity) {
        return accountRepository.save(accountEntity);
    }

    @Override
    @Transactional
    public AccountEntity update(AccountEntity accountEntity) {
        AccountEntity selectedAccountEntity = accountRepository.findById(accountEntity.getAccountId())
                .orElseThrow(()->new RuntimeException());

        selectedAccountEntity.updateNickname(accountEntity.getNickname());
        return accountEntity;
    }

    @Override
    public AccountEntity detail(Long id) {
        AccountEntity accountEntity;
        accountEntity = accountRepository.findById(id)
                .orElseThrow(()->new RuntimeException());

        return accountEntity;
    }
}
