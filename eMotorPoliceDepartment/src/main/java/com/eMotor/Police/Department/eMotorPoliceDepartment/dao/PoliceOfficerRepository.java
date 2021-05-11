package com.eMotor.Police.Department.eMotorPoliceDepartment.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.PoliceOfficer;

public interface PoliceOfficerRepository extends JpaRepository<PoliceOfficer, Integer> {
	 

	 @Query("SELECT p FROM PoliceOfficer p where p.nic = :nic") 
		public Optional<PoliceOfficer> findByNIC(String nic);
	 
	 @Query("SELECT p FROM PoliceOfficer p where p.officerNo = :officerNo") 
		public Optional<PoliceOfficer> findByOfficerNo(String officerNo);
}
