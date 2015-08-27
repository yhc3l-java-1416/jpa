package se.coredev.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "tblEmployees")
@NamedQuery(name = "Employee.giveMeAnEmployeeWithNumber", query = "select e from Employee e where e.employeeNumber = ?1")
public class Employee {

	@Id
	@GeneratedValue
	private Long id;

	private String firstname;
	private String lastname;
	@Column(unique = true)
	private String employeeNumber;

	@ManyToOne
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

	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
