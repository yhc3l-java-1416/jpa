package se.coredev.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(unique = true)
	private Address address;

	protected Employee() {
	}

	public Employee(String firstname, String lastname, String employeeNumber, Address address) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.employeeNumber = employeeNumber;
		this.address = address;
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
