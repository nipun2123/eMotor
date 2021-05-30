package com.eMotor.Driver.eMotorDriver.entity;

import java.io.Serializable;
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
@Table(name="completedrecords")
public class CompletedRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idcompletedrecords", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCompletedRecords;
	
	@Column(name = "completeddate" , nullable = false)
	private LocalDateTime completedDate;
	
	
	@Column(name="result", nullable = false, length = 500)
	private String result;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="useraccount_idaccount", nullable = false)
	private Useraccount useraccount;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="driverpenalty_iddriverpenalty", nullable = false)
	private DriverPenalty driverPenalty;
	
	
	@javax.persistence.Transient
	private String formatedCompletedDate;





	public CompletedRecord() {
		
	}

	


	public CompletedRecord(int idCompletedRecords, LocalDateTime completedDate, String result,
			Useraccount useraccount, DriverPenalty driverPenalty) {
		this.idCompletedRecords = idCompletedRecords;
		this.completedDate = completedDate;
		this.result = result;
		this.useraccount = useraccount;
		this.driverPenalty = driverPenalty;
	}








	public int getIdCompletedRecords() {
		return idCompletedRecords;
	}




	public void setIdCompletedRecords(int idCompletedRecords) {
		this.idCompletedRecords = idCompletedRecords;
	}




	public LocalDateTime getCompletedDate() {
		return completedDate;
	}




	public void setCompletedDate(LocalDateTime completedDate) {
		this.completedDate = completedDate;
	}





	public String getResult() {
		return result;
	}




	public void setResult(String result) {
		this.result = result;
	}




	public Useraccount getUseraccount() {
		return useraccount;
	}




	public void setUseraccount(Useraccount useraccount) {
		this.useraccount = useraccount;
	}




	public DriverPenalty getDriverPenalty() {
		return driverPenalty;
	}




	public void setDriverPenalty(DriverPenalty driverPenalty) {
		this.driverPenalty = driverPenalty;
	}
	
	public String getFormatedCompletedDate() {
		return formatedCompletedDate;
	}




	public void setFormatedCompletedDate(String formatedCompletedDate) {
		this.formatedCompletedDate = formatedCompletedDate;
	}

	
	@Override
	public String toString() {
		return "CompletedRecords [idCompletedRecords=" + idCompletedRecords + ", completedDate=" + completedDate
				+ ", result=" + result + ", useraccount=" + useraccount + ", driverPenalty="
				+ driverPenalty + "]";
	}

	
	
}
