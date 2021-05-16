package com.eMotor.Police.Officer.eMotorPoliceOfficer.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Driver;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;

public interface DriverPenaltyRepository extends JpaRepository<DriverPenalty, Integer> {

	@Query("SELECT dp FROM DriverPenalty dp where dp.driver = :driver") 
	 public List<DriverPenalty> findDriverPenalty(Driver driver);
	
	@Query("SELECT count(dp) FROM DriverPenalty dp where dp.driver = :driver") 
	 public int findDriverPenaltycountByDriver(Driver driver);
	
	@Query("SELECT dp FROM DriverPenalty dp where dp.penaltyNo = :penaltyNo") 
	 public DriverPenalty findDriverPenaltyByNo(String penaltyNo);
}
