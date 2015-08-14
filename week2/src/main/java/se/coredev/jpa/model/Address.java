package se.coredev.jpa.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name = "tblAddress")
public class Address extends AbstractEntity {

	@Column
	private String street;
	@Column
	private String postal;
	@Column(name = "zip_code")
	private String zip;
	@Column
	private String addressCode;

	public Address(String street, String postal, String zip) {
		this.street = street;
		this.postal = postal;
		this.zip = zip;
		this.addressCode = UUID.randomUUID().toString();
	}

	public String getStreet() {
		return street;
	}

	public String getPostal() {
		return postal;
	}

	public String getZip() {
		return zip;
	}

	public String getAddressCode() {
		return addressCode;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
}
