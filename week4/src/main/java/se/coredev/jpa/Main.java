package se.coredev.jpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import se.coredev.jpa.model.Address;
import se.coredev.jpa.model.Employee;
import se.coredev.jpa.repository.EmployeeRepository;

public class Main {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
			context.scan("se.coredev.jpa.config");
			context.refresh();

			EmployeeRepository repository = context.getBean(EmployeeRepository.class);
			// addRandomEmployees(repository, 50);

//			repository.findByLastnameLike("lastname1%", new PageRequest(0, 3)).forEach(System.out::println);

//			System.out.println(repository.giveMeAnotherEmployeeWithNumber("e1"));
			repository.employeesWithFirstnameAndNumberLike("2", "first").forEach(System.out::println);

		}
	}

	private static void addRandomEmployees(EmployeeRepository repository, int numberOfEmployees) {

		for (int i = 0; i < numberOfEmployees; i++) {
			repository.save(new Employee("firstname" + i, "lastname" + i, "e" + i,
			        new Address("street" + i, "city" + i, "zip" + i)));
		}
	}
}
