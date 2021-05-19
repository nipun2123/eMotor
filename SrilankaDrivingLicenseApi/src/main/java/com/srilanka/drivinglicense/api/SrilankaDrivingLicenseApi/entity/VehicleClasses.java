package com.srilanka.drivinglicense.api.SrilankaDrivingLicenseApi.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vehicleclasses")
public class VehicleClasses {

	@Id
	@Column(name="idvehicleclasses", nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idvVhicleClasses;
	
	@Column(name="vehicleclass", nullable = false, length=2)
	private String vehicleClass;
	
	
	public VehicleClasses() {

	}

	public VehicleClasses(int idvVhicleClasses, String vehicleClass) {

		this.idvVhicleClasses = idvVhicleClasses;
		this.vehicleClass = vehicleClass;
	}

	public int getIdvVhicleClasses() {
		return idvVhicleClasses;
	}

	public void setIdvVhicleClasses(int idvVhicleClasses) {
		this.idvVhicleClasses = idvVhicleClasses;
	}

	public String getVehicleClass() {
		return vehicleClass;
	}

	public void setVehicleClass(String vehicleClass) {
		this.vehicleClass = vehicleClass;
	}

	@Override
	public String toString() {
		return "VehicleClasses [idvVhicleClasses=" + idvVhicleClasses + ", vehicleClass=" + vehicleClass + "]";
	}
	
	
	
}
