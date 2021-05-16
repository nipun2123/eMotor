package com.eMotor.Police.Officer.eMotorPoliceOfficer.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.Penalty;

public interface PenaltyRepository extends JpaRepository<Penalty, Integer> {

	@Query("SELECT p FROM Penalty p where p.type = :type") 
	 public List<Penalty> findPenaltiesByType(String type);
}
