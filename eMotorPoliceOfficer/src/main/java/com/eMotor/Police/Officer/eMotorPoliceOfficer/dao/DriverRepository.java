package com.eMotor.Police.Officer.eMotorPoliceOfficer.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

	@Query("SELECT d FROM Driver d where d.licenseNo = :licenseNo and d.nic = :nic") 
	 public Optional<Driver> findDriving(String licenseNo, String nic);
	
	@Query("SELECT d FROM Driver d where d.licenseNo = :licenseNo") 
	 public Optional<Driver> findDriving(String licenseNo);
}
