package net.sf.memoranda.psp;

import net.sf.memoranda.date.CurrentDate;

public class PspImpl implements Psp {
	
	private int pID;
	private CurrentDate stDate;
	private String name;
	private String description;
	static int lastID = 100020001;
	
	//PspImpl constructor where values are initialized to empty values
	public PspImpl() {
		stDate = null;
		name = "";
		description = "";
	}
	
	//PspImpl that accepts parameters for all attributes except pID since pID can be accessed through Psp
	public PspImpl(CurrentDate stDate, String name, String description) {
		super();
		pID = Psp.pID;
		this.stDate = stDate;
		this.name = name;
		this.description = description;
	}
	
	//Accessor method that returns the project ID using the Psp interface
	public static int getpID() {
		return Psp.pID;
	}
	
	//Mutator method that should set the project ID from a file, but returns an integer temporarily
	public static void setpID(int pID) {
		//Will change to accept a static file as a parameter 2/17/2016 - Josh K.
		int theProjectID = Psp.pID;
		theProjectID = pID;
	}
	
	//Accessor method that returns the start date (stDate)
	public CurrentDate getStDate() {
		return stDate;
	}
	
	//Mutator method that sets the start date (stDate) given a parameter
	public void setStDate(CurrentDate stDate) {
		this.stDate = stDate;
	}
	
	//Accessor method that gets the name
	public String getName() {
		return name;
	}
	
	//Mutator method sets the name given a parameter
	public void setName(String name) {
		this.name = name;
	}
	
	//Accessor method that gets the description 
	public String getDescription() {
		return description;
	}
	
	//Mutator method that sets the description given a String value
	public void setDescription(String description) {
		this.description = description;
	}
	
	//Accessor method that gets the last ID
	public static int getLastID() {
		return lastID;
	}
	
	//Mutator method that sets the last ID
	public static void setLastID(int lastID) {
		PspImpl.lastID = lastID;
	}
	
	//toString method that returns all of PspImpl's attributes
	@Override
	public String toString() {
		return "PSP Project Information:\n"
				+ "Project ID = " + PspImpl.getpID() + ", Project Start Date = " + this.getStDate() 
				+ ", Project Name=" + this.getName() + ", Project Description=" + this.getDescription();
	}

}
