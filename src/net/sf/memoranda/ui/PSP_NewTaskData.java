package net.sf.memoranda.ui;

import java.io.Serializable;

public class PSP_NewTaskData implements Serializable {

	//arbitrary size (5) for testing, will change to list later 
	// but this works for the amount of columns the NewTask fields will populate
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3052458131219353040L;
	static String[] tdarray = new String[6];
	
	//method to build array

	public void saveTaskData(String fieldvalue, int count)
	
	{
	    tdarray[count]= fieldvalue;
	}

	//prints out array for testing
	
	public static void showTaskData(int count)
	
	{
		System.out.println(tdarray[count]);
   	}
	
	
	}