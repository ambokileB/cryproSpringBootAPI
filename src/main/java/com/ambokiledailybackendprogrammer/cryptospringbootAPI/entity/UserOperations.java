package com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class UserOperations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long operationId;
    private String operationName;
    private Double balance;
    @ManyToOne // Many UserOperations can belong to one UserInfo
    @JoinColumn(name = "user_info_id") // Name of the foreign key column in UserOperations table
    @JsonIgnore
    private UserInfo userInfo;

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
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

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public UserOperations() {
    }

    public UserOperations(Long operationId, String operationName, Double balance, UserInfo userInfo) {
        this.operationId = operationId;
        this.operationName = operationName;
        this.balance = balance;
        this.userInfo = userInfo;
    }

    @Override
    public String toString() {
        return "UserOperations{" +
                "operationId=" + operationId +
                ", operationName='" + operationName + '\'' +
                ", balance=" + balance +
                ", userInfo=" + userInfo +
                '}';
    }
}
