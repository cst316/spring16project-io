package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.memoranda.ui.NewTaskDialog;
import net.sf.memoranda.ui.NewTaskDialogClose;
import net.sf.memoranda.ui.NewTaskTable;

public class NewTaskTableTest {
	
	NewTaskTable tabletest;
	NewTaskDialog newtasktest;
	NewTaskDialogClose closetasktest;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		tabletest = new NewTaskTable();
		tabletest.setVisible(true);
		
		newtasktest = new NewTaskDialog();
		newtasktest.setVisible(false);
		
		closetasktest = new NewTaskDialogClose();
		closetasktest.setVisible(true);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testtable() {
				
		assertTrue(tabletest.isShowing());

		
		
	}
	
	@Test
	public void testnewtask() {
				

		assertTrue(!newtasktest.isShowing());

		
		
	}
	
	@Test
	public void testclosetask() {
				

		assertTrue(closetasktest.isShowing());
		
		
	}
}
