package com.java.cms.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.cms.model.Crime;
import com.java.cms.util.DBConnUtil;
import com.java.cms.util.DBPropertyUtil;

public class CrimeDaoImpl implements CrimeDao{
	
	Connection connection;
	PreparedStatement pst;
	@Override
	public List<Crime> showCrimes() throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd = "select * from Crime";
		pst = connection.prepareStatement(cmd);
		ResultSet rs = pst.executeQuery();
		List<Crime> crimeList = new ArrayList<Crime>();
		Crime crime = null;
		while(rs.next()) {
			crime = new Crime();
			crime.setCrimeID(rs.getInt("crimeId"));
			crime.setIncidentType(rs.getString("incidentType"));
			crime.setIncidentDate(rs.getString("incidentDate"));
			crime.setLocation(rs.getString("location"));
			crime.setDescription(rs.getString("description"));
			crime.setStatus(rs.getString("status"));
			crimeList.add(crime);
		}
		return crimeList;
	}
	@Override
	public Crime searchByCrimeId(int crimeId) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd = "select * from Crime where CrimeId=?";
		pst = connection.prepareStatement(cmd);
		pst.setInt(1, crimeId);
		ResultSet rs = pst.executeQuery();
		if(rs.next()) {
			Crime crime = new Crime();
			crime.setCrimeID(rs.getInt("crimeId"));
			crime.setIncidentType(rs.getString("IncidentType"));
			crime.setIncidentDate(rs.getString("incidentDate"));
			crime.setLocation(rs.getString("location"));
			crime.setDescription(rs.getString("description"));
			crime.setStatus(rs.getString("status"));
			return crime;
		}
		return null;
	}
	@Override
	public List<Crime> searchByIncidentType(String incidentType) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd = "select * from Crime where IncidentType=?";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, incidentType);
		ResultSet rs = pst.executeQuery();
		List<Crime>incidentTypeCrimeList = new ArrayList<Crime>();
		while(rs.next()) {
			Crime crime = new Crime();
			crime.setCrimeID(rs.getInt("crimeId"));
			crime.setIncidentType(rs.getString("incidentType"));
			crime.setIncidentDate(rs.getString("incidentDate"));
			crime.setLocation(rs.getString("location"));
			crime.setDescription(rs.getString("description"));
			crime.setStatus(rs.getString("status"));
			incidentTypeCrimeList.add(crime);
		}
		return incidentTypeCrimeList;
	}
	@Override
	public List<Crime> searchByIncidentDate(String incidentDate) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		Date dateIncident = Date.valueOf(incidentDate);
		String cmd = "select * from Crime where IncidentDate= ? ";
		pst = connection.prepareStatement(cmd);
		pst.setDate(1, dateIncident);
		ResultSet rs = pst.executeQuery();
		List<Crime>incidentDateCrimeList = new ArrayList<Crime>();
		while(rs.next()) {
			Crime crime = new Crime();
			crime.setCrimeID(rs.getInt("crimeId"));
			crime.setIncidentType(rs.getString("incidentType"));
			crime.setIncidentDate(rs.getString("incidentDate"));
			crime.setLocation(rs.getString("location"));
			crime.setDescription(rs.getString("description"));
			crime.setStatus(rs.getString("status"));
			incidentDateCrimeList.add(crime);
		}
		return incidentDateCrimeList;

	}
	@Override
	public List<Crime> openIncidents() throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd = "select * from Crime where Status = ? ";
		pst = connection.prepareStatement(cmd);
		pst.setString(1, "Open");
		ResultSet rs = pst.executeQuery();
		List<Crime>openIncidentsList = new ArrayList<Crime>();
		while(rs.next()) {
			Crime crime = new Crime();
			crime.setCrimeID(rs.getInt("crimeId"));
			crime.setIncidentType(rs.getString("incidentType"));
			crime.setIncidentDate(rs.getString("incidentDate"));
			crime.setLocation(rs.getString("location"));
			crime.setDescription(rs.getString("description"));
			crime.setStatus(rs.getString("status"));
			openIncidentsList.add(crime);
		}
		return openIncidentsList;
	}
	@Override
	public void addCrime(Crime crime) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd = "INSERT INTO Crime(CrimeId,IncidentType,IncidentDate,Location,Description,Status) VALUES(?,?,?,?,?,?)";
		pst = connection.prepareStatement(cmd);
		Date dateIncident = Date.valueOf(crime.getIncidentDate());
		pst.setInt(1, crime.getCrimeID());
		pst.setString(2, crime.getIncidentType());
		pst.setDate(3,dateIncident);
		pst.setString(4, crime.getLocation());
		pst.setString(5, crime.getDescription());
		pst.setString(6, crime.getStatus());
		int rowsInserted = pst.executeUpdate();
		if(rowsInserted > 0) {
			System.out.println("Record inserted successfully");
		}
		else{
			System.out.println("Failed to insert Record");
		}
		
	}
	
}
