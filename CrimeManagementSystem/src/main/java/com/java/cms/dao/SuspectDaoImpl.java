package com.java.cms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.cms.model.Suspect;
import com.java.cms.model.Victim;
import com.java.cms.util.DBConnUtil;
import com.java.cms.util.DBPropertyUtil;

public class SuspectDaoImpl implements SuspectDao{
	Connection connection;
	PreparedStatement pst;
	@Override
	public void addSuspect(Suspect suspect) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd = "INSERT INTO Suspect(SuspectID,CrimeId,Name,Age,Description,CriminalHistory) VALUES(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, suspect.getSuspectId());
		pst.setInt(2, suspect.getCrimeId());
		pst.setString(3,suspect.getName());
		pst.setInt(4, suspect.getAge());
		pst.setString(5,suspect.getDescription() );
		pst.setString(6,suspect.getCriminalHistory());
		int rowsInserted = pst.executeUpdate();
		if(rowsInserted > 0) {
			System.out.println("Record inserted successfully");
		}
		else{
			System.out.println("Failed to insert Record");
		}
		
	}

	@Override
	public Suspect searchSuspectByCrimeId(int crimeId) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd = "select * from Suspect where CrimeId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, crimeId);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			Suspect suspect = new Suspect();
			suspect.setSuspectId(rs.getInt("suspectId"));
			suspect.setCrimeId(rs.getInt("crimeId"));
			suspect.setName(rs.getString("name"));
			suspect.setAge(rs.getInt("age"));
			suspect.setDescription(rs.getString("description"));
			suspect.setCriminalHistory(rs.getString("criminalHistory"));
			return suspect;
		}
		return null;
	}

	@Override
	public Suspect searchSuspectBySuspectId(int suspectId) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd = "select * from Suspect where SuspectId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, suspectId);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			Suspect suspect = new Suspect();
			suspect.setSuspectId(rs.getInt("suspectId"));
			suspect.setCrimeId(rs.getInt("crimeId"));
			suspect.setName(rs.getString("name"));
			suspect.setAge(rs.getInt("age"));
			suspect.setDescription(rs.getString("description"));
			suspect.setCriminalHistory(rs.getString("criminalHistory"));
			return suspect;
		}
		return null;
	}

}
