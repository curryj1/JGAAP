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
package com.jgaap.classifiers;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Vector;

import org.junit.Test;

import com.jgaap.generics.Event;
import com.jgaap.generics.EventSet;
import com.jgaap.generics.Pair;

/**
 * @author darrenvescovi
 *
 */
public class SVMTest {

	/**
	 * Test method for {@link com.jgaap.classifiers.SVM#analyze(com.jgaap.generics.EventSet, List<EventSet>)}.
	 */
	@Test
	public void testAnalyze() {
		EventSet known1 = new EventSet();
		EventSet known2 = new EventSet();
		EventSet unknown = new EventSet();
		
		Vector<Event> test1 = new Vector<Event>();
		test1.add(new Event("Mary", null));
		test1.add(new Event("had", null));
		test1.add(new Event("a", null));
		test1.add(new Event("little", null));
		test1.add(new Event("lamb", null));
		test1.add(new Event("whose", null));
		test1.add(new Event("fleece", null));
		test1.add(new Event("was", null));
		test1.add(new Event("white", null));
		test1.add(new Event("as", null));
		test1.add(new Event("snow.", null));
		known1.addEvents(test1);
		known1.setAuthor("Mary");
		
		
		Vector<Event> test2 = new Vector<Event>();
		test2.add(new Event("Peter", null));
		test2.add(new Event("piper", null));
		test2.add(new Event("picked", null));
		test2.add(new Event("a", null));
		test2.add(new Event("pack", null));
		test2.add(new Event("of", null));
		test2.add(new Event("pickled", null));
		test2.add(new Event("peppers.", null));
		known2.addEvents(test2);
		known2.setAuthor("Peter");
		
		Vector<Event> test3 = new Vector<Event>();
		test3.add(new Event("Mary", null));
		test3.add(new Event("had", null));
		test3.add(new Event("a", null));
		test3.add(new Event("little", null));
		test3.add(new Event("lambda", null));
		test3.add(new Event("whose", null));
		test3.add(new Event("syntax", null));
		test3.add(new Event("was", null));
		test3.add(new Event("white", null));
		test3.add(new Event("as", null));
		test3.add(new Event("snow.", null));
		unknown.addEvents(test3);
		
		Vector <EventSet> esv = new Vector<EventSet>();
		esv.add(known1);
		esv.add(known2);
		
		SVM svm = new SVM();
		svm.train(esv);
		List<Pair<String,Double>> t = svm.analyze(unknown);
		String r = t.get(0).getFirst();
		String s = "Mary";
		
		assertTrue(r.equals(s));
		
	}

}
