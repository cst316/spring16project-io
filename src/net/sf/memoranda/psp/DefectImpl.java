package net.sf.memoranda.psp;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Date;

import net.sf.memoranda.date.CurrentDate;
import net.sf.memoranda.ui.ExceptionDialog;
import net.sf.memoranda.util.Util;

public class DefectImpl implements Defect {
	
	private ArrayList<TestRowObject> testObj = new ArrayList<TestRowObject>();
	//private String path = ""; //temp values until rest of class is implemented
	
	public DefectImpl(){
		this.testObj = null;
		//path = null;
	}
	
	public DefectImpl(File file){
		super();
		//loadTestData(file.getAbsolutePath(), file.getName());
	}

	@Override
	public CurrentDate getStDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setStDate(CurrentDate stDate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setpId(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getpId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setUserName(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getDefectNum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean setDefectNum(int num) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setDate(Date date) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setType(String type) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getInjectionPhase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setInjectionSite(String injectPhase) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getRemovalPhase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setRemovalPhase(String removalPhase) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getFixDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean setFixDetails(String fix) {
		// TODO Auto-generated method stub
		return false;
	}
	
	/**
	 * Saves row object passed in
	 * @param obj
	 * @return true if no errors are thrown
	 */
	public boolean saveData(TestRowObject obj){
		return true;
	}

	/**
	 * Takes in raw test row data and saves file from the data 
	 * @param date
	 * @param defNum
	 * @param defType
	 * @param injPhase
	 * @param remPhase
	 * @param fix
	 * @param fixRef
	 * @return true if no errors are thrown
	 */
	public boolean saveData(Date date, int defNum, String defType, String injPhase,
			String remPhase, String fix, String fixRef){
		
		return true;
	}

	/**
	 * Implement custom object reader
	 * @param stream
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		Util.debug("Planning retrieved");
	}
	
	/**
	 * Implement custom object writer
	 * @param stream
	 * @throws IOException
	 */
	private void writeObject(java.io.ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
		Util.debug("Planning wrtten");
	}

}
