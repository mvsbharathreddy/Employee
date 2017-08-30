package com.acc.ppes.magellan;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="employee")
@IdClass(EmployeeId.class)
public class Employee implements Serializable{
	@Id
	@Column(name = "name")
	private String name;
	@Id
	@Column(name = "location")
	private String location;
	@Column(name = "company")
	private int company;
	

	@Override
	public String toString() {
		return "Employee [name=" + name + ", location=" + location + ", company=" + company
				+ "]";
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getLocation() {
		return location;
	}




	public void setLocation(String location) {
		this.location = location;
	}




	public int getCompany() {
		return company;
	}




	public void setCompany(int company) {
		this.company = company;
	}
	
	

}
