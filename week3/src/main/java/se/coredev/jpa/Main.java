package se.coredev.jpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.coredev.jpa.model.Address;
import se.coredev.jpa.model.Employee;
import se.coredev.jpa.repository.EmployeeRepository;

public class Main {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
			context.scan("se.coredev.jpa.config");
			context.refresh();

			EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);
//			Address address = new Address("street", "city", "zip");
//			Employee employee = new Employee("firstname", "lastname", "employeeNumber", address);
//			employeeRepository.save(employee);
			
			employeeRepository.findByAddressZip("zip").forEach(System.out::println);
		}
	}
}
