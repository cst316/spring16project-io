package net.sf.memoranda.psp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import net.sf.memoranda.util.Util;

/**
 * 
 * @author Cephas Armstrong-Mensah
 * @author Team-IO
 * CST316 - Spring 2016, ASU Poly
 * This implementation, implements TimeLog.java interface
 * 03/29/2016
 */
public class TimeLogImpl implements TimeLog, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3790546736695557381L;
	
	private Psp pspValues;
	
	private static boolean isDirty = false;
	
	private List<TimeRowObject> timerow = new ArrayList<TimeRowObject>();
	
	public TimeLogImpl () {
		this.pspValues = new PspImpl();
	}
	
	public TimeLogImpl (Psp pspValues) {
		this.pspValues = pspValues;
	}
	
	@Override
	public void setPspValues (Psp pspValues) {
		this.pspValues = pspValues;
	}
	
	@Override
	public Psp getPspValues () {
		return this.pspValues;
	}
	
	@Override
	public boolean addTimeRowObject(TimeRowObject timerow) {
		// TODO Auto-generated method stub
		boolean isAdded = true;
		this.timerow.add(timerow);
		return isAdded;
	}

	@Override
	public TimeRowObject getTimeRowObject(int index) {
		// TODO Auto-generated method stub
		return this.timerow.get(index);
	}

	@Override
	public boolean addTimeRowObject(List<TimeRowObject> timerow) {
		// TODO Auto-generated method stub
		boolean isAdded = true;
		this.timerow = timerow;
		return isAdded;
	}

	@Override
	public List<TimeRowObject> getTimeRowLists() {
		// TODO Auto-generated method stub
		return this.timerow;
	}
	
	@Override
	public boolean removeAllObjects() {
		// TODO Auto-generated method stub
		this.timerow.clear();
		return false;
	}

	@Override
	public boolean removeTimeRowObject(TimeRowObject timerow, int index) {
		// TODO Auto-generated method stub
		boolean isRemoved = true;
		this.timerow.remove(index);
		return isRemoved;
	}	
	
	public boolean removeRow(int index){
		boolean isRemoved = true;
		
		try{
			timerow.remove(index);
			isDirty = true;		
		}catch(NullPointerException e){
			e.getMessage();
			isRemoved = false;
			Util.debug("Index does not exist. Index number: " + index);
			isRemoved = false;
		}catch(Exception e){
		    e.getMessage();
		    isRemoved = false;
		}
		
		return isRemoved;
	}

	
	@Override
	public boolean addRow(TimeRowObject rowObj) {
		boolean isAdded = true;
		
		try{
			timerow.add(rowObj);
		}catch(Exception e){
			e.getMessage();
			isAdded = false;
		}
		return isAdded;
	}
	
	/**
	 * Implement custom object reader
	 * @param stream
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		Util.debug("Time Log retrieved");
	}
	
	/**
	 * Implement custom object writer
	 * @param stream
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
		Util.debug("Time Log wrtten");
	}

	@Override
	public boolean editRow(int index, TimeRowObject rowObj) {
		boolean isEdited = false;
		
		if (index < this.timerow.size() && rowObj != null) {
			timerow.set(index, rowObj); //Overwrites the object at the index
			isEdited = true;
		} else if (rowObj != null) {
			isEdited = addRow(rowObj);	//Adds new object to Arraylist
		}
		
		if (isEdited) {
			isDirty = true;
		}
		
		return isEdited;
	}

}
