package se.coredev.jpa.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Table(name = "tblDepartment")
@Entity
public class Department {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
	private Collection<Employee> employees;

	protected Department() {
	}

	public Department(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Employee> getEmployees() {
		return employees;
	}

	@Override
	public String toString() {
//		return "Id:" + id + ", " + "Name:" + name;
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
