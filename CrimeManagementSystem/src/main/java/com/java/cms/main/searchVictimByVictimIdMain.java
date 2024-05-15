package com.java.cms.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.cms.dao.VictimDao;
import com.java.cms.dao.VictimDaoImpl;
import com.java.cms.model.Victim;

public class searchVictimByVictimIdMain {
	public static void main(String[] args) {
		VictimDao dao = new VictimDaoImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter VictimId : ");
		int victimId = sc.nextInt();
		try {
			Victim victim = dao.searchVictimByVictimId(victimId);
			if(victim == null) {
				System.out.println("---No Record Found for particular VictimId---");
			}
			else {
				System.out.println("---Record exists for given VictimId---");
				System.out.println(victim);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
