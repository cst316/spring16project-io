package net.sf.memoranda.psp;

import java.util.Date;
/**
 * Interface for psp related classes
 * @author Cephas
 *
 */
public interface Psp {
	
	//Static integer value that is a unique project ID (pID) to every project
	final static int pID = 100000001;
	
	//Abstract method to get the start date
	public Date getStDate();
	
	//Abstract method to set the start date
	public void setStDate(Date stDate);
	
	//Abstract method to set the id for the project
	public void setpId (int id);
	
	//Abstract method to get the id for the project
	public int getpId ();
		
	//Abstract method to get the name of the project
	public String getName();
	
	//Abstract method to set the name of the project
	public void setName(String name);
	
	//Abstract method to get the project description
	public String getDescription();
	
	//Abstract method to set the project description
	public void setDescription(String description);
}
