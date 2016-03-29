package net.sf.memoranda.psp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import net.sf.memoranda.util.Util;

public class TimeLogImpl implements TimeLog, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3790546736695557381L;
	
	
	
	public TimeLogImpl () {
		
	}
	
	public TimeLogImpl (Psp pspValue) {
		
	}
	
	
	
	
	
	
	
	
	/**
	 * Implement custom object reader
	 * @param stream
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
		stream.defaultReadObject();
		Util.debug("Psp retrieved");
	}
	
	/**
	 * Implement custom object writer
	 * @param stream
	 * @throws IOException
	 */
	private void writeObject(ObjectOutputStream stream) throws IOException {
		stream.defaultWriteObject();
		Util.debug("Psp wrtten");
	}	
}
