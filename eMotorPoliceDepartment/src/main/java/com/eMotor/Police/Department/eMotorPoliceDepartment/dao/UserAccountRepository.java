package com.eMotor.Police.Department.eMotorPoliceDepartment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.UserAccount;

public interface UserAccountRepository extends JpaRepository<UserAccount, Integer> {
	
	 @Query("SELECT u FROM UserAccount u where u.username = :username") 
    UserAccount findByUsername(String username);
}