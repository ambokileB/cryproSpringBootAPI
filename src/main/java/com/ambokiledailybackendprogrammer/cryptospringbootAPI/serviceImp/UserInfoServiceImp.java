package com.ambokiledailybackendprogrammer.cryptospringbootAPI.serviceImp;

import com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity.Account;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity.Role;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity.UserInfo;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.repository.UserInfoRepository;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.request.UserRequest;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserInfoServiceImp implements UserInfoService {
    @Autowired
    private final UserInfoRepository userInfoRepository;

    public UserInfoServiceImp(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }


    @Override
    public UserInfo addUser(UserRequest userRequest) {
        UserInfo newUserCreated = new UserInfo();
        newUserCreated.setUsername(userRequest.getUsername());
        newUserCreated.setEmail(userRequest.getEmail());
        newUserCreated.setPassword(userRequest.getPassword());
        newUserCreated.setRole(Role.USER);
        Account balance = new Account();
        balance.setBalance(0.00);
        newUserCreated.setAccount(balance);
        return userInfoRepository.save(newUserCreated);
    }
}
