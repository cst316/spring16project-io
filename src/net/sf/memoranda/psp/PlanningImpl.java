package net.sf.memoranda.psp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import net.sf.memoranda.util.Util;

public class PlanningImpl implements Planning, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2767071770527400292L;

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

	//toString method returns a String of all the instance variables
	public String toString() {
		return "Planning:\n" + "Estimated Time = " + this.getEstTime() + ", Lines of Code = " + this.getLocHr() + 
				", Estimated Size = " + this.getEstSize() + ", Estimated Defects = " + this.getEstDefect() + 
				", Filename=" + this.getFilename() + ", additional modulue(s)=" + this.getAdditionalMod();
	}

	@Override
	public boolean setAdditionalMod(HashMap<String, Integer> modDescription) {
		boolean isAdded = false;
		
		if (!this.moduleDescription.equals(modDescription)) { 
			this.moduleDescription = modDescription;
			isDirty = true;
			isAdded = true;
		}
				
		return isAdded;
	}	

	@Override
	public boolean setAdditionalMod(String newMod, int newSize) {
		boolean isAdded = false;
		
		if (!this.moduleDescription.containsKey(newMod)) {
			this.moduleDescription.put(newMod, newSize);
			isAdded = true;
			isDirty = true;
		}		
		return isAdded;
	}

	@Override
	public HashMap<String, Integer> getAdditionalMod() {
		// TODO Auto-generated method stub
		return this.moduleDescription;
	}

	/**
	 * Implement custom object reader
	 * @param stream
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		Util.debug("Planning retrieved");
	}
	
	/**
	 * Implement custom object writer
	 * @param stream
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
		Util.debug("Planning wrtten");
		isDirty = false;
	}
}