package net.sf.memoranda.psp;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import net.sf.memoranda.util.Util;

public class DefectImpl implements Defect, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8961650030847897462L;
	private static boolean isDirty = false;
	private Psp pspVal;
	private ArrayList<TestRowObject> testObj = new ArrayList<TestRowObject>();
	//private String path = ""; //temp values until rest of class is implemented
	
	public DefectImpl(){
		this.testObj = null;
		//path = null;
	}
	
	public DefectImpl(ArrayList<TestRowObject> list){
		super();
		this.testObj = list;
	}
	
	@Override
	public ArrayList<TestRowObject> getRow() {
		return this.testObj;
	}

	@Override
	public boolean setRow(ArrayList<TestRowObject> list) {
		isDirty = true;
		this.testObj = list;
		return false;
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
	
//	/**
//	 * Saves row object passed in resets isDirt value to false if status succeeds
//	 * @param obj
//	 * @return true if no errors are thrown
//	 */
//	public boolean saveData(TestRowObject obj){
//		boolean status = true;
//		try {
//			ObjectOutputStream oos = new ObjectOutputStream (
//					new FileOutputStream (".proj" + File.separator + pspVal.getpId() +
//							File.separator + pspVal.getpId() +"_defect"));
//			oos.writeObject(obj);
//			oos.close();
//		} catch (IOException e) {
//			e.getMessage();
//			status = false;
//		}catch(Exception e){
//			e.getMessage();
//			status = false;
//		}
//
//		if(status == true){
//			isDirty = false;
//		}
//		return status;
//	}
//
//	/**
//	 * Takes in raw test row data and saves file from the data
//	 * Saves row object and resets isDirt value to false if status succeeds 
//	 * @param date
//	 * @param defNum
//	 * @param defType
//	 * @param injPhase
//	 * @param remPhase
//	 * @param fix
//	 * @param fixRef
//	 * @return true if no errors are thrown
//	 */
//	public boolean saveData(Date date, int defNum, String defType, String injPhase,
//			String remPhase, String fix, String fixRef){
//		boolean status = true;
//		ObjectOutputStream oos;
//		
//		String projectName = pspVal.getName();
//		TestRowObject tro = new TestRowObject(projectName, date, defNum, defType,
//				injPhase, remPhase, fix, fixRef);
//		
//		try {
//			oos = new ObjectOutputStream (
//					new FileOutputStream (".proj" + File.separator + pspVal.getpId() +
//							File.separator + pspVal.getpId() +"_defect"));
//			oos.writeObject(tro);
//			oos.close();
//			
//		} catch (IOException e) {
//			e.getMessage();
//			status = false;
//		}catch(Exception e){
//			e.getMessage();
//			status = false;
//		}		
//		if(status == true){
//			isDirty = false;
//		}
//		return status;
//	}
//	
//	/**
//	 * save serialized object
//	 * @return success of output, false if error occurs
//	 */
//	public boolean saveData(){
//		boolean status = true;
//		try{
//		ObjectOutputStream oos = new ObjectOutputStream (
//				new FileOutputStream (".proj" + File.separator + pspVal.getpId() +
//						File.separator + pspVal.getpId() +"_defect"));
//		oos.writeObject(this.testObj);
//		oos.close();
//		}catch (IOException e) {
//			e.getMessage();
//			status = false;
//		}catch(Exception e){
//			e.getMessage();
//			status = false;
//		}		
//		if(status == true){
//			isDirty = false;
//		}
//		return status;
//	}

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
