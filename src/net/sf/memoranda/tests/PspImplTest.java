package net.sf.memoranda.tests;

import static org.junit.Assert.*;

<<<<<<< HEAD
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

=======
>>>>>>> us-45
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.date.CurrentDate;
<<<<<<< HEAD
import net.sf.memoranda.psp.Psp;
=======
>>>>>>> us-45

public class PspImplTest {
	
	private int pID;
	private CurrentDate stDate;
	private String name;
	private String description;
	static int lastID;
<<<<<<< HEAD
	private ObjectOutputStream fw;
=======

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
>>>>>>> us-45

	@Before
	public void setUp() throws Exception {
		pID = 100020004;
		stDate = new CurrentDate();
		name = "Adam";
		description = "Finance tracker keeps track of finances";
		lastID = 100020001;
<<<<<<< HEAD
		fw = new ObjectOutputStream(new FileOutputStream("save.txt"));
=======
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPspImpl() {
>>>>>>> us-45
		
	}

	@Test
	public void testPspImplCurrentDateStringString() {
<<<<<<< HEAD
		CalendarDate todaysDate = new CalendarDate(10, 12, 2016);
		CalendarDate tommorowsDate = new CalendarDate(3, 2, 2016);
		String wrongInput = "Got you";
		assertFalse(stDate.equals(todaysDate));
=======
		CalendarDate todaysDate = new CalendarDate(3, 1, 2016);
		CalendarDate tommorowsDate = new CalendarDate(3, 2, 2016);
		String wrongInput = "Got you";
		assertTrue(stDate.equals(todaysDate));
>>>>>>> us-45
		assertFalse(stDate.equals(tommorowsDate));
		assertFalse(stDate.equals(wrongInput));
	}

	@Test
<<<<<<< HEAD
=======
	public void testPspImplStringStringInt() {
		
	}

	@Test
>>>>>>> us-45
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
<<<<<<< HEAD
		CalendarDate startDate = new CalendarDate(12, 3, 2016);
		assertTrue(stDate.equals(stDate));
		assertFalse(stDate.equals(startDate));
		assertFalse(stDate.equals("3/1/2016"));
	}
	
	@Test
	public void testSetStDate() {
		assertTrue(stDate.equals(stDate));
=======
		CalendarDate startDate = new CalendarDate(3, 1, 2016);
		assertTrue(stDate.equals(startDate));
		assertFalse(stDate.equals("3/1/2016"));
	}

	@Test
	public void testSetStDate() {
		fail("Not yet implemented");
>>>>>>> us-45
	}

	@Test
	public void testGetName() {
		String nameTest = "Adam";
<<<<<<< HEAD
		String nameTest1 = "Bond";
		assertTrue(name.equals(nameTest));
		assertFalse(name.equals(nameTest1));
	}
	
	@Test
	public void testSetName() {
		String nameTest2 = "!@!!!@()";
		Integer nameTest3 = 12159;
		Double nameTest4 = 123.4443;
		assertFalse(name.equals(nameTest2));
		assertFalse(name.equals(nameTest3));
		assertFalse(name.equals(nameTest4));
=======
		String nameTest1 = "Adam";
		assertTrue(name.equals(nameTest));
		assertFalse(name.equals(nameTest1));
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
>>>>>>> us-45
	}

	@Test
	public void testGetDescription() {
<<<<<<< HEAD
		String notDescription = "Finances";
		assertFalse(description.equals(notDescription));
		
		String description1 = "Finance tracker keeps track of finances";
		assertTrue(description.equals(description1));
=======
		fail("Not yet implemented");
>>>>>>> us-45
	}

	@Test
	public void testSetDescription() {
<<<<<<< HEAD
		String description1 = "Finance tracker keeps track of finances";
		String description2 = "Business";
		Double notDescription2 = 12345.500;
		assertFalse(description.equals(description2));
		assertFalse(description.equals(notDescription2));
		assertTrue(description.equals(description1));
=======
		fail("Not yet implemented");
>>>>>>> us-45
	}

	@Test
	public void testGetLastID() {
<<<<<<< HEAD
		int lastId_1 = 100020001;
		assertTrue(lastID == 100020001);
		
		double notLastID = 123.4445;
		assertFalse(lastID == notLastID);
=======
		fail("Not yet implemented");
>>>>>>> us-45
	}

	@Test
	public void testSetLastID() {
<<<<<<< HEAD
		int lastId_1 = 100020001;
		int notLastId_1 = 1234455;
		assertTrue(lastID == lastId_1);
		assertFalse(lastID == notLastId_1);
	}

	@Test
	public void testSaveString() throws FileNotFoundException, IOException {
		ObjectOutputStream fw_2 = new ObjectOutputStream(new FileOutputStream("dontSave.txt"));
		assertFalse(fw.equals(fw_2));
		
	}
=======
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

>>>>>>> us-45
}
