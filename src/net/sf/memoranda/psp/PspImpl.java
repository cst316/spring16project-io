package net.sf.memoranda.psp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import net.sf.memoranda.date.CurrentDate;
import net.sf.memoranda.ui.ExceptionDialog;

public class PspImpl implements Psp {
	
	private int pID;
	private CurrentDate stDate;
	private String name;
	private String description;
	
	public static int lastID = Psp.pID;
	
	//PspImpl constructor where values are initialized to empty values
	public PspImpl () {
		super();
		stDate = null;
		name = "";
		description = "";
	}
	
	//PspImpl that accepts parameters for all attributes except pID since pID can be accessed through Psp
	public PspImpl(CurrentDate stDate, String name, String description) {
		super();
		pID = lastID;
		this.stDate = stDate;
		this.name = name;
		this.description = description;
	}
	
	//PspImpl that accepts the project name and project description parameters
	public PspImpl(String name, String description, int id) {
		super();
		this.pID = id;
		this.name = name;
		this.description = description;
		this.stDate = new CurrentDate ();
	}
		
	//Accessor method that returns the project ID using the Psp interface
	public int getpId() {
		return pID;
	}
	
	//Mutator method that should set the project ID from a file, but returns an integer temporarily
	public void setpId (int pID) {
		//Will change to accept a static file as a parameter 2/17/2016 - Josh K.
		this.pID = pID;
	}
	
	//Accessor method that returns the start date (stDate)
	public CurrentDate getStDate() {
		return stDate;
	}
	
	//Mutator method that sets the start date (stDate) given a parameter
	public void setStDate(CurrentDate startDate) {
		stDate = startDate;
	}
	
	//Accessor method that gets the name
	public String getName() {
		return name;
	}
	
	//Mutator method sets the name given a parameter
	public void setName(String projectName) {
		name = projectName;
	}
	
	//Accessor method that gets the description 
	public String getDescription() {
		return description;
	}
	
	//Mutator method that sets the description given a String value
	public void setDescription(String theDescription) {
		description = theDescription;
	}
	
	//Accessor method that gets the last ID
	public static int getLastID() {
		return lastID;
	}
	
	//Mutator method that sets the last ID
	public static void setLastID(int lastID) {
		PspImpl.lastID = lastID;
	}
	
	//Takes the FileInputStream as a parameter and reads the attributes of the PlanningImpl class to the file 
	public void open (FileInputStream streamOfFile)
	{
		try {
        	ObjectInputStream ois = new ObjectInputStream(streamOfFile);        
        	this.pID = ois.readInt();
        	this.name = ois.readUTF();
            this.description = ois.readUTF(); 
            ois.close();
        } catch (IOException ioException) {
            new ExceptionDialog(ioException, "File not found!" , "");
        } 
	}
	
	//Models the saveDocument() method in FileStorage.java (.util package)
	//Takes the file stream as a parameter and object, and writes it to a file stream
	public void save(FileOutputStream streamOfFile)
	{
		try {
            ObjectOutputStream fw = new ObjectOutputStream(streamOfFile);
            fw.writeInt(this.pID);
            fw.writeUTF (this.getName());
            fw.writeUTF (this.getDescription());
            fw.flush();
            fw.close();    
        }
        catch (IOException ioException) {
            new ExceptionDialog(
                ioException,
                "Saving the Project ID, Project Name, and Project Description for use in XML file has failed", "");
        }
	}
	
	//toString method that returns all of PspImpl's attributes
	@Override
	public String toString() {
		return "PSP Project Information:\n"
				+ "Project ID = " + getpId() + ", Project Start Date = " + this.getStDate() 
				+ ", Project Name=" + this.getName() + ", Project Description=" + this.getDescription();
	}
}
