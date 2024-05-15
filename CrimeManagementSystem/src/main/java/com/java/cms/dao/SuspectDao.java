package com.java.cms.dao;

import java.sql.SQLException;

import com.java.cms.model.Suspect;

public interface SuspectDao {
	void addSuspect(Suspect suspect) throws ClassNotFoundException, SQLException;
	Suspect searchSuspectByCrimeId(int crimeId) throws ClassNotFoundException, SQLException;
	Suspect searchSuspectBySuspectId(int suspectId) throws ClassNotFoundException, SQLException;
	
}
