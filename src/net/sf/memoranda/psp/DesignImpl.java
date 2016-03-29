package net.sf.memoranda.psp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import net.sf.memoranda.date.CurrentDate;

public class DesignImpl implements Design, Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -121825052540382970L;
	private String filePath;
	protected ArrayList<String> files;
	private Psp pspValues;
	
	private BufferedImage myImage; 
	
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
	
	public void fileAdd(String the_filePath)
	{
		files.add(the_filePath);
	}
	
	//Models Joe Michaels' code for PSP_DesignPanel.java for btnImport_Clicked() method
	@Override
	public boolean importImageFiles(File theFileToUse, String thePathOfFile, BufferedImage imageToUse) {
		boolean testVar = true;
		this.myImage = imageToUse;
		try{
				theFileToUse = new File(thePathOfFile);
			
			
			if (theFileToUse.getName().contains(".png"))
			{
				ImageIO.write(myImage, "png", new File(thePathOfFile + File.separator + theFileToUse.getName()));
			}
			else if (theFileToUse.getName().contains(".jpg"))
			{
				ImageIO.write(myImage, "jpg", new File(thePathOfFile + File.separator + theFileToUse.getName())); 
			}else if (theFileToUse.getName().contains(".img"))
			{
				ImageIO.write(myImage, "img", new File(thePathOfFile + File.separator + theFileToUse.getName()));
			} else if (theFileToUse.getName().contains(".tif"))
			{
				ImageIO.write(myImage, "tif", new File(thePathOfFile + File.separator + theFileToUse.getName())); 
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

	@Override
	public void setPspValues(Psp pspValues) {
		// TODO Auto-generated method stub
		this.pspValues = pspValues;
	}

	@Override
	public Psp getPspValues() {
		// TODO Auto-generated method stub
		return this.pspValues;
	}

}
