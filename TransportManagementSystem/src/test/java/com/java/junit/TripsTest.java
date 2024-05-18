package com.java.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.java.transport.model.Trips;

public class TripsTest {

	@Test
	public void testToString() {
		Trips trip1 = new Trips(60, 8, 18, "2024-06-29 10:30:00", "2024-06-29 14:30:00", "Scheduled", "Passenger", 30);
		String result = "Trips [tripid=" + 60 + ", vehicleid=" + 8 + ", routeid=" + 18 + ", departuredate="
				+ "2024-06-29 10:30:00" + ", arrivaldate=" + "2024-06-29 14:30:00" + ", status=" + "Scheduled"
				+ ", triptype=" + "Passenger" + ", maxpassengers=" + 30 + "]";
		assertEquals(result, trip1.toString());
	}

	@Test
	public void testEquals() {
		Trips trip1 = new Trips(60, 8, 18, "2024-06-29 10:30:00", "2024-06-29 14:30:00", "Scheduled", "Passenger", 30);
		Trips trip2 = new Trips(60, 8, 18, "2024-06-29 10:30:00", "2024-06-29 14:30:00", "Scheduled", "Passenger", 30);
		Trips trip3 = new Trips(70, 8, 18, "2024-06-29 10:30:00", "2024-06-29 14:30:00", "Scheduled", "Passenger", 30);
		assertTrue(trip1.equals(trip2));
		assertFalse(trip1.equals(trip3));
	}

	@Test
	public void testHashCode() {
		Trips trip1 = new Trips(60, 8, 18, "2024-06-29 10:30:00", "2024-06-29 14:30:00", "Scheduled", "Passenger", 30);
		Trips trip2 = new Trips(60, 8, 18, "2024-06-29 10:30:00", "2024-06-29 14:30:00", "Scheduled", "Passenger", 30);
		assertEquals(trip1.hashCode(), trip2.hashCode());
	}

	@Test
	public void testGettersandSetters() {
		Trips trip = new Trips();
		trip.setTripid(60);
		trip.setVehicleid(8);
		trip.setRouteid(18);
		trip.setDeparturedate("2024-06-29 10:30:00");
		trip.setArrivaldate("2024-06-29 14:30:00");
		trip.setStatus("Scheduled");
		trip.setTriptype("Passenger");
		trip.setMaxpassengers(30);
		assertEquals(60, trip.getTripid());
		assertEquals(8, trip.getVehicleid());
		assertEquals(18, trip.getRouteid());
		assertEquals("2024-06-29 10:30:00", trip.getDeparturedate());
		assertEquals("2024-06-29 14:30:00", trip.getArrivaldate());
		assertEquals("Scheduled", trip.getStatus());
		assertEquals("Passenger", trip.getTriptype());
		assertEquals(30, trip.getMaxpassengers());
	}

	@Test
	public void testConstructors() {
		Trips trip1 = new Trips();
		assertNotNull(trip1);
		Trips trip2 = new Trips(60, 8, 18, "2024-06-29 10:30:00", "2024-06-29 14:30:00", "Scheduled", "Passenger", 30);
		assertEquals(60, trip2.getTripid());
		assertEquals(8, trip2.getVehicleid());
		assertEquals(18, trip2.getRouteid());
		assertEquals("2024-06-29 10:30:00", trip2.getDeparturedate());
		assertEquals("2024-06-29 14:30:00", trip2.getArrivaldate());
		assertEquals("Scheduled", trip2.getStatus());
		assertEquals("Passenger", trip2.getTriptype());
		assertEquals(30, trip2.getMaxpassengers());

	}

}
