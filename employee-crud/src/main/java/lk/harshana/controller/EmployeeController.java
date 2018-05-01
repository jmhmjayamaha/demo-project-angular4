package lk.harshana.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lk.harshana.entity.Employee;
import lk.harshana.services.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empServices;
	
	@RequestMapping(method= RequestMethod.GET)
	@ResponseStatus(value=HttpStatus.OK)
	private List<Employee> getAllEmployees() {
		return empServices.listEmployees();
	}
}
