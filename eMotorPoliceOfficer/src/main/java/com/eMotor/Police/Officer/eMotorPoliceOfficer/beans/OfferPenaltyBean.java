package com.eMotor.Police.Officer.eMotorPoliceOfficer.beans;

import java.sql.Date;
import java.time.LocalDateTime;


public class OfferPenaltyBean {

	
	private String licenseNo;
	private String nic;
	private LocalDateTime penaltyFrom;
	private Date penaltyTo;
	private String place;
	private String vehicleNo;
	private String court;
	private Date courtDate;
	private String type;
	private String status;
	private int penaltyId;
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getNic() {
		return nic;
	}
	public void setNic(String nic) {
		this.nic = nic;
	}
	public LocalDateTime getPenaltyFrom() {
		return penaltyFrom;
	}
	public void setPenaltyFrom(LocalDateTime penaltyFrom) {
		this.penaltyFrom = penaltyFrom;
	}
	public Date getPenaltyTo() {
		return penaltyTo;
	}
	public void setPenaltyTo(Date penaltyTo) {
		this.penaltyTo = penaltyTo;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getVehicleNo() {
		return vehicleNo;
	}
	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}
	public String getCourt() {
		return court;
	}
	public void setCourt(String court) {
		this.court = court;
	}
	public Date getCourtDate() {
		return courtDate;
	}
	public void setCourtDate(Date courtDate) {
		this.courtDate = courtDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPenaltyId() {
		return penaltyId;
	}
	public void setPenaltyId(int penaltyId) {
		this.penaltyId = penaltyId;
	}
	
	
	
	
	 
}
