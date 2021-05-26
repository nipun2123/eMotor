package com.eMotor.Police.Officer.eMotorPoliceOfficer.entity;


import java.io.Serializable;

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
	
//	@NotNull
	@Column(name="policeStation", nullable = false, length=30,unique=true)
//	@Size(min = 3, max = 30, message = "Please enter between {min} and {max} characters.")
	private String policeStation;
	
//	@NotNull
	@Column(name="oic",nullable = false, length=150)
//	@Size(min = 4, max = 150, message = "Please enter between {min} and {max} characters.")
	private String oic;
	
//	@NotNull
	@Column(name="oicmobile",nullable = false, length=10)
//	@Size(min = 10, max = 10,  message = "Please enter {min} numbers." )
	private String oicMobile;
	
//	@NotNull
	@Column(name="oicoffice",nullable = false, length=10)
//	@Size(min = 10, max = 10,  message = "Please enter {min} numbers." )
	private String oicOffice;
	
//	@NotNull
	@Column(name="general",nullable = false, length=10)
//	@Size(min = 10, max = 10,  message = "Please enter {min} numbers." )
	private String general;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="province_idprovince", nullable = false)
	private Province province;
	
	@javax.persistence.Transient
	private String provinceName;
	
	@javax.persistence.Transient
	private String oldPoliceStation;

	
	public PoliceStation() {
		
	}

	public PoliceStation(int idPoliceStation, String policeStation, String oic, String oicMobile, String oicOffice,
			String general, Province province) {
		this.idPoliceStation = idPoliceStation;
		this.policeStation = policeStation;
		this.oic = oic;
		this.oicMobile = oicMobile;
		this.oicOffice = oicOffice;
		this.general = general;
		this.province = province;
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

	public String getOic() {
		return oic;
	}

	public void setOic(String oic) {
		this.oic = oic;
	}

	public String getOicMobile() {
		return oicMobile;
	}

	public void setOicMobile(String oicMobile) {
		this.oicMobile = oicMobile;
	}

	public String getOicOffice() {
		return oicOffice;
	}

	public void setOicOffice(String oicOffice) {
		this.oicOffice = oicOffice;
	}

	public String getGeneral() {
		return general;
	}

	public void setGeneral(String general) {
		this.general = general;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}
	
	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
	
	public String getOldPoliceStation() {
		return oldPoliceStation;
	}

	public void setOldPoliceStation(String oldPoliceStation) {
		this.oldPoliceStation = oldPoliceStation;
	}


	@Override
	public String toString() {
		return "PoliceStation [idPoliceStation=" + idPoliceStation + ", policeStation=" + policeStation + ", oic=" + oic
				+ ", oicMobile=" + oicMobile + ", oicOffice=" + oicOffice + ", general=" + general + ", division="
				+ province + "]";
	}
	
	
	
}
