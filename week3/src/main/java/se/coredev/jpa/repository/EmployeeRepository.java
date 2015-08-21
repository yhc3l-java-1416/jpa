package se.coredev.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import se.coredev.jpa.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
}
