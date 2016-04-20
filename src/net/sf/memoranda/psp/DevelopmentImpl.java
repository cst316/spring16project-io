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
	private Psp pspVal;
	
	public DevelopmentImpl(){
		rowObj = new ArrayList<DevRowObject> ();
	}
	
	public DevelopmentImpl(Psp psp){
		this();
		this.pspVal = psp;
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
		boolean isAdded = true;
		
		try{
			this.rowObj.add(rowObj);
		}catch(Exception e){
			e.printStackTrace();
			e.getMessage();
			isAdded = false;
			Util.debug("error adding row to DevRowObject");
		}
		return isAdded;
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
		boolean isRemoved = true;
		try{
			this.rowObj.remove(index);
		}catch(NullPointerException e){
			e.getMessage();
			isRemoved = false;
		    Util.debug("Null error removing row from rowObj at index" + index);
        }catch(Exception e){
            e.getMessage();
            isRemoved = false;
            Util.debug("error removing row to DevRowObject");
        }
		return isRemoved;
	}

	@Override
	public ArrayList<DevRowObject> getRow() {
		
		return this.rowObj;
	}
	
	@Override
	public boolean editRow (int index, DevRowObject rowObj) {
		boolean isEdited = true;
		try{
		    
    		this.rowObj.set(index, rowObj);
    		
		}catch(NullPointerException npe){
		    npe.getMessage();
		    Util.debug("null pointer thrown at index: " + index);
		    isEdited = false;
		}catch(Exception e){
            e.getMessage();
            isEdited = false;		    
		}
		
		return isEdited;
	}
    
	private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		Util.debug("Development retrieved");
	}
	
	private void writeObject(java.io.ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
		Util.debug("Development wrtten");
	}    
}
