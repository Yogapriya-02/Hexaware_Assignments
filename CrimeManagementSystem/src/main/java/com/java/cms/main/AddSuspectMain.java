package com.java.cms.main;
import java.sql.SQLException;
import java.util.Scanner;

import com.java.cms.dao.*;
import com.java.cms.model.Suspect;

public class AddSuspectMain {
	public static void main(String[] args) {
		SuspectDao dao = new SuspectDaoImpl();
		Suspect suspect = new Suspect();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter SuspectId : ");
		int suspectId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter CrimeId : ");
		int crimeId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Name : ");
		String name = sc.nextLine();
		System.out.println("Enter Age : ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Description : ");
		String description = sc.nextLine();
		System.out.println("Enter CriminalHistory : ");
		String criminalHistory = sc.nextLine();
		
		suspect.setSuspectId(suspectId);
		suspect.setCrimeId(crimeId);
		suspect.setName(name);
		suspect.setDescription(description);
		suspect.setCriminalHistory(criminalHistory);
		
		try {
			dao.addSuspect(suspect);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
