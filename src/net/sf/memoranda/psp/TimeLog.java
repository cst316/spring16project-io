package net.sf.memoranda.psp;

import java.util.Date;

/** 
 * @author Cephas Armstrong-Mensah
 * @author Team-IO
 * CST316 - Spring 2016, ASU Poly
 * This interface is used for TimeLogImpl.java
 * 03/29/2016
 */
public interface TimeLog {	
	
	public void setDate (Date date);
	
	public Date getDate ();
	
	public void setStartTime (float time);
	
	public float getStartTime ();
	
	public void setInterruptTime (float time);
	
	public float getInterruptTime ();
	
	public void setEndTime (float time);
	
	public float getEndTime ();
	
	public void setPhase (String phase);
	
	public String getPhase ();
}
