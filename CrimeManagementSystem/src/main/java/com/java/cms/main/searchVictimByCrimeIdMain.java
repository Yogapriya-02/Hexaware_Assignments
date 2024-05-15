package com.java.cms.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.cms.dao.VictimDao;
import com.java.cms.dao.VictimDaoImpl;
import com.java.cms.model.Victim;

public class searchVictimByCrimeIdMain {
	public static void main(String[] args) {
		VictimDao dao = new VictimDaoImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter CrimeId : ");
		int crimeId = sc.nextInt();
		try {
			Victim victim = dao.searchVictimByCrimeId(crimeId);
			if(victim == null) {
				System.out.println("---No Victim Record Found for particular CrimeId---");
			}
			else {
				System.out.println("---Record exists for given CrimeId---");
				System.out.println(victim);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
