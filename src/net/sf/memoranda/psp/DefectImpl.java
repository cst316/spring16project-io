package net.sf.memoranda.psp;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import net.sf.memoranda.util.Util;

public class DefectImpl implements Defect, Serializable {
	
	private static final long serialVersionUID 
	                    = 8961650030847897462L;
	private static boolean isDirty = false;
	private Psp pspVal;
	private ArrayList<TestRowObject> testObj  
	                                = new ArrayList<TestRowObject>();
	//private String path = ""; //temp values until rest of class is implemented
	
	public DefectImpl(){
		this.testObj = null;
		//path = null;
	}
	
	public DefectImpl(ArrayList<TestRowObject> list){
		super();
		this.testObj = list;
	}
	
	@Override
	public ArrayList<TestRowObject> getRow() {
		return this.testObj;
	}

	@Override
	public boolean setRow(ArrayList<TestRowObject> list) {
		isDirty = true;
		this.testObj = list;
		return false;
	}
	
	@Override
	public boolean addRow(TestRowObject rowObj) {
		boolean temp = true;
		try{
			isDirty = true;
			testObj.add(rowObj);
		}catch(Exception e){
			e.getMessage();
			temp = false;
		}
		return temp;
	}
	
	public boolean removeRow(int index){
		boolean temp = true;
		isDirty = true;
		try{
			testObj.remove(index);
		}catch(NullPointerException e){
			e.getMessage();
			temp = false;
		}
		return temp;
	}
	

	/**
	 * Implement custom object reader
	 * @param stream
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(java.io.ObjectInputStream stream) 
	                throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		Util.debug("object retrieved");
	}
	
	/**
	 * Implement custom object writer
	 * @param stream
	 * @throws IOException
	 */
	private void writeObject(java.io.ObjectOutputStream stream)
	                throws IOException {
		stream.defaultWriteObject();
		Util.debug("object wrtten");
	}
	
	public boolean getIsDirty(){
		return isDirty;
	}

}