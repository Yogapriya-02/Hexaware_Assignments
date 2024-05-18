package com.java.junit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.java.transport.model.Routes;

public class RoutesTest {

	@Test
	public void testEquals() {
		Routes route1 = new Routes(7, "Hyderabad", "Tirupati", 559.80, "Available");
		Routes route2 = new Routes(7, "Hyderabad", "Tirupati", 559.80, "Available");
		Routes route3 = new Routes(8, "Hyderabad", "Tirupati", 559.80, "Available");
		assertTrue(route1.equals(route2));
		assertFalse(route1.equals(route3));
	}

	@Test
	public void testToString() {
		Routes route = new Routes(7, "Hyderabad", "Tirupati", 559.80, "Available");
		String result = "Routes [routeId=" + 7 + ", startDestination=" + "Hyderabad" + ", endDestination=" + "Tirupati"
				+ ", distance=" + 559.80 + ", availability=" + "Available" + "]";
		assertEquals(result, route.toString());
	}

	@Test
	public void testHashCode() {
		Routes route1 = new Routes(7, "Hyderabad", "Tirupati", 559.80, "Available");
		Routes route2 = new Routes(7, "Hyderabad", "Tirupati", 559.80, "Available");
		assertEquals(route1.hashCode(), route2.hashCode());
	}

	@Test
	public void testGettersandSetters() {
		Routes route = new Routes();
		route.setRouteId(7);
		route.setStartDestination("Hyderabad");
		route.setEndDestination("Tirupati");
		route.setDistance(559.80);
		route.setAvailability("Available");
		assertEquals(7, route.getRouteId());
		assertEquals("Hyderabad", route.getStartDestination());
		assertEquals("Tirupati", route.getEndDestination());
		assertEquals(559.80, route.getDistance(), 0);
		assertEquals("Available", route.getAvailability());
	}

	@Test
	public void testConstructors() {
		Routes route1 = new Routes();
		assertNotNull(route1);
		Routes route2 = new Routes(7, "Hyderabad", "Tirupati", 559.80, "Available");
		assertEquals(7, route2.getRouteId());
		assertEquals("Hyderabad", route2.getStartDestination());
		assertEquals("Tirupati", route2.getEndDestination());
		assertEquals(559.80, route2.getDistance(), 0);
		assertEquals("Available", route2.getAvailability());

	}

}
