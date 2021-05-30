package com.eMotor.Police.Department.eMotorPoliceDepartment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.DepartmentAccount;

public interface DepartmentAccountRepository extends JpaRepository<DepartmentAccount, Integer> {
	
	DepartmentAccount findByUsername(String username);
	
}
