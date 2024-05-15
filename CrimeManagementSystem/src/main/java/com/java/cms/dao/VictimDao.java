package com.java.cms.dao;

import java.sql.SQLException;

import com.java.cms.model.Victim;

public interface VictimDao {
	Victim searchVictimByCrimeId(int crimeId) throws ClassNotFoundException, SQLException;
	Victim searchVictimByVictimId(int victimId) throws ClassNotFoundException, SQLException;
	void addVictim(Victim victim) throws ClassNotFoundException, SQLException;
}
