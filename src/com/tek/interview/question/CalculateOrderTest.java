package com.tek.interview.question;

import static org.junit.Assert.*;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

public class CalculateOrderTest {

	@Test
	public void tesImportedt() throws Exception {
		
		Map<String, Order> o = new TreeMap<String, Order>();
		Order c3 = new Order();

		c3.add(new OrderLine(new Item("iMPORted bottle of perfume", (float) 27.99), 1));// test for quantity more than 1
		c3.add(new OrderLine(new Item("bottle imported of perfume", (float) 18.99), 1)); 
		c3.add(new OrderLine(new Item("packet of IMPORTED headache pills", (float) 9.75), 1));

		o.put("Order 3", c3);
		new calculator().calculate(o);
	}
	
	@Test
	public void testQuantity() throws Exception {
		
		Map<String, Order> o = new TreeMap<String, Order>();
		Order c3 = new Order();

		c3.add(new OrderLine(new Item("iMPORted bottle of perfume", (float) 27.99), 2));// test for quantity more than 1
		c3.add(new OrderLine(new Item("bottle imported of perfume", (float) 18.99), 3)); 
		c3.add(new OrderLine(new Item("packet of IMPORTED headache pills", (float) 9.75), 4));

		o.put("Order 3", c3);
		new calculator().calculate(o);
	}

}
