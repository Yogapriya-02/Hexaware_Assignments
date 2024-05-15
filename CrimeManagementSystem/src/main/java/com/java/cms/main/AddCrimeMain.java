package com.java.cms.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.cms.dao.CrimeDao;
import com.java.cms.dao.CrimeDaoImpl;
import com.java.cms.model.Crime;

public class AddCrimeMain {
	public static void main(String[] args) {
		CrimeDao dao = new CrimeDaoImpl();
		Crime crime = new Crime();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Crime Id : ");
		int crimeId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter IncidentType : ");
		String incidentType = sc.nextLine();
		System.out.println("Enter IncidentDate : ");
		String incidentDate = sc.nextLine();
		System.out.println("Enter Location : ");
		String location = sc.nextLine();
		System.out.println("Enter Status : ");
		String status = sc.nextLine();
		System.out.println("Enter Description : ");
		String description = sc.nextLine();
		
		
		crime.setCrimeID(crimeId);
		crime.setIncidentType(incidentType);
		crime.setIncidentDate(incidentDate);
		crime.setLocation(location);
		crime.setDescription(description);
		crime.setStatus(status);
		
		try {
			dao.addCrime(crime);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
