package com.back.roomify.repository;

import com.back.roomify.domain.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    List<Account> findByUsernameContainingIgnoreCase(String username);
}
