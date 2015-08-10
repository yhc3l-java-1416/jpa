package se.coredev.jpa;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
		Employee employee = new Employee(UUID.randomUUID().toString(), "Master", "Jones", parkingSpot, department);
		employee = persistValue(employee);

		// Find Employee by id
		Employee findResult = findEmployeeById(1L);
		System.out.println(findResult);

		factory.close();
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

//	private static List<Employee> queryEmployeeById(Long id) {
//		EntityManager manager = factory.createEntityManager();
//
//		List<Employee> result = manager.createQuery("select e from Employee e where e.id = :id", Employee.class)
//		                               .setParameter("id", id)
//		                               .getResultList();
//		manager.close();
//
//		return result;
//	}

}
