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

import com.jgaap.util.Event;
import com.jgaap.util.EventMap;
import com.jgaap.util.EventSet;

/**
 * @author Juola
 *
 */
public class KeseljWeightedDistanceTest {

	/**
	 * Test method for {@link com.jgaap.distances.HistogramDistance#distance(com.jgaap.util.EventSet, com.jgaap.util.EventSet)}.
	 */
	@Test
	public void testDistance() {
		// first two tests taken from ordinary histogram distance 
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
		assertTrue(new KeseljWeightedDistance().distance(new EventMap(es1), new EventMap(es2)) == 0);
		Vector<Event> test2 = new Vector<Event>();
		test2.add(new Event("3", null));
		test2.add(new Event("..", null));
		test2.add(new Event("1", null));
		test2.add(new Event("4", null));
		test2.add(new Event("11", null));
		test2.add(new Event("5", null));
		test2.add(new Event("2", null));
		test2.add(new Event("6", null));
		test2.add(new Event("55", null));
		test2.add(new Event("33", null));
		es2 = new EventSet();
		es2.addEvents(test2);
		double result = new KeseljWeightedDistance().distance(new EventMap(es1), new EventMap(es2));
		//System.out.println("test 2 result is " + result);
		assertTrue(DistanceTestHelper.inRange(result, 20.0, 0.0000000001));

		// and now for the fun stuff, where the weighting matters
		Vector<Event> test3 = new Vector<Event>();
		// each event has probability 0.2, generates 0.111... distance
		test3.add(new Event("The", null));
		test3.add(new Event("quick", null));
		test3.add(new Event("brown", null));
		test3.add(new Event("fox", null));
		test3.add(new Event("jumps", null));
		// five events missing -- should add 5.0 as distance
		es2 = new EventSet();
		es2.addEvents(test3);
		result = new KeseljWeightedDistance().distance(new EventMap(es1), new EventMap(es2));
		//System.out.println("test 3 result is " + result);
		assertTrue(DistanceTestHelper.inRange(result, 5.5555555555, 0.000001));
	}

}
