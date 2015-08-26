package se.coredev.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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
	
	Employee findByEmployeeNumber(String employeeNumber);
	
	// Pageable
//	Page<Employee> findByLastnameLike(String lastname, Pageable pageable);
	Slice<Employee> findByLastnameLike(String lastname, Pageable pageable);
	
	// Named query
	Employee giveMeAnEmployeeWithNumber(String employeeNumber);
	
	// Query
	@Query("select e from Employee e where e.employeeNumber = ?1")
	Employee giveMeAnotherEmployeeWithNumber(String employeeNumber);
	
	// Named parameters
	@Query("select e from #{#entityName} e where e.employeeNumber like %:empNo and e.firstname like %:firstname")	
	List<Employee> employeesWithFirstnameAndNumberLike(@Param("empNo") String employeeNumber, 
	                                                   @Param("firstname") String firstname);
}
