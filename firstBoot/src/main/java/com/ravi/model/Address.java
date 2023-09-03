package com.ravi.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@Column(name="add_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int add_id;

	@Column(name="city")
	String city;

	@Column(name="street_address")
	String street_address;

	@Column(name="state")
	String state;

	@OneToOne(targetEntity = Employee.class, mappedBy = "address")
	@JsonBackReference
	private Employee employee;


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

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Address(){

	}

	public int getAdd_id() {
		return add_id;
	}

	public void setAdd_id(int add_id) {
		this.add_id = add_id;
	}

	public Address(int add_id, String city, String street_address, String state) {
		this.add_id = add_id;
		this.city = city;
		this.street_address = street_address;
		this.state = state;
	}
}
