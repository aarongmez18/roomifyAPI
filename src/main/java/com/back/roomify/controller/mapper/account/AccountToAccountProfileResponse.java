package com.back.roomify.controller.mapper.account;

import com.back.roomify.domain.dtos.response.account.AccountProfileResponse;
import com.back.roomify.domain.entity.Account;
import lombok.NonNull;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountToAccountProfileResponse extends Converter<Account, AccountProfileResponse> {

    @Autowired
    AccountProfileResponse convert(@NonNull Account source);
}
