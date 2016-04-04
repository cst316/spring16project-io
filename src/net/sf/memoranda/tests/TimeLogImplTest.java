package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.memoranda.psp.TimeLog;
import net.sf.memoranda.psp.TimeLogImpl;
import net.sf.memoranda.psp.TimeRowObject;

public class TimeLogImplTest {

	TimeRowObject timerow;
	TimeLog timelog;

	@Before
	public void setUp() throws Exception {
		timelog = new TimeLogImpl();

		timerow = new TimeRowObject();
		timerow.setDate("03/22/2016");
		timerow.setStartTime("12:15 pm");
		timerow.setEndTime("06:13 pm");
		timerow.setInterruptTime(0.75f);
		timerow.setPhase("Testing");		
		
		timelog.addTimeRowObject(timerow);
	}

	@Test
	public void testGetIsDirty () {
		//assertTrue (TimeLogImpl.getIsDirty());
	}
	
	@Test
	public void testTimeRowList () {
		assertTrue (timelog.getTimeRowLists().size() >= 1);
	}
	
	@Test
	public void testRemoveTimeRowList () {
		timelog.removeTimeRowObject(timerow, 0);
		assertTrue (timelog.getTimeRowLists().size() == 0);
	}
	
	/*@Test
	public void testGetTimeRowList () {
		assertTrue (timelog.getTimeRowObject(0).getEndTime() >
		timelog.getTimeRowObject(0).getStartTime());
	}*/
}
