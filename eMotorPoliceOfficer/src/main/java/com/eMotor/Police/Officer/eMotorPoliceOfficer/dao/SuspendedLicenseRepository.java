package com.eMotor.Police.Officer.eMotorPoliceOfficer.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Driver;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.SuspendedLicense;

public interface SuspendedLicenseRepository extends JpaRepository<SuspendedLicense, Integer> {

	@Query("SELECT sl FROM SuspendedLicense sl where sl.driver = :driver") 
	 public Optional<SuspendedLicense> findSuspendedLicense(Driver driver);
}
