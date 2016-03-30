package net.sf.memoranda.psp;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import net.sf.memoranda.util.Util;

/**
 * 
 * @author Cephas Armstrong-Mensah
 * @author Team-IO
 * CST316 - Spring 2016, ASU Poly
 * This class abstracts the Time Log objects into a row
 * 03/29/2016
 */
public class TimeRowObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7354700070702212027L;
	private Date date;
	private float startTime;
	private float endTime;
	private float interruptTime;
	private String phase;	
	
	private static boolean isDirty;	
	
	public TimeRowObject () {
		this.date = new Date();
		this.startTime = 0.0f;		
	}
	
	public void setDate(Date date) {
		// TODO Auto-generated method stub
		this.date = date;
		isDirty = true;
	}
	
	public void setDate(String date) {
		// TODO Auto-generated method stub
		DateFormat formatter ; 
		formatter = new SimpleDateFormat("MM/dd/yy");
		try {
			this.date = formatter.parse(date);
			isDirty = true;
			System.out.println("The parsed date is: " + date.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			Util.debug ("Date parsing issue: ".toUpperCase() + e.getMessage());
		}
	}
	
	public Date getDate() {
		// TODO Auto-generated method stub
		return date;
	}
	
	public void setStartTime(float time) {
		// TODO Auto-generated method stub
		this.startTime = time;
		isDirty = true;
	}
	
	public float getStartTime() {
		// TODO Auto-generated method stub
		return this.startTime;
	}
	
	public void setInterruptTime(float time) {
		// TODO Auto-generated method stub
		this.interruptTime = time;
		isDirty = true;
	}
	
	public float getInterruptTime() {
		// TODO Auto-generated method stub
		return this.interruptTime;
	}
	
	public void setEndTime(float time) {
		// TODO Auto-generated method stub
		this.endTime = time;
		isDirty = true;
	}

	public float getEndTime() {
		// TODO Auto-generated method stub
		return this.endTime;
	}
	
	public void setPhase(String phase) {
		// TODO Auto-generated method stub
		this.phase = phase;
		isDirty = true;
	}

	public String getPhase() {
		// TODO Auto-generated method stub
		return this.phase;
	}
	
	public static void setIsDirty(boolean dirty) {
		isDirty = dirty;
	}
	
	public static boolean getIsDirty() {
		return isDirty;
	}
}
