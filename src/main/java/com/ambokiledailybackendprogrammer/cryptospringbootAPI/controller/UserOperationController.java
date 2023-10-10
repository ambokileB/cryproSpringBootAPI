package com.ambokiledailybackendprogrammer.cryptospringbootAPI.controller;

import com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity.UserInfo;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity.UserOperations;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.request.OperationRequest;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.service.UserOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/request")
public class UserOperationController {
    @Autowired
    private  final UserOperationService userOperationService;

    public UserOperationController(UserOperationService userOperationService) {
        this.userOperationService = userOperationService;
    }

    @PostMapping("/{userId}")
    public ResponseEntity<UserOperations> createNewOperation(
            @PathVariable String userId,
            @RequestBody OperationRequest operationRequest) {

        UserOperations createdOperation = userOperationService.createNewOperation(userId, operationRequest);
        return new ResponseEntity<>(createdOperation, HttpStatus.CREATED);
    }
    @GetMapping("/getAllRequest")
    public List<UserOperations> getAllUserOperations(){
       return userOperationService.getAllUserOperations();
    }
}
