package com.eMotor.Police.Officer.eMotorPoliceOfficer.dao;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.CompletedRecord;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.DriverPenalty;

public interface CompletedRecordRepository extends JpaRepository<CompletedRecord, Integer> {

	@Query("SELECT cr FROM CompletedRecord cr where cr.driverPenalty = :driverPenalty") 
	 public Optional<CompletedRecord> findCompletedRecord(DriverPenalty driverPenalty);
	
	@Query("SELECT cr FROM CompletedRecord cr where DATE(cr.completedDate) = :completedDate") 
	 public List<CompletedRecord> findCompletedRecordsToday(Date completedDate);
	
	@Query("SELECT cr FROM CompletedRecord cr where DATE(cr.completedDate)  BETWEEN :startDate AND :endDate") 
	 public List<CompletedRecord> findCompletedRecordsBetween(Date startDate,Date endDate);
}
