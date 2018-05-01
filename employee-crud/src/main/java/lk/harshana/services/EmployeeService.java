package lk.harshana.services;

import java.util.List;

import lk.harshana.entity.Employee;

public interface EmployeeService {

	void createEmployee(Employee employee);
	List<Employee> listEmployees();
	Employee findEmployee(int id);
	Employee findEmployeeByFirstName(String name);
	void updateEmployee(int id, Employee employee);
	boolean deleteEmployee(int id);
	
}
