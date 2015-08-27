package se.coredev.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import se.coredev.jpa.model.Employee;
import se.coredev.jpa.repository.AddressRepository;
import se.coredev.jpa.repository.EmployeeRepository;

public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	@Transactional
	public Employee addEmployee(Employee employee) {
		addressRepository.save(employee.getAddress());
		return employeeRepository.save(employee);
	}

	
	
}
