package net.sf.memoranda.psp;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import net.sf.memoranda.date.CurrentDate;
import net.sf.memoranda.util.Util;

/**
 * Controller for PSP_Design class.
 * @author Josh Kappamamoottil
 */
public class DesignImpl implements Design, Serializable {

	private static final long serialVersionUID = -121825052540382970L;
	private String filePath;
	private ArrayList<String> files;
	private Psp pspValues;	
	private BufferedImage myImage; 
	
	public DesignImpl(ArrayList<String> theFiles, String nameOfFile){
		filePath = nameOfFile;
		files = theFiles;
	}
	
	public DesignImpl(){
		filePath = "";
		files = null;
		pspValues = null;
	}
	
	@Override
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
		
	@Override
	public String getFilePath() {
		return filePath;
	}

	@Override
	public String getFileName() {
		return filePath;
	}

	@Override
	public boolean setFileName(String theFileName) {
		this.filePath = theFileName;
		return true;
	}

	@Override
	public ArrayList<String> getFiles() {
		return files;
	}

	@Override
	public boolean setFiles(ArrayList<String> theFiles) {
		this.files = theFiles;
		return true;
	}
	
	@Override
	public void fileAdd(String the_filePath){
		files.add(the_filePath);
	}
	
	//Models Joe Michaels' code for PSP_DesignPanel.java for btnImport_Clicked() method
	/**
	 * Imports file directly into given directory path
	 * @param theFileToUse file thats being imported
	 * @param thePathOfFile absolute pathway for storing the file
	 * @param imageToUse image object of file
	 * @return temp boolean value indicates success of procedure
	 */
	@Override
	public boolean importImageFiles(File theFileToUse, String thePathOfFile, BufferedImage imageToUse) {
		boolean temp = true;
		this.myImage = imageToUse;
		try{
				theFileToUse = new File(thePathOfFile);
			
			if (theFileToUse.getName().contains(".png")){
				ImageIO.write(myImage, "png", new File(thePathOfFile + File.separator + theFileToUse.getName()));
			}else if (theFileToUse.getName().contains(".jpg")){
				ImageIO.write(myImage, "jpg", new File(thePathOfFile + File.separator + theFileToUse.getName())); 
			}else if (theFileToUse.getName().contains(".img")){
				ImageIO.write(myImage, "img", new File(thePathOfFile + File.separator + theFileToUse.getName()));
			}else if (theFileToUse.getName().contains(".tif")){
				ImageIO.write(myImage, "tif", new File(thePathOfFile + File.separator + theFileToUse.getName())); 
			}else{
				System.out.println("Invalid file format!");
			}
			
			files.add(thePathOfFile + File.separator + theFileToUse.getName());
		}catch(FileNotFoundException fnf){
		    fnf.getMessage();
		    Util.debug(theFileToUse.getName() + " not found in " + thePathOfFile);
		    temp = false;
		}catch(Exception e){
			e.getStackTrace();
			System.out.println("Invalid file.");
			temp = false; // want to flag in a test if an error is thrown.
		}
		
		return temp;
	}
	
	/**
	 * 
	 * @return temp status value of success of the deletion of the file
	 * @throws NullPointerException method may throw null pointer exception
	 * if file size is 0 or null 
	 * @throws Exception catch any left over exception that could possibly occur
	 */
	public boolean deleteImageFile(){
		
	    boolean temp = true;
	    try{
	        files.remove(files.size()-1);
	    }catch(NullPointerException npe){
	        npe.getMessage();
	        Util.debug("Null pointer returned, check files list size");
	        temp = false;
	    }catch(Exception e){
	        e.getMessage();
	        temp = false;
	    }
		return temp;
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
