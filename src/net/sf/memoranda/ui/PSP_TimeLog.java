package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

import net.sf.memoranda.psp.Psp;
import net.sf.memoranda.psp.TimeLog;
import net.sf.memoranda.psp.TimeLogImpl;
import net.sf.memoranda.psp.TimeRowObject;
import net.sf.memoranda.util.Local;
import net.sf.memoranda.util.Util;

import javax.swing.ImageIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SuppressWarnings("rawtypes")
public class PSP_TimeLog extends JPanel {
	
	private static final long serialVersionUID = -9032126534041955899L;

	private static boolean isDirty = false;
	
	private String[] phases = {"Planning", "Design", "Code", 
			"Code Review", "Test", "Postmortem"};
	
	private JButton bttnDone;
	
	//private TimeRowObject timeEntries;
	
	private JTextField dateTextField;
	private JTextField startTimeTextField;
	private JTextField interruptTimeTextField;
	private JComboBox phaseTextField;
	private JTextField endTimeTextField;
	private JButton btnAddModule;

	private List <JTextField> dateTxtList = new ArrayList <JTextField>();
	private List <JTextField> startTimeList = new ArrayList <JTextField>();
	private List <JTextField> interruptTimeList = new ArrayList <JTextField>();
	private List <JComboBox> phaseList = new ArrayList <JComboBox>();
	private List <JTextField> endTimeList = new ArrayList <JTextField>();
	private List <JPanel> addButtonList = new ArrayList <JPanel> ();
	private List <JButton> actionList = new ArrayList <JButton> ();
	
	private JPanel pnlEachLog;
	private JPanel containsTimeLogs;
	private JScrollPane spTimeLog;
	
	private Date date = new Date(); 
	
	private TimeLog timelog;


	/**
	 * Create the panel.
	 */
	public PSP_TimeLog() {		
		try {
			jInit();
		}
		catch(Exception ex) {
			new ExceptionDialog(ex);
			ex.printStackTrace();
		}
	}
	/**
	 * Create the panel.
	 */
	public PSP_TimeLog(TimeLog timelog) {	
		try{
			this.timelog = timelog;
			jInit();
		} catch (Exception ex) {
			System.out.println("Exception while trying to intilize PSP_TimeLog GUI");
			new ExceptionDialog(ex);
			ex.printStackTrace();
		}
	}
	
	public PSP_TimeLog(Psp pspVal) {
		this.timelog = new TimeLogImpl(pspVal);
		jInit();
	}
	
	public void jInit () {
		this.setBounds(0, 0, 1262, 743);
		this.setBackground(Color.WHITE);
        
        JLabel lblTimeLogEntries = new JLabel("Time Log Entries");
        lblTimeLogEntries.setBounds(597, 13, 189, 40);
        lblTimeLogEntries.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 18));
        lblTimeLogEntries.setHorizontalAlignment(SwingConstants.CENTER);
        lblTimeLogEntries.setIcon(
	            new ImageIcon(
	                net.sf.memoranda.ui.AppFrame.class.getResource
	                ("resources/icons/time.png")));
        this.add(lblTimeLogEntries);
        
        containsTimeLogs = new JPanel();
        containsTimeLogs.setBounds(0, 75, 1276, 583);
		this.add(containsTimeLogs);
		containsTimeLogs.setBackground(Color.WHITE);
		containsTimeLogs.setLayout(null);
		
		JPanel eachTimeLog = new JPanel();
		eachTimeLog.setBounds(0, 75, 1276, 508);
		containsTimeLogs.add(eachTimeLog);
		eachTimeLog.setLayout(new BorderLayout());
        setLayout(null);
		
		/*bttnDone = new JButton("Done");
		bttnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					bttnDoneAction();
			}
		});
		bttnDone.setBounds(1047, 394, 97, 25);
		bttnDone.setToolTipText("Save Time Log");
		eachTimeLog.add(bttnDone);*/
		
		spTimeLog = new JScrollPane();
		spTimeLog.setBorder(null);
		eachTimeLog.add(spTimeLog);
		spTimeLog.setHorizontalScrollBarPolicy
				(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spTimeLog.setBounds(0, 75, 1276, 508);
		
		pnlEachLog = new JPanel();
		spTimeLog.setViewportView(pnlEachLog);
		pnlEachLog.setLayout(null);
		pnlEachLog.setBounds(0, 75, 1276, 508);
		pnlEachLog.setBackground(Color.WHITE);
		
		addTimeLog ();
        this.add(containsTimeLogs);
        
        JLabel dateLabel = new JLabel("Date");
        dateLabel.setBounds(84, 26, 26, 40);
        containsTimeLogs.add(dateLabel);
        
        JLabel startTimeLabel = new JLabel("Start Time");
        startTimeLabel.setBounds(274, 22, 61, 40);
        containsTimeLogs.add(startTimeLabel);
        
        JLabel interruptTimeLabel = new JLabel("Interrupt Time");
        interruptTimeLabel.setBounds(507, 22, 83, 40);
        containsTimeLogs.add(interruptTimeLabel);
        
        JLabel endTimeLabel = new JLabel("End Time");
        endTimeLabel.setBounds(736, 26, 59, 40);
        containsTimeLogs.add(endTimeLabel);
        
        JLabel phaseLabel = new JLabel("Phase");
        phaseLabel.setBounds(952, 22, 83, 40);
        containsTimeLogs.add(phaseLabel);
        
        JLabel addMoreLogsLabel = new JLabel("Add More Logs");
        addMoreLogsLabel.setBounds(1109, 34, 98, 16);
        containsTimeLogs.add(addMoreLogsLabel);
        
        bttnDone = new JButton();
        bttnDone.setBounds(1185, 2, 65, 45);
        containsTimeLogs.add(bttnDone);
        bttnDone.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		bttnDoneAction();
        	}
        });
        bttnDone.setText("Done");
        pnlEachLog.add(bttnDone);
        
        addTimeLog ();
    	if (timelog.getTimeRowLists().size() > 0) {
			updateTimeRowPanels();
		}

        
	}
	
	private void bttnDoneAction(){
		boolean dirty = false;
		
		//timeEntries = new TimeRowObject();
		for(int i = 0; i < actionList.size(); ++i){
			//Adding some guards so we are not adding empty data
			if (!dateTxtList.get(i).getText().isEmpty() &&
				!startTimeList.get(i).getText().isEmpty() &&
				!interruptTimeList.get(i).getText().isEmpty() &&
				!endTimeList.get(i).getText().isEmpty() &&
				!(phaseList.get(i).getSelectedIndex() == -1)) {
			
				dateTxtList.get(i).setEditable(false);
				startTimeList.get(i).setEditable(false);
				interruptTimeList.get(i).setEditable(false);
				endTimeList.get(i).setEditable(false);
				phaseList.get(i).setEditable(false);
				
				//using edit to implement add and edit both
				timelog.editRow (i, this.createTestRow(i));
				
				//If dirt is not set already, then set it, else no need
				if (!dirty) {
					dirty = true;
					setIsDirty(dirty);
				}
			}				
		}
		
		if(dirty){
			JOptionPane.showMessageDialog(App.getFrame(),
					Local.getString("Time Log saved"));
		}else{
			JOptionPane.showMessageDialog(App.getFrame(),
					Local.getString("Error in saving Time Log\n" +
							"Check that all fields are filled in and try again"));
		}
	}
	
	private void updateTimeRowPanels() {
		// TODO Auto-generated method stub
		//timelog.getTimeRowLists()
		for (int i = 0; i < timelog.getTimeRowLists().size(); i++) {
			startTimeList.get(i).setText(getDateTime (timelog.getTimeRowLists().get(i).getStartTime(), 1));
			dateTxtList.get(i).setText(getDateTime (timelog.getTimeRowLists().get(i).getDate(), 0));
			interruptTimeList.get(i).setText(""
					+ timelog.getTimeRowLists().get(i).getInterruptTime());
			endTimeList.get(i).setText(getDateTime(timelog.getTimeRowLists().get(i).getEndTime(), 1));
			//phaseList.get(i).setText(timelog.getTimeRowLists().get(i).getPhase());
			
			//Disabling text field objects from editing unless you click on edit button
			for (Component t : this.addButtonList.get(i).getComponents())
			{
				if (t instanceof JTextField) {
					((JTextField) t).setEditable(false);
				}
			}
			buttonAction_Clicked ("ADD_MOD");
		}			
	}
	
	private TimeRowObject createTestRow(int index) {
		// TODO Auto-generated method stub		
		TimeRowObject my_timeRow = new TimeRowObject();
		my_timeRow.setDate(dateTxtList.get(index).getText());
		my_timeRow.setStartTime(startTimeList.get(index).getText());
		my_timeRow.setInterruptTime(
				Float.parseFloat(interruptTimeList.get(index).getText()));
		my_timeRow.setEndTime(endTimeList.get(index).getText());
		//my_timeRow.setPhase(phaseList.get(index).getText());
		
		return my_timeRow;
	}
	
	/**
	 * 
	 * @param timeEntries TimeRowObject for saving purposes
	 * @param date the date of the time log entry
	 * Sets the date of the time log entry
	 */
	public static void setTimeLogDate(TimeRowObject timeEntries, String date){
		timeEntries.setDate(date);
	}
	
	/**
	 * 
	 * @param timeEntries TimeRowObject for saving purposes
	 * @param startTime the start time of the time log entry
	 * NumberFormatException is caught if startTime cannot be converted to a Float
	 * Sets the start time of the time log entry
	 */
	public static void setTimeLogStartTime(TimeRowObject timeEntries, String startTime){
		try{
			timeEntries.setStartTime(startTime);
		}catch(NumberFormatException e){
			Util.debug("Unable to convert time entered, check format \"hh:mm a\"");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param timeEntries TimeRowObject for saving purposes
	 * @param interruptTime the interrupt time of the time log entry
	 * NumberFormatException is caught if interruptTime cannot be converted to a Float
	 * Sets the interrupt time of the time log entry
	 */
	public static void setTimeLogInterruptTime(TimeRowObject timeEntries, String interruptTime){
		try{
			timeEntries.setInterruptTime(Float.parseFloat(interruptTime));
		}catch(NumberFormatException e){
			Util.debug("Unable to convert interruptTime to Float");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param timeEntries TimeRowObject for saving purposes
	 * @param endTime the end time of the time log entry
	 * NumberFormatException is caught if endTime cannot be converted to a Float
	 * Sets the end time of the time log entry
	 */
	public static void setTimeLogEndTime(TimeRowObject timeEntries, String endTime){
		try{
			timeEntries.setEndTime(endTime);
		}catch (NumberFormatException e){
			Util.debug("Unable to convert time entered, check format \"hh:mm a\"");
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param timeEntries TimeRowObject for saving purposes
	 * @param phase the phase of the time log entry
	 * Sets the phase of the time log entry
	 */
	public static void setTimeLogPhase(TimeRowObject timeEntries, int phase){
		String strPhase = "";
		switch(phase){
			case 1:
				strPhase = "Planning";
				break;
			case 2:
				strPhase = "Design";
				break;
			case 3:
				strPhase = "Code";
				break;
			case 4:
				strPhase = "Code Review";
				break;
			case 5:
				strPhase = "Test";
				break;
			case 6:
				strPhase = "Postmortem";
				break;
		}
		timeEntries.setPhase(strPhase);
	}
	
	@SuppressWarnings("unchecked")
	private void addTimeLog () {	
		int width = 1270;
		int height = 25;
		int x = 0;
		int y = (addButtonList.size() == 0 ? 0 : 
			addButtonList.get(addButtonList.size() - 1).getY() + height + 5);

		btnAddModule = new JButton("");
		btnAddModule.setBorder(null);
		btnAddModule.setBounds(1140, 0, 25, 25);
		btnAddModule.setBackground(Color.WHITE);
		actionList.add(btnAddModule);
		
		
		dateTextField = new JTextField();
		dateTextField.setBounds(80, 0, 130, 22);
		dateTextField.setText(getDateTime(date, 0));
		dateTextField.setToolTipText("Date you worked on the project: mm/dd/yy");
		dateTxtList.add(dateTextField);
		
		startTimeTextField = new JTextField();
		startTimeTextField.setBounds(228, 0, 153, 22);
		startTimeTextField.setColumns(10);
		startTimeTextField.setToolTipText("Time started working on project: (hh:mm am/pm) 12 hour format");
		startTimeList.add(startTimeTextField);
	
		interruptTimeTextField = new JTextField();
		interruptTimeTextField.setBounds(475, 0, 153, 22);
		interruptTimeTextField.setColumns(10);
		interruptTimeTextField.setToolTipText("Interrupt time for this time entry (hh.mm)");
		interruptTimeList.add(interruptTimeTextField);
		
		endTimeTextField = new JTextField();
		endTimeTextField.setBounds(695, 0, 153, 22);
		endTimeTextField.setColumns(10);
		endTimeTextField.setToolTipText("Time done working on project: (hh:mm am/pm) 12 hour format");
		endTimeList.add(endTimeTextField);
		
		phaseTextField = new JComboBox(phases);
		phaseTextField.setBounds(904, 0, 153, 22);
		phaseTextField.setSelectedIndex(-1);
		phaseTextField.setToolTipText("Phase of project");
		phaseList.add(phaseTextField);
		
		
		JPanel holdItems = new JPanel();
		holdItems.setBackground(Color.WHITE);
		holdItems.setLayout(null);
		holdItems.add(dateTextField);
		holdItems.add(startTimeTextField);
		holdItems.add(btnAddModule);
		holdItems.add(interruptTimeTextField);
		holdItems.add(endTimeTextField);
		holdItems.add(phaseTextField);
		holdItems.setBounds(x, y, width, height);
		addButtonList.add(holdItems);
		
		remActionListener(actionList);
		repaintPanel (addButtonList, actionList, pnlEachLog);
		addModActionListner(actionList);
		pnlEachLog.setPreferredSize(new Dimension (width, y + height));
		spTimeLog.setVerticalScrollBarPolicy
			(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	/**
	 * Removing a specific row of items from the display
	 * @param e - takes in an ActionEvent as to know which specific
	 * item to remove from the display of file items
	 */
	private void removeTimeLog (ActionEvent e) {	
		int width = 1270;
		int height = 25;
		int x = 0;
		int y = 0;
		
		remActionListener (actionList);
		for (int i = 0; i < actionList.size(); i++) {
			if (e.getSource() == actionList.get(i)) {
				actionList.remove(i);
				addButtonList.remove(i);
				dateTxtList.remove(i);
				startTimeList.remove(i);
				interruptTimeList.remove(i);
				endTimeList.remove(i);
				phaseList.remove(i);
				break;
			}
		}
		
		for (int i = 0; i < actionList.size(); i++) {
			addButtonList.get(i).setBounds(x, y, width, height);
			y += height + 5;
		}		
		
		repaintPanel (addButtonList, actionList, pnlEachLog);
		addModActionListner(actionList);
		pnlEachLog.setPreferredSize(new Dimension (width, y));
		spTimeLog.setVerticalScrollBarPolicy
			(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	/**
	 * Repaints the Current JPanel due to the changes for add and remove
	 * @param repaintPnl - List of items within that panel
	 * @param iconBtn - buttons that need to have action listeners enabled
	 * @param whichPnl - panel to repaint changes onto
	 */
	private void repaintPanel (List<JPanel> repaintPnl, List<JButton> iconBtn, JPanel whichPnl) {
		String icon = "/net/sf/memoranda/ui/resources/icons/minus.png";			
		
		whichPnl.removeAll();
		for (int i = 0; i < repaintPnl.size(); i++) {
			whichPnl.add(repaintPnl.get(i));
			if (i == repaintPnl.size() - 1) { 
				icon = "/net/sf/memoranda/ui/resources/icons/plus.png";
				repaintPnl.get(i).getComponent(0).requestFocus();
			}
			iconBtn.get(i).setIcon(new ImageIcon(
					PSP_PlanningWizardFrame.class.getResource(icon)));	
		}
		whichPnl.revalidate();
		whichPnl.repaint();
	}
	
	/**
	 * Adding action listeners
	 * @param addB - module buttons to add action listener to
	 */
	private void addModActionListner (List<JButton> addB) {
		for (int i = 0; i < addB.size(); i++) {
			if (i == addB.size() - 1) {
				addB.get(i).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						buttonAction_Clicked ("ADD_MOD");
					}
				});
			} else {
				addB.get(i).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						removeTimeLog (e);
					}
				});
			}
		}		
	}
	
	private void remActionListener (List<JButton> remB) {
		for (int i = 0; i < remB.size(); i++) {
			for (ActionListener al : remB.get(i).getActionListeners()) 
				remB.get(i).removeActionListener(al);			
		}		
	}
	
	private void buttonAction_Clicked (String pan) {
		if (pan.equals("ADD_MOD")) {	
			addTimeLog ();	
		}
	}
	
	//Need date code 0 or time code 1 in a short format; Date/Time is part of the Date class
	private String getDateTime (Date d, int code) {
		DateFormat df = null;
		switch (code) {
			case 0:
				df = DateFormat.getDateInstance(DateFormat.SHORT);
				break;
			case 1:
				df = DateFormat.getTimeInstance(DateFormat.SHORT);
				break;
			default:
				Util.debug("Never should have gotten here");
		}		
		return (df.format(d));
	}
	
	public static void setIsDirty (boolean dirty) {
		isDirty = dirty;
		if (isDirty) {
			PSP_Panel.setIsDirty(true);
			PSP_Panel.myPanel.setSaveEnabled();
		}
	}

	public static boolean getIsDirty () {
		return isDirty;
	}	
}