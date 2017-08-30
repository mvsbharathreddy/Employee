package com.acc.ppes.magellan;


import java.util.Collection;

import org.springframework.data.repository.Repository;


public interface EmployeeRepository extends Repository<Employee,Long> {

	public Employee save(Employee Employee);
	public Collection<Employee> findAll();
	
	
	
	
	
}
