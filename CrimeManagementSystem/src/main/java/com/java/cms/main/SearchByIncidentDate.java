package com.java.cms.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.cms.dao.CrimeDao;
import com.java.cms.dao.CrimeDaoImpl;
import com.java.cms.model.Crime;

public class SearchByIncidentDate {
	public static void main(String[] args) {
		CrimeDao dao = new CrimeDaoImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter IncidentDate in YYYY-mm-dd format: ");
		String incidentDate = sc.nextLine();
		try {
			List<Crime> incidentDateList = dao.searchByIncidentDate(incidentDate);
			if(incidentDateList.size() == 0) {
				System.out.println("---No Record Found for particular Incident Date---");
			}
			else {
				System.out.println("Records of crime on " + incidentDate+" :");
				int listIndex = 0;
		        while (listIndex < incidentDateList.size()) {
		            System.out.println(incidentDateList.get(listIndex));
		            listIndex++;
		        }
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
