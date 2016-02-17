package net.sf.memoranda.psp;

import net.sf.memoranda.date.CurrentDate;

public interface Psp {
	
	final static int pID = 1;

	public CurrentDate getStDate();
	public void setStDate(CurrentDate stDate);
	public String getName();
	public void setName(String name);
	public String getDescription();
	public void setDescription(String description);
}
