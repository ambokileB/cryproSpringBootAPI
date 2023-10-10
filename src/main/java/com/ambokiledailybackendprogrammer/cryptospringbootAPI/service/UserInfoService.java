package com.ambokiledailybackendprogrammer.cryptospringbootAPI.service;

import com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity.UserInfo;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.request.UserRequest;

public interface UserInfoService {
    public UserInfo addUser(UserRequest userRequest);
}
