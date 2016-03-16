package net.sf.memoranda.psp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Date;

import net.sf.memoranda.date.CurrentDate;
import net.sf.memoranda.ui.ExceptionDialog;

public class TestingImpl implements Testing {
	
	
	
	public TestingImpl(){
		
	}
	
	public TestingImpl(File file){
		super();
		loadTestData(file);
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
	public void save(FileOutputStream stream) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void open(FileInputStream streamOfFile) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int getPID() {
		// TODO Auto-generated method stub
		return 0;
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

	@Override
	public boolean loadTestData(File file) {
		boolean status = true;
		
		try{
			
			FileInputStream fileStream = new FileInputStream(file);
			ObjectInputStream obj = new ObjectInputStream(fileStream);
			
			
			
		}catch (IOException e) {
            new ExceptionDialog(e, "File not found!" , "");
            status = false;
        }catch(Exception e){
			e.getMessage();
			status = false;
		}
		return status;
	}

	@Override
	public boolean saveTestData() {
		// TODO Auto-generated method stub
		return false;
	}

}
