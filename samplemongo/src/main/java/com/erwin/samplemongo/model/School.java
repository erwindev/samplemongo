package com.erwin.samplemongo.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "school")
public class School {
	private String name;
	private String unitid;
	private Address mainAddress;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getMainAddress() {
		return mainAddress;
	}
	public void setMainAddress(Address mainAddress) {
		this.mainAddress = mainAddress;
	}
	public String getUnitid() {
		return unitid;
	}
	public void setUnitid(String unitid) {
		this.unitid = unitid;
	}
	
	public String toString(){
		return "name = " + name + "\n" +
			   "unitid = " + unitid + "\n" +
			   mainAddress;
	}
	
}
