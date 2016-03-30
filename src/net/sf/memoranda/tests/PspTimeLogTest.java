package net.sf.memoranda.tests;


import org.junit.Test;

import net.sf.memoranda.psp.TimeRowObject;
import net.sf.memoranda.ui.PSP_TimeLog;

public class PspTimeLogTest {

	private TimeRowObject timeEntries;
	
	private String date;
	private String startTime;
	private String interruptTime;
	private String endTime;
	private String phase;
	
	public void setUp() throws Exception{
		timeEntries = new TimeRowObject();
		date = "12/06/15";
		startTime = "12.30";
		interruptTime = "5.0";
		endTime = "3.00";
		phase = "PLANNING";
	}
	
	@Test
	public void testPSP_TimeLog(){
		/*PSP_TimeLog.setTimeLogDate(timeEntries, date);
		PSP_TimeLog.setTimeLogStartTime(timeEntries, startTime);
		PSP_TimeLog.setTimeLogInterruptTime(timeEntries, interruptTime);
		PSP_TimeLog.setTimeLogEndTime(timeEntries, endTime);
		PSP_TimeLog.setTimeLogPhase(timeEntries, phase);*/
	}
	

}
