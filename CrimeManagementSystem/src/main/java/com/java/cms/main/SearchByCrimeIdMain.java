package com.java.cms.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.java.cms.dao.CrimeDao;
import com.java.cms.dao.CrimeDaoImpl;
import com.java.cms.model.Crime;

public class SearchByCrimeIdMain {
	public static void main(String[] args) {
		CrimeDao dao = new CrimeDaoImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter CrimeId : ");
		int crimeId = sc.nextInt();
		try {
			Crime crime = dao.searchByCrimeId(crimeId);
			if(crime == null) {
				System.out.println("---No Record Found for particular CrimeId---");
			}
			else {
				System.out.println("---Record exists for given CrimeId---");
				System.out.println(crime);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
