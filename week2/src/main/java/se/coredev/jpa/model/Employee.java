package se.coredev.jpa.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKeyColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
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

	@OneToMany (cascade = CascadeType.PERSIST)
	private Map<String, Address> addresses;

	@ElementCollection
	@CollectionTable(name = "tblEmployeeNote")
	@MapKeyColumn(name = "noteId")
	private Map<String, String> notes;

	protected Employee() {
	}

	public Employee(String employeeNumber, String firstName, String lastName, ParkingSpot parkingSpot,
	        Department department) {
		this.employeeNumber = employeeNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.parkingSpot = parkingSpot;
		this.department = department;
		this.addresses = new HashMap<>();
		this.notes = new HashMap<>();
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

	public Map<String, Address> getAddresses() {
		return addresses;
	}

	public Employee addAddress(Address address) {
		addresses.put(address.getAddressCode(), address);
		return this;
	}

	public Map<String, String> getNotes() {
		return notes;
	}

	public Employee addNote(String note) {
		notes.put(UUID.randomUUID().toString(), note);
		return this;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

}
