package com.wjy35.nocqrs;

import com.wjy35.nocqrs.db.entity.Account;
import com.wjy35.nocqrs.db.repository.AccountRepository;
import com.wjy35.nocqrs.service.impl.AccountServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ServiceTest {
    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    @Test
    void detail_return_Selected_Account(){
        //given
        Account expected = Account.builder().accountId(1l).nickname("wjy35").name("왕준영").build();
        when(accountRepository.findById(1l)).thenReturn(Optional.ofNullable(expected));

        //when
        Account selectedAccount = accountService.detailAccount(1l);

        //then
        System.out.println("selectedAccountId = " + selectedAccount.getAccountId());
        assertEquals(expected.getAccountId(), selectedAccount.getAccountId());
    }

    @Test
    @Transactional
    void join_return_Created_Account(){
        //given
        Account expected = Account.builder().accountId(1l).nickname("wjy35").name("왕준영").build();
        when(accountRepository.save(any(Account.class))).thenReturn(expected);

        //when
        Account actual = accountService.createAccount(expected);

        //then
        assertEquals(expected.getAccountId(),actual.getAccountId());
        verify(accountRepository,times(1)).save(expected);
    }

    @Test
    @Transactional
    void update_return_Updated_Account(){
        //given
        Long accountId = 1l;
        Account expected = Account.builder()
                .accountId(accountId)
                .nickname("wjy0516")
                .name("왕준영").build();
        when(accountRepository.findById(accountId)).thenReturn(Optional.ofNullable(expected));

        //when
        Account actual = accountService.updateAccount(expected);

        //then
        System.out.println("actual.getNickname() = " + actual.getNickname());
        assertEquals(expected.getAccountId(),actual.getAccountId());
    }
}
