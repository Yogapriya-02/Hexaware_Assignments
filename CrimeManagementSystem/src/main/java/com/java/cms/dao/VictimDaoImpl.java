package com.java.cms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.java.cms.model.Victim;
import com.java.cms.util.DBConnUtil;
import com.java.cms.util.DBPropertyUtil;

public class VictimDaoImpl implements VictimDao{
	Connection connection;
	PreparedStatement pst;
	@Override
	public Victim searchVictimByCrimeId(int crimeId) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd = "select * from Victim where CrimeId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, crimeId);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			Victim victim = new Victim();
			victim.setVictimId(rs.getInt("victimId"));
			victim.setCrimeId(rs.getInt("crimeId"));
			victim.setName(rs.getString("name"));
			victim.setContactInfo(rs.getString("contactInfo"));
			victim.setInjuries(rs.getString("injuries"));
			return victim;
		}
		return null;
	}
	@Override
	public Victim searchVictimByVictimId(int victimId) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd = "select * from Victim where VictimId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, victimId);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			Victim victim = new Victim();
			victim.setVictimId(rs.getInt("victimId"));
			victim.setCrimeId(rs.getInt("crimeId"));
			victim.setName(rs.getString("name"));
			victim.setContactInfo(rs.getString("contactInfo"));
			victim.setInjuries(rs.getString("injuries"));
			return victim;
		}
		return null;
	}
	@Override
	public void addVictim(Victim victim) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd = "INSERT INTO Victim(VictimID,CrimeId,Name,ContactInfo,Injuries) VALUES(?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, victim.getVictimId());
		pst.setInt(2, victim.getCrimeId());
		pst.setString(3,victim.getName());
		pst.setString(4, victim.getContactInfo());
		pst.setString(5, victim.getInjuries());
		int rowsInserted = pst.executeUpdate();
		if(rowsInserted > 0) {
			System.out.println("Record inserted successfully");
		}
		else{
			System.out.println("Failed to insert Record");
		}
		
	}
	
}
