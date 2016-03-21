package net.sf.memoranda.ui;

public class PSP_NewTaskData {

	//arbitrary size (5) for testing, will change to list later
	
	static String[] s = new String[5];
	
	//method to build array

	public void saveTaskData(String na, int count){
	    s[count]=na;
	}

	//prints out array for testing
	
	public static void showTaskData(int count){
	    for (int i = 0; i < count; i++) {
	        System.out.println(s[count]);
	    }
	}

	}