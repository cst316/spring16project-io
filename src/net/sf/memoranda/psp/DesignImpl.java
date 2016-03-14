package net.sf.memoranda.psp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import net.sf.memoranda.date.CurrentDate;

public class DesignImpl implements Design {
	
	private String fileName;
	protected ArrayList<String> files;
	
	public DesignImpl()
	{
		fileName = "";
	}
	
	public DesignImpl(ArrayList<String> theFiles, String nameOfFile)
	{
		fileName = nameOfFile;
		files = theFiles;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String theFileName) {
		this.fileName = theFileName;
	}

	public ArrayList<String> getFiles() {
		return files;
	}

	public void setFiles(ArrayList<String> theFiles) {
		this.files = theFiles;
	}
}
