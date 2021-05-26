package com.eMotor.Driver.eMotorDriver.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eMotor.Driver.eMotorDriver.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

	@Query("SELECT d FROM Driver d where d.licenseNo = :licenseNo and d.nic = :nic") 
	 public Optional<Driver> findDriving(String licenseNo, String nic);
	
}
