package com.java.transport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.java.myexceptions.BookingNotFoundException;
import com.java.myexceptions.VehicleNotFoundException;
import com.java.transport.model.Bookings;
import com.java.transport.model.Drivers;
import com.java.transport.model.Vehicles;
import com.java.transport.util.DBConnUtil;
import com.java.transport.util.DBPropertyUtil;

public class TransportManagementServiceDaoImpl implements TransportManagementServiceDao {
	Connection connection;
	PreparedStatement pst;

	@Override
	public String addVehicle(Vehicles vehicle) throws ClassNotFoundException, SQLException, VehicleNotFoundException {
		// Using general insert method to add new vehicle data to existing Vehicle Table
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd = "INSERT INTO Vehicles(vehicleId,model,capacity,type,status,fuel_type) values(?,?,?,?,?,?)";
		PreparedStatement pst = connection.prepareStatement(cmd);
		pst.setInt(1, vehicle.getVehicleId());
		pst.setString(2, vehicle.getModel());
		pst.setDouble(3, vehicle.getCapacity());
		pst.setString(4, vehicle.getType());
		pst.setString(5, vehicle.getStatus());
		pst.setString(6, vehicle.getFuel_type());
		int rowsInserted = pst.executeUpdate();
		if (rowsInserted > 0) {
			return "***---Record Inserted Successfully---***";
		} else {
			return "!!!!Failed to insert record!!!!";
		}
	}

	@Override
	public String updateVehicle(Vehicles vehicle)
			throws ClassNotFoundException, SQLException, VehicleNotFoundException {
		// Using general update method to update vehicle data in existing Vehicle Table
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd = "UPDATE Vehicles SET model=?, capacity=?,type=?, status=?, fuel_type=? WHERE vehicleId=?";
		PreparedStatement pst = connection.prepareStatement(cmd);
		pst.setString(1, vehicle.getModel());
		pst.setDouble(2, vehicle.getCapacity());
		pst.setString(3, vehicle.getType());
		pst.setString(4, vehicle.getStatus());
		pst.setString(5, vehicle.getFuel_type());
		pst.setInt(6, vehicle.getVehicleId());

		int rowsUpdated = pst.executeUpdate();
		if (rowsUpdated > 0) {
			return "***---Record Updated Successfully---***";
		} else {
			return "!!!!Failed to update record!!!!";
		}
	}

	@Override
	public String deleteVehicle(Vehicles vehicle)
			throws ClassNotFoundException, SQLException, VehicleNotFoundException {
		// Using general delete method to delete vehicle data from existing Vehicle
		// Table given vehicleId
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd = "DELETE FROM Vehicles WHERE VehicleId=?";
		PreparedStatement pst = connection.prepareStatement(cmd);
		pst.setInt(1, vehicle.getVehicleId());

		int rowsDeleted = pst.executeUpdate();
		if (rowsDeleted > 0) {
			return "***---Record Deleted Successfully---***";
		} else {
			return "!!!!Failed to delete record!!!!";
		}
	}

	@Override
	public boolean scheduleTrip(int vehicleId, int routeId, String departureDate, String arrivalDate)
			throws ClassNotFoundException, SQLException, VehicleNotFoundException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		boolean success = false;
		Timestamp departureTimestamp = Timestamp.valueOf(departureDate);
		Timestamp arrivalTimestamp = Timestamp.valueOf(arrivalDate);

		// Checking if the vehicle is available before scheduling a trip
		String checkQuery = "SELECT COUNT(*) AS count FROM Trips WHERE VehicleID = ? AND Trip_Status NOT IN ('Scheduled', 'In Progress')";
		PreparedStatement pst1 = connection.prepareStatement(checkQuery);
		pst1.setInt(1, vehicleId);
		ResultSet rs = pst1.executeQuery();

		if (rs.next() && rs.getInt("count") != 0) {
			// If vehicle is available use insert method to append new row with booking
			// details
			String insertQuery = "INSERT INTO Trips (VehicleID, RouteID, DepartureDate, ArrivalDate, Trip_Status) VALUES (?, ?, ?, ?, 'Scheduled')";
			PreparedStatement pst2 = connection.prepareStatement(insertQuery);
			pst2.setInt(1, vehicleId);
			pst2.setInt(2, routeId);
			pst2.setTimestamp(3, departureTimestamp);
			pst2.setTimestamp(4, arrivalTimestamp);

			int rowsInserted = pst2.executeUpdate();
			if (rowsInserted > 0) {
				success = true;
				System.out.println("Trip scheduled successfully.");
			} else {
				System.out.println("Failed to schedule trip.");
			}
		} else {
			throw new VehicleNotFoundException(
					"Vehicle with ID " + vehicleId + " is currently unavailable or does not exist.");
		}
		return success;
	}

	@Override
	public boolean cancelTrip(int tripId) throws ClassNotFoundException, SQLException {
		// Cancel Trip based on TripId if TripId exists
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);

		String cmd1 = "SELECT vehicleId FROM Trips WHERE Trip_Id = ?";
		PreparedStatement pst1 = connection.prepareStatement(cmd1);
		pst1.setInt(1, tripId);
		ResultSet res = pst1.executeQuery();
		int vehicleId = -1;
		if (res.next()) {
			vehicleId = res.getInt("vehicleId");
		} else {
			return false;
		}

		String cmd = "DELETE FROM Trips WHERE Trip_Id = ?";
		PreparedStatement pst = connection.prepareStatement(cmd);
		pst.setInt(1, tripId);
		int rowsDeleted = pst.executeUpdate();
		if (rowsDeleted > 0) {
			String cmd2 = "Update Vehicles SET Status='available' where vehicleId = ?";
			PreparedStatement pst2 = connection.prepareStatement(cmd2);
			pst2.setInt(1, vehicleId);
			pst2.executeUpdate();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean bookTrip(int tripId, int passengerId, String bookingDate)
			throws ClassNotFoundException, SQLException {
		// First check if passenger is registered with passenger table or not
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd1 = "SELECT * FROM Passengers WHERE PassengerID = ?";
		PreparedStatement pst1 = connection.prepareStatement(cmd1);
		pst1.setInt(1, passengerId);
		ResultSet res1 = pst1.executeQuery();
		if (res1.next()) {
			System.out.println("PassengerId Registered...Processing BookingDetails...");
		} else {
			System.out.println("Register/Create PassengerId");
			return false;
		}

		// If passenger data exists,book the trip for the passenger
		String cmd2 = "INSERT INTO Bookings(Trip_ID,PassengerId,BookingDate,Status) VALUES(?,?,?,?);";
		PreparedStatement pst2 = connection.prepareStatement(cmd2);
		pst2.setInt(1, tripId);
		pst2.setInt(2, passengerId);
		pst2.setString(3, bookingDate);
		pst2.setString(4, "Confirmed");
		int rowsUpdated = pst2.executeUpdate();
		if (rowsUpdated > 0) {
			System.out.println("Booking Successful");
			return true;
		} else {
			System.out.println("Booking Unsuccessful....Check the details");
			return false;
		}
	}

	@Override
	public boolean cancelBooking(int bookingId) throws ClassNotFoundException, SQLException, BookingNotFoundException {
		// Update the status in Bookings table as cancelled for given bookingId
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd1 = "UPDATE Bookings SET Status=? WHERE BookingId =?";
		PreparedStatement pst1 = connection.prepareStatement(cmd1);
		pst1.setString(1, "Cancelled");
		pst1.setInt(2, bookingId);
		;
		int rowsUpdated = pst1.executeUpdate();
		if (rowsUpdated > 0) {
			System.out.println("---Trip Cancellation Successful---");
			return true;
		} else {
			System.out.println("<-!-!BookingId doesn't Exis!-!->");
			throw new BookingNotFoundException("Booking ID " + bookingId + " not found.");
		}
	}

	@Override
	public boolean allocateDriver(int tripId, int driverId) throws ClassNotFoundException, SQLException {
		//To allocateDriver first check if the trip exists or not
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);

		String cmd = "SELECT * FROM Trips WHERE Trip_ID = ?";
		PreparedStatement pst = connection.prepareStatement(cmd);
		pst.setInt(1, tripId);
		ResultSet tripResult = pst.executeQuery();

		if (!tripResult.next()) {
			System.out.println("Trip does not exist");
			return false;
		}
		//If trip exists search particular driver is available or not
		String cmd1 = "SELECT * FROM Drivers WHERE DriverId = ? AND AllocationStatus = ?";
		PreparedStatement pst1 = connection.prepareStatement(cmd1);
		pst1.setInt(1, driverId);
		pst1.setString(2, "Available");
		ResultSet rs = pst1.executeQuery();

		if (rs.next()) {
			//If driver is available,allocate driver to trip and insert record in DriverAllocations Table
			String cmd2 = "INSERT INTO DriverAllocations (DriverId, TripId, AllocationStatus) VALUES (?, ?, ?)";
			PreparedStatement pst2 = connection.prepareStatement(cmd2);
			pst2.setInt(1, driverId);
			pst2.setInt(2, tripId);
			pst2.setString(3, "Allocated");
			int rowsAffected = pst2.executeUpdate();
			
			//After driver allocation, update driver status as allocated in drivers table
			String cmd3 = "UPDATE Drivers SET TripId = ?,AllocationStatus=? WHERE DriverId=?";
			PreparedStatement pst3 = connection.prepareStatement(cmd3);
			pst3.setInt(1, tripId);
			pst3.setString(2, "Allocated");
			pst3.setInt(3, driverId);
			int rowsUpdated = pst3.executeUpdate();

			if (rowsAffected > 0) {
				System.out.println("Driver Allocation successful");
				return true;
			} else {
				System.out.println("Driver is already allocated to another trip ");
				return false;
			}
		} else {
			System.out.println("Driver is not available");
			return false;
		}
	}F

	@Override
	public boolean deallocateDriver(int tripId) throws ClassNotFoundException, SQLException {
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		boolean success = false;
		// To deallocate driver check if a trip exists with given tripId and status as
		// allocated
		String cmd1 = "SELECT * FROM Drivers WHERE TripId = ? AND AllocationStatus = 'Allocated'";
		PreparedStatement pst1 = connection.prepareStatement(cmd1);
		pst1.setInt(1, tripId);
		ResultSet rs = pst1.executeQuery();

		if (rs.next()) {
			// If exists, then delete particular record from driver allocations table
			int driverId = rs.getInt("DriverId");
			String cmd2 = "DELETE FROM DriverAllocations WHERE TripId = ?";
			PreparedStatement pst2 = connection.prepareStatement(cmd2);
			pst2.setInt(1, tripId);
			int rowsAffected = pst2.executeUpdate();
			// The, upadte status of driver as Available in Drivers tablej
			String cmd3 = "UPDATE Drivers SET AllocationStatus = ?, TripId = NULL WHERE DriverId = ?";
			PreparedStatement pst3 = connection.prepareStatement(cmd3);
			pst3.setString(1, "Available");
			pst3.setInt(2, driverId);
			int rowsUpdated = pst3.executeUpdate();
			if (rowsAffected > 0 && rowsUpdated > 0) {
				System.out.println("Driver deallocation successful");
				success = true;
			} else {
				System.out.println("Driver deallocation failed");
			}
		} else {
			System.out.println("Driver is not available");
		}
		return success;
	}

	@Override
	public List<Bookings> getBookingsByPassenger(int passengerId) throws ClassNotFoundException, SQLException {
		// Using general select statement with where condition to get Booking details
		// with given passengerId
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd1 = "SELECT * FROM Bookings WHERE PassengerId =?";
		PreparedStatement pst1 = connection.prepareStatement(cmd1);
		pst1.setInt(1, passengerId);
		ResultSet rs = pst1.executeQuery();
		List<Bookings> resultantBookings = new ArrayList<Bookings>();
		while (rs.next()) {
			Bookings booking = new Bookings();
			booking.setBookingId(rs.getInt("bookingId"));
			booking.setTripsId(rs.getInt("Trip_Id"));
			booking.setPassengerId(rs.getInt("passengerId"));
			booking.setBookingDate(rs.getString("bookingDate"));
			booking.setStatus(rs.getString("status"));
			resultantBookings.add(booking);
		}
		return resultantBookings;
	}

	@Override
	public List<Bookings> getBookingsByTrip(int tripId) throws ClassNotFoundException, SQLException {
		// Using general select statement with where condition to get Booking details
		// with given tripId
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd1 = "SELECT * FROM Bookings WHERE Trip_Id =?";
		PreparedStatement pst1 = connection.prepareStatement(cmd1);
		pst1.setInt(1, tripId);
		ResultSet rs = pst1.executeQuery();
		List<Bookings> resultantBookings = new ArrayList<Bookings>();
		while (rs.next()) {
			Bookings booking = new Bookings();
			booking.setBookingId(rs.getInt("bookingId"));
			booking.setTripsId(rs.getInt("Trip_Id"));
			booking.setPassengerId(rs.getInt("passengerId"));
			booking.setBookingDate(rs.getString("bookingDate"));
			booking.setStatus(rs.getString("status"));
			resultantBookings.add(booking);
		}
		return resultantBookings;
	}

	@Override
	public List<Drivers> getAvailableDrivers() throws ClassNotFoundException, SQLException {
		// Using general select statement with where condition to get Available Drivers
		// details with given passengerId
		String connStr = DBPropertyUtil.getConnectionString("db");
		connection = DBConnUtil.GetConnection(connStr);
		String cmd1 = "SELECT * FROM Drivers WHERE AllocationStatus=?";
		PreparedStatement pst1 = connection.prepareStatement(cmd1);
		pst1.setString(1, "Available");
		ResultSet rs = pst1.executeQuery();
		List<Drivers> availableDrivers = new ArrayList<Drivers>();
		while (rs.next()) {
			Drivers driver = new Drivers();
			driver.setDriverId(rs.getInt("driverId"));
			driver.setName(rs.getString("tripId"));
			driver.setAge(rs.getInt("age"));
			driver.setTripId(rs.getInt("tripId"));
			driver.setAllocationStatus(rs.getString("allocationStatus"));
			availableDrivers.add(driver);
		}
		return availableDrivers;

	}

}
