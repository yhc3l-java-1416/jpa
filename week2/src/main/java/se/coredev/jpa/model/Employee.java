package se.coredev.jpa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@NamedQueries({
        @NamedQuery(name = "Employee.GetAll", query = "select e from Employee e"),
        @NamedQuery(name = "Employee.GetByEmployeeNumber", query = "select e from Employee e where e.employeeNumber = :employeeNumber")
})
@Entity
@Table(name = "tblEmployees")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;

	@Column(name = "emp_no", unique = true)
	private String employeeNumber;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@OneToOne(cascade = CascadeType.REMOVE)
	@JoinColumn(unique = true)
	private ParkingSpot parkingSpot;

	@ManyToOne
	private Department department;

	@Column
	private Address address;

	protected Employee() {
	}

	public Employee(String employeeNumber, String firstName, String lastName, ParkingSpot parkingSpot,
	        Department department, Address address) {
		this.employeeNumber = employeeNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.parkingSpot = parkingSpot;
		this.department = department;
		this.address = address;
	}

	public Long getId() {
		return id;
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

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}

	public void setParkingSpot(ParkingSpot parkingSpot) {
		this.parkingSpot = parkingSpot;
	}

	public Department getDepartment() {
		return department;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
