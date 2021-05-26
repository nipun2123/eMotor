package com.eMotor.Driver.eMotorDriver.dao;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eMotor.Driver.eMotorDriver.entity.CompletedRecord;
import com.eMotor.Driver.eMotorDriver.entity.DriverPenalty;

public interface CompletedRecordRepository extends JpaRepository<CompletedRecord, Integer> {

	@Query("SELECT cr FROM CompletedRecord cr where cr.driverPenalty = :driverPenalty") 
	 public Optional<CompletedRecord> findCompletedRecord(DriverPenalty driverPenalty);
}
