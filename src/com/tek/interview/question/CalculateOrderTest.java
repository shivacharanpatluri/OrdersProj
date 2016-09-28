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
	//This test helps to test order items which may have more than 1 quantity.
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

	//This is to test the order of displaying order, with the given test data(order names) output is expected but one descripancy
	//is displaying Order 104 is prior than Order 22. But this is
	// technically good though as we are comparing as strings not integers.
	@Test
	public void testOrder() throws Exception {
		
		Map<String, Order> o = new TreeMap<String, Order>();
		Order c1 = new Order();
		
		c1.add(new OrderLine(new Item("book", (float) 12.49), 1));
		c1.add(new OrderLine(new Item("music CD", (float) 14.99), 1));
		c1.add(new OrderLine(new Item("chocolate bar", (float) 0.85), 1));

		o.put("Order 51", c1);

		// Reuse cart for an other order
		//c1.clear();

		Order c2 = new Order();
		c2.add(new OrderLine(new Item("imported box of chocolate", 10), 1));
		c2.add(new OrderLine(new Item("imported bottle of perfume", (float) 47.50), 1));

		o.put("Order 104", c2);

		// Reuse cart for an other order
		//c2.clear();
		Order c3 = new Order();

		c3.add(new OrderLine(new Item("Imported bottle of perfume", (float) 27.99), 1));
		c3.add(new OrderLine(new Item("bottle of perfume", (float) 18.99), 1));
		c3.add(new OrderLine(new Item("packet of headache pills", (float) 9.75), 1));
		c3.add(new OrderLine(new Item("box of impoted chocolates", (float) 11.25), 1));

		o.put("Order 22", c3);
		new calculator().calculate(o);
	}
}
