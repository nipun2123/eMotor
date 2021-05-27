package com.eMotor.Police.Department.eMotorPoliceDepartment;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.Penalty;
import com.eMotor.Police.Department.eMotorPoliceDepartment.entity.PenaltyDateSettings;
import com.eMotor.Police.Department.eMotorPoliceDepartment.service.PenaltyService;

@SpringBootTest
class PenaltyMaintainTests {
	
	
	@Autowired
	PenaltyService penaltyService;

	@Test
	public void saveSpotTest() {
		Penalty penalty = new Penalty();
		penalty.setIdPenalty(0);
		penalty.setPenaltyEnglish("Non-compliance with Speed limits provisions");
		penalty.setPenaltySinhala("වේග සීමා විධිවිධාන වලට අනුකූලව ධාවන නොකිරීම");
		penalty.setPenaltyTamil("வேக வரம்பு விதிகளின்படி வாகனம் ஓட்டுவதில் தோல்வி");
		penalty.setAmount(3000);
		
		Penalty response = penaltyService.saveSpot(penalty);
		Assert.assertEquals("Non-compliance with Speed limits provisions", response.getPenaltyEnglish());
	}
	
	@Test
	public void saveCourtTest() {
		Penalty penalty = new Penalty();
		penalty.setIdPenalty(0);
		penalty.setPenaltyEnglish("Reckless driving");
		penalty.setPenaltySinhala("අපරික්ෂාකාරී ලෙස රිය පැදවීම");
		penalty.setPenaltyTamil("பொறுப்பற்ற முறையில் வாகனம் ஓட்டுதல்");
		
		Penalty response = penaltyService.saveCourt(penalty);
		Assert.assertEquals("Reckless driving",  response.getPenaltyEnglish());
	}
	
	@Test
	public void saveWarnTest() {
		Penalty penalty = new Penalty();
		penalty.setIdPenalty(0);
		penalty.setPenaltyEnglish("Driving without rear light bulbs");
		penalty.setPenaltySinhala("පිටිපස විදුලි බල්බ නොමැතිව ධාවනය කිරීම");
		penalty.setPenaltyTamil("பின்புற ஒளி விளக்குகள் இல்லாமல் வாகனம் ஓட்டுதல்");
		
		Penalty response = penaltyService.saveWarn(penalty);
		Assert.assertEquals("Driving without rear light bulbs",  response.getPenaltyEnglish());
	}
	
	@Test
	public void savePenaltyDateSettingsTest() {
		PenaltyDateSettings settings = new PenaltyDateSettings();
		settings.setDoubleDateCount(14);
		settings.setCourtDateCount(28);
		
		PenaltyDateSettings response = penaltyService.savePenaltyDateSettings(settings);
		Assert.assertEquals(14, response.getDoubleDateCount());
	}
	
	

}
