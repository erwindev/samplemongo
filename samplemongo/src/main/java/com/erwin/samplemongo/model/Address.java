package com.erwin.samplemongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "school")
public class Address {
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zipCode;
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String toString(){
		return "address1 = " + address1 + "\n" +
			   "address2 = " + address2 + "\n" +
			   "city = " + city + "\n" +
			   "state = " + state + "\n" +			   
			   "zipCode = " + zipCode + "\n";	
	}	
}
