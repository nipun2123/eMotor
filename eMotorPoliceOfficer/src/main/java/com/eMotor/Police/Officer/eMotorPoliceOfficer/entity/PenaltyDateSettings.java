package com.eMotor.Police.Officer.eMotorPoliceOfficer.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="penaltydatesettings")
public class PenaltyDateSettings  implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idpenaltydatesettings", nullable = false)
	private int idPenaltyDateSettings;
	
	


	@Column(name="doubleDateCount", nullable = false, length=2) 
	private int doubleDateCount;

	@Column(name="courtDateCount", nullable = false, length=2) 
	private int courtDateCount;
	



	public PenaltyDateSettings() {
		
	}

	

	public PenaltyDateSettings(int idPenaltyDateSettings, int doubleDateCount, int courtDateCount) {
	
		this.idPenaltyDateSettings = idPenaltyDateSettings;
		this.doubleDateCount = doubleDateCount;
		this.courtDateCount = courtDateCount;
	}



	public int getIdPenaltyDateSettings() {
		return idPenaltyDateSettings;
	}

	public void setIdPenaltyDateSettings(int idPenaltyDateSettings) {
		this.idPenaltyDateSettings = idPenaltyDateSettings;
	}

	public int getDoubleDateCount() {
		return doubleDateCount;
	}

	public void setDoubleDateCount(int doubleDateCount) {
		this.doubleDateCount = doubleDateCount;
	}

	public int getCourtDateCount() {
		return courtDateCount;
	}

	public void setCourtDateCount(int courtDateCount) {
		this.courtDateCount = courtDateCount;
	}

	

	@Override
	public String toString() {
		return "PenaltyDateSettings [idPenaltyDateSettings=" + idPenaltyDateSettings + ", doubleDateCount="
				+ doubleDateCount + ", courtDateCount=" + courtDateCount + "]";
	}


	
	
}
