package net.sf.memoranda.psp;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.sf.memoranda.ui.App;
import net.sf.memoranda.util.Local;
import net.sf.memoranda.util.Util;

/**
 * 
 * @author Joe Michaels
 * @author Team-IO
 * CST316 - Spring 2016
 * Object to manipulate development statistics and easily save/retrieve needed data
 * 
 * 03/28/2016
 */

public class DevRowObject implements Serializable{
	

	private static final long serialVersionUID = -5963248021152547526L;
	private Date startDate, endDate, estDate;
	private String taskName, status;
	private int priority, estimate;
	private float percentDone, actualComplete;
	private String closingComment, description;
	
	public DevRowObject(){
		this.startDate = null;
		this.endDate = null;
		this.estDate = null;
		this.taskName = "";
		this.status = "";
		this.priority = -1;
		// must be 1 incase percent complete is called to be calculated
		this.estimate = 1; 
		this.actualComplete = 0;
		
		this.percentDone = calcPercentDone();
	}
	
	public DevRowObject(Date startDate, Date endDate, Date estDate,
			String taskName, String status, int priority, int estimate,
			float actualComplete){
		this.startDate = startDate;
		this.endDate = endDate;
		this.estDate = estDate;
		this.taskName = taskName;
		this.status = status;
		this.priority = priority;
		
		// must be 1 incase percent complete is called to be calculated
		this.estimate = estimate; 
		this.actualComplete = actualComplete;
		
		//this.percentDone = calcPercentDone();
	}
	
	public Date setDate(String strDate) {
		Date date = new Date();
		DateFormat df ; 
		df = new SimpleDateFormat("MM/dd/yy");
		try {
			date = df.parse(strDate);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(App.getFrame(),
					Local.getString("Invalid date entry mm\\dd\\yy"));
			e.printStackTrace();
		}
		
		return date;
	}
	
	/**
	 * 
	 * @return value calculates value of percent of the project done based on estimates
	 * @throws Exception in the off chance this 
	 * method is called and estimate is set to 0
	 */
	private float calcPercentDone(){
		float value;
		
		try{
			value = this.actualComplete/this.estimate;
		}catch(Exception e){
			e.getMessage();
			value = 0;
		}
		return value;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = this.setDate(startDate);		
	}
	
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = this.setDate(endDate);
	}
	public Date getEstDate() {
		return estDate;
	}
	public void setEstDate(String estDate) {
		this.estDate = this.setDate(estDate);
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getEstimate() {
		return estimate;
	}
	public void setEstimate(int estimate) {
		this.estimate = estimate;
	}
	public float getActualComplete() {
		return actualComplete;
	}
	public void setActualComplete(float actualComplete) {
		this.actualComplete = actualComplete;
	}
	
	public void setPercentComplete(float percentComplete) {
		this.percentDone = percentComplete;
	}
	
	public float getPercentComplete(){
		return this.percentDone;
	}
	
	public void setCloseComment(String comment) {
		
		this.closingComment = comment;
	}
	
	public String getCloseComment() {
	
		return this.closingComment;
	
	}
	
	public void setDescription (String comment) {
		
		this.description = comment;
	}
	
	public String getDescription () {	
		return this.description;	
	}
}
