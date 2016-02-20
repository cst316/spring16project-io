package net.sf.memoranda.psp;

import net.sf.memoranda.date.CurrentDate;

public class PspImpl implements Psp {
	
	private int pID;
	private CurrentDate stDate;
	private String name;
	private String description;
	static int lastID = 100020001;
	
	public PspImpl() {
		stDate = null;
		name = "";
		description = "";
	}
	public PspImpl(CurrentDate stDate, String name, String description) {
		super();
		pID = Psp.pID;
		this.stDate = stDate;
		this.name = name;
		this.description = description;
	}
	
	public static int getpID() {
		return Psp.pID;
	}
	public static void setpID(int pID) {
		//Will change to accept a static file as a parameter 2/17/2016 - Josh K.
		int theProjectID = Psp.pID;
		theProjectID = pID;
	}
	public CurrentDate getStDate() {
		return stDate;
	}
	public void setStDate(CurrentDate stDate) {
		this.stDate = stDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public static int getLastID() {
		return lastID;
	}
	public static void setLastID(int lastID) {
		PspImpl.lastID = lastID;
	}
	@Override
	public String toString() {
		return "PSP Project Information:\n"
				+ "Project ID = " + PspImpl.getpID() + ", Project Start Date = " + this.getStDate() 
				+ ", Project Name=" + this.getName() + ", Project Description=" + this.getDescription();
	}
}
