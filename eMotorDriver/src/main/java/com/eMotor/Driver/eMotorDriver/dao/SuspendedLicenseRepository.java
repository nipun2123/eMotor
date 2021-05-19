package com.eMotor.Driver.eMotorDriver.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eMotor.Driver.eMotorDriver.entity.Driver;
import com.eMotor.Driver.eMotorDriver.entity.SuspendedLicense;

public interface SuspendedLicenseRepository extends JpaRepository<SuspendedLicense, Integer> {

	@Query("SELECT sl FROM SuspendedLicense sl where sl.driver = :driver") 
	 public Optional<SuspendedLicense> findSuspendedLicense(Driver driver);
}
