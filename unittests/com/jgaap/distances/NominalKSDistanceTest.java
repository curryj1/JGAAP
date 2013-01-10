/*
 * JGAAP -- a graphical program for stylometric authorship attribution
 * Copyright (C) 2009,2011 by Patrick Juola
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
/**
 * 
 */
package com.jgaap.distances;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import com.jgaap.generics.Event;
import com.jgaap.generics.EventMap;
import com.jgaap.generics.EventSet;

/**
 * @author Nicole
 *
 */
public class NominalKSDistanceTest {

	/**
	 * Test method for {@link com.jgaap.distances.NominalKSDistance#distance(com.jgaap.generics.EventSet, com.jgaap.generics.EventSet)}.
	 */
	@Test
	public void testDistance() {
		EventSet es1 = new EventSet();
		EventSet es2 = new EventSet();
		Vector<Event> test1 = new Vector<Event>();
		test1.add(new Event("The", null));
		test1.add(new Event("quick", null));
		test1.add(new Event("brown", null));
		test1.add(new Event("fox", null));
		test1.add(new Event("jumps", null));
		test1.add(new Event("over", null));
		test1.add(new Event("the", null));
		test1.add(new Event("lazy", null));
		test1.add(new Event("dog", null));
		test1.add(new Event(".", null));
		es1.addEvents(test1);
		es2.addEvents(test1);
		
		assertTrue(new NominalKSDistance().distance(new EventMap(es1), new EventMap(es2)) == 0.00);
		
		Vector<Event> test2 = new Vector<Event>();//set with the same number of elements, only one repeats and none are the same as in test1
		test2.add(new Event("33", null));
		test2.add(new Event("5", null));
		test2.add(new Event("6", null));
		test2.add(new Event("8", null));
		test2.add(new Event("44", null));
		test2.add(new Event("7", null));
		test2.add(new Event("33", null));
		test2.add(new Event("10", null));
		test2.add(new Event("2", null));
		test2.add(new Event("..", null));
		es2 = new EventSet();
		es2.addEvents(test2);
		double result = new NominalKSDistance().distance(new EventMap(es1), new EventMap(es2));
		assertTrue(DistanceTestHelper.inRange(result, 1.00, 0.0000000001));
	}

}
