import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';
import { Router, ActivatedRoute } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  employeeFrm: FormGroup;
  employees: Array<Employee>;

  constructor(private _employeeService: EmployeeService, private router: Router, private aR: ActivatedRoute, private fb: FormBuilder) { }

  ngOnInit() {
    this.employeeFrm = this.fb.group({
      'firstName' : [null, Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(45)])],
      'lastName' : [null, Validators.compose([Validators.required, Validators.minLength(3)])],
      'age' : [null, Validators.compose([Validators.required, Validators.minLength(1), Validators.maxLength(45)])],
      'gender' : [null, Validators.compose([Validators.required, Validators.minLength(4), Validators.maxLength(10)])],
      'address' : [null, Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(45)])],
      'email' : [null, Validators.compose([Validators.required, Validators.minLength(5), Validators.maxLength(45)])],
      'telNo' : [null, Validators.compose([Validators.required, Validators.minLength(10), Validators.maxLength(45)])],
    });
  }

  addEmployee(employee: Employee) {
    this._employeeService.insertEmployee(employee)
      .subscribe(newEmployee => {
        this.employees.push(newEmployee);
        this.router.navigateByUrl('/');
      });
  }

}
