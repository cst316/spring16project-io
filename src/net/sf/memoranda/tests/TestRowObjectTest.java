package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.memoranda.psp.TestRowObject;

public class TestRowObjectTest {
	private String project;
	private Date date;
	private int defNumber;
	private String defType;
	private String injPhase;
	private String remPhase;
	private String fix;
	private String fixRef;
	private String program;
	private TestRowObject testRow;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		String project = "myProject";
		Date date = new Date();
		int defNumber = 12;
		String defType = "10";
		String injPhase = "Planning";
		String remPhase = "Design";
		String fix = "Testing";
		String fixRef = "1001";
		String program = "sample.java";
		testRow = new TestRowObject(project, date, defNumber, defType, injPhase
				, remPhase, fix, fixRef, program);
	}

	@After
	public void tearDown() throws Exception {
		String project = null;
		Date date = null;
		int defNumber = 0;
		String defType = "";
		String injPhase = "";
		String remPhase = "";
		String fix = "";
		String fixRef = "";
		String program = "";
	}

	@Test
	public void getProjectTest() {
		String correctProject = "myProject";
		String wrongProject = "notmyproject";
		assertTrue(testRow.getProject().equals(correctProject));
		assertFalse(testRow.getProject().equals(wrongProject));
	}
	
	@Test
	public void setProjectTest(){
		testRow.setProject("Works");
		String correctVal = "Works";
		assertTrue(testRow.getProject().equals(correctVal));
		
	}
	
	@Test
	public void getProgramTest() {
		String wrongVal = "Something.java";
		String correctVal = "sample.java";
		assertTrue(testRow.getProgram().equals(correctVal));
		assertFalse(testRow.getProgram().equals(wrongVal));
		
	}
	
	@Test
	public void setProgramTest() {
		String correctVal = "Bank.java";
		testRow.setProgram(correctVal);
		assertTrue(testRow.getProgram().equals(correctVal));
	}
	
	@Test
	public void getDateTest() {
		Date myDate = new Date();
		assertTrue(testRow.getDate().equals(myDate));
	}
	
	@Test
	public void getDefNumberTest() {
		int wrongVal = 110;
		int correctVal = 12;
		assertTrue(testRow.getDefNumber() == correctVal);
		assertFalse(testRow.getDefNumber() == wrongVal);
	}
	
	@Test
	public void setDefNumberTest() {
		int correctVal = 2;
		testRow.setDefNumber(correctVal);
		assertTrue(testRow.getDefNumber() == correctVal);
	}
	
	@Test
	public void getDefTypeTest() {
		String correctVal = "10";
		String wrongVal = "20";
		assertTrue(testRow.getDefType().equals(correctVal));
		assertFalse(testRow.getDefType().equals(wrongVal));
	
	}
	
	@Test
	public void setDefTypeTest() {
		String correctVal = "20"; 
		String wrongVal = "50";
		testRow.setDefType(correctVal);
		assertTrue(testRow.getDefType().equals(correctVal));
		assertFalse(testRow.getDefType().equals(wrongVal));
	}
	
	@Test
	public void getInjPhaseTest() {
		String correctVal = "Planning"; 
		String wrongVal = "Design";
		assertTrue(testRow.getInjPhase().equals(correctVal));
		assertFalse(testRow.getInjPhase().equals(wrongVal));
	}
	
	@Test
	public void setInjPhaseTest() {
		String correctVal = "Testing"; 
		String wrongVal = "Planning";
		testRow.setInjPhase(correctVal);
		assertTrue(testRow.getInjPhase().equals(correctVal));
		assertFalse(testRow.getInjPhase().equals(wrongVal));
	}
	
	@Test
	public void getRemPhaseTest() {
		String correctVal = "Design"; 
		String wrongVal = "Planning";
		assertTrue(testRow.getRemPhase().equals(correctVal));
		assertFalse(testRow.getRemPhase().equals(wrongVal));
	}
	
	@Test
	public void setRemPhaseTest() {
		String correctVal = "Planning"; 
		String wrongVal = "Testing";
		testRow.setRemPhase(correctVal);
		assertTrue(testRow.getRemPhase().equals(correctVal));
		assertFalse(testRow.getRemPhase().equals(wrongVal));
	}
	
	@Test
	public void getFixTest() {
		String correctVal = "Testing"; 
		String wrongVal = "Planning";
		assertTrue(testRow.getFix().equals(correctVal));
		assertFalse(testRow.getFix().equals(wrongVal));
		
	}
	
	@Test
	public void setFixTest() {
		String correctVal = "Coding"; 
		String wrongVal = "Design";
		testRow.setFix(correctVal);
		assertTrue(testRow.getFix().equals(correctVal));
		assertFalse(testRow.getFix().equals(wrongVal));
	}
	
	@Test
	public void getFixRefTest() {
		String correctVal = "1001";
		String wrongVal = "1002";
		assertTrue(testRow.getFixRef().equals(correctVal));
		assertFalse(testRow.getFixRef().equals(wrongVal));
	}
	
	@Test
	public void setFixRefTest() {
		String correctVal = "100334";
		String wrongVal = "100111111111";
		testRow.setFixRef(correctVal);
		assertTrue(testRow.getFixRef().equals(correctVal));
		assertFalse(testRow.getFixRef().equals(wrongVal));
	}

}
