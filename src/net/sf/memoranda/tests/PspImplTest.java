package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.date.CurrentDate;
import net.sf.memoranda.psp.Psp;

public class PspImplTest {
	
	private int pID;
	private CurrentDate stDate;
	private String name;
	private String description;
	static int lastID;
	private ObjectOutputStream fw;

	@Before
	public void setUp() throws Exception {
		pID = 100020004;
		stDate = new CurrentDate();
		name = "Adam";
		description = "Finance tracker keeps track of finances";
		lastID = 100020001;
		fw = new ObjectOutputStream(new FileOutputStream("save.txt"));
		
	}

	@Test
	public void testPspImplCurrentDateStringString() {
		CalendarDate todaysDate = new CalendarDate(10, 12, 2016);
		CalendarDate tommorowsDate = new CalendarDate(3, 2, 2016);
		String wrongInput = "Got you";
		assertFalse(stDate.equals(todaysDate));
		assertFalse(stDate.equals(tommorowsDate));
		assertFalse(stDate.equals(wrongInput));
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
		CalendarDate startDate = new CalendarDate(12, 3, 2016);
		assertTrue(stDate.equals(stDate));
		assertFalse(stDate.equals(startDate));
		assertFalse(stDate.equals("3/1/2016"));
	}
	
	@Test
	public void testSetStDate() {
		assertTrue(stDate.equals(stDate));
	}

	@Test
	public void testGetName() {
		String nameTest = "Adam";
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
	}

	@Test
	public void testGetDescription() {
		String notDescription = "Finances";
		assertFalse(description.equals(notDescription));
		
		String description1 = "Finance tracker keeps track of finances";
		assertTrue(description.equals(description1));
	}

	@Test
	public void testSetDescription() {
		String description1 = "Finance tracker keeps track of finances";
		String description2 = "Business";
		Double notDescription2 = 12345.500;
		assertFalse(description.equals(description2));
		assertFalse(description.equals(notDescription2));
		assertTrue(description.equals(description1));
	}

	@Test
	public void testGetLastID() {
		int lastId_1 = 100020001;
		assertTrue(lastID == 100020001);
		
		double notLastID = 123.4445;
		assertFalse(lastID == notLastID);
	}

	@Test
	public void testSetLastID() {
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
}
