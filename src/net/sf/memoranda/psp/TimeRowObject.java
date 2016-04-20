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
		this.date = date;
	}
	
	/**
	 * setter for consistent date value
	 * @param date input to be parse to set date
	 * @return isSet boolean value returns success of set date
	 * @throws ParseException
	 */
	public boolean setDate(String date) {
		boolean isSet = true;
		DateFormat formatter ; 
		formatter = new SimpleDateFormat("MM/dd/yy");
		try {
			this.date = formatter.parse(date);
		} catch (ParseException e) {
			Util.debug ("Date parsing issue: ".toUpperCase() + e.getMessage());
			isSet = false;
		}		
		return isSet;
	}
	
	public Date getDate() {
		return this.date;
	}
	
	/**
	 * parse and set start time
	 * @param time string input to be parsed
	 * @return isSet boolean value indicates successful parse
	 * @throws ParseException outputs debug information 
	 */
	public boolean setStartTime(String time) {
		boolean isSet = true;
		DateFormat formatter ; 
		formatter = new SimpleDateFormat("hh:mm a");
		try {
			this.startTime = formatter.parse(time);
		} catch (ParseException e) {
			Util.debug ("Time parsing issue: ".toUpperCase() + e.getMessage());
            isSet = false;
		}		
		return isSet;
	}
	
	public Date getStartTime() {
		return this.startTime;
	}
	
	public void setInterruptTime(float time) {
		this.interruptTime = time;
	}
	
	public float getInterruptTime() {
		return this.interruptTime;
	}
	
	/**
	 * parse and set ending time
	 * @param time string value to parse into dateFormat
	 * @return isSet boolean value indicates success of parse
	 * @throws ParseException details time parse failure
	 */
	public boolean setEndTime(String time) {
		boolean isSet = true;
		DateFormat formatter ; 
		formatter = new SimpleDateFormat("hh:mm a");
		try {
			this.endTime = formatter.parse(time);
		} catch (ParseException e) {
			Util.debug ("Time parsing issue: ".toUpperCase() + e.getMessage());
            isSet = false;
		}		
		return isSet;
	}

	public Date getEndTime() {
		return this.endTime;
	}
	
	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getPhase() {
		return this.phase;
	}
}