import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()
export class EmployeeService {

  result: any;

  constructor(private _http: Http) { }

  getEmployees() {
    return this._http.get('http://localhost:9090/employee')
      .map(result => this.result = result.json());
  }

}
