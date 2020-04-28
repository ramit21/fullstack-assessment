package com.employee.portal.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.employee.portal.app.dao.EmployeeRepository;
import com.employee.portal.app.model.Employee;

@Component
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository repo;
	
	public EmployeeService(EmployeeRepository repo) {
		this.repo = repo;
	}
	
	public List<Employee> getAllEmployees(){
		return new ArrayList<Employee>();
	}

	public Long saveEmployee(Employee emp) {
		return null;
	}

}
