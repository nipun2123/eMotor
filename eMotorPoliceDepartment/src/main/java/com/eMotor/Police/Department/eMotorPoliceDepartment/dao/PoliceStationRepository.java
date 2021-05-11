package com.eMotor.Police.Department.eMotorPoliceDepartment.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.PoliceStation;

public interface PoliceStationRepository extends JpaRepository<PoliceStation, Integer> {
	 
	 @Query("SELECT p FROM PoliceStation p where p.policeStation = :policeStation") 
	public Optional<PoliceStation> findByPoliceStation(String policeStation);
	 
}
