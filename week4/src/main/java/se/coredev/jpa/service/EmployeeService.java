package se.coredev.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;

import se.coredev.jpa.model.Employee;
import se.coredev.jpa.repository.EmployeeRepository;

public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

}
