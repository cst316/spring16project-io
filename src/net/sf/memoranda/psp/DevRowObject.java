package net.sf.memoranda.psp;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @author Joe Michaels
 * @author Team-IO
 * CST316 - Spring 2016
 * Object to manipulate development statistics
 * 
 * 03/28/2016
 */

public class DevRowObject implements Serializable{
	

	private static final long serialVersionUID = -5963248021152547526L;
	private Date startDate, endDate, estDate;
	private String taskName, status;
	private int priority, estimate;
	private float percentDone, actualComplete;
	
	public DevRowObject(){
		this.startDate = null;
		this.endDate = null;
		this.estDate = null;
		this.taskName = null;
		this.status = null;
		this.priority = 0;
		
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
		
		this.percentDone = calcPercentDone();
	}
	
	private float calcPercentDone(){
		float temp;
		
		try{
			temp = this.actualComplete/this.estimate;
		}catch(Exception e){
			e.getMessage();
			temp = 0;
		}
		return temp;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Date getEstDate() {
		return estDate;
	}
	public void setEstDate(Date estDate) {
		this.estDate = estDate;
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
	
	public float getPercentComplete(){
		return this.percentDone = calcPercentDone();
	}
	
}
