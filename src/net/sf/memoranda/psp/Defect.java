package net.sf.memoranda.psp;

import java.util.ArrayList;

/**
 * 
 * interface for DefectImpl class
 * @author Joe Michaels
 *
 */
public interface Defect {

	public void setPspValues (Psp pspValues);
	
	public Psp getPspValues ();	

	public ArrayList<TestRowObject> getRowObject();

	public boolean setRowObject(ArrayList<TestRowObject> list);

	public boolean removeRow(TestRowObject rowObj);
	
	public boolean removeRow(int index);
	
	public boolean editRow (int index, TestRowObject editThis);
}
