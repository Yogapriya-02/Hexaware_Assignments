package com.java.cms.dao;

import java.sql.SQLException;
import java.util.List;
import com.java.cms.model.Crime;



public interface CrimeDao {
	List<Crime> showCrimes() throws ClassNotFoundException, SQLException;
	Crime searchByCrimeId(int crimeId) throws ClassNotFoundException, SQLException;
	List<Crime> searchByIncidentType(String incidentType) throws ClassNotFoundException, SQLException;
	List<Crime> searchByIncidentDate(String incidentDate) throws ClassNotFoundException, SQLException;
	List<Crime> openIncidents() throws ClassNotFoundException, SQLException;
	void addCrime(Crime crime) throws ClassNotFoundException, SQLException;
}
