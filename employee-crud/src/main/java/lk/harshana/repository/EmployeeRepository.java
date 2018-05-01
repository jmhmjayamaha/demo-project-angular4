package lk.harshana.repository;

import org.springframework.data.repository.CrudRepository;

import lk.harshana.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer>{

	Employee findByFirstName(String name);
	Employee findById(int id);
}
