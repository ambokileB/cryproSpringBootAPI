package com.ambokiledailybackendprogrammer.cryptospringbootAPI.repository;

import com.ambokiledailybackendprogrammer.cryptospringbootAPI.entity.UserOperations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserPerationRepository extends JpaRepository<UserOperations,Long> {
    Optional<UserOperations>findByOperationId(Long operationId);
}
