package net.sf.memoranda.psp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;

import net.sf.memoranda.date.CurrentDate;
import net.sf.memoranda.ui.ExceptionDialog;

public class PlanningImpl implements Psp, Planning {
	
	//Psp interface reference variable used to get access to the Psp pID constant
	Psp pspValues;

	//Attributes related to the Planning class
	float estTime;
	int locHr;
	int estSize;
	int estDefect;
	int descriptionSize;

	String filename;
	HashMap <String, Integer> projectDescription;
	
	//PlanningImpl class constructor with empty values and no parameters
	public PlanningImpl() {
		// TODO Auto-generated constructor stub
		float estTime = 0;
		int locHr = 0;
		int estSize = 0; 
		int estDefect = 0;
		int descriptionSize = 0;
		String filename = "";
		HashMap <String, Integer> projectDescription = null;
	}
	
	//PlanningImpl class constructor initialized to variables specified in the method parameter header  
	public PlanningImpl(float estimatedTime, int linesOfCodePerHour, int estimatedSize, int estimatedDefect, 
			int descriptionSize, String nameOfFile, HashMap <String, Integer> projDesc) {
		// TODO Auto-generated constructor stub
		float estTime = estimatedTime;
		int locHr = linesOfCodePerHour;
		int estSize = estimatedSize; 
		int estDefect = estimatedDefect;
		String filename = nameOfFile;
		HashMap <String, Integer> projectDescription = projDesc;
	}
	
	//Accessor method that gets the estimated time (estTime)
	public float getEstTime() {
		return estTime;
	}
	
	//Mutator method that sets the estimated time (estTime) 
	public void setEstTime(float estTime) {
		this.estTime = estTime;
	}

	//Accessor method that gets the lines of code per hour (locHr) 
	public int getLocHr() {
		return locHr;
	}
	
	//Mutator method that sets the lines of code per hour (locHr)
	public void setLocHr(int locHr) {
		this.locHr = locHr;
	}
	
	//Accessor method that gets the estimated size (estSize)
	public int getEstSize() {
		return estSize;
	}
	
	//Mutator method that sets the estimated size (estSize)
	public void setEstSize(int estSize) {
		this.estSize = estSize;
	}

	//Accessor method that gets the estimated number of defects (estDefect)
	public int getEstDefect() {
		return estDefect;
	}

	//Mutator method that set the estimated number of defects (estDefect)
	public void setEstDefect(int estDefect) {
		this.estDefect = estDefect;
	}
	
	//Returns the size associated with the description
	public int getDescriptionSize() {
		return descriptionSize;
	}

	//Sets the size associated with the description
	public void setDescriptionSize(int descriptionSize) {
		this.descriptionSize = descriptionSize;
	}

	//Accessor method that returns the name of the file to be used in the project (fileName)
	public String getFilename() {
		return filename;
	}

	//Mutator method that sets the fileName given a file as a parameter
	public void setFilename(String fileName) {
		this.filename = filename;
	}

	//Accessor method that gets the project description as a hash map based on a unique key
	public HashMap<String, Integer> getProjectDescription() {
		return projectDescription;
	}

	//Mutator method that sets the project description
	public void setProjectDescription(HashMap<String, Integer> projectDescription) {
		this.projectDescription = projectDescription;
	}

	//Accessor method that gets the start date (stDate)
	@Override
	public CurrentDate getStDate() {
		return pspValues.getStDate();
	}

	//Mutator method that sets the start date (stDate)
	@Override
	public void setStDate(CurrentDate stDate) {
		CurrentDate startDate = pspValues.getStDate();
		startDate = stDate; 
		
	}
	//Accessor method that gets the name by returning the pspValues object reference variable's getName() method
	@Override
	public String getName() {
		return pspValues.getName();
	}

	//Mutator method that sets the name by using the pspValues object reference variable
	@Override
	public void setName(String name) {
		String projectName = pspValues.getName();
		projectName = name; 

	}

	//Accessor method that gets the description by using the pspValues object reference variable's
	//getDescription() method
	@Override
	public String getDescription() {
		return pspValues.getDescription();
	}

	//Mutator method sets the description given a String parameter
	@Override
	public void setDescription(String description) {
		String projDesc = pspValues.getDescription();
		projDesc = description;
	}
	
	//Models the saveDocument() method in FileStorage.java (.util package)
	//Takes 
	public void save(String thePathOfTheFile)
	{
        try {
            OutputStreamWriter fw =
                new OutputStreamWriter(new FileOutputStream(thePathOfTheFile), "UTF-8");
            fw.write((int) this.getEstTime());
            fw.write(this.getLocHr());
            fw.write(this.getEstSize());
            fw.write(this.getEstDefect());
            fw.write(this.getFilename());
            fw.write(this.getDescription());
            fw.write(this.getDescriptionSize());
        
            fw.flush();
            fw.close();
        }
        catch (IOException ioException) {
            new ExceptionDialog(
                ioException,
                "Saving the estimated time, estimated lines of code per hour, "
                + " estimated size, and estimated number of defects, the file name and"
                + " the description and the size of the description for use in XML file has failed" 
                + thePathOfTheFile, "");
        }
	}

	//toString method returns a String of all the instance variables
	@Override
	public String toString() {
		return "Planning:\n" + "Estimated Time = " + this.getEstTime() + ", Lines of Code = " + this.getLocHr() + 
				", Estimated Size = " + this.getEstSize() + ", Estimated Defects = " + this.getEstDefect() + 
				", Filename=" + this.getFilename() + ", projectDescription=" + this.getProjectDescription();
	}

}