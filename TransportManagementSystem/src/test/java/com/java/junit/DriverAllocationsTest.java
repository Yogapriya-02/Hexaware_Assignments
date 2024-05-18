package com.java.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.text.ParseException;
import org.junit.Test;
import com.java.transport.model.DriverAllocations;

public class DriverAllocationsTest {

	@Test
	public void testToString() throws ParseException {
		DriverAllocations driverAllocation1 = new DriverAllocations(9, 4, 7, "Allocated");
		String result = "DriverAllocations [allocationId=" + 9 + ", driverId=" + 4 + ", tripId=" + 7
				+ ", allocationStatus=" + "Allocated" + "]";
		assertEquals(driverAllocation1.toString(), result);
	}

	@Test
	public void testEquals() throws ParseException {
		DriverAllocations driverAllocation1 = new DriverAllocations(9, 4, 7, "Allocated");
		DriverAllocations driverAllocation2 = new DriverAllocations(9, 4, 7, "Allocated");
		DriverAllocations driverAllocation3 = new DriverAllocations(9, 8, 7, "Allocated");
		assertTrue(driverAllocation1.equals(driverAllocation2));
		assertFalse(driverAllocation1.equals(driverAllocation3));

	}

	@Test
	public void testHashCode() throws ParseException {
		DriverAllocations driverAllocation1 = new DriverAllocations(9, 4, 7, "Allocated");
		DriverAllocations driverAllocation2 = new DriverAllocations(9, 4, 7, "Allocated");
		assertEquals(driverAllocation1.hashCode(), driverAllocation2.hashCode());
	}

	@Test
	public void testGettersandSetters() {
		DriverAllocations driverAllocation = new DriverAllocations();
		driverAllocation.setAllocationId(9);
		driverAllocation.setDriverId(4);
		driverAllocation.setTripId(7);
		driverAllocation.setAllocationStatus("Allocated");
		assertEquals(9, driverAllocation.getAllocationId());
		assertEquals(4, driverAllocation.getDriverId());
		assertEquals(7, driverAllocation.getTripId());
		assertEquals("Allocated", driverAllocation.getAllocationStatus());
	}

	@Test
	public void testConstructors() {
		DriverAllocations driverAllocation = new DriverAllocations();
		assertNotNull(driverAllocation);
		DriverAllocations d = new DriverAllocations(9, 4, 7, "Allocated");
		assertEquals(9, d.getAllocationId());
		assertEquals(4, d.getDriverId());
		assertEquals(7, d.getTripId());
		assertEquals("Allocated", d.getAllocationStatus());
	}

}
