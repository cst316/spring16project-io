package net.sf.memoranda.psp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public interface Design {
	
	public String getFileName();

	public boolean setFileName(String theFileName);

	public ArrayList<String> getFiles();

	public boolean setFiles(ArrayList<String> theFiles);
	
	public boolean importImageFiles(File theFile, String theFilePath,  BufferedImage imageToUse);
	
	public void fileAdd(String filePath);
	
	public void setPspValues (Psp pspValues);
	
	public Psp getPspValues ();
}