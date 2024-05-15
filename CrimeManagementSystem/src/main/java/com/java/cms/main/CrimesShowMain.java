package com.java.cms.main;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.cms.dao.*;
import com.java.cms.model.*;

public class CrimesShowMain {
	public static void main(String[] args) {
		CrimeDao dao = new CrimeDaoImpl();
		try {
			List<Crime> crimeList = new ArrayList<Crime>();
			crimeList = dao.showCrimes();
			for (Crime crime : crimeList) {
				System.out.println(crime);
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
	}
}
