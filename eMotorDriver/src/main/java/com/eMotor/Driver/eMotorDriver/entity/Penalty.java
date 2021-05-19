package com.eMotor.Driver.eMotorDriver.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="penalty")
public class Penalty {

	@Id
	@Column(name="idpenalty", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPenalty;
	
	@Column(name="penaltyenglish", nullable = false)
	private String penaltyEnglish;
	
	@Column(name="penaltysinhala", nullable = false)
	private String penaltySinhala;
	
	@Column(name="penaltytamil", nullable = false)
	private String penaltyTamil;
	
	@Column(name="type", nullable = false, length=5)
	private String type;
	
	@Column(name="status", nullable = false)
	private boolean status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="fineamount_idfineamount")
	private FineAmount fineAmount;
	
	@javax.persistence.Transient
	private String penaltyCommon;
	

	public Penalty() {
			
	}

	public Penalty(int idPenalty, String penaltyEnglish, String penaltySinhala, String penaltyTamil, String type,
			boolean status, FineAmount fineAmount) {
		this.idPenalty = idPenalty;
		this.penaltyEnglish = penaltyEnglish;
		this.penaltySinhala = penaltySinhala;
		this.penaltyTamil = penaltyTamil;
		this.type = type;
		this.status = status;
		this.fineAmount = fineAmount;
	}

	public int getIdPenalty() {
		return idPenalty;
	}

	public void setIdPenalty(int idPenalty) {
		this.idPenalty = idPenalty;
	}

	public String getPenaltyEnglish() {
		return penaltyEnglish;
	}

	public void setPenaltyEnglish(String penaltyEnglish) {
		this.penaltyEnglish = penaltyEnglish;
	}

	public String getPenaltySinhala() {
		return penaltySinhala;
	}

	public void setPenaltySinhala(String penaltySinhala) {
		this.penaltySinhala = penaltySinhala;
	}

	public String getPenaltyTamil() {
		return penaltyTamil;
	}

	public void setPenaltyTamil(String penaltyTamil) {
		this.penaltyTamil = penaltyTamil;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public FineAmount getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(FineAmount fineAmount) {
		this.fineAmount = fineAmount;
	}

	public String getPenaltyCommon() {
		return penaltyCommon;
	}

	public void setPenaltyCommon(String penaltyCommon) {
		this.penaltyCommon = penaltyCommon;
	}

	
	@Override
	public String toString() {
		return "Penalty [idPenalty=" + idPenalty + ", penaltyEnglish=" + penaltyEnglish + ", penaltySinhala="
				+ penaltySinhala + ", penaltyTamil=" + penaltyTamil + ", type=" + type + ", status=" + status
				+ ", fineAmount=" + fineAmount + "]";
	}
	
	
	
}
