package com.ambokiledailybackendprogrammer.cryptospringbootAPI.controller;

import com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity.UserInfo;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.request.UserRequest;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.securityConfig.JwtService;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.authentication.AuthenticationManager;

@RestController
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    private final UserInfoService userInfoService;
    private AuthenticationManager  authenticationManager;

    private JwtService jwtService;

    public UserInfoController(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }

    @PostMapping("/register")
    public UserInfo addUser(@RequestBody UserRequest userRequest){
        return userInfoService.addUser(userRequest);
    }

    @GetMapping("/welcome")
    public String Welcome(){
        return "Welcome endpoint not secured";
    }

    @GetMapping("/userProfile")
    @PreAuthorize("hasAuthority('USER')")
    public String UserProfile(){
        return "Welcome to user profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }


}
