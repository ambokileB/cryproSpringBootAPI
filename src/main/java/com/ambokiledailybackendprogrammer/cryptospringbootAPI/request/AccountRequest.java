package com.ambokiledailybackendprogrammer.cryptospringbootAPI.request;

public class AccountRequest {
    private Double balance;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountRequest() {
    }

    public AccountRequest(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "AccountRequest{" +
                "balance=" + balance +
                '}';
    }
}
