package com.builder;

import org.springframework.batch.core.configuration.annotation.JobScope;

public class StudentDto {
	
    private String lastName;
    private String firstName;
    private String Address;
    private String City;
    private String phone;
    private String Marks;
    private int Id;
    
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMarks() {
		return Marks;
	}
	public void setMarks(String marks) {
		Marks = marks;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
}