package net.sf.memoranda.psp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import net.sf.memoranda.util.Util;

/**
 * Implementation of PSP class
 * @author Josh
 * edited by Cephas
 *
 */
public class PspImpl implements Psp, Serializable {	

	private static final long serialVersionUID = 4409606508885247769L;
	private int pID;
	private String name;
	private String description;		
	private Date stDate;
		
	public static int lastID = Psp.pID;
	
	public PspImpl () {
		super();
		stDate = null;
		name = "";
		description = "";
	}
	
	public PspImpl(Date stDate, String name, String description) {
		super();
		pID = lastID;
		this.stDate = stDate;
		this.name = name;
		this.description = description;
	}
	
	public PspImpl(String name, String description, int id) {
		super();
		this.pID = id;
		this.name = name;
		this.description = description;
		this.stDate = new Date ();
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
	public Date getStDate() {
		return stDate;
	}
	
	//Mutator method that sets the start date (stDate) given a parameter
	public void setStDate(Date startDate) {
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
	
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		Util.debug("Psp retrieved");
	}
	
	private void writeObject(ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
		Util.debug("Psp wrtten");
	}	
	
	public String toString() {
		return "PSP Project Information:\n"
				+ "Project ID = " + getpId() + ", Project Start Date = " + this.getStDate() 
				+ ", Project Name=" + this.getName() + ", Project Description=" + this.getDescription();
	}
}
