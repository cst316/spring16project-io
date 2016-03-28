package net.sf.memoranda.ui;

import java.io.Serializable;

public class PSP_NewTaskData implements Serializable {

	//arbitrary size (5) for testing, will change to list later 
	// but this works for the amount of columns the NewTask fields will populate
	
	static String[] tdarray = new String[6];
	
	//method to build array

	public void saveTaskData(String fieldvalue, int count)
	
	{
	    tdarray[count]= fieldvalue;
	}

	//prints out array for testing
	
	public static void showTaskData(int count)
	
	{
		
		//System.out.println(tdarray[1]);
		
	    //for (int i = 0; i < count; i++) 
	    
	    //{
	        System.out.println(tdarray[count]);
	    //}
	}
	
	
	

	}