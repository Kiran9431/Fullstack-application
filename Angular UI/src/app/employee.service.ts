import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private baseURL = "http://localhost:9000/api";

  constructor(private httpClient: HttpClient) { }
  
  getEmployeesList(): Observable<Employee[]>{
    return this.httpClient.get<Employee[]>(`${this.baseURL+"/employees"}`);
  }

  createEmployee(employee: Employee): Observable<Object>{
    return this.httpClient.post(`${this.baseURL+"/save-employee"}`, employee);
  }

  getEmployeeById(id: number): Observable<Employee>{
    const url=this.baseURL+"/get-employee?employeeId="+id;
    return this.httpClient.get<Employee>(`${url}`);
  }

  updateEmployee(id: number, employee: Employee): Observable<Object>{
    const url=this.baseURL+"/save-employee";
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient.post(`${url}`, JSON.stringify(employee),{ headers });
  }

  deleteEmployee(id: number): Observable<Object>{
    const url=this.baseURL+"/delete-employee?employeeId="+id;
    return this.httpClient.delete(`${url}`);
  }
}
