package com.java.transport.model;

import java.util.Objects;

public class Trips {

	private int tripid;
	private int vehicleid;
	private int routeid;
	private String departuredate;
	private String arrivaldate;
	private String status;
	private String triptype;
	private int maxpassengers;

	public int getTripid() {
		return tripid;
	}

	public void setTripid(int tripid) {
		this.tripid = tripid;
	}

	public int getVehicleid() {
		return vehicleid;
	}

	public void setVehicleid(int vehicleid) {
		this.vehicleid = vehicleid;
	}

	public int getRouteid() {
		return routeid;
	}

	public void setRouteid(int routeid) {
		this.routeid = routeid;
	}

	public String getDeparturedate() {
		return departuredate;
	}

	public void setDeparturedate(String departuredate) {
		this.departuredate = departuredate;
	}

	public String getArrivaldate() {
		return arrivaldate;
	}

	public void setArrivaldate(String arrivaldate) {
		this.arrivaldate = arrivaldate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTriptype() {
		return triptype;
	}

	public void setTriptype(String triptype) {
		this.triptype = triptype;
	}

	public int getMaxpassengers() {
		return maxpassengers;
	}

	public void setMaxpassengers(int maxpassengers) {
		this.maxpassengers = maxpassengers;
	}

	public Trips() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trips(int tripid, int vehicleid, int routeid, String departuredate, String arrivaldate, String status,
			String triptype, int maxpassengers) {
		super();
		this.tripid = tripid;
		this.vehicleid = vehicleid;
		this.routeid = routeid;
		this.departuredate = departuredate;
		this.arrivaldate = arrivaldate;
		this.status = status;
		this.triptype = triptype;
		this.maxpassengers = maxpassengers;
	}

	@Override
	public String toString() {
		return "Trips [tripid=" + tripid + ", vehicleid=" + vehicleid + ", routeid=" + routeid + ", departuredate="
				+ departuredate + ", arrivaldate=" + arrivaldate + ", status=" + status + ", triptype=" + triptype
				+ ", maxpassengers=" + maxpassengers + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(tripid, vehicleid, routeid, departuredate, arrivaldate, status, triptype, maxpassengers);
	}

	@Override
	public boolean equals(Object obj) {
		Trips trip = (Trips) obj;
		if (trip.getTripid() == tripid && trip.getVehicleid() == vehicleid && trip.getRouteid() == routeid
				&& trip.getDeparturedate() == departuredate && trip.getArrivaldate() == arrivaldate
				&& trip.getStatus() == status && trip.getTriptype() == triptype
				&& trip.getMaxpassengers() == maxpassengers) {
			return true;
		}
		return false;
	}

}
