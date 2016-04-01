package net.sf.memoranda.psp;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import net.sf.memoranda.util.Util;

/**
 * 
 * @author Joe Michaels
 * 3/28/2016
 * development gui controller, handles arrayList of DevRowObject object
 *
 */
public class DevelopmentImpl implements Development, Serializable{


	private static final long serialVersionUID = 9142054105867396986L;
	private ArrayList<DevRowObject> rowObj;
	private static boolean isDirty = false;
	private Psp pspValues;
	
	public DevelopmentImpl(){
		rowObj = new ArrayList<DevRowObject>();
	}
	
	// This should be the main constructor to use
	public DevelopmentImpl(Psp psp){
		this();		// Calling empty constructor
		this.pspValues = psp;
	}
	
	public DevelopmentImpl(ArrayList<DevRowObject> rowObj){
		this.rowObj = rowObj;
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
	public boolean setRow(ArrayList<DevRowObject> list) {
		isDirty = true;
		this.rowObj = list;
		return false;
	}

	@Override
	public boolean addRow(DevRowObject rowObj) {
		boolean temp = true;
		try{
			isDirty = true;
			this.rowObj.add(rowObj);
		}catch(Exception e){
			e.getMessage();
			temp = false;
		}
		return temp;
	}

	@Override
	public boolean removeRow(int i) {
		boolean temp = true;
		isDirty = true;
		try{
			this.rowObj.remove(i);
		}catch(NullPointerException e){
			e.getMessage();
			temp = false;
		}
		return temp;
	}

	@Override
	public ArrayList<DevRowObject> getRow() {
		return this.rowObj;
	}
	

	/**
	 * Implement custom object reader, copied from defectImpl.java
	 * @param stream
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		Util.debug("Development retrieved");
	}
	
	/**
	 * Implement custom object writer, copied from defectImpl.java
	 * @param stream
	 * @throws IOException
	 */
	private void writeObject(java.io.ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
		Util.debug("Development wrtten");
	}
	
	public boolean getIsDirty(){
		return isDirty;
	}
}
