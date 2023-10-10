package com.ambokiledailybackendprogrammer.cryptospringbootAPI.controller;

import com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity.Account;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.request.AccountRequest;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/{accountId}/deposit")
    public ResponseEntity<Account> makeDeposit(
            @PathVariable Long accountId,
            @RequestBody AccountRequest accountRequest
    ) {
        Account updatedAccount = accountService.makeDeposit(accountId, accountRequest);
        return ResponseEntity.ok(updatedAccount);
    }

    @PostMapping("/{accountId}/withdraw")
    public ResponseEntity<Account> makeWithdraw(
            @PathVariable Long accountId,
            @RequestBody AccountRequest accountRequest
    ) {
        Account updatedAccount = accountService.makeWithdraw(accountId, accountRequest);
        return ResponseEntity.ok(updatedAccount);
    }
}
