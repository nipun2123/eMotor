package com.eMotor.Police.Department.eMotorPoliceDepartment.service;

import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.DepartmentAccount;

public interface UserService {
    DepartmentAccount findByUsername(String username);
}