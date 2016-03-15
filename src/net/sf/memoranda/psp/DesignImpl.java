package net.sf.memoranda.psp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import net.sf.memoranda.date.CurrentDate;

public class DesignImpl implements Design {
	

	private String filePath;
	protected ArrayList<String> files;
	private Psp pspValues;
	private BufferedImage myImage;
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
		myImage = null;
	}
	
	public DesignImpl(ArrayList<String> theFiles, String nameOfFile)
	{
		filePath = nameOfFile;
		files = theFiles;
	}
	
	public DesignImpl(ArrayList<String> theFiles, String nameOfFile, Psp thePspValues,
			BufferedImage theImage, File theFile)
	{
		filePath = nameOfFile;
		files = theFiles;
		pspValues = thePspValues;
		myImage = theImage;
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

	@Override
	public void save(FileOutputStream stream) {
		pspValues.save(stream);
	}

	@Override
	public void open(FileInputStream streamOfFile) {
		pspValues.open(streamOfFile);
	}
	
	//Models Joe Michael's code for PSP_DesignPanel.java for btnImport_Clicked() method
	@Override
	public boolean importImageFiles(File theFileToUse, String thePathOfFile) {
		try{
			myImage = ImageIO.read(theFileToUse);
			
			if(!Files.exists(Paths.get(thePathOfFile)))
			{
				theFileToUse = new File(thePathOfFile);
			}
			
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
		}
		
		return true;
	}
}
