package com.eMotor.Police.Department.eMotorPoliceDepartment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eMotor.Police.Department.eMotorPoliceDepartment.dao.DepartmentAccountRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.DepartmentAccount;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private DepartmentAccountRepository departmentAccountRepository;
    

    @Override
    public DepartmentAccount findByUsername(String username) {
        return departmentAccountRepository.findByUsername(username);
    }
}