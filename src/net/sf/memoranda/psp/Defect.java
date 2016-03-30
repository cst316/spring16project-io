package net.sf.memoranda.psp;

import java.util.ArrayList;

public interface Defect {

	
	//public boolean loadTestData(String path, String name); //used in constructor elsewhere if needed
	//public boolean saveTestData(String path, String name); //creates and saves file using current data
	

	public ArrayList<TestRowObject> getRowObject();
	
	public boolean setRowObject(ArrayList<TestRowObject> list);

	public boolean addRow(TestRowObject rowObj);
	
	public boolean removeRow(int i);
	
	public boolean getIsDirty();
}
