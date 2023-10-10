package com.ambokiledailybackendprogrammer.cryptospringbootAPI.repository;

import com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByAccountId(Long accountId);
}
