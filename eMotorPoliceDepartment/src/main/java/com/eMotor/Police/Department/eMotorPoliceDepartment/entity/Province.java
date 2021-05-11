package com.eMotor.Police.Department.eMotorPoliceDepartment.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="province")
public class Province  implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idprovince", nullable = false)
	private int idProvince;
	
	
	@Column(name="province", nullable = false, length=20) 
	private String province;

	
	public Province() {
		
	}

	public Province(int idProvince, String province) {
		
		this.idProvince = idProvince;
		this.province = province;
	}


	public int getIdProvince() {
		return idProvince;
	}


	public void setIdProvince(int idProvince) {
		this.idProvince = idProvince;
	}


	public String getProvince() {
		return province;
	}


	public void setProvince(String province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "province [idProvince=" + idProvince + ", province=" + province + "]";
	}
	
	
	
	
}
