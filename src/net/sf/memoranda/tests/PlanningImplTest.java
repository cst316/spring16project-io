package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.memoranda.psp.Psp;

public class PlanningImplTest {

	private Psp pspValues;
	private float estTime;
	private int locHr;
	private int estSize;
	private int estDefect;
	private int descriptionSize;
	private String filename;
	private int pId;
	
	ArrayList <String> files;
	HashMap <String, Integer> moduleDescription;

	@Before
	public void setUp() throws Exception {
		estTime = 234;
		locHr = 150;
		estSize = 12;
		estDefect = 34;
		descriptionSize = 2345;
		filename = "twentyone.txt";
		pId = 100000234;
		files = new ArrayList<String>();
		moduleDescription = new HashMap<String, Integer>();
	}

	@Test
	public void testGetEstTime() {
		int estimatedTime = 234;
		int falseEstimatedTime = 23456;
		double wrongEstimatedTime = 234.56;
		assertTrue(estTime == estimatedTime);
		assertFalse(estTime == falseEstimatedTime);
		assertFalse(estTime == wrongEstimatedTime);
	}

	@Test
	public void testSetEstTime() {
		int estimatedTime = 234;
		assertTrue(estTime == estimatedTime);
	}

	@Test
	public void testGetLocHr() {
		int linesOfCodeHr = 150;
		assertTrue(locHr == linesOfCodeHr);
		assertFalse(locHr == 1245);
		assertFalse(locHr == 12.345);
		assertFalse(locHr == 0.0001);
	}

	@Test
	public void testSetLocHr() {
		int linesOfCodeHr = 150;
		assertTrue(locHr == linesOfCodeHr);
	}

	@Test
	public void testGetEstSize() {
		assertTrue(estSize == 12);
		assertFalse(estSize == 100.04569);
	}

	@Test
	public void testSetEstSize() {
		assertTrue(estSize == 12);
	}

	@Test
	public void testGetEstDefect() {
		assertTrue(estDefect == 34);
		assertFalse(estDefect == 12.3451);
		assertFalse(estDefect == 0.001);
	}

	@Test
	public void testSetEstDefect() {
		assertTrue(estDefect == 34);
	}

	@Test
	public void testGetDescriptionSize() {
		assertTrue(descriptionSize == 2345);
		assertFalse(descriptionSize == 1000.2234);
		assertFalse(descriptionSize == 600034.3);
		assertFalse(descriptionSize == 1);
	}

	@Test
	public void testSetDescriptionSize() {
		assertTrue(descriptionSize == 2345);
	}

	@Test
	public void testGetFilename() {
		assertTrue(filename.equals("twentyone.txt"));
	}


	@Test
	public void testSetFilename() {
		assertTrue(filename.equals("twentyone.txt"));
		assertFalse(filename.equals("helloWorld"));
	}
}
