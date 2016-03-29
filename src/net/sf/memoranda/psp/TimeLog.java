package net.sf.memoranda.psp;

import java.util.List;

/** 
 * @author Cephas Armstrong-Mensah
 * @author Team-IO
 * CST316 - Spring 2016, ASU Poly
 * This interface is used for TimeLogImpl.java
 * 03/29/2016
 */
public interface TimeLog {	
	
	public void setPspValues (Psp pspValues);
	
	public Psp getPspValues ();
	
	public void setTimeRowObject (TimeRowObject timerow);
	
	public TimeRowObject getTimeRowObject(int index);
	
	public void setTimeRowObject (List<TimeRowObject> timerow);
	
	public List<TimeRowObject> getTimeRowLists();	
}
