package com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private Account account;

    @OneToMany(mappedBy = "userInfo", cascade = CascadeType.ALL) // mappedBy refers to the field in UserOperations that maps to this relationship
    private List<UserOperations> userOperations;



    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public List<UserOperations> getUserOperations() {
        return userOperations;
    }

    public void setUserOperations(List<UserOperations> userOperations) {
        this.userOperations = userOperations;
    }

    public UserInfo() {
    }

    public UserInfo(String userId, String username, String email, String password, Role role, Account account, List<UserOperations> userOperations) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.account = account;
        this.userOperations = userOperations;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", account=" + account +
                ", userOperations=" + userOperations +
                '}';
    }
}
