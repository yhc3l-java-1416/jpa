package se.coredev.jpa;

import java.util.UUID;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.coredev.jpa.model.Employee;
import se.coredev.jpa.repository.EmployeeRepository;

public class Main {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
			context.scan("se.coredev.jpa");
			context.refresh();

			EmployeeRepository repository = context.getBean(EmployeeRepository.class);
			repository.save(new Employee("Master", "Jones", UUID.randomUUID().toString()));
			repository.save(new Employee("Master", "Jones", UUID.randomUUID().toString()));
			repository.save(new Employee("Master", "Jones", UUID.randomUUID().toString()));
			repository.save(new Employee("Master", "Jones", UUID.randomUUID().toString()));
			repository.save(new Employee("Master", "Jones", UUID.randomUUID().toString()));
			repository.save(new Employee("Master", "Jones", UUID.randomUUID().toString()));

			repository.findAll().forEach(System.out::println);
		}
	}
}