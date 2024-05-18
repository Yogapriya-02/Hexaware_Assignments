package com.java.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import org.junit.Test;
import com.java.transport.model.Bookings;

public class BookingsTest {
	@Test
	public void testToString() throws ParseException {
		Bookings booking1 = new Bookings(41, 7, 10, "2024-05-14 09:00:00", "Completed");
		String result = "Bookings [bookingId=" + 41 + ", tripsId=" + 7 + ", passengerId=" + 10 + ", BookingDate="
				+ "2024-05-14 09:00:00" + ", status=" + "Completed" + "]";
		assertEquals(booking1.toString(), result);
	}

	@Test
	public void testEquals() throws ParseException {
		Bookings booking1 = new Bookings(41, 7, 10, "2024-05-14 09:00:00", "Completed");
		Bookings booking2 = new Bookings(41, 7, 10, "2024-05-14 09:00:00", "Completed");
		Bookings booking3 = new Bookings(41, 8, 10, "2024-05-14 09:00:00", "Completed");
		assertTrue(booking1.equals(booking2));
		assertFalse(booking1.equals(booking3));

	}

	@Test
	public void testHashCode() throws ParseException {
		Bookings booking1 = new Bookings(41, 7, 10, "2024-05-14 09:00:00", "Completed");
		Bookings booking2 = new Bookings(41, 7, 10, "2024-05-14 09:00:00", "Completed");
		assertEquals(booking1.hashCode(), booking2.hashCode());
	}

	@Test
	public void testGettersAndSetters() throws ParseException {
		Bookings booking = new Bookings();
		booking.setBookingId(41);
		booking.setTripsId(7);
		booking.setPassengerId(10);
		booking.setBookingDate("2024-05-14 09:00:00");
		booking.setStatus("Completed");
		assertEquals(41, booking.getBookingId());
		assertEquals(7, booking.getTripsId());
		assertEquals(10, booking.getPassengerId());
		assertEquals("2024-05-14 09:00:00", booking.getBookingDate());
		assertEquals("Completed", booking.getStatus());
	}

	@Test
	public void testConstructors() throws ParseException {
		Bookings booking = new Bookings();
		assertNotNull(booking);
		Bookings b = new Bookings(41, 7, 10, "2024-05-14 09:00:00", "Completed");
		assertEquals(41, b.getBookingId());
		assertEquals(7, b.getTripsId());
		assertEquals(10, b.getPassengerId());
		assertEquals("2024-05-14 09:00:00", b.getBookingDate());
		assertEquals("Completed", b.getStatus());

	}

}
