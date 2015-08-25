package se.coredev.jpa.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import se.coredev.jpa.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
	
	List<Employee> findByFirstname(String firstname);
	List<Employee> findByLastname(String lastname);
	List<Employee> findByFirstnameAndLastname(String firstname, String lastname);

	Long countByLastname(String lastname);
	
	@Transactional
	List<Employee> removeByLastname(String lastname);
	
	List<Employee> findFirst5ByFirstname(String firstname);
	
	List<Employee> findByAddressZip(String zip);
		
}
