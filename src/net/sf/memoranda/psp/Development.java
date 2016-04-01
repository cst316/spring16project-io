package net.sf.memoranda.psp;

import java.util.ArrayList;

/**
 * 
 * @author Joe Michaels
 *	3/28/2016
 *	interface for development controller
 */
public interface Development {
	
	public void setPspValues (Psp pspValues);
	
	public Psp getPspValues ();
	
	public ArrayList<DevRowObject> getRow();
	
	public boolean setRow(ArrayList<DevRowObject> list);

	public boolean addRow(DevRowObject rowObj);
	
	public boolean removeRow(int i);
	
	public boolean getIsDirty();
}
