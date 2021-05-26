package com.eMotor.Driver.eMotorDriver.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eMotor.Driver.eMotorDriver.entity.Driver;
import com.eMotor.Driver.eMotorDriver.entity.DriverPenalty;


public interface DriverPenaltyRepository extends JpaRepository<DriverPenalty, Integer> {

	@Query("SELECT dp FROM DriverPenalty dp where dp.driver = :driver") 
	 public List<DriverPenalty> findDriverPenalty(Driver driver);
	
	@Query("SELECT dp FROM DriverPenalty dp where dp.penaltyNo = :penaltyNo") 
	 public DriverPenalty findDriverPenaltyByNo(String penaltyNo);
	
}
