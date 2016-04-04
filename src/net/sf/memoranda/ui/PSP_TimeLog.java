package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import net.sf.memoranda.psp.TimeLog;
import net.sf.memoranda.psp.TimeRowObject;
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

public class PSP_TimeLog extends JPanel {
	
	private static final long serialVersionUID = -9032126534041955899L;

	private static boolean isDirty = false;
	
	private JButton bttnDone;
	
	private TimeLog timelog;
	private TimeRowObject timeEntries;
	
	private JTextField dateTextField;
	private JTextField startTimeTextField;
	private JTextField interruptTimeTextField;
	private JTextField phaseTextField;
	private JTextField endTimeTextField;
	private JButton btnAddModule;

	private List <JTextField> dateTxtList = new ArrayList <JTextField>();
	private List <JTextField> startTimeList = new ArrayList <JTextField>();
	private List <JTextField> interruptTimeList = new ArrayList <JTextField>();
	private List <JTextField> phaseList = new ArrayList <JTextField>();
	private List <JTextField> endTimeList = new ArrayList <JTextField>();
	private List <JPanel> addButtonList = new ArrayList <JPanel> ();
	private List <JButton> actionList = new ArrayList <JButton> ();
	
	private JPanel pnlEachLog;
	private JPanel pnlTimeLog;
	private JScrollPane spTimeLog;
	
	private Date date = new Date(); 
	
	/**
	 * Used in the phase entry
	 *
	 */
	public enum Phase{
		PLANNING, DESIGN, CODE, CODE_REVIEW, TEST, POSTMORTEM
	}

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
		this.timelog = timelog;
		try{
			jInit();
		} catch (Exception ex) {
			System.out.println("Exception while trying to intilize PSP_TimeLog GUI");
			new ExceptionDialog(ex);
			ex.printStackTrace();
		}
	}
	
	public void jInit () {
		this.setBounds(0, 0, 1262, 743);
		this.setBackground(Color.WHITE);
		
		
		JTextArea phaseKey = new JTextArea();
		phaseKey.setText("Phases of PSP:\n" +
		"\nPLANNING     \tDESIGN" +
		"\nCODE     \tCODE_REVIEW" + 
		"\nTEST     \tPOSTMORTEM");
		
		phaseKey.setBounds(900, 13, 300, 85);
		phaseKey.setToolTipText("Phase Key");
		phaseKey.setEditable(false);
		add(phaseKey);
        
        JLabel lblTimeLogEntries = new JLabel("Time Log Entries");
        lblTimeLogEntries.setBounds(597, 13, 189, 40);
        lblTimeLogEntries.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 18));
        lblTimeLogEntries.setHorizontalAlignment(SwingConstants.CENTER);
        lblTimeLogEntries.setIcon(
	            new ImageIcon(
	                net.sf.memoranda.ui.AppFrame.class.getResource
	                ("resources/icons/time.png")));
        
        bttnDone = new JButton();
        bttnDone.setBounds(620, 671, 65, 45);
        bttnDone.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		timeEntries = new TimeRowObject();
        		setTimeLogDate(timeEntries, dateTextField.getText());
        		setTimeLogStartTime(timeEntries, startTimeTextField.getText());
        		setTimeLogInterruptTime(timeEntries, interruptTimeTextField.getText());
        		setTimeLogEndTime(timeEntries, endTimeTextField.getText());
        		setTimeLogPhase(timeEntries, phaseTextField.getText());
        	}
        });
        setLayout(null);
        bttnDone.setText("Done");
        
        pnlTimeLog = new JPanel();
        pnlTimeLog.setBounds(0, 75, 1276, 583);
		this.add(pnlTimeLog);
		pnlTimeLog.setBackground(Color.WHITE);
		pnlTimeLog.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 75, 1276, 508);
		pnlTimeLog.add(panel_1);
		panel_1.setLayout(new BorderLayout());
		
		spTimeLog = new JScrollPane();
		spTimeLog.setBorder(null);
		panel_1.add(spTimeLog);
		spTimeLog.setHorizontalScrollBarPolicy
				(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		spTimeLog.setBounds(0, 75, 1276, 508);
		
		pnlEachLog = new JPanel();
		spTimeLog.setViewportView(pnlEachLog);
		pnlEachLog.setLayout(null);
		pnlEachLog.setBounds(0, 75, 1276, 508);
		pnlEachLog.setBackground(Color.WHITE);
		
		addTimeLog ();
        this.add(pnlTimeLog);
        
        JLabel dateLabel = new JLabel("Date");
        dateLabel.setBounds(84, 26, 26, 40);
        pnlTimeLog.add(dateLabel);
        
        JLabel startTimeLabel = new JLabel("Start Time");
        startTimeLabel.setBounds(274, 22, 61, 40);
        pnlTimeLog.add(startTimeLabel);
        
        JLabel interruptTimeLabel = new JLabel("Interrupt Time");
        interruptTimeLabel.setBounds(507, 22, 83, 40);
        pnlTimeLog.add(interruptTimeLabel);
        
        JLabel endTimeLabel = new JLabel("End Time");
        endTimeLabel.setBounds(736, 26, 59, 40);
        pnlTimeLog.add(endTimeLabel);
        
        JLabel phaseLabel = new JLabel("Phase");
        phaseLabel.setBounds(952, 22, 83, 40);
        pnlTimeLog.add(phaseLabel);
        
        JLabel addMoreLogsLabel = new JLabel("Add More Logs");
        addMoreLogsLabel.setBounds(1109, 34, 98, 16);
        pnlTimeLog.add(addMoreLogsLabel);
        this.add(bttnDone);
        this.add(lblTimeLogEntries);
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
	public static void setTimeLogPhase(TimeRowObject timeEntries, String phase){
		timeEntries.setPhase(phase);
	}
	
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
		dateTextField.setToolTipText("Date you worked on the project");
		dateTxtList.add(dateTextField);
		
		startTimeTextField = new JTextField();
		startTimeTextField.setBounds(228, 0, 153, 22);
		startTimeTextField.setColumns(10);
		startTimeTextField.setToolTipText("Time you started working on the project");
		startTimeList.add(startTimeTextField);
	
		interruptTimeTextField = new JTextField();
		interruptTimeTextField.setBounds(475, 0, 153, 22);
		interruptTimeTextField.setColumns(10);
		interruptTimeTextField.setToolTipText("Interrupt time for this time entry");
		interruptTimeList.add(interruptTimeTextField);
		
		endTimeTextField = new JTextField();
		endTimeTextField.setBounds(695, 0, 153, 22);
		endTimeTextField.setColumns(10);
		endTimeTextField.setToolTipText("Time done working on project");
		endTimeList.add(endTimeTextField);
		
		phaseTextField = new JTextField();
		phaseTextField.setBounds(904, 0, 153, 22);
		phaseTextField.setColumns(10);
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
