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
import net.sf.memoranda.psp.TimeLog;
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
	
	private TimeRowObject timeEntries;
	
	private JTextField dateTextField;
	private JTextField startTimeTextField;
	private JTextField interruptTimeTextField;
	private JComboBox<String> phaseTextField;
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


	/**
	 * Create the panel.
	 */
	public PSP_TimeLog() {		
		jInit();
	}
	
	/**
	 * Create the panel.
	 */
	public PSP_TimeLog(TimeLog timelog) {	
		try{
			jInit();
		} catch (Exception ex) {
			Util.debug("Exception while trying to intilize PSP_TimeLog GUI");
			new ExceptionDialog(ex);
			ex.printStackTrace();
		}
	}
	
	public void jInit () {
		setBounds(0, 0, PSP_Panel.currentView.getWidth(), PSP_Panel.currentView.getHeight());
		setBackground(Color.WHITE);
        
		int xSpace = (getWidth() - 200) / 2 ;
        JLabel lblTimeLogEntries = new JLabel("Time Log Entries");
        lblTimeLogEntries.setBounds(xSpace, 15, 250, 40);
        lblTimeLogEntries.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 18));
        lblTimeLogEntries.setHorizontalAlignment(SwingConstants.CENTER);
        lblTimeLogEntries.setIcon(
	            new ImageIcon(
	                net.sf.memoranda.ui.AppFrame.class.getResource
	                ("resources/icons/time.png")));
        this.add(lblTimeLogEntries);
        
        bttnDone = new JButton();                
        add(bttnDone);
        bttnDone.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		bttnDoneAction();
        	}
        });
        bttnDone.setText("Done");
        
        xSpace = (getWidth() - 930) / 2;
        containsTimeLogs = new JPanel();
        containsTimeLogs.setBounds(xSpace, 75, 930, getHeight() - 105);
		this.add(containsTimeLogs);
		containsTimeLogs.setBackground(Color.WHITE);
		containsTimeLogs.setLayout(null);
		
		JPanel eachTimeLog = new JPanel();
		eachTimeLog.setBounds(0, 40, containsTimeLogs.getWidth(), containsTimeLogs.getHeight() - 100);
		containsTimeLogs.add(eachTimeLog);
		eachTimeLog.setLayout(new BorderLayout());
        setLayout(null);
		
		spTimeLog = new JScrollPane();
		spTimeLog.setBorder(null);
		eachTimeLog.add(spTimeLog);
		spTimeLog.setHorizontalScrollBarPolicy
				(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spTimeLog.setBounds(0, 40, containsTimeLogs.getWidth(), containsTimeLogs.getHeight() - 100);
		
		pnlEachLog = new JPanel();
		spTimeLog.setViewportView(pnlEachLog);
		pnlEachLog.setLayout(null);
		pnlEachLog.setBounds(0, 75, containsTimeLogs.getWidth(), containsTimeLogs.getHeight() - 100);
		pnlEachLog.setBackground(Color.WHITE);
		
		addTimeLog ();
        this.add(containsTimeLogs);
        
        JLabel dateLabel = new JLabel("Date");
        dateLabel.setBounds(85, 0, 105, 25);
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        containsTimeLogs.add(dateLabel);
        
        JLabel startTimeLabel = new JLabel("Start Time");
        startTimeLabel.setBounds(210, 0, 105, 25);
        startTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        containsTimeLogs.add(startTimeLabel);
        
        JLabel interruptTimeLabel = new JLabel("Interrupt Time");
        interruptTimeLabel.setBounds(335, 0, 105, 25);
        interruptTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        containsTimeLogs.add(interruptTimeLabel);
        
        JLabel endTimeLabel = new JLabel("End Time");
        endTimeLabel.setBounds(460, 0, 105, 25);
        endTimeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        containsTimeLogs.add(endTimeLabel);
        
        JLabel phaseLabel = new JLabel("Phase");
        phaseLabel.setBounds(585, 0, 250, 25);
        phaseLabel.setHorizontalAlignment(SwingConstants.CENTER);
        containsTimeLogs.add(phaseLabel);
        
        JLabel addMoreLogsLabel = new JLabel("(+/-) Logs");
        addMoreLogsLabel.setBounds(855, 0, 75, 25);
        addMoreLogsLabel.setHorizontalAlignment(SwingConstants.CENTER);
        containsTimeLogs.add(addMoreLogsLabel);
        
        xSpace = xSpace + containsTimeLogs.getWidth() - 80;
        bttnDone.setBounds(xSpace, getHeight() - 50, 80, 25);              
	}
	
	private void bttnDoneAction(){
		boolean dirty = false;
		
		timeEntries = new TimeRowObject();
		for(int i = 0; i < addButtonList.size(); ++i){
			if(dateTextField.getText() != null &&
					startTimeTextField.getText() != null &&
					interruptTimeTextField.getText() != null &&
					endTimeTextField.getText() != null &&
					phaseTextField.getSelectedIndex() != -1){
				
				setTimeLogDate(timeEntries, dateTextField.getText());
				setTimeLogStartTime(timeEntries, startTimeTextField.getText());
				setTimeLogInterruptTime(timeEntries, interruptTimeTextField.getText());
				setTimeLogEndTime(timeEntries, endTimeTextField.getText());
				setTimeLogPhase(timeEntries, phaseTextField.getSelectedIndex());
				
				dirty = true;
			}				
		}
		
		setIsDirty(dirty);
		
		if(dirty){
			JOptionPane.showMessageDialog(App.getFrame(),
					Local.getString("Time Log saved"));
		}else{
			JOptionPane.showMessageDialog(App.getFrame(),
					Local.getString("Error in saving Time Log\n" +
							"Check that all fields are filled in and try again"));
		}
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
	
	private void addTimeLog () {	
		int width = containsTimeLogs.getWidth();
		int height = 25;
		int x = 0;
		int y = (addButtonList.size() == 0 ? 0 : 
			addButtonList.get(addButtonList.size() - 1).getY() + height + 15);

		btnAddModule = new JButton("");
		btnAddModule.setBorder(null);
		btnAddModule.setBounds(880, 0, 25, 25);
		btnAddModule.setBackground(Color.WHITE);
		actionList.add(btnAddModule);
				
		dateTextField = new JTextField();
		dateTextField.setBounds(85, 0, 105, 25);
		dateTextField.setText(getDateTime(date, 0));
		dateTextField.setToolTipText("Date you worked on the project: mm/dd/yy");
		dateTxtList.add(dateTextField);
		
		startTimeTextField = new JTextField();
		startTimeTextField.setBounds(210, 0, 105, 25);
		startTimeTextField.setColumns(10);
		startTimeTextField.setToolTipText("Time started working on project: (hh:mm am/pm) 12 hour format");
		startTimeList.add(startTimeTextField);
	
		interruptTimeTextField = new JTextField();
		interruptTimeTextField.setBounds(335, 0, 105, 25);
		interruptTimeTextField.setColumns(10);
		interruptTimeTextField.setToolTipText("Interrupt time for this time entry (hh.mm)");
		interruptTimeList.add(interruptTimeTextField);
		
		endTimeTextField = new JTextField();
		endTimeTextField.setBounds(460, 0, 105, 25);
		endTimeTextField.setColumns(10);
		endTimeTextField.setToolTipText("Time done working on project: (hh:mm am/pm) 12 hour format");
		endTimeList.add(endTimeTextField);
		
		phaseTextField = new JComboBox<String>(phases);
		phaseTextField.setBounds(585, 0, 250, 25);
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
		
		for (Component c : holdItems.getComponents()) {
			if ( c instanceof JTextField) {
				((JTextField) c).setHorizontalAlignment(SwingConstants.CENTER);
			}
		}
		
		addButtonList.add(holdItems);
		
		remActionListener(actionList);
		repaintPanel (addButtonList, actionList, pnlEachLog);
		addModActionListner(actionList);
		pnlEachLog.setPreferredSize(new Dimension (width, y + height));
	}
	
	/**
	 * Removing a specific row of items from the display
	 * @param e - takes in an ActionEvent as to know which specific
	 * item to remove from the display of file items
	 */
	private void removeTimeLog (ActionEvent e) {	
		int width = containsTimeLogs.getWidth();
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
			y += height + 15;
		}		
		
		repaintPanel (addButtonList, actionList, pnlEachLog);
		addModActionListner(actionList);
		pnlEachLog.setPreferredSize(new Dimension (width, y));
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
		

		spTimeLog.setVerticalScrollBarPolicy
			(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
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