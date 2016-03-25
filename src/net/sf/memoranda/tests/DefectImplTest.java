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

public class DefectImplTest {
	String path;
	File file;
	Defect def;
	Date date = new Date(1/1/2001);
	String desc = "desc", filename = "filename", fxDet = "fxDet", 
			injPoint = "injPoint",name = "name", 
			remPhase = "remPhase", type = "type";
	int pID = 123, defNum = 1234;
	
	@Before
	public void setUp() throws Exception {
		def = new DefectImpl();
		path =  System.getProperty("user.home") + File.separator + 
				".memoranda" + File.separator + ".proj" + File.separator + 
				 "." + "test";
		
		file = new File(path);
		file.mkdirs();
		
	}
	
	@Test
	public void testSaveTestData() {
		//assertTrue(def.saveTestData(path, "defectTest"));
	}
	
	@Test
	public void testLoadTestData() {
		//assertTrue(def.loadTestData(path, "defectTest"));
	}

	@Test
	public void testGetters() {
		
		assertEquals(def.getDate(),new Date(1/1/2001));
		assertEquals(def.getDefectNum(),1234);
		assertEquals(def.getDescription(), "desc");
		assertEquals(def.getFileName(), "filename");
		assertEquals(def.getFixDetails(), "fxDet");
		assertEquals(def.getInjectionPhase(), "injPoint");
		assertEquals(def.getName(), "name");
		assertEquals(def.getpId(), 123);
		assertEquals(def.getRemovalPhase(), "remPhase");
		assertEquals(def.getType(), "type");
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		//delete .test folder
	}

	
	

}
