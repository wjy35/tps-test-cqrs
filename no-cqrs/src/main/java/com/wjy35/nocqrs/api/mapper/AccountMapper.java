package com.wjy35.nocqrs.api.mapper;

import com.wjy35.nocqrs.api.request.AccountCreationRequest;
import com.wjy35.nocqrs.api.request.AccountUpdateRequest;
import com.wjy35.nocqrs.api.response.AccountCreationResponse;
import com.wjy35.nocqrs.api.response.AccountReadResponse;
import com.wjy35.nocqrs.api.response.AccountUpdateResponse;
import com.wjy35.nocqrs.db.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AccountMapper {
    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account toEntity(AccountCreationRequest accountCreationRequest);
    Account toEntity(AccountUpdateRequest accountUpdateRequest);

    AccountCreationResponse toCreationResponse(Account account);
    AccountReadResponse toReadResponse(Account account);
    AccountUpdateResponse toUpdateResponse(Account account);
}
