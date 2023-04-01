package com.ravi.model;


import javax.persistence.*;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;

	@Column(name="city")
	String city;

	@Column(name="street_address")
	String street_address;

	@Column(name="state")
	String state;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet_address() {
		return street_address;
	}

	public void setStreet_address(String street_address) {
		this.street_address = street_address;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address(String city, String street_address, String state) {
		this.id = id;
		this.city = city;
		this.street_address = street_address;
		this.state = state;
	}

	public Address(){

	}
}
