import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { EmployeeComponent } from './employee.component';
import { EmployeeService } from '../../services/employee.service';
import { Observable, of} from 'rxjs';
import { FormsModule } from '@angular/forms';
import { Employee } from 'src/app/model/Employee';

describe('EmployeeComponent', () => {
  let component: EmployeeComponent;
  let fixture: ComponentFixture<EmployeeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      imports: [ FormsModule ],
      declarations: [ EmployeeComponent ],
      providers: [ { provide: EmployeeService, useClass: FakeEmployeeService} ] 
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EmployeeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('getEmployees returns employee data', () => {
    component.getEmployees();
    expect(component.employees[0].firstName).toEqual('Ciara');
  });

  it('saveEmployees updates employee list with new employee', () => {
    component.firstName = "Ciara";
    component.createEmployee();
    expect(component.employees[0].firstName).toEqual('Ciara');
  });
});

class FakeEmployeeService{
  getEmployees():Observable<Employee[]>{
      return of([{"id":4,"firstName":"Ciara","lastName":"Lavelle","gender":"F","dateOfJoining":"31/12/2014","dept":"HR"}]);
  }
  saveEmployee():Observable<any>{
    return of({});
  }
}