package com.employee.portal.app.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Employee implements Comparable<Employee>{

	@Id
	@GeneratedValue
	private Long id;
	
	private String firstName;
	private String lastName;
	private String gender;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")  
	private Date dateOfJoining;
	private String dept;
	
	public Employee() {}
	
	public Employee(String firstName, String lastName, String gender, Date dateOfJoining, String dept) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.dateOfJoining = dateOfJoining;
		this.dept = dept;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("[id=");
		sb.append(id);
		sb.append(",");
		sb.append(firstName);
		sb.append(" ");
		sb.append(lastName);
		sb.append("]");
		return sb.toString();
	}

	@Override
	public int compareTo(Employee o) {
		if(firstName == null && o.firstName == null) {
			return 0;
		}
		if(firstName != null && o.firstName == null) {
			return 1;
		}
		if(firstName == null && o.firstName != null) {
			return -1;
		}
		return firstName.toLowerCase().compareTo(o.firstName.toLowerCase());
	}
	
	
}
