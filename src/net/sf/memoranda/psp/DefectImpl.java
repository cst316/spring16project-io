package net.sf.memoranda.psp;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import net.sf.memoranda.util.Util;

/**
 * This is the controller class for PSP_DefectPanel
 * @author Joe Michaels
 * 4/5/2016
 * 
 */
public class DefectImpl implements Defect, Serializable {
	
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
	
	/**
	 * Stores full TestRowObject ArrayList
	 * @param list
	 */
	public DefectImpl(ArrayList<TestRowObject> list){

		this.testObj = list;
	}
	
	/**
	 * Imports psp values from project if needed
	 * @param pspValues
	 */
	@Override
	public void setPspValues (Psp pspValues) {
		this.pspValues = pspValues;
	}
	
	/**
	 * returns psp information as Psp type
	 * @return pspValues
	 */
	@Override
	public Psp getPspValues () {
		return this.pspValues;
	}
	
	/**
	 * retrieves current working list object object as ArrayList<TestRowObject>
	 * @return testObj
	 */
	@Override
    public ArrayList<TestRowObject> getRowObject() {
        // TODO Auto-generated method stub
        return this.testObj;
    }

	/**
	 * Changes current testObj with new list, if succesfull returns true.
	 * Will make isDirty = true
	 * @param list
	 * @return temp
	 * @throws NullPointerException
	 */
    @Override
    public boolean setRowObject(ArrayList<TestRowObject> list) {
        isDirty = true;
        boolean temp = true;
        try{
            this.testObj = list;
            if(list == null){
                throw new NullPointerException();
            }
        }catch(NullPointerException npe){
            npe.getMessage();
            Util.debug("null object");
            temp = false;
        }catch(Exception e){
            e.getMessage();
            temp = false;
        }
        return temp;
    }
	
    /*
     * Adds new TestRowObject to existing ArrayList, throws exception if error.
     * Will make isDirty = true
     * @param rowObj
     * @return temp
     * @throws Exception
     */
	private boolean addRow(TestRowObject rowObj) {
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
		
		if (index < this.testObj.size()) {
			testObj.set(index, rowObj);  //Overwrites the object at the index
			isEdited = true;
		} else {
			isEdited = addRow(rowObj);	//Adds new object to Arraylist
		}
		
		if (isEdited) {
			isDirty = true;
		}
		
		return isEdited;
	}
    

	/**
	 * Removes row from ArrayList by matching object 
	 * @param rowObj
	 * @return temp
	 * @throws NullPointerException
	 */
	public boolean removeRow(TestRowObject rowObj){
		boolean isRemoved = true;
		isDirty = true;
		try{
			testObj.remove(rowObj);
			isDirty = true;		
		}catch(NullPointerException e){
			e.getMessage();
			isRemoved = false;
			Util.debug("Null pointer for object " + rowObj.toString());
			isRemoved = false;
		}catch(Exception e){
		    e.getMessage();
		    isRemoved = false;
		}
		return isRemoved;
	}

    /**
     * Removes row from ArrayList by index in ArrayList 
     * @param index
     * @return temp
     * @throws NullPointerException
     */
	@Override
	public boolean removeRow(int index){
		boolean isRemoved = true;
		
		try{
			testObj.remove(index);
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

	/**
	 * gets isDirty status
	 * @return isDirty
	 */
	public boolean getIsDirty(){
		return isDirty;
	}
}

