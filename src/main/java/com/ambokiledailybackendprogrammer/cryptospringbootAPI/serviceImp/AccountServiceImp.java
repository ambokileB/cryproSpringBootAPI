package com.ambokiledailybackendprogrammer.cryptospringbootAPI.serviceImp;

import com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity.Account;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.repository.AccountRepository;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.request.AccountRequest;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImp implements AccountService {
    @Autowired
    private final AccountRepository accountRepository;

    public AccountServiceImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public Account makeDeposit(Long accountId, AccountRequest accountRequest) {

        // Retrieve the account by its unique ID
        Account existingAccount = accountRepository.findByAccountId(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found for ID: " + accountId));


        // Update the balance with the deposit amount from the request
        Double currentBalance = existingAccount.getBalance();
        Double depositAmount = accountRequest.getBalance();

//        Double newBalance = Double.parseDouble(currentBalance) + Double.parseDouble(depositAmount);
        Double newBalance = currentBalance + depositAmount;

        // Update the balance on the existing account
        existingAccount.setBalance(newBalance);

        // Save the updated account
        return accountRepository.save(existingAccount);
    }

    @Override
    public Account makeWithdraw(Long accountId, AccountRequest accountRequest) {

        // Retrieve the account by its unique ID
        Account existingAccount = accountRepository.findByAccountId(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found for ID: " + accountId));

        // Update the balance by subtracting the withdrawal amount from the request
        Double currentBalance = existingAccount.getBalance();
        Double withdrawalAmount = accountRequest.getBalance();

//        Double newBalance  = currentBalance - withdrawalAmount;
//        if (newBalance < 0) {
//            throw new IllegalArgumentException("Insufficient balance for withdrawal");
//        }
//
//        // Update the balance on the existing account
//        existingAccount.setBalance(newBalance);
//
//        // Save the updated account
//        return accountRepository.save(existingAccount);

        if (currentBalance <= 5000){

            Double newBalance  = currentBalance - withdrawalAmount;
            Double penalty = 2000.00;
            existingAccount.setBalance(newBalance - penalty);
            return accountRepository.save(existingAccount);

        }
        else {
            Double newBalance  = currentBalance - withdrawalAmount;
            existingAccount.setBalance(newBalance);
            return accountRepository.save(existingAccount);

        }


    }


//    @Scheduled(fixedRate = 24 * 60 * 60 * 1000) // Run every 24 hours
   @Scheduled(fixedRate = 5000) // Run every 24 hours
    public void autoUpdateBalances() {
        List<Account> userAccounts = accountRepository.findAll();

        for (Account account : userAccounts) {
            Double currentBalance = account.getBalance();

            if (currentBalance >= 26) {

                currentBalance += 0.6;
                account.setBalance(currentBalance);
                accountRepository.save(account);
            }
            if (currentBalance >= 61) {

                currentBalance += 1.6;
                account.setBalance(currentBalance);
                accountRepository.save(account);
            }
            if (currentBalance >= 201) {

                currentBalance += 3.2;
                account.setBalance(currentBalance);
                accountRepository.save(account);
            }
            if (currentBalance >= 501) {

                currentBalance += 10;
                account.setBalance(currentBalance);
                accountRepository.save(account);
            }
            if (currentBalance >= 901) {

                currentBalance += 24;
                account.setBalance(currentBalance);
                accountRepository.save(account);
            }
            if (currentBalance >= 1500) {

                currentBalance += 36;
                account.setBalance(currentBalance);
                accountRepository.save(account);
            }

            if (currentBalance >= 2001) {

                currentBalance += 43;
                account.setBalance(currentBalance);
                accountRepository.save(account);
            }
            if (currentBalance >= 5001) {

                currentBalance += 109;
                account.setBalance(currentBalance);
                accountRepository.save(account);
            }
            if (currentBalance >= 10000) {

                currentBalance += 218;
                account.setBalance(currentBalance);
                accountRepository.save(account);
            }
            if (currentBalance >= 20000) {

                currentBalance += 514;
                account.setBalance(currentBalance);
                accountRepository.save(account);
            }

        }
    }



}
