package com.back.roomify.service.account.impl;

import com.back.roomify.domain.dtos.request.account.AccountSearchRequest;
import com.back.roomify.domain.entity.Account;
import com.back.roomify.repository.AccountRepository;
import com.back.roomify.service.account.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public Account getProfile(Long accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }

    @Override
    public List<Account> searchAccountsByUsername(AccountSearchRequest request) {
        return accountRepository.findByUsernameContainingIgnoreCase(request.getUsername());
    }

    @Override
    public Account getMyProfile() {
        return null;
    }
}
