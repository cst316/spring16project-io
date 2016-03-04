<<<<<<< HEAD
/**
 * @author Julie
 * Tests the class ProjectSummaryCreator
 */
package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import net.sf.memoranda.psp.ProjectSummaryCreator;


public class ProjectSummaryCreatorTest {
	private String author;
	private String programName;
	private String date;
	private double[] estimatedTime;
	private double[] actualTime;
	private int[] estimatedDefects;
	private int[] actualDefects;
	private double[] estimatedTotal; 
	private double[] actualTotal;
	/**
	 * @throws java.lang.Exception
	 * Creates a test PDF
	 */
	@Before
	public void setUp() throws Exception {
		author = "Bob Smith";
		programName = "Test Program";
		date = "Febuary 29 2016";
		estimatedTime = new double[] {5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 35.0};
		actualTime = new double[] {5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 35.0};
		estimatedDefects = new int[] {1, 1, 1, 1, 1, 1, 1, 7};
		actualDefects = new int[] {1, 1, 1, 1, 1, 1, 1, 7};
		estimatedTotal = new double[] {50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 350.0};
		actualTotal = new double[] {50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 350.0};
	}

	/**
	 * Test method for {@link net.sf.memoranda.psp.ProjectSummaryCreator#createFileSummary(java.lang.String, java.lang.String, java.lang.String, double[], double[], int[], double[], double[])}.
	 */
	@Test
	public void testCreateFileSummary() {
		ProjectSummaryCreator.createFileSummary(author, programName, date, estimatedTime, actualTime, estimatedDefects, actualDefects, estimatedTotal, actualTotal);
	}

}
=======
/**
 * @author Julie
 * Tests the class ProjectSummaryCreator
 */
package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import net.sf.memoranda.psp.ProjectSummaryCreator;


public class ProjectSummaryCreatorTest {
	private String author;
	private String programName;
	private String date;
	private double[] estimatedTime;
	private double[] actualTime;
	private int[] estimatedDefects;
	private int[] actualDefects;
	private double[] estimatedTotal; 
	private double[] actualTotal;
	/**
	 * @throws java.lang.Exception
	 * Creates a test PDF
	 */
	@Before
	public void setUp() throws Exception {
		author = "Bob Smith";
		programName = "Test Program";
		date = "Febuary 29 2016";
		estimatedTime = new double[] {5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 35.0};
		actualTime = new double[] {5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 35.0};
		estimatedDefects = new int[] {1, 1, 1, 1, 1, 1, 1, 7};
		actualDefects = new int[] {1, 1, 1, 1, 1, 1, 1, 7};
		estimatedTotal = new double[] {50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 350.0};
		actualTotal = new double[] {50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 50.0, 350.0};
	}

	/**
	 * Test method for {@link net.sf.memoranda.psp.ProjectSummaryCreator#createFileSummary(java.lang.String, java.lang.String, java.lang.String, double[], double[], int[], double[], double[])}.
	 */
	@Test
	public void testCreateFileSummary() {
		ProjectSummaryCreator.createFileSummary(author, programName, date, estimatedTime, actualTime, estimatedDefects, actualDefects, estimatedTotal, actualTotal);
	}

}
>>>>>>> us-45
