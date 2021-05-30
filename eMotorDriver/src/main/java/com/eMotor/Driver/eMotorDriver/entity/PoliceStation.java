package com.eMotor.Driver.eMotorDriver.entity;


import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="policestation")
public class PoliceStation  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idpolicestation", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPoliceStation;
	
	@Column(name="policeStation", nullable = false, length=30,unique=true)
	private String policeStation;



	
	public PoliceStation() {
		
	}

	public PoliceStation(int idPoliceStation, String policeStation) {
		this.idPoliceStation = idPoliceStation;
		this.policeStation = policeStation;
	}

	public int getIdPoliceStation() {
		return idPoliceStation;
	}

	public void setIdPoliceStation(int idPoliceStation) {
		this.idPoliceStation = idPoliceStation;
	}

	public String getPoliceStation() {
		return policeStation;
	}

	public void setPoliceStation(String policeStation) {
		this.policeStation = policeStation;
	}

	

	@Override
	public String toString() {
		return "PoliceStation [idPoliceStation=" + idPoliceStation + ", policeStation=" + policeStation + "]";
	}
	
	
	
}
