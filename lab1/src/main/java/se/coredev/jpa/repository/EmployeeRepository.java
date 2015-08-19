package se.coredev.jpa.repository;

import se.coredev.jpa.model.Employee;

public class EmployeeRepository extends AbstractRepository<Employee> {

	public EmployeeRepository() {
		super(Employee.class);
	}
}
