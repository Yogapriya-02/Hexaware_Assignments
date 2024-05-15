package com.java.cms.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.cms.dao.SuspectDao;
import com.java.cms.dao.SuspectDaoImpl;
import com.java.cms.model.Suspect;
import com.java.cms.model.Victim;

public class searchSuspectByCrimeIdMain {
	public static void main(String[] args) {
		SuspectDao dao = new SuspectDaoImpl();
		Suspect suspect = new Suspect();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter CrimeId : ");
		int crimeId = sc.nextInt();
		sc.nextLine();
		try {
			suspect = dao.searchSuspectByCrimeId(crimeId);
			if(suspect == null) {
				System.out.println("---No Victim Record Found for particular CrimeId---");
			}
			else {
				System.out.println("---Record exists for given CrimeId---");
				System.out.println(suspect);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
