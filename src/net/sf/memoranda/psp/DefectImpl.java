package net.sf.memoranda.psp;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import net.sf.memoranda.util.Util;

/**
 * 
 * @author Joe Michaels
 *
 */
public class DefectImpl implements Defect, Serializable {
	
	private static final long serialVersionUID 
	                    = 8961650030847897462L;
	private static boolean isDirty;
	private Psp pspVal;
	private ArrayList<TestRowObject> testObj  
	                                = new ArrayList<TestRowObject>();
	//private String path = ""; //temp values until rest of class is implemented
	
	public DefectImpl(){
	    isDirty = false;
		this.testObj = null;
		//path = null;
	}
	
	public DefectImpl(ArrayList<TestRowObject> list){
	    isDirty = false;
		this.testObj = list;
	}
	
	
    public DefectImpl(ArrayList<TestRowObject> list, Psp pspVal){
        isDirty = false;
        this.testObj = list;
        this.pspVal = pspVal;
    }
	
	@Override
	public ArrayList<TestRowObject> getRowObject() {
		return this.testObj;
	}

	@Override
	public boolean setRowObject(ArrayList<TestRowObject> list) {
		boolean temp = true;
	    isDirty = true;
		this.testObj = list;
		return temp;
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
			Util.debug("error adding row to TestRowObject");
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
			Util.debug("Null error removing row to TestRowObject");
		}catch(Exception e){
            e.getMessage();
            temp = false;
            Util.debug("error removing row to TestRowObject");
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
	
	public static void setIsDirty(boolean dirty) {
        isDirty = dirty;
    }
	
	public int getPID(){
	    int id = 0;
	    try{
	        id = pspVal.getpId();
	    }catch(NullPointerException e){
	        e.getMessage();
	        Util.debug("psp Value not initialized");
	    }catch(Exception e){
	        e.getMessage();
	        Util.debug("psp Value is " + pspVal.getpId() );
	    }
	    return id;
	}

}