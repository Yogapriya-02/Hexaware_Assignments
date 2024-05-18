package com.java.transport.model;

import java.util.Objects;

public class Routes {
	private int routeId;
	private String startDestination;
	private String endDestination;
	private Double distance;
	private String availability;

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getStartDestination() {
		return startDestination;
	}

	public void setStartDestination(String startDestination) {
		this.startDestination = startDestination;
	}

	public String getEndDestination() {
		return endDestination;
	}

	public void setEndDestination(String endDestination) {
		this.endDestination = endDestination;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public Routes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Routes(int routeId, String startDestination, String endDestination, Double distance, String availability) {
		this.routeId = routeId;
		this.startDestination = startDestination;
		this.endDestination = endDestination;
		this.distance = distance;
		this.availability = availability;
	}

	@Override
	public String toString() {
		return "Routes [routeId=" + routeId + ", startDestination=" + startDestination + ", endDestination="
				+ endDestination + ", distance=" + distance + ", availability=" + availability + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(routeId, startDestination, endDestination, distance, availability);
	}

	@Override
	public boolean equals(Object obj) {
		Routes route = (Routes) obj;
		if (route.getRouteId() == routeId && route.getStartDestination() == startDestination
				&& route.getEndDestination() == endDestination && route.getDistance() == distance
				&& route.getAvailability() == availability) {
			return true;
		}
		return false;
	}
}
