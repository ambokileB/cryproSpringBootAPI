package com.ambokiledailybackendprogrammer.cryptospringbootAPI.service;

import com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity.UserInfo;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity.UserOperations;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.request.OperationRequest;

import java.util.List;

public interface UserOperationService {
    UserOperations createNewOperation(String userId,OperationRequest operationRequest);
     List<UserOperations> getAllUserOperations();
}
