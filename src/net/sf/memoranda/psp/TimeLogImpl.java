package net.sf.memoranda.psp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

import net.sf.memoranda.util.Util;

/**
 * 
 * @author Cephas Armstrong-Mensah
 * @author Team-IO
 * CST316 - Spring 2016, ASU Poly
 * This implementation, implements TimeLog.java interface
 * 03/29/2016
 */
public class TimeLogImpl implements TimeLog, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3790546736695557381L;
	
	private Psp pspValues;
	private Date date;
	private float startTime;
	private float endTime;
	private float interruptTime;
	private String phase;

	public TimeLogImpl () {
		
	}
	
	public TimeLogImpl (Psp pspValues) {
		this.pspValues = pspValues;
		this.date = new Date();
		this.startTime = 0.0f;
		this.endTime = 0.0f;
		this.interruptTime = 0.0f;
		this.phase = "";		
	}

	@Override
	public void setDate(Date date) {
		// TODO Auto-generated method stub
		this.date = date;
	}

	@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return date;
	}

	@Override
	public void setStartTime(float time) {
		// TODO Auto-generated method stub
		this.startTime = time;
	}

	@Override
	public float getStartTime() {
		// TODO Auto-generated method stub
		return this.startTime;
	}

	@Override
	public void setInterruptTime(float time) {
		// TODO Auto-generated method stub
		this.interruptTime = time;
	}

	@Override
	public float getInterruptTime() {
		// TODO Auto-generated method stub
		return this.interruptTime;
	}

	@Override
	public void setEndTime(float time) {
		// TODO Auto-generated method stub
		this.endTime = time;
	}

	@Override
	public float getEndTime() {
		// TODO Auto-generated method stub
		return this.endTime;
	}

	@Override
	public void setPhase(String phase) {
		// TODO Auto-generated method stub
		this.phase = phase;
	}

	@Override
	public String getPhase() {
		// TODO Auto-generated method stub
		return this.phase;
	}
		
	/**
	 * Implement custom object reader
	 * @param stream
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		Util.debug("Time Log retrieved");
	}
	
	/**
	 * Implement custom object writer
	 * @param stream
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
		Util.debug("Time Log wrtten");
	}
}
