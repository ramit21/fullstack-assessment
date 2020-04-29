import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../model/Bug';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private _url : string = "http://localhost:8080/"; 

  constructor(private _http: HttpClient) { }

  getEmployees(){
    return this._http.get(this._url+'employees');
  }

  saveEmployee(employee: Employee){
    return this._http.post(this._url+'saveEmployee', employee);
  }
}