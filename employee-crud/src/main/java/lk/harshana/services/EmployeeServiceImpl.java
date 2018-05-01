package lk.harshana.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.harshana.entity.Employee;
import lk.harshana.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;
	
	@Override
	public void createEmployee(Employee employee) {
		empRepository.save(employee);
	}

	@Override
	public List<Employee> listEmployees() {
		// TODO Auto-generated method stub
		return (List<Employee>) empRepository.findAll();
	}

	@Override
	public Employee findEmployee(int id) {
		// TODO Auto-generated method stub
		return empRepository.findById(id);
	}

	@Override
	public Employee findEmployeeByFirstName(String name) {
		// TODO Auto-generated method stub
		return empRepository.findByFirstName(name);
	}

	@Override
	public void updateEmployee(int id, Employee employee) {
		Employee emp = empRepository.findById(id);
		
		if(emp != null) {
			employee.setId(id);
			empRepository.save(employee);
		}
		
	}

	@Override
	public boolean deleteEmployee(int id) {
		Employee emp = empRepository.findById(id);
		
		if(emp != null) {
			empRepository.delete(emp);
			return true;
		}
		return false;
	}

}
