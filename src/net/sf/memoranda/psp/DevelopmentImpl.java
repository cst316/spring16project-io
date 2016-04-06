package net.sf.memoranda.psp;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import net.sf.memoranda.util.Util;

/**
 * 
 * @author Joe Michaels
 * 3/28/2016
 *  controller for PSP_Development gui, handles arrayList 
 *  of DevRowObject object
 *
 */
public class DevelopmentImpl implements Development, Serializable{


	private static final long serialVersionUID = 9142054105867396986L;
	private ArrayList<DevRowObject> rowObj;
	private static boolean isDirty;
	private Psp pspVal;
	
	public DevelopmentImpl(){
	    isDirty = false;
		rowObj = null;
	}
	
	public DevelopmentImpl(ArrayList<DevRowObject> rowObj){
	    isDirty = false;
	}

	// This should be the main constructor to use
	public DevelopmentImpl(Psp psp){
		this();		// Calling empty constructor
		this.pspVal = psp;
	}
	
	public DevelopmentImpl(ArrayList<DevRowObject> rowObj, Psp pspVal){
        isDirty = false;
        this.pspVal = pspVal;
        this.rowObj = rowObj;
    }
	
	@Override
	public void setPspValues (Psp pspValues) {
		this.pspVal = pspValues;
	}
	
	@Override
	public Psp getPspValues () {
		return this.pspVal;
	}
	
	@Override
	public boolean setRow(ArrayList<DevRowObject> list) {
		isDirty = true;
		this.rowObj = list;
		return false;
	}

	/**
	 * adds another element to ArrayList object
	 * @param rowObj is of type DevRowObject 
	 * @return temp returns true if addition of element
	 * did not throw errors
	 * @throws Exception
	 */
	@Override
	public boolean addRow(DevRowObject rowObj) {
		boolean temp = true;
		try{
			isDirty = true;
			this.rowObj.add(rowObj);
		}catch(Exception e){
			e.getMessage();
			temp = false;
			Util.debug("error adding row to DevRowObject");
		}
		return temp;
	}

	/**
	 * removes row from ArrayList rowObj by specified index
	 * @param index index number to remove from ArrayList rowObj
	 * @return temp boolean value indicating successful 
	 * removal of element from ArrayList, will be false if error occurs.
	 * @throws NullPointerException 
	 * @throws Exception
	 */
	@Override
	public boolean removeRow(int index) {
		boolean temp = true;
		isDirty = true;
		try{
			this.rowObj.remove(index);
		}catch(NullPointerException e){
			e.getMessage();
			temp = false;
		    Util.debug("Null error removing row from rowObj at index" + index);
        }catch(Exception e){
            e.getMessage();
            temp = false;
            Util.debug("error removing row to DevRowObject");
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
	
	public static void setIsDirty(boolean dirty) {
        isDirty = dirty;
    }
    
	/**
	 * getter for project ID value
	 * @return id returns project id number of current open application
	 * @throws NullPointerException thrown if pspVal is not initialized at some point
	 * @throws Exception
	 */
    public int getPID(){
        int id = 0;
        try{
            id = pspVal.getpId();
        }catch(NullPointerException npe){
            npe.getMessage();
            Util.debug("psp Value not initialized");
        }catch(Exception e){
            e.getMessage();
            Util.debug("psp Value is " + pspVal.getpId() );
        }
        return id;
    }
}
