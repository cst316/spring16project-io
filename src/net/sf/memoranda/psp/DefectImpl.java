package net.sf.memoranda.psp;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import net.sf.memoranda.util.Util;

public class DefectImpl implements Defect, Serializable {
	
	/**
     * 
     */
    private static final long serialVersionUID = -3899481284282752580L;
	private static boolean isDirty = false;
	private Psp pspValues;
	private ArrayList<TestRowObject> testObj;
	//private String path = ""; //temp values until rest of class is implemented
	
	public DefectImpl(){
		this.testObj = new ArrayList<TestRowObject> ();
		//path = null;
	}
	
	//This should be the main constructor to use
	public DefectImpl(Psp psp){
		this();		// Calling empty constructor
		this.pspValues = psp;
	}
	
	public DefectImpl(ArrayList<TestRowObject> list){

		this.testObj = list;
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
    public ArrayList<TestRowObject> getRowObject() {
        // TODO Auto-generated method stub
        return this.testObj;
    }

    @Override
    public boolean setRowObject(ArrayList<TestRowObject> list) {
        boolean isSet = false;
        
        if (list != null) {
        	this.testObj = list;
        	isSet = true;
        	isDirty = true;
        }
        return isSet;
    }
	
    @Override
	public boolean addRow(TestRowObject rowObj) {
		boolean isAdded = true;
		
		try{
			testObj.add(rowObj);
		}catch(Exception e){
			e.getMessage();
			isAdded = false;
		}
		return isAdded;
	}
	
	@Override
	public boolean editRow (int index, TestRowObject rowObj) {
		// TODO Auto-generated method stub
		boolean isEdited = false;
		
		if (index < this.testObj.size() && rowObj != null) {
			testObj.set(index, rowObj);  //Overwrites the object at the index
			isEdited = true;
		} else if (rowObj != null) {
			isEdited = addRow(rowObj);	//Adds new object to Arraylist
		}
		
		if (isEdited) {
			isDirty = true;
		}
		
		return isEdited;
	}
    
	@Override
	public boolean removeRow (TestRowObject rowObj){
		boolean isRemoved = true;
		
		try{
			testObj.remove(rowObj);
			isDirty = true;		
		}catch(NullPointerException e){
			e.getMessage();
			isRemoved = false;
		}
		
		return isRemoved;
	}
	
	@Override
	public boolean removeRow(int index){
		boolean isRemoved = true;
		
		try{
			testObj.remove(index);
			isDirty = true;		
		}catch(NullPointerException e){
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
	private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		Util.debug("Defect retrieved");
	}
	
	/**
	 * Implement custom object writer
	 * @param stream
	 * @throws IOException
	 */
	private void writeObject(java.io.ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
		Util.debug("Defect wrtten");
	}

	public boolean getIsDirty(){
		return isDirty;
	}
}

