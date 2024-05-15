package com.java.cms.main;
import java.sql.SQLException;
import java.util.Scanner;

import com.java.cms.dao.*;
import com.java.cms.model.Victim;

public class AddVictimMain {
	public static void main(String[] args) {
		VictimDao dao = new VictimDaoImpl();
		Victim victim = new Victim();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter VictimId : ");
		int victimId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter CrimeId : ");
		int crimeId = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter Name : ");
		String name = sc.nextLine();
		System.out.println("Enter ContactInfo : ");
		String contactInfo = sc.nextLine();
		System.out.println("Enter Injuries : ");
		String injuries = sc.nextLine();
		
		victim.setVictimId(victimId);
		victim.setCrimeId(crimeId);
		victim.setName(name);
		victim.setContactInfo(contactInfo);
		victim.setInjuries(injuries);
		
		try {
			dao.addVictim(victim);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
