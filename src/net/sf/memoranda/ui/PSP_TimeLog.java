package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import net.sf.memoranda.psp.TimeLog;
import net.sf.memoranda.psp.TimeRowObject;
import net.sf.memoranda.util.Util;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PSP_TimeLog extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static boolean isDirty = false;
	
	private JButton bttnDone;
	
	private TimeLog timelog;
	private TimeRowObject timeEntries;
	
	private JLabel dateLabel;
	private JTextField txtStartTime;
	private JTextField txtInterruptTime;
	private JTextField txtPhase;
	private JTextField txtEndTime;
	private JButton btnAddModule;
	private JButton btnAddTime;
	private JButton btnAddTime2;
	private JButton btnAddTime3;

	private List <JLabel> dateLabelList = new ArrayList <JLabel>();
	private List <JTextField> startTimeList = new ArrayList <JTextField>();
	private List <JTextField> interruptTimeList = new ArrayList <JTextField>();
	private List <JTextField> phaseList = new ArrayList <JTextField>();
	private List <JTextField> endTimeList = new ArrayList <JTextField>();
	private List <JPanel> addButtonList = new ArrayList <JPanel> ();
	private List <JButton> actionList = new ArrayList <JButton> ();
	private List <JButton> btnAddTimeList = new ArrayList <JButton> (); 
	private List <JButton> btnAddTimeList2 = new ArrayList <JButton> (); 
	private List <JButton> btnAddTimeList3 = new ArrayList <JButton> (); 
	
	private JPanel pnlEachLog;
	private JPanel pnlTimeLog;
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
        		setTimeLogDate(timeEntries, dateLabel.getText());
        		setTimeLogStartTime(timeEntries, txtStartTime.getText());
        		setTimeLogInterruptTime(timeEntries, txtInterruptTime.getText());
        		setTimeLogEndTime(timeEntries, txtEndTime.getText());
        		setTimeLogPhase(timeEntries, txtPhase.getText());
        	}
        });
        setLayout(null);
        bttnDone.setText("Done");
        
        
        /*
         * Cephas methods
         */
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
        
        JLabel label = new JLabel("Date");
        label.setBounds(84, 26, 26, 40);
        pnlTimeLog.add(label);
        
        JLabel label_1 = new JLabel("Start Time");
        label_1.setBounds(274, 22, 61, 40);
        pnlTimeLog.add(label_1);
        
        JLabel label_2 = new JLabel("Interrupt Time");
        label_2.setBounds(507, 22, 83, 40);
        pnlTimeLog.add(label_2);
        
        JLabel label_3 = new JLabel("End Time");
        label_3.setBounds(736, 26, 59, 40);
        pnlTimeLog.add(label_3);
        
        JLabel label_4 = new JLabel("Phase");
        label_4.setBounds(952, 22, 83, 40);
        pnlTimeLog.add(label_4);
        
        JLabel lblAddMoreLogs = new JLabel("Add More Logs");
        lblAddMoreLogs.setBounds(1109, 34, 98, 16);
        pnlTimeLog.add(lblAddMoreLogs);
        this.add(bttnDone);
        this.add(lblTimeLogEntries);
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
			timeEntries.setStartTime(Float.parseFloat(startTime));
		}catch(NumberFormatException e){
			Util.debug("Unable to convert startTime to Float");
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
			timeEntries.setEndTime(Float.parseFloat(endTime));
		}catch (NumberFormatException e){
			Util.debug("Unable to convert endTime to Float");
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
	
	/*
	 * Cephas Methods
	 */
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
		
		btnAddTime = new JButton("");
		btnAddTime.setBorder(null);
		btnAddTime.setBounds(385, 0, 25, 25);
		btnAddTime.setBackground(Color.WHITE);
		btnAddTime.setIcon(
	            new ImageIcon(
	                net.sf.memoranda.ui.AppFrame.class.getResource
	                ("resources/icons/time.png")));
		btnAddTimeList.add(btnAddTime);
		
		btnAddTime2 = new JButton("");
		btnAddTime2.setBorder(null);
		btnAddTime2.setBounds(630, 0, 25, 25);
		btnAddTime2.setBackground(Color.WHITE);
		btnAddTime2.setIcon(
	            new ImageIcon(
	                net.sf.memoranda.ui.AppFrame.class.getResource
	                ("resources/icons/time.png")));
		btnAddTimeList2.add(btnAddTime2);
		
		btnAddTime3 = new JButton("");
		btnAddTime3.setBorder(null);
		btnAddTime3.setBounds(850, 0, 25, 25);
		btnAddTime3.setBackground(Color.WHITE);
		btnAddTime3.setIcon(
	            new ImageIcon(
	                net.sf.memoranda.ui.AppFrame.class.getResource
	                ("resources/icons/time.png")));
		btnAddTimeList3.add(btnAddTime3);
		
		dateLabel = new JLabel();
		dateLabel.setBounds(80, 0, 153, 22);
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		dateLabel.setText(df.format(date));
		dateLabelList.add(dateLabel);
		
		txtStartTime = new JTextField();
		txtStartTime.setBounds(228, 0, 153, 22);
		txtStartTime.setColumns(10);
		startTimeList.add(txtStartTime);
	
		txtInterruptTime = new JTextField();
		txtInterruptTime.setBounds(475, 0, 153, 22);
		txtInterruptTime.setColumns(10);
		interruptTimeList.add(txtInterruptTime);
		
		txtEndTime = new JTextField();
		txtEndTime.setBounds(695, 0, 153, 22);
		txtEndTime.setColumns(10);
		endTimeList.add(txtInterruptTime);
		
		txtPhase = new JTextField();
		txtPhase.setBounds(904, 0, 153, 22);
		txtPhase.setColumns(10);
		phaseList.add(txtPhase);
		
		
		JPanel holdItems = new JPanel();
		holdItems.setBackground(Color.WHITE);
		holdItems.setLayout(null);
		holdItems.add(dateLabel);
		holdItems.add(txtStartTime);
		holdItems.add(btnAddModule);
		holdItems.add(btnAddTime);
		holdItems.add(btnAddTime2);
		holdItems.add(btnAddTime3);
		holdItems.add(txtInterruptTime);
		holdItems.add(txtEndTime);
		holdItems.add(txtPhase);
		holdItems.setBounds(x, y, width, height);
		addButtonList.add(holdItems);
		
		remActionListener(actionList);
		currentTimeActionListener(btnAddTimeList);
		currentTime2ActionListener(btnAddTimeList2);
		currentTime3ActionListener(btnAddTimeList3);
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
				dateLabelList.remove(i);
				startTimeList.remove(i);
				interruptTimeList.remove(i);
				endTimeList.remove(i);
				phaseList.remove(i);
				btnAddTimeList.remove(i);
				btnAddTimeList2.remove(i);
				btnAddTimeList3.remove(i);
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
	
	private void currentTimeActionListener (List<JButton> currentTimeLst) {
		for (int i = 0; i < currentTimeLst.size(); i++) {{
			currentTimeLst.get(i).addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							currentStartTime();
						}
					});	
				}
		}	
	}
	
	private void currentTime2ActionListener (List<JButton> currentTimeLst2) {
		for (int i = 0; i < currentTimeLst2.size(); i++) {{
			currentTimeLst2.get(i).addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							currentInterruptTime();
						}
					});	
				}
		}	
	}
	
	private void currentTime3ActionListener (List<JButton> currentTimeLst3) {
		for (int i = 0; i < currentTimeLst3.size(); i++) {{
			currentTimeLst3.get(i).addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							currentEndTime();
						}
					});	
				}
		}	
	}
	
	private void buttonAction_Clicked (String pan) {
		if (pan.equals("ADD_MOD")) {	
			addTimeLog ();	
		}
		else {
			//Do nothing
		}
	}
	
	private void currentStartTime()
	{
		DateFormat df = DateFormat.getTimeInstance(DateFormat.SHORT);
		
		txtStartTime.setText(df.format(date));
	}
	
	private void currentInterruptTime()
	{
		DateFormat df = DateFormat.getTimeInstance(DateFormat.SHORT);
		
		txtInterruptTime.setText(df.format(date));
	}
	
	private void currentEndTime()
	{
		DateFormat df = DateFormat.getTimeInstance(DateFormat.SHORT);
		
		txtEndTime.setText(df.format(date));
	}
	
	
}
