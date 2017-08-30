package com.acc.ppes.magellan;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class EmployeeUtility implements EmployeeService {

	@Autowired
	EmployeeRepository repo;
	
	
	public EmployeeUtility() {
		
	}
	
	public Employee saveEmployee(Employee Employee) {

		repo.save(Employee);
		return Employee;

	}

	@Override
	public Collection<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	

	


}
