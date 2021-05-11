package com.eMotor.Police.Department.eMotorPoliceDepartment.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.FineAmount;

public interface FineAmountRepository extends JpaRepository<FineAmount, Integer> {
	 
}
