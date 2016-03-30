package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import net.sf.memoranda.psp.Defect;
import net.sf.memoranda.psp.DefectImpl;
import net.sf.memoranda.psp.Design;
import net.sf.memoranda.psp.DesignImpl;
import net.sf.memoranda.psp.TestRowObject;

public class DefectImplTest {
	String path;
	File file;
	Defect def;
	TestRowObject tro;
	ArrayList<TestRowObject> array;
	Date date = new Date(1/1/2001);
	String desc = "desc", filename = "filename", fix = "fix", 
			injPoint = "injPoint",name = "name", fixRef = "fixRef",
			remPhase = "remPhase", type = "type", defectType = "1";
	int pID = 123, defNum = 1234;
	
	@Before
	public void setUp() throws Exception {
		
		array = new ArrayList<TestRowObject>();
		tro = new TestRowObject(name, date, defNum, defectType,
				injPoint, remPhase, fix, fixRef);
		array.add(tro);
		def = new DefectImpl(array);
		
		path =  System.getProperty("user.home") + File.separator + 
				".memoranda" + File.separator + ".proj" + File.separator + 
				 "." + "test";
		
		file = new File(path);
		file.mkdirs();
	}
	

	@Test
	public void testSetArr(){
	    assertEquals(def.getIsDirty(), false);
		assertNotNull(tro);
		assertNotNull(def);
		assertEquals(def.setRowObject(array), true);
		assertEquals(def.getRowObject(), array);
		assertEquals(def.addRow(tro),true);
		assertEquals(def.removeRow(0), true);
		assertEquals(def.getIsDirty(), true);
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//delete .test folder
	}

	
	

}
