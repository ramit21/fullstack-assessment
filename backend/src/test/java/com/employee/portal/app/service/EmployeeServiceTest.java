package com.employee.portal.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.employee.portal.app.dao.EmployeeRepository;
import com.employee.portal.app.model.Employee;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepository repo;

	@Autowired
	@InjectMocks
	private EmployeeService service;
	
	private List<Employee> emps;
	
	@Before
	public void setUp() throws ParseException{
		emps = new ArrayList<>();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
	    emps.add(new Employee("Ramit", "Sharma", "M", df.parse("21/10/2008"), "IT" ));
		emps.add(new Employee("Rohit", "Gupta", "M", df.parse("31/3/2013"), "OPS" ));
		emps.add(new Employee("David", "Carr", "M", df.parse("20/3/2000"), "IT" ));
		emps.add(new Employee("Ciara", "Lavelle", "F", df.parse("1/1/2015"), "HR" ));
	}
	
	@Test
	public void testGetAllemployees(){
		Mockito.when(repo.findAll()).thenReturn(emps);
		List<Employee> resultList = service.getAllEmployees();
		Assert.assertEquals(4, resultList.size());
		Assert.assertEquals("Ciara", resultList.get(0).getFirstName());
		Assert.assertEquals("Rohit", resultList.get(3).getFirstName());
	}
	
	@Test
	public void testSaveEmployee() throws ParseException{
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Employee mockEmp = new Employee("Ramit", "Sharma", "M", df.parse("21/10/2008"), "IT" );
		mockEmp.setId(1L);
		Mockito.when(repo.save(Mockito.any())).thenReturn(mockEmp);
		Long id = service.saveEmployee(new Employee("Ramit", "Sharma", "M", df.parse("21/10/2008"), "IT" ));
		Assert.assertTrue(id == 1);
	}

}
