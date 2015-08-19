package se.coredev.jpa;

import java.util.UUID;

import se.coredev.jpa.model.Employee;
import se.coredev.jpa.repository.EmployeeRepository;

public class Main {

	public static void main(String[] args) {

		Employee employee = new Employee(UUID.randomUUID().toString(), "Master", "Jones");
		new EmployeeRepository().saveOrUpdate(employee);
	}
}
