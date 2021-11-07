package com.tutorial.Springproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Department {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long departmentId;

	@NotBlank(message = "please add Department name")
	public String dapartmentName;
	public String dapartmentAddress;
	public String dapartmentCode;
	
	public long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}
	public String getDapartmentName() {
		return dapartmentName;
	}
	public void setDapartmentName(String dapartmentName) {
		this.dapartmentName = dapartmentName;
	}
	public String getDapartmentAddress() {
		return dapartmentAddress;
	}
	public void setDapartmentAddress(String dapartmentAddress) {
		this.dapartmentAddress = dapartmentAddress;
	}
	public String getDapartmentCode() {
		return dapartmentCode;
	}
	public void setDapartmentCode(String dapartmentCode) {
		this.dapartmentCode = dapartmentCode;
	}
	public Department(long departmentId, String dapartmentName, String dapartmentAddress, String dapartmentCode) {
		super();
		this.departmentId = departmentId;
		this.dapartmentName = dapartmentName;
		this.dapartmentAddress = dapartmentAddress;
		this.dapartmentCode = dapartmentCode;
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", dapartmentName=" + dapartmentName
				+ ", dapartmentAddress=" + dapartmentAddress + ", dapartmentCode=" + dapartmentCode + "]";
	}
	public Department() {
		super();
	}

	
	
}
