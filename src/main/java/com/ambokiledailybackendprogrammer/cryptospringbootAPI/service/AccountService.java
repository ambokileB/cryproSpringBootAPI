package com.ambokiledailybackendprogrammer.cryptospringbootAPI.service;

import com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity.Account;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.request.AccountRequest;

public interface AccountService {


//    public Account makeDeposite( AccountRequest accountRequest);
Account makeDeposit(Long accountId, AccountRequest accountRequest);
Account makeWithdraw(Long accountId, AccountRequest accountRequest);
    void autoUpdateBalances();
}
