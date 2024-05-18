package com.java.transport.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.java.myexceptions.BookingNotFoundException;
import com.java.myexceptions.VehicleNotFoundException;
import com.java.transport.dao.*;
import com.java.transport.model.Bookings;
import com.java.transport.model.Drivers;
import com.java.transport.model.Trips;
import com.java.transport.model.Vehicles;

public class TransportManagementApp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("*******************************************************");
		System.out.println("AVAILABLE OPERATIONS : ");
		System.out.println();
		System.out.println("1. ADD VEHICLE ");
		System.out.println("2. UPDATE VEHICLE");
		System.out.println("3. DELETE VEHICLE");
		System.out.println("4. SCHEDULE TRIP");
		System.out.println("5. CANCEL TRIP");
		System.out.println("6. BOOK TRIP");
		System.out.println("7. CANCEL BOOKING");
		System.out.println("8. ALLOCATE DRIVER");
		System.out.println("9. DEALLOCATE DRIVER");
		System.out.println("10. GET BOOKINGS BY PASSENGER");
		System.out.println("11. GET BOOKINGS BY TRIP");
		System.out.println("12. GET AVAILABLE DRIVERS");
		System.out.println("********************************************************");
		System.out.println("ENTER YOUR CHOICE OF ACTION : ");
		int choice = sc.nextInt();
		switch (choice) {
		case 1:
			System.out.println("-----------------------------------------------------");
			System.out.println("Welcome to Add Vehicle Method");
			TransportManagementServiceDao dao = new TransportManagementServiceDaoImpl();
			Vehicles vehicles = new Vehicles();
			Scanner sc1 = new Scanner(System.in);
			System.out.println("Enter Vehicle ID : ");
			int vehicleId = sc1.nextInt();
			System.out.println("Enter Model Name :");
			String model = sc1.next();
			System.out.println("Enter Capacity : ");
			double capacity = sc1.nextDouble();
			System.out.println("Enter type : ");
			String type = sc1.next();
			System.out.println("Enter status : ");
			String status = sc1.next();
			System.out.println("Enter FuelType : ");
			String fuel_type = sc1.next();

			vehicles.setVehicleId(vehicleId);
			vehicles.setModel(model);
			vehicles.setCapacity(capacity);
			vehicles.setType(type);
			vehicles.setStatus(status);
			vehicles.setFuel_type(fuel_type);

			try {
				String result = dao.addVehicle(vehicles);
				System.out.println(result);
				System.out.println("-----------------------------------------------------");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (VehicleNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case 2:
			System.out.println("-----------------------------------------------------");
			System.out.println("Welcome to Update Vehicle Method");
			TransportManagementServiceDao dao2 = new TransportManagementServiceDaoImpl();
			Vehicles vehicles2 = new Vehicles();
			Scanner sc2 = new Scanner(System.in);
			System.out.println("Enter Vehicle ID : ");
			int vehicleId2 = sc2.nextInt();
			sc2.nextLine();
			System.out.println("Enter Model Name :");
			String model2 = sc2.nextLine();
			System.out.println("Enter Capacity : ");
			double capacity2 = sc2.nextDouble();
			sc2.nextLine();
			System.out.println("Enter type : ");
			String type2 = sc2.nextLine();
			System.out.println("Enter status : ");
			String status2 = sc2.nextLine();
			System.out.println("Enter FuelType : ");
			String fuel_type2 = sc2.nextLine();

			vehicles2.setVehicleId(vehicleId2);
			vehicles2.setModel(model2);
			vehicles2.setCapacity(capacity2);
			vehicles2.setType(type2);
			vehicles2.setStatus(status2);
			vehicles2.setFuel_type(fuel_type2);

			try {
				String result = dao2.updateVehicle(vehicles2);
				System.out.println(result);
				System.out.println("-----------------------------------------------------");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (VehicleNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 3:
			System.out.println("-----------------------------------------------------");
			System.out.println("Welcome to Delete Vehicle Method");
			TransportManagementServiceDao dao3 = new TransportManagementServiceDaoImpl();
			Vehicles vehicles3 = new Vehicles();
			Scanner sc3 = new Scanner(System.in);
			System.out.println("Enter Vehicle ID : ");
			int vehicleId3 = sc3.nextInt();
			vehicles3.setVehicleId(vehicleId3);

			try {
				String result = dao3.deleteVehicle(vehicles3);
				System.out.println(result);
				System.out.println("-----------------------------------------------------");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (VehicleNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 4:
			System.out.println("-----------------------------------------------------");
			System.out.println("Welcome to Schedule Trip Method");
			TransportManagementServiceDao dao4 = new TransportManagementServiceDaoImpl();
			Scanner sc4 = new Scanner(System.in);

			System.out.println("Enter Vehicle ID: ");
			int vehicleId4 = sc4.nextInt();

			System.out.println("Enter RouteId: ");
			int routeId4 = sc4.nextInt();

			sc4.nextLine();

			System.out.println("Enter DepartureDate in yyyy-MM-dd HH:mm:ss format: ");
			String departureDate4 = sc4.nextLine();

			System.out.println("Enter Arrival Date in yyyy-MM-dd HH:mm:ss format: ");
			String arrivalDate4 = sc4.nextLine();

			try {
				boolean res = dao4.scheduleTrip(vehicleId4, routeId4, departureDate4, arrivalDate4);
				System.out.println("-----------------------------------------------------");
			} catch (VehicleNotFoundException e) {
				System.out.println("Error: " + e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case 5:
			System.out.println("-----------------------------------------------------");
			System.out.println("Welcome to Cancel Trip Method");
			TransportManagementServiceDao dao5 = new TransportManagementServiceDaoImpl();

			Trips trip5 = new Trips();
			Scanner sc5 = new Scanner(System.in);
			System.out.println("Enter Trip ID : ");
			int vehicleId5 = sc5.nextInt();
			boolean result;
			try {
				result = dao5.cancelTrip(vehicleId5);
				if (result) {
					System.out.println("**--Trip Cancellation Successful--**");
				} else {
					System.out.println("**--TripID/VehicleID not found--**");
				}
				System.out.println("-----------------------------------------------------");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		case 6:
			System.out.println("-----------------------------------------------------");
			System.out.println("Welcome to Delete Book Trip");
			TransportManagementServiceDao dao6 = new TransportManagementServiceDaoImpl();
			Scanner sc6 = new Scanner(System.in);
			System.out.println("Enter TripID : ");
			int tripId6 = sc6.nextInt();
			System.out.println("Enter PassengerID : ");
			int passengerId6 = sc6.nextInt();
			System.out.println("Enter BookingDate in yyyy-MM-dd HH:mm:ss format : : ");
			String bookingDate6 = sc6.next();

			try {
				boolean result6 = dao6.bookTrip(tripId6, passengerId6, bookingDate6);
				System.out.println("-----------------------------------------------------");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 7:
			System.out.println("-----------------------------------------------------");
			System.out.println("Welcome to Cancel Booking Method");
			TransportManagementServiceDao dao7 = new TransportManagementServiceDaoImpl();
			Scanner sc7 = new Scanner(System.in);
			System.out.println("Enter BookingId for Cancellation: ");
			int bookingId7 = sc7.nextInt();
			try {
				boolean result7 = dao7.cancelBooking(bookingId7);
				System.out.println("-----------------------------------------------------");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BookingNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 8:
			System.out.println("-----------------------------------------------------");
			System.out.println("Welcome to Allocate Driver Method");
			TransportManagementServiceDao dao8 = new TransportManagementServiceDaoImpl();
			Scanner sc8 = new Scanner(System.in);
			System.out.println("Enter TripId : ");
			int tripId8 = sc8.nextInt();
			System.out.println("Enter DriverId : ");
			int driverId8 = sc8.nextInt();

			try {
				dao8.allocateDriver(tripId8, driverId8);
				System.out.println("-----------------------------------------------------");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 9:
			System.out.println("-----------------------------------------------------");
			System.out.println("Welcome to DeAllocate Driver Method");
			TransportManagementServiceDao dao9 = new TransportManagementServiceDaoImpl();
			Scanner sc9 = new Scanner(System.in);
			System.out.println("Enter TripId : ");
			int tripId9 = sc9.nextInt();

			try {
				dao9.deallocateDriver(tripId9);
				System.out.println("-----------------------------------------------------");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 10:
			System.out.println("-----------------------------------------------------");
			System.out.println("Welcome to GetBookings By Passenger Method");
			TransportManagementServiceDao dao10 = new TransportManagementServiceDaoImpl();
			System.out.println("Enter PassengerId : ");
			Scanner sc10 = new Scanner(System.in);
			int passengerId10 = sc10.nextInt();
			try {
				List<Bookings> bookingsList = new ArrayList<Bookings>();
				bookingsList = dao10.getBookingsByPassenger(passengerId10);
				if (bookingsList.size() == 0) {
					System.out.println("No Record Exists for given PassengerId");
				} else {
					System.out.println("Records with given PassengerId : ");
					for (Bookings booking : bookingsList) {
						System.out.println(booking);
					}
				}
				System.out.println("-----------------------------------------------------");

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 11:
			System.out.println("-----------------------------------------------------");
			System.out.println("Welcome to GetBookings By Trip Method");
			TransportManagementServiceDao dao11 = new TransportManagementServiceDaoImpl();
			System.out.println("Enter TripId : ");
			Scanner sc11 = new Scanner(System.in);
			int tripId11 = sc11.nextInt();
			try {
				List<Bookings> bookingsList = new ArrayList<Bookings>();
				bookingsList = dao11.getBookingsByTrip(tripId11);
				if (bookingsList.size() == 0) {
					System.out.println("No Record Exists for given TripId");
				} else {
					System.out.println("Records with given TripId : ");
					for (Bookings booking : bookingsList) {
						System.out.println(booking);
					}
				}
				System.out.println("-----------------------------------------------------");

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		case 12:
			System.out.println("-----------------------------------------------------");
			System.out.println("Welcome to GetAvailable Drivers Method");
			TransportManagementServiceDao dao12 = new TransportManagementServiceDaoImpl();

			try {
				List<Drivers> driversList = new ArrayList<Drivers>();
				driversList = dao12.getAvailableDrivers();
				if (driversList.size() == 0) {
					System.out.println("No Drivers are available");
				} else {
					System.out.println("Records of available drivers : ");
					for (Drivers driver : driversList) {
						System.out.println(driver);
					}
				}
				System.out.println("-----------------------------------------------------");

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}
}
