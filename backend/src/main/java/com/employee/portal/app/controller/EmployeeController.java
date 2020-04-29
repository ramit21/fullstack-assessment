package com.employee.portal.app.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.employee.portal.app.model.Employee;
import com.employee.portal.app.service.EmployeeService;

@Controller
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}
	
	@ResponseBody
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public Long saveEmployees(@RequestBody Employee emp) {
		return service.saveEmployee(emp);
	}
	
}
