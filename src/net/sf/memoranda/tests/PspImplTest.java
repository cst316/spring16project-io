package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.date.CurrentDate;

public class PspImplTest {
	
	private int pID;
	private CurrentDate stDate;
	private String name;
	private String description;
	static int lastID;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		pID = 100020004;
		stDate = new CurrentDate();
		name = "Adam";
		description = "Finance tracker keeps track of finances";
		lastID = 100020001;
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPspImpl() {
		
	}

	@Test
	public void testPspImplCurrentDateStringString() {
		CalendarDate todaysDate = new CalendarDate(3, 1, 2016);
		CalendarDate tommorowsDate = new CalendarDate(3, 2, 2016);
		String wrongInput = "Got you";
		assertTrue(stDate.equals(todaysDate));
		assertFalse(stDate.equals(tommorowsDate));
		assertFalse(stDate.equals(wrongInput));
	}

	@Test
	public void testPspImplStringStringInt() {
		
	}

	@Test
	public void testGetpId() {
		assertTrue(pID == 100020004);
		assertFalse(pID == 20003);
		assertFalse(pID == 0);
	}

	@Test
	public void testSetpId() {
		assertTrue(pID == 100020004);
		assertFalse(pID == 123);
		assertFalse(pID == 456);
	}

	@Test
	public void testGetStDate() {
		CalendarDate startDate = new CalendarDate(3, 1, 2016);
		assertTrue(stDate.equals(startDate));
		assertFalse(stDate.equals("3/1/2016"));
	}

	@Test
	public void testSetStDate() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetName() {
		String nameTest = "Adam";
		String nameTest1 = "Adam";
		assertTrue(name.equals(nameTest));
		assertFalse(name.equals(nameTest1));
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDescription() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDescription() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLastID() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetLastID() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveString() {
		fail("Not yet implemented");
	}

	@Test
	public void testSaveFileOutputStream() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
