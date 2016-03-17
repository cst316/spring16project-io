package net.sf.memoranda.psp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import net.sf.memoranda.date.CurrentDate;
import net.sf.memoranda.ui.ExceptionDialog;
import net.sf.memoranda.util.Util;

public class PlanningImpl implements Planning {
	
	//Psp interface reference variable used to get access to the Psp pID constant
	private Psp pspValues;

	//Attributes related to the Planning class
	private float estTime;
	private int locHr;
	private int estSize;
	private int estDefect;
	private int descriptionSize;
	private String filename;
	private int pId;
	private ArrayList <String> files = new ArrayList<String>();
	private HashMap <String, Integer> moduleDescription;
	
	static boolean isDirty;
	
	//PlanningImpl class constructor with empty values and no parameters
	public PlanningImpl() {
		// TODO Auto-generated constructor stub
		this.estTime = 0.0f;
		this.locHr = 0;
		this.estSize = 0; 
		this.estDefect = 0;
		this.descriptionSize = 0;
		this.files = new ArrayList<String>();
		this.filename = "";
		this.moduleDescription = new HashMap <String, Integer> ();
		pspValues = new PspImpl ();
		isDirty = false;	
	}
	
	//PlanningImpl class constructor initialized to variables specified in the method parameter header  
	public PlanningImpl(float estimatedTime, int linesOfCodePerHour, int estimatedSize, int estimatedDefect, 
			ArrayList<String> nameOfFile, HashMap <String, Integer> projDesc, int pId) {
		// TODO Auto-generated constructor stub
		this.estTime = estimatedTime;
		this.locHr = linesOfCodePerHour;
		this.estSize = estimatedSize; 
		this.estDefect = estimatedDefect;
		this.files = nameOfFile;
		this.filename="";
		this.moduleDescription = projDesc;
		this.pId = pId;

		pspValues = new PspImpl ();
		isDirty = false;		
	}
	
	//Accessor method that gets the estimated time (estTime)
	public float getEstTime() {
		return estTime;
	}
	
	//Mutator method that sets the estimated time (estTime) 
	public void setEstTime(float estTime) {
		this.estTime = estTime;
		isDirty = true;
	}

	//Accessor method that gets the lines of code per hour (locHr) 
	public int getLocHr() {
		return locHr;
	}
	
	//Mutator method that sets the lines of code per hour (locHr)
	public void setLocHr(int locHr) {
		this.locHr = locHr;
		isDirty = true;
	}
	
	//Accessor method that gets the estimated size (estSize)
	public int getEstSize() {
		return estSize;
	}
	
	//Mutator method that sets the estimated size (estSize)
	public void setEstSize(int estSize) {
		this.estSize = estSize;
		isDirty = true;
	}

	//Accessor method that gets the estimated number of defects (estDefect)
	public int getEstDefect() {
		return estDefect;
	}

	//Mutator method that set the estimated number of defects (estDefect)
	public void setEstDefect(int estDefect) {
		this.estDefect = estDefect;
		isDirty = true;
	}
	
	//Returns the size associated with the description
	public int getDescriptionSize() {
		return descriptionSize;
	}

	//Sets the size associated with the description
	public void setDescriptionSize(int descriptionSize) {
		this.descriptionSize = descriptionSize;
		isDirty = true;
	}

	//Accessor abstract method that returns the name of the file to be used in the project (fileName)
	public String getFilename() {
		// TODO Auto-generated method stub
		return this.filename;
	}
	
	//Accessor abstract method that returns the name of the file to be used in the project (fileName)
	public String getFilename(int index) {
		// TODO Auto-generated method stub
		return this.files.get(index);
	}
	

	//Accessor method that returns the name of the file to be used in the project (fileName)
	public ArrayList<String> getFilenames () {
		System.out.println(files + " queried " + files.size());
		return this.files;
	}

	//Accessor method that sets the name of the file to be used in the project (fileName)
	public void setFilenames (ArrayList<String> filenames) {
		this.files = filenames;
		isDirty = true;
	}
	
	//Mutator method that sets the fileName given a file as a parameter
	public boolean setFilename(String filename) {
		boolean isAdded = true;
		
		for (int i = 0; i < files.size(); i++) {
			if (this.files.get(i).equals(filename)) {
				isAdded = false;
			}
		}
		
		if (isAdded) {
			this.files.add(filename);
			isDirty = true;
		}
		return isAdded;
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
		isDirty = true;
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
		isDirty = true;
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
		isDirty = true;
	}
		
	public void save (PlanningImpl p) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream ("proj/" + pspValues.getpId ()+"_planning"));
			oos.writeObject(p);
			oos.close();
		} catch (IOException ioException) {
			new ExceptionDialog(
	                ioException,
	                "Saving the estimated time, estimated lines of code per hour, "
	                + " estimated size, and estimated number of defects, the file name and"
	                + " the description and the size of the description for use in XML file has failed" 
	                + "thePathOfTheFile", "");
		}
	}

	//toString method returns a String of all the instance variables
	@Override
	public String toString() {
		return "Planning:\n" + "Estimated Time = " + this.getEstTime() + ", Lines of Code = " + this.getLocHr() + 
				", Estimated Size = " + this.getEstSize() + ", Estimated Defects = " + this.getEstDefect() + 
				", Filename=" + this.getFilename() + ", additional modulue(s)=" + this.getAdditionalMod();
	}

	@Override
	public void setPspValues(Psp values) {
		// TODO Auto-generated method stub
		this.pspValues = values;
		//isDirty = true;
	}

	@Override
	public void setpId(int id) {
		// TODO Auto-generated method stub
		//isDirty = true;
	}

	@Override
	public int getpId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public HashMap<String, Integer> getAdditionalMod() {
		// TODO Auto-generated method stub
		return this.moduleDescription;
	}

	@Override
	public boolean setAdditionalMod(HashMap<String, Integer> modDescription) {
		boolean isAdded = false;
		
		if (!this.moduleDescription.equals(modDescription)) { 
			this.moduleDescription = modDescription;
			isDirty = true;
		}
				
		return isAdded;
	}	
	
	public boolean setAdditionalMod(String newMod, int newSize) {
		boolean isAdded = false;
		
		if (!this.moduleDescription.containsKey(newMod)) {
			this.moduleDescription.put(newMod, newSize);
			isAdded = true;
			isDirty = true;
		}		
		return isAdded;
	}	

	/**
	 * Implement custom object reader
	 * @param stream
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		Util.debug("Planning retrieved");
	}
	
	/**
	 * Implement custom object writer
	 * @param stream
	 * @throws IOException
	 */
	private void writeObject(java.io.ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
		Util.debug("Planning wrtten");
		isDirty = false;
	}
}