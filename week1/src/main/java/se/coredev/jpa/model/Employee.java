package se.coredev.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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

	@OneToOne
	@JoinColumn(unique = true)
	private ParkingSpot parkingSpot;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private Department department;

	protected Employee() {
	}

	public Employee(String employeeNumber, String firstName, String lastName, ParkingSpot parkingSpot, Department department) {
		this.employeeNumber = employeeNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.parkingSpot = parkingSpot;
		this.department = department;
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

	public ParkingSpot getParkingSpot() {
		return parkingSpot;
	}

	public Department getDepartment() {
		return department;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
