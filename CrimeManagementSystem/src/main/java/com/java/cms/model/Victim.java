package com.java.cms.model;

public class Victim {
	private int victimId;
	private int crimeId;
	private String name;
	private String contactInfo;
	private String injuries;
	public int getVictimId() {
		return victimId;
	}
	public void setVictimId(int victimId) {
		this.victimId = victimId;
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
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	public String getInjuries() {
		return injuries;
	}
	public void setInjuries(String injuries) {
		this.injuries = injuries;
	}
	public Victim() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Victim(int victimId, int crimeId, String name, String contactInfo, String injuries) {
		super();
		this.victimId = victimId;
		this.crimeId = crimeId;
		this.name = name;
		this.contactInfo = contactInfo;
		this.injuries = injuries;
	}
	@Override
	public String toString() {
		return "Victim [victimId=" + victimId + ", crimeId=" + crimeId + ", name=" + name + ", contactInfo="
				+ contactInfo + ", injuries=" + injuries + "]";
	}
	
	
}
