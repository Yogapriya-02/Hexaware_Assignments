package com.java.cms.main;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.java.cms.dao.CrimeDao;
import com.java.cms.dao.CrimeDaoImpl;
import com.java.cms.model.Crime;

public class OpenIncidentsMain {
	public static void main(String[] args) {
		CrimeDao dao = new CrimeDaoImpl();
		try {
			List<Crime> openIncidentsList = dao.openIncidents();
			if(openIncidentsList == null) {
				System.out.println("---No Record Found for Open Crimes---");
			}
			else {
				System.out.println("Records of Open Crimes :  ");
				int index = 0;
		        while (index < openIncidentsList.size()) {
		            System.out.println(openIncidentsList.get(index));
		            index++;
		        }
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
