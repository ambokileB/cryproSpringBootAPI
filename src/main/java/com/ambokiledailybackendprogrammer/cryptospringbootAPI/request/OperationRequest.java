package com.ambokiledailybackendprogrammer.cryptospringbootAPI.request;

import com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity.UserInfo;

public class OperationRequest {
    private String operationName;
    private Double balance;
    private UserInfo userInfo;

    public UserInfo getUserInfo(String userInfo) {
        return this.userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public OperationRequest() {
    }

    public OperationRequest(String operationName, Double balance, UserInfo userInfo) {
        this.operationName = operationName;
        this.balance = balance;
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "OperationRequest{" +
                "operationName='" + operationName + '\'' +
                ", balance=" + balance +
                ", userInfo=" + userInfo +
                '}';
    }
}
