package com.eMotor.Police.Department.eMotorPoliceDepartment.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.Province;

public interface ProvinceRepository extends JpaRepository<Province, Integer> {
	
	 @Query("SELECT p FROM Province p where p.province = :province") 
	    Province findByProvince(@Param("province") String province);
}
