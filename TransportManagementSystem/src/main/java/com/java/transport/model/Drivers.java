package com.java.transport.model;

import java.util.Objects;

public class Drivers {
	private int driverId;
	private String name;
	private int age;
	private int tripId;
	private String allocationStatus;

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}

	public String getAllocationStatus() {
		return allocationStatus;
	}

	public void setAllocationStatus(String allocationStatus) {
		this.allocationStatus = allocationStatus;
	}

	public Drivers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Drivers(int driverId, String name, int age, int tripId, String allocationStatus) {
		super();
		this.driverId = driverId;
		this.name = name;
		this.age = age;
		this.tripId = tripId;
		this.allocationStatus = allocationStatus;
	}

	@Override
	public String toString() {
		return "Drivers [driverId=" + driverId + ", name=" + name + ", age=" + age + ", tripId=" + tripId
				+ ", allocationStatus=" + allocationStatus + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(driverId, name, age, tripId, allocationStatus);
	}

	@Override
	public boolean equals(Object obj) {
		Drivers driver = (Drivers) obj;
		if (driver.getDriverId() == driverId && driver.getName() == name && driver.getAge() == age
				&& driver.getTripId() == tripId && driver.getAllocationStatus() == allocationStatus) {
			return true;
		}
		return false;
	}

}
