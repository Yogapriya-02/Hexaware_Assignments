package com.java.transport.model;

import java.util.Objects;

public class DriverAllocations {
	private int allocationId;
	private int driverId;
	private int tripId;
	private String allocationStatus;

	public int getAllocationId() {
		return allocationId;
	}

	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
	}

	public int getDriverId() {
		return driverId;
	}

	public void setDriverId(int driverId) {
		this.driverId = driverId;
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

	public DriverAllocations() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DriverAllocations(int allocationId, int driverId, int tripId, String allocationStatus) {
		super();
		this.allocationId = allocationId;
		this.driverId = driverId;
		this.tripId = tripId;
		this.allocationStatus = allocationStatus;
	}

	@Override
	public String toString() {
		return "DriverAllocations [allocationId=" + allocationId + ", driverId=" + driverId + ", tripId=" + tripId
				+ ", allocationStatus=" + allocationStatus + "]";
	}

	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(allocationId, driverId, tripId, allocationStatus);
	}

	public boolean equals(Object obj) {
		DriverAllocations driverAllocation = (DriverAllocations) obj;
		if (driverAllocation.getAllocationId() == allocationId && driverAllocation.getDriverId() == driverId
				&& driverAllocation.getTripId() == tripId
				&& driverAllocation.getAllocationStatus() == allocationStatus) {
			return true;
		}
		return false;
	}
}
