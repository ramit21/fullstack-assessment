package com.employee.portal.app;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.employee.portal.app.dao.EmployeeRepository;
import com.employee.portal.app.model.Employee;

@SpringBootApplication
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(final EmployeeRepository repo) {
		return new CommandLineRunner() {
			@Override
			public void run(String... strings) throws Exception {
				List<Employee> emps = new ArrayList<>();
				SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); 
			    emps.add(new Employee("Ramit", "Sharma", "M", df.parse("21/10/2008"), "IT" ));
				emps.add(new Employee("Rohit", "Gupta", "M", df.parse("31/3/2013"), "OPS" ));
				emps.add(new Employee("David", "Carr", "M", df.parse("20/3/2000"), "IT" ));
				emps.add(new Employee("Ciara", "Lavelle", "F", df.parse("1/1/2015"), "HR" ));
				 
				repo.saveAll(emps);
				//repo.findAll().forEach(e-> System.out.println(e));
			}
		};
	}
}
