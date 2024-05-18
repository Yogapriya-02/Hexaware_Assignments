package com.java.transport.model;

import java.util.Objects;

public class Bookings {
	private int bookingId;
	private int tripsId;
	private int passengerId;
	private String BookingDate;
	private String status;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getTripsId() {
		return tripsId;
	}

	public void setTripsId(int tripsId) {
		this.tripsId = tripsId;
	}

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getBookingDate() {
		return BookingDate;
	}

	public void setBookingDate(String bookingDate) {
		BookingDate = bookingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Bookings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bookings(int bookingId, int tripsId, int passengerId, String bookingDate, String status) {
		this.bookingId = bookingId;
		this.tripsId = tripsId;
		this.passengerId = passengerId;
		BookingDate = bookingDate;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bookings [bookingId=" + bookingId + ", tripsId=" + tripsId + ", passengerId=" + passengerId
				+ ", BookingDate=" + BookingDate + ", status=" + status + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hash(bookingId, tripsId, passengerId, BookingDate, status);
	}

	@Override
	public boolean equals(Object obj) {
		Bookings booking = (Bookings) obj;
		if (booking.getBookingId() == bookingId && booking.getTripsId() == tripsId
				&& booking.getPassengerId() == passengerId && booking.getBookingDate() == BookingDate
				&& booking.getStatus() == status) {
			return true;
		}
		return false;
	}

}
