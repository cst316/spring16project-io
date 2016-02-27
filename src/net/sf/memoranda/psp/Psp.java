package net.sf.memoranda.psp;

import java.io.FileOutputStream;

import net.sf.memoranda.date.CurrentDate;

public interface Psp {
	
	//Static integer value that is a unique project ID (pID) to every project
	static int pID = 100000001;

	//Abstract method to get the start date
	public CurrentDate getStDate();
	
	//Abstract method to set the start date
	public void setStDate(CurrentDate stDate);
	
	//Abstract method to get the name of the project
	public String getName();
	
	//Abstract method to set the name of the project
	public void setName(String name);
	
	//Abstract method to get the project description
	public String getDescription();
	
	//Abstract method to set the project description
	public void setDescription(String description);
	
	//Abstract method to save all the values entered into the Psp wizard
	public void save(FileOutputStream stream);
}
