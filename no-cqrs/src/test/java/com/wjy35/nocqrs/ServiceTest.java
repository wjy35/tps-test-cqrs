package com.wjy35.nocqrs;

import com.wjy35.nocqrs.db.entity.AccountEntity;
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
    void detail_return_Selected_AccountEntity(){
        //given
        AccountEntity expected = AccountEntity.builder().accountId(1l).nickname("wjy35").name("왕준영").build();
        when(accountRepository.findById(1l)).thenReturn(Optional.ofNullable(expected));

        //when
        AccountEntity selectedAccountEntity = accountService.detailAccount(1l);

        //then
        System.out.println("selectedAccountId = " + selectedAccountEntity.getAccountId());
        assertEquals(expected.getAccountId(), selectedAccountEntity.getAccountId());
    }

    @Test
    @Transactional
    void join_return_Created_Account(){
        //given
        AccountEntity expected = AccountEntity.builder().accountId(1l).nickname("wjy35").name("왕준영").build();
        when(accountRepository.save(any(AccountEntity.class))).thenReturn(expected);

        //when
        AccountEntity actual = accountService.createAccount(expected);

        //then
        assertEquals(expected.getAccountId(),actual.getAccountId());
        verify(accountRepository,times(1)).save(expected);
    }

    @Test
    @Transactional
    void update_return_Updated_Account(){
        //given
        Long accountId = 1l;
        AccountEntity expected = AccountEntity.builder()
                .accountId(accountId)
                .nickname("wjy0516")
                .name("왕준영").build();
        when(accountRepository.findById(accountId)).thenReturn(Optional.ofNullable(expected));

        //when
        AccountEntity actual = accountService.updateAccount(expected);

        //then
        System.out.println("actual.getNickname() = " + actual.getNickname());
        assertEquals(expected.getAccountId(),actual.getAccountId());
    }
}
