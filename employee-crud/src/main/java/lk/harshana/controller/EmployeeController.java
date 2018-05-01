package lk.harshana.controller;

import java.util.AbstractMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lk.harshana.dto.EmployeeDto;
import lk.harshana.entity.Employee;
import lk.harshana.services.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empServices;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public List<Employee> getAllEmployees() {
		return empServices.listEmployees();
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.CREATED)
	public void createEmployee(@RequestBody @Validated EmployeeDto empDto) {

		Employee emp = new Employee(empDto.getFirstName(), empDto.getLastName(), empDto.getAge(), empDto.getGender(),
				empDto.getAddress(), empDto.getEmail(), empDto.getTelNo());

		empServices.createEmployee(emp);
	}

	@RequestMapping(method = RequestMethod.PUT, value="/{empId}")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void updateEmployee(@PathVariable int empId, @RequestBody @Validated EmployeeDto empDto) {
		
		Employee emp = new Employee(empDto.getFirstName(), empDto.getLastName(), empDto.getAge(), empDto.getGender(),
				empDto.getAddress(), empDto.getEmail(), empDto.getTelNo());

		empServices.updateEmployee(empId, emp);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/{empId}")
	@ResponseStatus(value=HttpStatus.OK)
	public AbstractMap.SimpleEntry<String, String> deleteEmployee(@PathVariable("empId")int empId) {
		if(empServices.deleteEmployee(empId)) {
			return new AbstractMap.SimpleEntry<String, String>("status", "deleted");
		} 
		return new AbstractMap.SimpleEntry<String, String>("status", "Not Deleted");
	}
	
	@RequestMapping(method=RequestMethod.GET , value="/{empId}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("empId") int empId) {
		Employee employee =  empServices.findEmployee(empId);
		
		if(employee != null) {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
