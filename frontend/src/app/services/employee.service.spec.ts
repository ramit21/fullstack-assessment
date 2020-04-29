import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule,HttpTestingController } from '@angular/common/http/testing';
import { EmployeeService } from './employee.service';

describe('EmployeeService', () => {

  let httpMock : HttpTestingController;

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [EmployeeService],
      imports: [HttpClientTestingModule] //HttpClient needed for the http in the constructor of the service
    });
    httpMock = TestBed.get(HttpTestingController);
  });

  it('should be created', () => {
    const service : EmployeeService = TestBed.get(EmployeeService);
    expect(service).toBeTruthy();
  });

  it('getEmployees returns employees data', (done) => {
    const employeeService : EmployeeService = TestBed.get(EmployeeService);
    employeeService.getEmployees().subscribe(res => {
        expect(res).toEqual([{"id":4,"firstName":"Ciara","lastName":"Lavelle","gender":"F","dateOfJoining":"31/12/2014","dept":"HR"}]);
        done(); 
    });
    
    let dataRequest = httpMock.expectOne('http://localhost:8080/employees');
    dataRequest.flush([{"id":4,"firstName":"Ciara","lastName":"Lavelle","gender":"F","dateOfJoining":"31/12/2014","dept":"HR"}]);
    httpMock.verify();
  });


});
