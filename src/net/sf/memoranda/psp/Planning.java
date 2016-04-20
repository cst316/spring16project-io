package net.sf.memoranda.psp;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Interface for psp planning controller 
 * @author Josh
 * and edited by Cephas
 */
public interface Planning {
	
	public void setPspValues (Psp pspValues);
	
	public Psp getPspValues ();
	
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
	
	//Accessor abstract method that returns the name of the file to be used in the project (fileName)
	public String getFilename(int index);

	//Mutator abstract method that sets the fileName given a String as a parameter
	public boolean setFilename (String filename);

	//Accessor method that returns the name of the file to be used in the project (fileName)
	public ArrayList<String> getFilenames ();
	
	//Accessor method that sets the name of the file to be used in the project (fileName)
	public void setFilenames (ArrayList<String> filenames);
		
	//Accessor abstract method returns additional modules added during the wizard phase
	public HashMap<String, Integer> getAdditionalMod();
	
	//Mutator abstract method that sets the project description
	public boolean setAdditionalMod(HashMap<String, Integer> modDescription);
	
	//Mutator abstract method that sets the project description
	public boolean setAdditionalMod(String newMod, int newSize);
}
