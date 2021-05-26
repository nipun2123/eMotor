package com.eMotor.Police.Department.eMotorPoliceDepartment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.DepartmentAccount;

public interface DepartmentAccountRepository extends JpaRepository<DepartmentAccount, Integer> {
	
	 @Query("SELECT da FROM DepartmentAccount da where da.username = :username and da.password = :password") 
	 public DepartmentAccount chekcUsernamePassword(String username,String password);
}
