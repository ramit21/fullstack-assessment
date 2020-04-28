package com.employee.portal.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.portal.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}
