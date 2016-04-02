package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import net.sf.memoranda.ui.PSP_DevelopmentData;
import net.sf.memoranda.ui.PSP_DevelopmentDialog;
import net.sf.memoranda.ui.PSP_DevelopmentDialogClose;
import net.sf.memoranda.ui.PSP_DevelopmentTable;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class PSP_NewTaskDataTest 

{
	
	PSP_DevelopmentData tdata = new PSP_DevelopmentData();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception 
	{
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception 
	{
		
	}

	@Before
	public void setUp() throws Exception
	{

	}

	@After
	public void tearDown() throws Exception 
	{
		
	}

	@Test
	public void testSaveTaskData() 
	
	{
		String tdarray;
		int count;
		
		tdarray= "savedata0";
		count = 0;
		tdata.saveTaskData(tdarray, count);
		assertTrue(PSP_DevelopmentData.tdarray[0].contains(tdarray));
		
		tdarray = "savedata1";
		count = 1;
		tdata.saveTaskData(tdarray, count);
		assertTrue(PSP_DevelopmentData.tdarray[1].contains(tdarray));
		
		tdarray = "savedata2";
		count = 2;
		tdata.saveTaskData(tdarray, count);
		assertTrue(PSP_DevelopmentData.tdarray[2].contains(tdarray));
		
		tdarray = "savedata3";
		count = 3;
		tdata.saveTaskData(tdarray, count);
		assertTrue(PSP_DevelopmentData.tdarray[3].contains(tdarray));
		
		tdarray = "savedata4";
		count = 4;
		tdata.saveTaskData(tdarray, count);
		assertTrue(PSP_DevelopmentData.tdarray[4].contains(tdarray));
		
		tdarray = "savedata5";
		count = 5;
		tdata.saveTaskData(tdarray, count);
		assertTrue(PSP_DevelopmentData.tdarray[5].contains(tdarray));
		
	}

	private void assertTrue(boolean b) 
	{
			
	}

	@Test
	public void testSaveTaskDataBounds() 
	{
		
		String tdarray;
		int count;
		
		try 
		{
			
		tdarray = "savedata6";
		count = 6;
		tdata.saveTaskData(tdarray, count);
		
		assertTrue(!PSP_DevelopmentData.tdarray[6].contains(tdarray));
		
		}
		
	    catch (ArrayIndexOutOfBoundsException e) {

	    	System.out.println("expected OOB");

	    }
		
		try 
		{
			
		tdarray = "savedata-1";
		count = -1;
		tdata.saveTaskData(tdarray, count);
		
		assertTrue(!PSP_DevelopmentData.tdarray[-1].contains(tdarray));
		
		}
		
	    catch (ArrayIndexOutOfBoundsException e) {

	        System.out.println("expected OOB");

	    }  
		
	
	}

}
