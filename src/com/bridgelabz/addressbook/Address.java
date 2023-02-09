package com.bridgelabz.addressbook;

public class Address {
	
	public String city, state;
	public long zipCode;
	
	public String getCity() {
		return city;
	}
	public String getState() {
		return state;
	}
	public long getZipCode() {
		return zipCode;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setZipCode(long zipCode2) {
		this.zipCode = zipCode2;
	}
	public String toString() {
		return city+", "+state+", "+zipCode+".";
	}
}
