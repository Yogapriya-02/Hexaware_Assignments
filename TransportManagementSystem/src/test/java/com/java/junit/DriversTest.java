package com.java.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.java.transport.model.Drivers;

public class DriversTest {

	@Test
	public void testToString() {
		Drivers driver = new Drivers(8, "Arun", 42, 6, "Allocated");
		String result = "Drivers [driverId=" + 8 + ", name=" + "Arun" + ", age=" + 42 + ", tripId=" + 6
				+ ", allocationStatus=" + "Allocated" + "]";
		assertEquals(result, driver.toString());
	}

	@Test
	public void testEquals() {
		Drivers driver1 = new Drivers(8, "Arun", 42, 6, "Allocated");
		Drivers driver2 = new Drivers(8, "Arun", 42, 6, "Allocated");
		Drivers driver3 = new Drivers(9, "Arun", 42, 6, "Allocated");
		assertTrue(driver1.equals(driver2));
		assertFalse(driver1.equals(driver3));
	}

	@Test
	public void testHashCode() {
		Drivers driver1 = new Drivers(8, "Arun", 42, 6, "Allocated");
		Drivers driver2 = new Drivers(8, "Arun", 42, 6, "Allocated");
		assertEquals(driver1.hashCode(), driver2.hashCode());
	}

	@Test
	public void testGettersandSetters() {
		Drivers driver = new Drivers();
		driver.setDriverId(8);
		driver.setName("Arun");
		driver.setAge(42);
		driver.setTripId(6);
		driver.setAllocationStatus("Allocated");
		assertEquals(8, driver.getDriverId());
		assertEquals("Arun", driver.getName());
		assertEquals(42, driver.getAge());
		assertEquals(6, driver.getTripId());
		assertEquals("Allocated", driver.getAllocationStatus());
	}

	@Test
	public void testConstructors() {
		Drivers driver1 = new Drivers();
		assertNotNull(driver1);
		Drivers driver2 = new Drivers(8, "Arun", 42, 6, "Allocated");
		assertEquals(8, driver2.getDriverId());
		assertEquals("Arun", driver2.getName());
		assertEquals(42, driver2.getAge());
		assertEquals(6, driver2.getTripId());
		assertEquals("Allocated", driver2.getAllocationStatus());
	}

}
