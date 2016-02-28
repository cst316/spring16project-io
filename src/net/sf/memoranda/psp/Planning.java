package net.sf.memoranda.psp;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import net.sf.memoranda.date.CurrentDate;

public interface Planning extends Psp {
	//Accessor abstract method that gets the estimated time (estTime)
	public float getEstTime();
	
	//Mutator abstract method that sets the estimated time (estTime) 
	public void setEstTime(float estTime);

	//Accessor abstract method that gets the lines of code per hour (locHr) 
	public int getLocHr();
	
	//Mutator abstract method that sets the lines of code per hour (locHr)
	public void setLocHr(int locHr);
	
	//Accessor abstract method that gets the estimated size (estSize)
	public int getEstSize();
	
	//Mutator abstract method that sets the estimated size (estSize)
	public void setEstSize(int estSize);

	//Accessor abstract method that gets the estimated number of defects (estDefect)
	public int getEstDefect();
	
	//Mutator abstract method that set the estimated number of defects (estDefect)
	public void setEstDefect(int estDefect);

	//Accessor abstract method that returns the name of the file to be used in the project (fileName)
	public String getFilename();

	//Accessor abstract method that returns the list of filenames in the planning (<fileName>)
	public ArrayList<String> getFilenames();

	
	//Mutator abstract method that sets the fileName given a String as a parameter
	public void setFilename(String filename);

	//Accessor abstract method that gets the project description as a hash map based on a unique key
	public HashMap<String, Integer> getProjectDescription();
	
	//Mutator abstract method that sets the project description
	public void setProjectDescription(HashMap<String, Integer> projectDescription);

	//Accessor abstract method that gets the start date (stDate)
	@Override
	public CurrentDate getStDate();

	//Mutator abstract method that sets the start date (stDate)
	@Override
	public void setStDate(CurrentDate stDate);
	
	//Accessor abstract method that gets the name by returning the pspValues object reference variable's getName() method
	@Override
	public String getName();
	
	//Gives access to Psp that corresponds to this Plan
	public void setPspValues (Psp pspValues);

	//Mutator abstract method that sets the name by using the pspValues object reference variable
	@Override
	public void setName(String name);

	//Accessor abstract method that gets the description by using the pspValues object reference variable's
	//getDescription() method
	@Override
	public String getDescription();

	//Mutator abstract method sets the description given a String parameter
	@Override
	public void setDescription(String description);


}
