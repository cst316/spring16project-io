package net.sf.memoranda.psp;

import java.io.Serializable;
import java.util.Date;

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
	
	public void setDate(Date date) {
		// TODO Auto-generated method stub
		this.date = date;
		isDirty = true;
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
