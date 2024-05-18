package com.java.transport.dao;

import java.sql.SQLException;
import java.util.List;

import com.java.myexceptions.BookingNotFoundException;
import com.java.myexceptions.VehicleNotFoundException;
import com.java.transport.model.Bookings;
import com.java.transport.model.Drivers;
import com.java.transport.model.Vehicles;

public interface TransportManagementServiceDao {
	String addVehicle(Vehicles vehicle) throws ClassNotFoundException, SQLException, VehicleNotFoundException;

	String updateVehicle(Vehicles vehicle) throws ClassNotFoundException, SQLException, VehicleNotFoundException;

	String deleteVehicle(Vehicles vehicle) throws ClassNotFoundException, SQLException, VehicleNotFoundException;

	boolean scheduleTrip(int vehicleId, int routeId, String departureDate, String arrivalDate)
			throws ClassNotFoundException, SQLException, VehicleNotFoundException;

	boolean cancelTrip(int tripId) throws ClassNotFoundException, SQLException;

	boolean bookTrip(int tripId, int passengerId, String bookingDate) throws ClassNotFoundException, SQLException;

	boolean cancelBooking(int bookingId) throws ClassNotFoundException, SQLException, BookingNotFoundException;

	boolean allocateDriver(int tripId, int driverId) throws ClassNotFoundException, SQLException;

	boolean deallocateDriver(int tripId) throws ClassNotFoundException, SQLException;

	List<Bookings> getBookingsByPassenger(int passengerId) throws ClassNotFoundException, SQLException;

	List<Bookings> getBookingsByTrip(int tripId) throws ClassNotFoundException, SQLException;

	List<Drivers> getAvailableDrivers() throws ClassNotFoundException, SQLException;
}
