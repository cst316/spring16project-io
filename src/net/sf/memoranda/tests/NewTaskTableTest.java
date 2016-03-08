package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.memoranda.ui.PSP_NewTaskDialog;
import net.sf.memoranda.ui.PSP_NewTaskDialogClose;
import net.sf.memoranda.ui.PSP_NewTaskTable;

public class NewTaskTableTest {
	
	PSP_NewTaskTable tabletest;
	PSP_NewTaskDialog newtasktest;
	PSP_NewTaskDialogClose closetasktest;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
		tabletest = new PSP_NewTaskTable();
		tabletest.setVisible(true);
		
		newtasktest = new PSP_NewTaskDialog();
		newtasktest.setVisible(false);
		
		closetasktest = new PSP_NewTaskDialogClose();
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
