package com.java.junit;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import com.java.transport.model.Trips;
import com.java.transport.model.Vehicles;

public class VehicleTest {

	@Test
	public void testToString() throws ParseException {
		Vehicles vehicle1 = new Vehicles(16, "Toyota Hiace", 220.00, "van", "available", "diesel");
		String result = "Vehicles [vehicleId=" + 16 + ", model=" + "Toyota Hiace" + ", capacity=" + 220.00 + ", type="
				+ "van" + ", status=" + "available" + ", fuel_type=" + "diesel" + "]";
		assertEquals(result, vehicle1.toString());
	}

	@Test
	public void testEquals() throws ParseException {
		Vehicles vehicle1 = new Vehicles(16, "Toyota Hiace", 220.00, "van", "available", "diesel");
		Vehicles vehicle2 = new Vehicles(16, "Toyota Hiace", 220.00, "van", "available", "diesel");
		Vehicles vehicle3 = new Vehicles(17, "Toyota Hiace", 220.00, "van", "available", "diesel");
		assertTrue(vehicle1.equals(vehicle2));
		assertFalse(vehicle1.equals(vehicle3));
	}

	@Test
	public void testHashCode() throws ParseException {
		Vehicles vehicle1 = new Vehicles(16, "Toyota Hiace", 220.00, "van", "available", "diesel");
		Vehicles vehicle2 = new Vehicles(16, "Toyota Hiace", 220.00, "van", "available", "diesel");
		assertEquals(vehicle1.hashCode(), vehicle2.hashCode());
	}

	@Test
	public void testGettersandSetters() throws ParseException {
		Vehicles vehicle = new Vehicles();
		vehicle.setVehicleId(16);
		vehicle.setModel("Toyota Hiace");
		vehicle.setCapacity(220.00);
		vehicle.setType("van");
		vehicle.setFuel_type("diesel");
		vehicle.setStatus("available");
		assertEquals(16, vehicle.getVehicleId());
		assertEquals("Toyota Hiace", vehicle.getModel());
		assertEquals(220.00, vehicle.getCapacity(), 0);
		assertEquals("van", vehicle.getType());
		assertEquals("available", vehicle.getStatus());
		assertEquals("diesel", vehicle.getFuel_type());
	}

	@Test
	public void testConstructors() throws ParseException {
		Vehicles vehicle1 = new Vehicles();
		assertNotNull(vehicle1);
		Vehicles vehicle2 = new Vehicles(16, "Toyota Hiace", 220.00, "van", "available", "diesel");
		assertEquals(16, vehicle2.getVehicleId());
		assertEquals("Toyota Hiace", vehicle2.getModel());
		assertEquals(220.00, vehicle2.getCapacity(), 0);
		assertEquals("van", vehicle2.getType());
		assertEquals("available", vehicle2.getStatus());
		assertEquals("diesel", vehicle2.getFuel_type());

	}

}
