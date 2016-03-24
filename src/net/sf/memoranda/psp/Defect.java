package net.sf.memoranda.psp;

import java.io.File;
import java.util.Date;

public interface Defect extends Psp {

	
	public boolean loadTestData(String path, String name); //used in constructor elsewhere if needed
	public boolean saveTestData(String path, String name); //creates and saves file using current data
	
	// setters and getters
	public String getFileName();
	
	public String getUserName();
	
	public boolean setUserName(String name);
	
	public int getDefectNum();
	
	public boolean setDefectNum(int num);
	
	public Date getDate();
	
	public boolean setDate(Date date);
	
	public String getType();
	
	public boolean setType(String type);
	
	public String getInjectionPhase();
	
	public boolean setInjectionSite(String injectPhase);
	
	public String getRemovalPhase();
	
	public boolean setRemovalPhase(String removalPhase);
	
	public String getFixDetails();
	
	public boolean setFixDetails(String fix);
}
