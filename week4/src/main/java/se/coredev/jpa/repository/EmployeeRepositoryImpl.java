package se.coredev.jpa.repository;

import se.coredev.jpa.model.Employee;

public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

	@Override
	public void logEmployee(Employee employee) {
		System.out.println("0 # Logging employee: [" + employee + "]");
	}

}
