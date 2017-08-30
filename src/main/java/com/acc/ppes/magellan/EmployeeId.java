package com.acc.ppes.magellan;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class EmployeeId implements Serializable {

	@Id
	@Column(name = "name")
	private String name;
	@Id
	@Column(name = "location")
	private String location;
}
