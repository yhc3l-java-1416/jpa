package se.coredev.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "tblEmployees")
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	private String firstname;
	private String lastname;
	private String employeeNumber;

	protected Employee() {
	}

	public Employee(String firstname, String lastname, String employeeNumber) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.employeeNumber = employeeNumber;
	}

	public Long getId() {
		return id;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
