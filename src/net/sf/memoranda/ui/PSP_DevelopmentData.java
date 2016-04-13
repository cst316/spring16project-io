package net.sf.memoranda.ui;

import java.io.Serializable;

public class PSP_DevelopmentData implements Serializable {

	private static final long serialVersionUID = 3052458131219353040L;
	public static String[] tdarray = new String[6];
	
	//method to build array
	public void saveTaskData(String fieldvalue, int count){
	    tdarray[count]= fieldvalue;
	}

	//prints out array for testing
	public static void showTaskData(int count){
		System.out.println(tdarray[count]);
   	}
}