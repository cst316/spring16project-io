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
	private Date startTime;
	private Date endTime;
	private float interruptTime;
	private String phase;	
	
	public TimeRowObject () {
		this.date = null;
		this.startTime = null;
		this.endTime = null;
		this.interruptTime = 0.0f;
		this.phase = null;
	}
	
	public void setDate(Date date) {
		// TODO Auto-generated method stub
		this.date = date;
	}
	
	public boolean setDate(String date) {
		// TODO Auto-generated method stub
		boolean isSet = false;
		DateFormat formatter ; 
		formatter = new SimpleDateFormat("MM/dd/yy");
		try {
			this.date = formatter.parse(date);
			isSet = true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			Util.debug ("Date parsing issue: ".toUpperCase() + e.getMessage());
		}		
		return isSet;
	}
	
	public Date getDate() {
		// TODO Auto-generated method stub
		return this.date;
	}
	
	public boolean setStartTime(String time) {
		// TODO Auto-generated method stub
		boolean isSet = false;
		DateFormat formatter ; 
		formatter = new SimpleDateFormat("hh:mm a");
		try {
			this.startTime = formatter.parse(time);
			isSet = true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			Util.debug ("Time parsing issue: ".toUpperCase() + e.getMessage());
		}		
		return isSet;
	}
	
	public Date getStartTime() {
		// TODO Auto-generated method stub
		return this.startTime;
	}
	
	public void setInterruptTime(float time) {
		// TODO Auto-generated method stub
		this.interruptTime = time;
	}
	
	public float getInterruptTime() {
		// TODO Auto-generated method stub
		return this.interruptTime;
	}
	
	public boolean setEndTime(String time) {
		// TODO Auto-generated method stub
		boolean isSet = false;
		DateFormat formatter ; 
		formatter = new SimpleDateFormat("hh:mm a");
		try {
			this.endTime = formatter.parse(time);
			isSet = true;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			Util.debug ("Time parsing issue: ".toUpperCase() + e.getMessage());
		}		
		return isSet;
	}

	public Date getEndTime() {
		// TODO Auto-generated method stub
		return this.endTime;
	}
	
	public void setPhase(String phase) {
		// TODO Auto-generated method stub
		this.phase = phase;
	}

	public String getPhase() {
		// TODO Auto-generated method stub
		return this.phase;
	}
}