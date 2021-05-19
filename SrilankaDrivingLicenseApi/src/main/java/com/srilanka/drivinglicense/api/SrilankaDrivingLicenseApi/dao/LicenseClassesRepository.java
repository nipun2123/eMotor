package com.srilanka.drivinglicense.api.SrilankaDrivingLicenseApi.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.srilanka.drivinglicense.api.SrilankaDrivingLicenseApi.entity.License;
import com.srilanka.drivinglicense.api.SrilankaDrivingLicenseApi.entity.LicenseClasses;


public interface LicenseClassesRepository extends JpaRepository<LicenseClasses, Integer> {
	
	 @Query("SELECT lc FROM LicenseClasses lc where lc.license = :license") 
	 public List<LicenseClasses> findDrivingLicenseClasses(License license);
}
