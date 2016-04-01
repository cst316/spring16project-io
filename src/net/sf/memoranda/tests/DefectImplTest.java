package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import net.sf.memoranda.psp.Defect;
import net.sf.memoranda.psp.DefectImpl;
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
			remPhase = "remPhase", type = "type", defectType = "1",
			program = "program.java";
	int pID = 123, defNum = 1234;
	
	@Before
	public void setUp() throws Exception {
		
		array = new ArrayList<TestRowObject>();
		tro = new TestRowObject(name, date, defNum, defectType,
				injPoint, remPhase, fix, fixRef, program);
		array.add(tro);
		def = new DefectImpl(array);
		
		path =  System.getProperty("user.home") + File.separator + 
				".memoranda" + File.separator + ".proj" + File.separator + 
				 "." + "test";
		
		file = new File(path);
		file.mkdirs();
	}
	
	@Test
	public void testInit(){
	    assertEquals(def.getIsDirty(), false);
        assertNotNull(tro);
        assertNotNull(def);
	}
	

	/*@Test
	public void testSetArr(){
		assertEquals(def.setRowObject(array), false);
		assertEquals(def.getRowObject(), array);
		assertEquals(def.addRow(tro),true);
		assertEquals(def.removeRow(0), true);
		assertEquals(def.getIsDirty(), true);
	}*/
	
	@Test
	public void testEnd(){
	    def = new DefectImpl(array);
	    assertEquals(def.getIsDirty(), false);
	}
}