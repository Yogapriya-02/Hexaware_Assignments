package com.java.cms.model;

public class Crime {
	private int crimeID;
	private String incidentType;
	private String incidentDate;
	private String location;
	private String description;
	private String status;
	public int getCrimeID() {
		return crimeID;
	}
	public void setCrimeID(int crimeID) {
		this.crimeID = crimeID;
	}
	public String getIncidentType() {
		return incidentType;
	}
	public void setIncidentType(String incidentType) {
		this.incidentType = incidentType;
	}
	public String getIncidentDate() {
		return incidentDate;
	}
	public void setIncidentDate(String incidentDate) {
		this.incidentDate = incidentDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Crime() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Crime(int crimeID, String incidentType, String incidentDate, String location, String description,
			String status) {
		super();
		this.crimeID = crimeID;
		this.incidentType = incidentType;
		this.incidentDate = incidentDate;
		this.location = location;
		this.description = description;
		this.status = status;
	}
	@Override
	public String toString() {
		return "Crime [crimeID=" + crimeID + ", incidentType=" + incidentType + ", incidentDate=" + incidentDate
				+ ", location=" + location + ", description=" + description + ", status=" + status + "]";
	}
	
	
}
