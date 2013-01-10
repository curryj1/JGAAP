package com.jgaap.eventCullers;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.jgaap.generics.Event;
import com.jgaap.generics.EventCullingException;
import com.jgaap.generics.EventSet;

public class WeightedVarianceTest {

	@Test
	public void testProcess() throws EventCullingException {
		List<EventSet> eventSets = new ArrayList<EventSet>();
		EventSet eventSet1 = new EventSet();
		eventSet1.addEvent(new Event("A", null));
		eventSet1.addEvent(new Event("A", null));
		eventSet1.addEvent(new Event("A", null));
		eventSet1.addEvent(new Event("A", null));
		eventSet1.addEvent(new Event("A", null));
		eventSet1.addEvent(new Event("B", null));
		eventSet1.addEvent(new Event("B", null));
		eventSet1.addEvent(new Event("B", null));
		eventSet1.addEvent(new Event("C", null));
		eventSets.add(eventSet1);
		EventSet eventSet2 = new EventSet();
		eventSet2.addEvent(new Event("A", null));
		eventSet2.addEvent(new Event("B", null));
		eventSet2.addEvent(new Event("C", null));
		eventSet2.addEvent(new Event("D", null));
		eventSet2.addEvent(new Event("E", null));
		eventSet2.addEvent(new Event("F", null));
		eventSet2.addEvent(new Event("F", null));
		eventSet2.addEvent(new Event("G", null));
		eventSet2.addEvent(new Event("H", null));
		eventSets.add(eventSet2);
		EventSet eventSet3 = new EventSet();
		eventSet3.addEvent(new Event("E", null));
		eventSet3.addEvent(new Event("E", null));
		eventSet3.addEvent(new Event("E", null));
		eventSet3.addEvent(new Event("F", null));
		eventSet3.addEvent(new Event("A", null));
		eventSet3.addEvent(new Event("B", null));
		eventSet3.addEvent(new Event("D", null));
		eventSet3.addEvent(new Event("H", null));
		eventSet3.addEvent(new Event("C", null));
		eventSets.add(eventSet3);

		WeightedVariance culler = new WeightedVariance();
        culler.setParameter("numEvents", 4);
        List<EventSet> results = culler.cull(eventSets);
		List<EventSet> expected = new ArrayList<EventSet>();
		EventSet expectedEventSet = new EventSet();
		expectedEventSet.addEvent(new Event("A", null));
		expectedEventSet.addEvent(new Event("A", null));
		expectedEventSet.addEvent(new Event("A", null));
		expectedEventSet.addEvent(new Event("A", null));
		expectedEventSet.addEvent(new Event("A", null));
		expectedEventSet.addEvent(new Event("B", null));	
		expectedEventSet.addEvent(new Event("B", null));	
		expectedEventSet.addEvent(new Event("B", null));			
		expectedEventSet.addEvent(new Event("A", null));
		expectedEventSet.addEvent(new Event("B", null));
		expectedEventSet.addEvent(new Event("E", null));		
		expectedEventSet.addEvent(new Event("F", null));
		expectedEventSet.addEvent(new Event("F", null));		
		expectedEventSet.addEvent(new Event("E", null));
		expectedEventSet.addEvent(new Event("E", null));
		expectedEventSet.addEvent(new Event("E", null));
		expectedEventSet.addEvent(new Event("F", null));
		expectedEventSet.addEvent(new Event("A", null));		
		expectedEventSet.addEvent(new Event("B", null));
		expected.add(expectedEventSet);
		assertTrue(results.toString().equals(expected.toString()));
		
	
	}
}
