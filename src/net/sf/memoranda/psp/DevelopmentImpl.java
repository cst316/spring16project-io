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
	private Psp pspVal;
	
	public DevelopmentImpl(){
		rowObj = null;
	}
	
	public DevelopmentImpl(ArrayList<DevRowObject> rowObj){
		super();
		this.rowObj = rowObj;
	}
	
	@Override
	public boolean setRow(ArrayList<DevRowObject> list) {
		this.rowObj = list;
		return false;
	}

	@Override
	public boolean addRow(DevRowObject rowObj) {
		boolean temp = true;
		try{
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
}
