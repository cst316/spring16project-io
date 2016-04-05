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
	
	private static final long serialVersionUID = 3790546736695557381L;
	
	private Psp pspValues;
	
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
	
	private boolean addRow(TimeRowObject rowObj) {
		boolean isAdded = false;
		
		try {
			this.timerow.add(rowObj);
			isAdded = true;
		} catch(Exception e) {
			e.getMessage();
		}
		return isAdded;
	}
	
	@Override
	public boolean editRow (int index, TimeRowObject rowObj) {
		// TODO Auto-generated method stub
		boolean isEdited = false;
		
		if (index < this.timerow.size()) {
			timerow.set(index, rowObj);  //Overwrites the object at the index
			isEdited = true;
		} else {
			isEdited = addRow(rowObj);	//Adds new object to Arraylist
		}
		
		return isEdited;
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
}
