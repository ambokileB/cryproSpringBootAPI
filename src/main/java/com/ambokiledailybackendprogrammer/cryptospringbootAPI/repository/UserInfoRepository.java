package com.ambokiledailybackendprogrammer.cryptospringbootAPI.repository;

import com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo,String> {
        Optional<UserInfo>findByUserId(String userId);
        Optional<UserInfo>findByUsername(String username);
}
