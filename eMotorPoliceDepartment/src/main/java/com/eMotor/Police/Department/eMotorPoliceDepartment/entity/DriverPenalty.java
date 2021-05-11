package com.eMotor.Police.Department.eMotorPoliceDepartment.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="driverpenalty")
public class DriverPenalty  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="iddriverpenalty", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idDriverPenalty;
	
	@Column(name="penaltyno", nullable = false, length=12)
	String penaltyNo;
	
	@Column(name = "penaltyfrom")
	LocalDateTime penaltyFrom;
	
	@Column(name = "penaltyto")
	LocalDateTime penaltyTo;
	
	@Column(name="place", nullable = false, length=45)
	String place;
	
	@Column(name="court", nullable = false, length=45)
	String court;
	
	@Column(name="courtdate")
	Date courtDate;
	
	@Column(name="type", nullable = false, length=5)
	String type;
	
	@Column(name="status", nullable = false, length=10)
	String status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="driver_iddriver", nullable = false)
	private Driver driver;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="penalty_idpenalty", nullable = false)
	private Penalty penalty;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="courtpenalty_idcourtpenalty")
	private CourtPenalty courtPenalty;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userccount_iduseraccount", nullable = false)
	private UserAccount useraccount;

	
	public DriverPenalty() {

	}
	
	public DriverPenalty(int idDriverPenalty, String penaltyNo, LocalDateTime penaltyFrom, LocalDateTime penaltyTo,
			String place, String court, Date courtDate, String type, String status, Driver driver, Penalty penalty,
			CourtPenalty courtPenalty, UserAccount useraccount) {

		this.idDriverPenalty = idDriverPenalty;
		this.penaltyNo = penaltyNo;
		this.penaltyFrom = penaltyFrom;
		this.penaltyTo = penaltyTo;
		this.place = place;
		this.court = court;
		this.courtDate = courtDate;
		this.type = type;
		this.status = status;
		this.driver = driver;
		this.penalty = penalty;
		this.courtPenalty = courtPenalty;
		this.useraccount = useraccount;
	}

	public int getIdDriverPenalty() {
		return idDriverPenalty;
	}

	public void setIdDriverPenalty(int idDriverPenalty) {
		this.idDriverPenalty = idDriverPenalty;
	}

	public String getPenaltyNo() {
		return penaltyNo;
	}

	public void setPenaltyNo(String penaltyNo) {
		this.penaltyNo = penaltyNo;
	}

	public LocalDateTime getPenaltyFrom() {
		return penaltyFrom;
	}

	public void setPenaltyFrom(LocalDateTime penaltyFrom) {
		this.penaltyFrom = penaltyFrom;
	}

	public LocalDateTime getPenaltyTo() {
		return penaltyTo;
	}

	public void setPenaltyTo(LocalDateTime penaltyTo) {
		this.penaltyTo = penaltyTo;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
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

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public Penalty getPenalty() {
		return penalty;
	}

	public void setPenalty(Penalty penalty) {
		this.penalty = penalty;
	}

	public CourtPenalty getCourtPenalty() {
		return courtPenalty;
	}

	public void setCourtPenalty(CourtPenalty courtPenalty) {
		this.courtPenalty = courtPenalty;
	}

	public UserAccount getUseraccount() {
		return useraccount;
	}

	public void setUseraccount(UserAccount useraccount) {
		this.useraccount = useraccount;
	}
	

	@Override
	public String toString() {
		return "DriverPenalty [idDriverPenalty=" + idDriverPenalty + ", penaltyNo=" + penaltyNo + ", penaltyFrom="
				+ penaltyFrom + ", penaltyTo=" + penaltyTo + ", place=" + place + ", court=" + court + ", courtDate="
				+ courtDate + ", type=" + type + ", status=" + status + ", driver=" + driver + ", penalty=" + penalty
				+ ", courtPenalty=" + courtPenalty + ", useraccount=" + useraccount + "]";
	}
	
	
	
}
