package se.coredev.jpa;

import java.util.Collection;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import se.coredev.jpa.model.Address;
import se.coredev.jpa.model.Department;
import se.coredev.jpa.model.Employee;
import se.coredev.jpa.model.ParkingSpot;

public class Main {

	private static final EntityManagerFactory factory = Persistence.createEntityManagerFactory("PersistenceUnit");

	public static void main(String[] args) {

		// Persist ParkingSpot
		ParkingSpot parkingSpot = new ParkingSpot("A-17");
		parkingSpot = persistValue(parkingSpot);

		// Persist Department
		Department department = new Department("Development");
		department = persistValue(department);

		// Persist Employee
		Address address = new Address("street", "postal", "zip");
		Employee employee = new Employee(UUID.randomUUID().toString(), "Master", "Jones", parkingSpot, department, address);
		employee = persistValue(employee);

		// Find Employee by id
		// Employee findResult = findEmployeeById(1L);

		// testMerge(findResult);

		// Test find Department
		testFindDepartment();

		factory.close();
	}

	private static void testFindDepartment() {
		EntityManager manager = factory.createEntityManager();
		TypedQuery<Department> query = manager.createQuery("select d from Department d join fetch d.employees", Department.class);

		Collection<Department> result = query.getResultList();
		manager.close();

		result.forEach(System.out::println);
	}

	
	private static void testMerge(Employee employee) {

		EntityManager manager = factory.createEntityManager();
		manager = factory.createEntityManager();
		manager.getTransaction().begin();

		employee = manager.merge(employee);

		employee.setAddress(new Address("new street", "new postal", "new zip"));
		employee.setLastName("new last name");

		manager.getTransaction().commit();
		manager.close();
	}

	private static <T> T persistValue(T value) {

		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(value);
		manager.getTransaction().commit();
		manager.close();

		return value;
	}

	private static Employee findEmployeeById(Long id) {
		EntityManager manager = factory.createEntityManager();

		Employee result = manager.find(Employee.class, id);

		manager.close();

		return result;
	}

	// private static List<Employee> queryEmployeeById(Long id) {
	// EntityManager manager = factory.createEntityManager();
	//
	// List<Employee> result = manager.createQuery("select e from Employee e
	// where e.id = :id", Employee.class)
	// .setParameter("id", id)
	// .getResultList();
	// manager.close();
	//
	// return result;
	// }

}
