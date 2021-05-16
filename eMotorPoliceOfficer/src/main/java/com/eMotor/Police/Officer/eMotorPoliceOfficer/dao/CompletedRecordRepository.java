package com.eMotor.Police.Officer.eMotorPoliceOfficer.dao;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.CompletedRecord;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;

public interface CompletedRecordRepository extends JpaRepository<CompletedRecord, Integer> {

	@Query("SELECT cr FROM CompletedRecord cr where cr.driverPenalty = :driverPenalty") 
	 public Optional<CompletedRecord> findCompletedRecord(DriverPenalty driverPenalty);
}
