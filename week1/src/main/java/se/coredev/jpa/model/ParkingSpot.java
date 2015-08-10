package se.coredev.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Table(name = "tblParkingSpot")
@Entity
public class ParkingSpot {

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "number")
	private String number;

	protected ParkingSpot() {
	}

	public ParkingSpot(String number) {
		this.number = number;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
