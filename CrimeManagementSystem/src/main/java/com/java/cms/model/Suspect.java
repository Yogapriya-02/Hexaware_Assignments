package com.java.cms.model;

public class Suspect {
	private int suspectId;
	private int crimeId;
	private String name;
	private int Age;
	private String description;
	private String criminalHistory;
	public int getSuspectId() {
		return suspectId;
	}
	public void setSuspectId(int suspectId) {
		this.suspectId = suspectId;
	}
	public int getCrimeId() {
		return crimeId;
	}
	public void setCrimeId(int crimeId) {
		this.crimeId = crimeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCriminalHistory() {
		return criminalHistory;
	}
	public void setCriminalHistory(String criminalHistory) {
		this.criminalHistory = criminalHistory;
	}
	public Suspect(int suspectId, int crimeId, String name, int age, String description, String criminalHistory) {
		super();
		this.suspectId = suspectId;
		this.crimeId = crimeId;
		this.name = name;
		Age = age;
		this.description = description;
		this.criminalHistory = criminalHistory;
	}
	public Suspect() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Suspect [suspectId=" + suspectId + ", crimeId=" + crimeId + ", name=" + name + ", Age=" + Age
				+ ", description=" + description + ", criminalHistory=" + criminalHistory + "]";
	}
	
	
	
}
