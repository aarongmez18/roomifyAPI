package com.back.roomify.service.account;

import com.back.roomify.domain.dtos.request.account.AccountSearchRequest;
import com.back.roomify.domain.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    Account getProfile(Long accountId);

    List<Account> searchAccountsByUsername(AccountSearchRequest request);

    Account getMyProfile();

}
