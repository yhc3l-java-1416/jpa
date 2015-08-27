package se.coredev.jpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import se.coredev.jpa.model.Address;
import se.coredev.jpa.model.Employee;
import se.coredev.jpa.repository.EmployeeRepository;
import se.coredev.jpa.service.EmployeeService;

public class Main {

	public static void main(String[] args) {

		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
			context.scan("se.coredev.jpa.config");
			context.refresh();

//			EmployeeService service = context.getBean(EmployeeService.class);
//			
//			Employee employee1 = new Employee("firstname1", "lastname1", "1001", new Address("street1", "city2", "zip3"));
//			Employee employee2 = new Employee("firstname2", "lastname2", "1001", new Address("street2", "city2", "zip3"));
//			
//			service.addEmployee(employee1);
//			service.addEmployee(employee2);
			
			EmployeeRepository repository = context.getBean(EmployeeRepository.class);
			Employee employee = new Employee("firstname", "lastname", "1001", new Address("street", "city", "zip"));
			repository.logEmployee(employee);
		}
	}

	private static void addRandomEmployees(EmployeeRepository repository, int numberOfEmployees) {

		for (int i = 0; i < numberOfEmployees; i++) {
			repository.save(new Employee("firstname" + i, "lastname" + i, "e" + i,
			        new Address("street" + i, "city" + i, "zip" + i)));
		}
	}
}
