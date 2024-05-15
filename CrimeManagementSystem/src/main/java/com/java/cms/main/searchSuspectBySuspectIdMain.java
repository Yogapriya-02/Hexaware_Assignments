package com.java.cms.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.cms.dao.SuspectDao;
import com.java.cms.dao.SuspectDaoImpl;
import com.java.cms.model.Suspect;

public class searchSuspectBySuspectIdMain {
	public static void main(String[] args) {
		SuspectDao dao = new SuspectDaoImpl();
		Suspect suspect = new Suspect();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter SuspectId : ");
		int suspectId = sc.nextInt();
		sc.nextLine();
		try {
			suspect = dao.searchSuspectBySuspectId(suspectId);
			if(suspect == null) {
				System.out.println("---No Victim Record Found for particular SuspectId---");
			}
			else {
				System.out.println("---Record exists for given SuspectId---");
				System.out.println(suspect);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
