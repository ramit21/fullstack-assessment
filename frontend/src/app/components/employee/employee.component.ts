import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { Employee } from 'src/app/model/Employee';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  firstName: String;
  lastName: String;
  gender: String;
  doj: String;
  dept: String;
  
  employees = [];
  error : String;
  columns = ["First Name", "Last Name", "Gender", "Date of joining", "Department"];

  constructor(private employeeService: EmployeeService) { }

  ngOnInit() {
    this.getEmployees();
  }

  createEmployee(){
    if(!this.firstName){
      alert("First name is missing");
      return;
    }
    const employee = new Employee(null, this.firstName, this.lastName,
      this.gender, this.doj, this.dept);
    this.employeeService.saveEmployee(employee)
      .subscribe(
        responseData => this.getEmployees(),
        error => this.error = error.message    //Error handling
      );
  }

  getEmployees(){
    this.employeeService.getEmployees()
    .subscribe(
      responseData => this.employees = responseData,
      error => this.error = error    //Error handling
    );
  }

}

