/**
 * 
 */
package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import net.sf.memoranda.psp.TimeRowObject;

/**
 * @author carmstr7
 *
 */
public class TimeRowTest {

	TimeRowObject timerow;
	Date d;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		timerow = new TimeRowObject();
		timerow.setDate("03/22/2016");
		timerow.setStartTime(10.30f);
		timerow.setEndTime(15.50f);
		timerow.setInterruptTime(0.75f);
		timerow.setPhase("Testing");		
	}
	
	@Test
	public void testStartDate() {
		d = new Date();
		assertTrue (timerow.getDate().compareTo(d) < 0);
	}
	
	@Test
	public void testStartTime () {
		assertTrue (timerow.getStartTime() > 0.0f);
		assertTrue (timerow.getEndTime() - timerow.getStartTime() > 0.0f);
	}
	
	@Test
	public void testGetIsDirty() {
		assertTrue (TimeRowObject.getIsDirty());
	}
	
	@Test
	public void testGetPhase() {
		assertTrue (timerow.getPhase().equalsIgnoreCase("Testing"));
	}
}
