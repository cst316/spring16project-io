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
	
	private void jInit () {
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
        
        addTimeLog ();
    	if (timelog.getTimeRowLists().size() > 0) {
			updateTimeRowPanels();
		}        
	}
		
	private void bttnDoneAction(){
		boolean dirty = false;
		
		for(int i = 0; i < actionList.size(); ++i){
			//Adding some guards so we are not adding empty data
			if (!dateTxtList.get(i).getText().isEmpty() &&
				!startTimeList.get(i).getText().isEmpty() &&
				!interruptTimeList.get(i).getText().isEmpty() &&
				!endTimeList.get(i).getText().isEmpty() &&
				!(phaseList.get(i).getSelectedIndex() == -1)) {
			
				/*dateTxtList.get(i).setEditable(false);
				startTimeList.get(i).setEditable(false);
				interruptTimeList.get(i).setEditable(false);
				endTimeList.get(i).setEditable(false);
				phaseList.get(i).setEditable(false);*/
				
				timelog.editRow (i, this.createTestRow(i));
				
				if (!dirty) {
					dirty = true;
					setIsDirty(dirty);
				}
			}				
		}
		
		if(dirty){
			JOptionPane.showMessageDialog(App.getFrame(),
					Local.getString("Time Log saved"));
		} else {
			JOptionPane.showMessageDialog(App.getFrame(),
					Local.getString("Error in saving Time Log\n" +
							"Check that all fields are filled in and try again"));
		}
	}
	
	private void updateTimeRowPanels() {
		
		for (int i = 0; i < timelog.getTimeRowLists().size(); i++) {
			startTimeList.get(i).setText(getDateTime (timelog.getTimeRowLists().get(i).getStartTime(), 1));
			dateTxtList.get(i).setText(getDateTime (timelog.getTimeRowLists().get(i).getDate(), 0));
			interruptTimeList.get(i).setText(""
					+ timelog.getTimeRowLists().get(i).getInterruptTime());
			endTimeList.get(i).setText(getDateTime(timelog.getTimeRowLists().get(i).getEndTime(), 1));
			phaseList.get(i).setSelectedIndex (getTimeLogPhase(timelog.getTimeRowLists().get(i).getPhase()));
			
			//Disabling text field objects from editing unless you click on edit button
			/*for (Component t : this.addButtonList.get(i).getComponents())
			{
				if (t instanceof JTextField) {
					((JTextField) t).setEditable(false);
				}
			}*/
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
		my_timeRow.setPhase(phaseList.get(index).getSelectedItem().toString());
		
		return my_timeRow;
	}
	
	/**
	 *
	 * @param phase the phase of the time log entry
	 * Sets the item of the combo box from its index
	 * @return index of combo box to select
	 */
	private static int getTimeLogPhase(String phase){
		int index = -1;
		
		switch(phase){
			case "Planning":
				index = 0;
				break;
			case "Design":
				index = 1;
				break;
			case "Code":
				index = 2;
				break;
			case "Code Review":
				index = 3;
				break;
			case "Test":
				index = 4;
				break;
			case "Postmortem":
				index = 5;
				break;
		}
		
		return index;
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
				
				if (i < timelog.getTimeRowLists().size()) {
					timelog.removeRow(i);
					
					//If isDirty is not set already, then set it, else no need
					if (!getIsDirty()) {
						setIsDirty(true);
					}
				}
								
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