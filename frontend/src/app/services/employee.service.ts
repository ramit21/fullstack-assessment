import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private _url : string = "http://localhost:8080/employees"; 

  constructor(private _http: HttpClient) { }

  getEmployees(){
    return this._http.get(this._url);
  }
}
