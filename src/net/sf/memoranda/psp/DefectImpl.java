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
        isDirty = true;
        this.testObj = list;
        return true;
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
	
	public boolean removeRow(TestRowObject rowObj){
		boolean temp = true;
		isDirty = true;
		try{
			testObj.remove(rowObj);
		}catch(NullPointerException e){
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
	private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		Util.debug("object retrieved");
	}
	
	/**
	 * Implement custom object writer
	 * @param stream
	 * @throws IOException
	 */
	private void writeObject(java.io.ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
		Util.debug("object wrtten");
	}

	public boolean getIsDirty(){
		return isDirty;
	}
}

