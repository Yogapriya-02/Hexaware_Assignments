package com.java.cms.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.cms.dao.CrimeDao;
import com.java.cms.dao.CrimeDaoImpl;
import com.java.cms.model.Crime;

public class SearchByIncidenType {
	public static void main(String[] args) {
		CrimeDao dao = new CrimeDaoImpl();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter IncidentType : ");
		String incidentType = sc.next();
		try {
			List<Crime> incidentTypeList = dao.searchByIncidentType(incidentType);
			if(incidentTypeList == null) {
				System.out.println("---No Record Found for particular Incident Type---");
			}
			else {
				System.out.println("Records of crime for " + incidentType+" :");
				int index = 0;
		        while (index < incidentTypeList.size()) {
		            System.out.println(incidentTypeList.get(index));
		            index++;
		        }
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
