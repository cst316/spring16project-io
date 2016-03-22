package net.sf.memoranda.psp;

import java.io.File;
import java.util.ArrayList;
import net.sf.memoranda.date.CurrentDate;

public class DesignImpl implements Design {
	

	private String filePath;
	protected ArrayList<String> files;
	private Psp pspValues;
	private CurrentDate pspStartDate;
	private int pID;
	private String projectName;
	private String projectDescription;
	
	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public DesignImpl()
	{
		filePath = "";
		files = null;
		pspValues = null;
	}
	
	public DesignImpl(ArrayList<String> theFiles, String nameOfFile)
	{
		filePath = nameOfFile;
		files = theFiles;
	}

	public String getFileName() {
		return filePath;
	}

	public boolean setFileName(String theFileName) {
		this.filePath = theFileName;
		return true;
	}

	public ArrayList<String> getFiles() {
		return files;
	}

	public boolean setFiles(ArrayList<String> theFiles) {
		this.files = theFiles;
		return true;
	}

	@Override
	public CurrentDate getStDate() {
		return pspValues.getStDate();
	}

	@Override
	public void setStDate(CurrentDate stDate) {
		pspStartDate = pspValues.getStDate();
		pspStartDate = stDate;
	}

	@Override
	public void setpId(int id) {
		pID = pspValues.getpId();
		pID = id;
	}

	@Override
	public int getpId() {
		return pspValues.getpId();
	}

	@Override
	public String getName() {
		return pspValues.getName();
	}

	@Override
	public void setName(String name) {
		projectName = pspValues.getName();
		projectName = name;
	}

	@Override
	public String getDescription() {
		return pspValues.getDescription();
	}

	@Override
	public void setDescription(String description) {
		projectDescription = pspValues.getDescription();
		projectDescription = description;
	}
	
	//Models Joe Michaels' code for PSP_DesignPanel.java for btnImport_Clicked() method
	@Override
	public boolean importImageFiles(File theFileToUse, String thePathOfFile) {
		boolean testVar = true;
		try{
				theFileToUse = new File(thePathOfFile);
			
			
			if (theFileToUse.getName().contains(".png"))
			{
				files.add(thePathOfFile);
			}
			else if (theFileToUse.getName().contains(".jpg"))
			{
				files.add(thePathOfFile);
			}else if (theFileToUse.getName().contains(".img"))
			{
				files.add(thePathOfFile);
			} else if (theFileToUse.getName().contains(".tif"))
			{
				files.add(thePathOfFile);
			} else
			{
				System.out.println("Invalid file format!");
			}
			
			files.add(thePathOfFile + File.separator + theFileToUse.getName());
		}
		catch(Exception e)
		{
			e.getStackTrace();
			System.out.println("Invalid file.");
			testVar = false; // want to flag in a test if an error is thrown.
		}
		
		return testVar;
	}
	
	public boolean deleteImageFile()
	{
		files.remove(files.size()-1);
		return true;
	}

}
