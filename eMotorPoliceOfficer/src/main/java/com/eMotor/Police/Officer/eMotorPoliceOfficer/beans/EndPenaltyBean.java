package com.eMotor.Police.Officer.eMotorPoliceOfficer.beans;

import java.io.Serializable;

public class EndPenaltyBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String licenseNo;
	private String penaltyNo;
	private boolean payFine;
	
	
	private String paidAmount;
	
	private boolean licenseSuspend;

	private int suspededYear = 0;
	private int suspededMonth = 0;
	private int suspededDate = 0;
	
	private boolean jailed;
	
	private int jailedYear = 0;
	private int jailedMonth = 0;
	private int jailedDate = 0;
	
	private boolean freed;
	
	
	public boolean isJailed() {
		return jailed;
	}
	public void setJailed(boolean jailed) {
		this.jailed = jailed;
	}
	
	public boolean isLicenseSuspend() {
		return licenseSuspend;
	}
	public void setLicenseSuspend(boolean licenseSuspend) {
		this.licenseSuspend = licenseSuspend;
	}
	
	public int getSuspededYear() {
		return suspededYear;
	}
	public void setSuspededYear(int suspededYear) {
		this.suspededYear = suspededYear;
	}
	public int getSuspededMonth() {
		return suspededMonth;
	}
	public void setSuspededMonth(int suspededMonth) {
		this.suspededMonth = suspededMonth;
	}
	public int getSuspededDate() {
		return suspededDate;
	}
	public void setSuspededDate(int suspededDate) {
		this.suspededDate = suspededDate;
	}
	public int getJailedYear() {
		return jailedYear;
	}
	public void setJailedYear(int jailedYear) {
		this.jailedYear = jailedYear;
	}
	public int getJailedMonth() {
		return jailedMonth;
	}
	public void setJailedMonth(int jailedMonth) {
		this.jailedMonth = jailedMonth;
	}
	public int getJailedDate() {
		return jailedDate;
	}
	public void setJailedDate(int jailedDate) {
		this.jailedDate = jailedDate;
	}
	public boolean isFreed() {
		return freed;
	}
	public void setFreed(boolean freed) {
		this.freed = freed;
	}
	public String getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getPenaltyNo() {
		return penaltyNo;
	}
	public void setPenaltyNo(String penaltyNo) {
		this.penaltyNo = penaltyNo;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	
	public boolean isPayFine() {
		return payFine;
	}
	public void setPayFine(boolean payFine) {
		this.payFine = payFine;
	}
	
	 
}
