package com.ambokiledailybackendprogrammer.cryptospringbootAPI.serviceImp;

import com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity.UserInfo;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity.UserOperations;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.repository.UserInfoRepository;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.repository.UserPerationRepository;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.request.OperationRequest;
import com.ambokiledailybackendprogrammer.cryptospringbootAPI.service.UserOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserOperationServiceImp implements UserOperationService {
    @Autowired
    private  final UserPerationRepository userPerationRepository;
    @Autowired
    private final UserInfoRepository userInfoRepository;

    public UserOperationServiceImp(UserPerationRepository userPerationRepository, UserInfoRepository userInfoRepository) {
        this.userPerationRepository = userPerationRepository;
        this.userInfoRepository = userInfoRepository;
    }

    @Override
    public UserOperations createNewOperation(String userId,OperationRequest operationRequest) {
        UserInfo userInfo = userInfoRepository.findByUserId(userId)
                .orElseThrow(()-> new IllegalArgumentException("user Not found"));
        UserOperations userOperation = new UserOperations();
        userOperation.setOperationName(operationRequest.getOperationName());
        userOperation.setBalance(operationRequest.getBalance());
        userOperation.setUserInfo(userInfo);



        return userPerationRepository.save(userOperation);
    }



    @Override
    public List<UserOperations> getAllUserOperations() {

        return userPerationRepository.findAll();
    }
}
