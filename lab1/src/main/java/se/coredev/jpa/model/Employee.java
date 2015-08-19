package se.coredev.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@NamedQueries({
        @NamedQuery(name = "Employee.GetAll", query = "select e from Employee e"),
        @NamedQuery(name = "Employee.GetByEmployeeNumber", query = "select e from Employee e where e.employeeNumber = :employeeNumber")
})
@Entity
@Table(name = "tblEmployees")
public class Employee extends AbstractEntity {

	@Column(name = "emp_no", unique = true)
	private String employeeNumber;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	protected Employee() {
	}

	public Employee(String employeeNumber, String firstName, String lastName) {
		this.employeeNumber = employeeNumber;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
