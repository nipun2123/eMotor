package com.eMotor.Police.Officer.eMotorPoliceOfficer.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.eMotor.Police.Officer.eMotorPoliceOfficer.entity.PoliceOfficer;


public interface PoliceOfficerRepository extends JpaRepository<PoliceOfficer, Integer> {
	 

	 @Query("SELECT p FROM PoliceOfficer p INNER JOIN Useraccount u on p.idPoliceOfficer = u.officer where u.username = :username") 
		public PoliceOfficer findByUsername(String username);
}
