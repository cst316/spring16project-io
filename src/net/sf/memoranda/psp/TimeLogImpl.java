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
	
	/**
	 * Handles addition of new row into object of rows
	 * @param timeRow send in TimeRowObject that holds attributes
	 * for time recording logs
	 * @return isAdded boolean value returns based on 
	 * success of addition of object into timerow ArrayList
	 */
	@Override
	public boolean addTimeRowObject(TimeRowObject timeRow) {
		boolean isAdded = true;
		this.timerow.add(timeRow);
		return isAdded;
	}

	/**
	 * @param index location in List to return object
	 * @return obj TimeRowObject that is returned to caller
	 * @throws NullPointerException is thrown in chance caller gives
	 * invalid location
	 * @throws Exception 
	 */
	@Override
	public TimeRowObject getTimeRowObject(int index) {
	    TimeRowObject obj = new TimeRowObject();
	    try{
	        obj = this.timerow.get(index);
	    }catch(NullPointerException npe){
	        npe.getMessage();
	        Util.debug("null pointer at index: " + index);
	    }catch(Exception e){
	        e.getMessage();
	    }
		return obj;
	}

	/**
	 * replaces current List of objects, basically a setter
	 * @param timerow List of objects to replace current List
	 * @return isAdded boolean value returned in success of addition
	 */
	@Override
	public boolean addTimeRowObject(List<TimeRowObject> timerow) {
		boolean isAdded = true;
		this.timerow = timerow;
		return isAdded;
	}
	
	/**
	 * private method to add TimeRowObject to current List
	 * @param rowObj object to add to list
	 * @return isAdded status returning whether addition was valid
	 * @throws Exception 
	 */
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
	
	/**
	 * This method replaces element in specific index with new element
	 * @param rowObj value of replacement data
	 * @param index int value of index to replace
	 * @return isEdited boolean value returned is operation is successful
	 * 
	 */
	@Override
	public boolean editRow (int index, TimeRowObject rowObj) {
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
		return this.timerow;
	}
	
	@Override
	public boolean removeAllObjects() {
		this.timerow.clear();
		return false;
	}

	/**
	 * removes element at given index
	 * @param timerow
	 * @param index location of element to remove
	 * @return isRemoved boolean detailing success of operation
	 * @throws NullPointerException thrown if index is not within timerow's
	 * size
	 * @throws Exception
	 * Note: needs to be refactored
	 */
	@Override
	public boolean removeTimeRowObject(TimeRowObject timerow, int index) {
		boolean isRemoved = true;
		try{
		    this.timerow.remove(index);
		}catch(NullPointerException npe){
		    npe.getMessage();
		    Util.debug("null pointer at index: " + index);
		    isRemoved = false;
		}catch(Exception e){
		    e.getMessage();
		    isRemoved = false;
		}
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
