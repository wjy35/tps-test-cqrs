package com.wjy35.nocqrs;

import com.wjy35.nocqrs.db.entity.Account;
import com.wjy35.nocqrs.db.repository.AccountRepository;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RepositoryTest {
    @Autowired
    AccountRepository accountRepository;

    @Test
    void testRepositoryLoad(){
        assertNotNull(accountRepository);
    }

    @Test
    void select_Account_Success(){
        Long accountId = 1l;

        Account account = accountRepository.findById(accountId).get();

        System.out.println("account.getAccountId() = " + account.getAccountId());
        assertEquals(accountId, account.getAccountId());
    }
}
