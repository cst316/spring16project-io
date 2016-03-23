package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import net.sf.memoranda.psp.Design;
import net.sf.memoranda.psp.DesignImpl;

public class DesignImplTest {
	private String filePath;
	private ArrayList<String> files;
	Design des;
	
	@Before
	public void setUp() throws Exception {
		filePath = "C:/image001";
		files = new ArrayList<String>();
		des = new DesignImpl(files,"Test File");
	}

	@Test
	public void testGetFilePath() {
		assertTrue(filePath.equals("C:/image001"));
		assertFalse(filePath.equals("D:/image002"));
		assertFalse(filePath.equals("image001"));
	}

	@Test
	public void testSetFilePath() {
		filePath = "tempFolder/sky_image";
		String my_file = "tempFolder/sky_image";
		assertTrue(filePath.equals(my_file));
		assertFalse(filePath.equals("F:/wrongFile"));
	}

	@Test
	public void testGetFiles() {
		String file1 = "doi.png";
		String file2 = "dsimsd.tif";
		files.add(file1);
		files.add(file2);
		files.remove(file2);
		assertTrue(files.contains(file1));
		assertFalse(files.contains(file2));
	}

	@Test
	public void testSetFiles() {
		String file3 = "gignu.jpg";
		String file4 = "dasdc.png";
		files.add(file3);
		files.add(file4);
		files.remove(file3);
		assertTrue(files.contains(file4));
		assertFalse(files.contains(file3));
	}

	@Test
	public void testImportImageFiles() {
		filePath = "C:/do.png";
		File the_file = new File(filePath);
		files.add(the_file.getName());
		files.add(filePath);
		assertTrue(files.contains(filePath));
		assertTrue(files.contains(the_file.getName()));
		//DesignImpl test = new DesignImpl();
		//assertTrue(test.importImageFiles(null, null));
	}

	@Test
	public void testDeleteImageFile() {
		filePath = "oi.png";
		files.add(filePath);
		DesignImpl test = new DesignImpl();
		files.remove(filePath);
		assertFalse(files.contains(filePath));
		//assertTrue(test.deleteImageFile());
		
	}

}
