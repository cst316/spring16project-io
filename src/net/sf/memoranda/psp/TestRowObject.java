package net.sf.memoranda.psp;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Joe Michaels
 * @author Team-IO
 * CST316 - Spring 2016
 * This class is designed to easily hold and manipulate data
 * from a row in the psp testing classes (not for junit tests).
 * 03/015/2016
 */

public class TestRowObject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4935113146958069224L;
	private String project;
	private Date date;
	private int defNumber;
	private String defType;
	private String injPhase;
	private String remPhase;
	private String fix;
	private String fixRef;
	
	public TestRowObject(){
		this.project = null;
		this.date = null;
		this.defNumber = 0;
		this.defType = null;
		this.injPhase = null;
		this.remPhase = null;
		this.fix = null;
		this.fixRef = null;
	}
	
	public TestRowObject(String project, Date date, int defNumber, String defType, String injPhase, String remPhase,
			String fix, String fixRef) {
		this.project = project;
		this.date = date;
		this.defNumber = defNumber;
		this.defType = defType;
		this.injPhase = injPhase;
		this.remPhase = remPhase;
		this.fix = fix;
		this.fixRef = fixRef;
	}
	
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getDefNumber() {
		return defNumber;
	}
	public void setDefNumber(int defNumber) {
		this.defNumber = defNumber;
	}
	public String getDefType() {
		return defType;
	}
	public void setDefType(String defType) {
		this.defType = defType;
	}
	public String getInjPhase() {
		return injPhase;
	}
	public void setInjPhase(String injPhase) {
		this.injPhase = injPhase;
	}
	public String getRemPhase() {
		return remPhase;
	}
	public void setRemPhase(String remPhase) {
		this.remPhase = remPhase;
	}
	public String getFix() {
		return fix;
	}
	public void setFix(String fix) {
		this.fix = fix;
	}
	public String getFixRef() {
		return fixRef;
	}
	public void setFixRef(String fixRef) {
		this.fixRef = fixRef;
	}
	
}
