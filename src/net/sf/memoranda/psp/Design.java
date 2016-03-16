package net.sf.memoranda.psp;

import java.io.File;
import java.util.ArrayList;

public interface Design extends Psp {
	
	static final long serialVersionUID = 1L;

	public String getFileName();

	public boolean setFileName(String theFileName);

	public ArrayList<String> getFiles();

	public boolean setFiles(ArrayList<String> theFiles);
	
	public boolean importImageFiles(File theFile, String theFilePath);
	
}