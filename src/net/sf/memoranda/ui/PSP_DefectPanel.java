package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;

import net.sf.memoranda.psp.Defect;
import net.sf.memoranda.psp.DefectImpl;
import net.sf.memoranda.psp.Psp;
import net.sf.memoranda.psp.TestRowObject;
import net.sf.memoranda.util.Local;
import net.sf.memoranda.util.Util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PSP_DefectPanel extends JPanel {
	
	private static final long serialVersionUID = 4093818888674281261L;
	
	/**
	 * Main panels used in the defect panel
	 */
	private JPanel containsLogsPanel;
	private JPanel eachLogPanel;
	
	/**
	 * Text field variables for student, date, program
	, program number, type, defects injected, defects removed,
	defects fixed and the fix reference number
	**/
	private JTextField userTextField;
	private JTextField dateTextField;
	private JTextField prjctTextField;
	private JTextField prjctNumberTextField;
	private JTextField typeTextField;
	private JTextField injectTextField;
	private JTextField removeTextField;
	private JTextField fixTextField;
	private JTextField fixRefTextField;
	
	/**
	 * Label variables for project name, date and defect number
	 */
	private JTextField programTextField;
	private JTextField dateTextField_2;
	private JLabel numberLabel;
	
	/**
	 * Button variables for adding and editing defect logs
	 */
	private JButton addButton;
	private JButton editButton;

	/**
	 * List variables that stores a list of each of the attributes above
	 */
	private List <JTextField> programTextFieldList = new ArrayList <JTextField>();
	private List <JTextField> dateTextFieldList_2 = new ArrayList <JTextField>();
	private List <JLabel> numberLabelList = new ArrayList <JLabel>();
	private List <JTextField> typeTextFieldList = new ArrayList <JTextField>();
	private List <JTextField> injectTextFieldList = new ArrayList <JTextField>();
	private List <JTextField> removeTextFieldList = new ArrayList <JTextField>();
	private List <JTextField> fixTextFieldList = new ArrayList <JTextField>();
	private List <JTextField> fixRefTextFieldList = new ArrayList <JTextField>();
	private List <JPanel> addDefectPanelsList = new ArrayList <JPanel> ();
	private List <JButton> addButtonList = new ArrayList <JButton> ();
	private List <JButton> editButtonList = new ArrayList <JButton> ();
	
	/**
	 * Panels used to store each defect and to allow users to scroll  
	 */
	private JPanel eachDefect_panel;
	private JPanel mainDefectPanel;
	private JScrollPane scrollPaneDefectLog;
	
	/**
	 * Update button saves all current defect logs
	 */
	private JButton update;
	
	/**
	 * isDirty is used to keep track of changes, count keeps
	 * track of each defect log and d is used for labels and
	 * text fields that require a date
	 */
	static boolean isDirty = false;
	int count = 1;
	
	Date date = new Date();
	
	//Taken from PSP_NPWizardFrame by Cephas M. to make 
	//frame compatible to the main panel
	private Defect defect;
	
	private JLabel projectLabel;

    private List<JLabel> projectLabelList = new ArrayList<JLabel>(); 

	public PSP_DefectPanel() {
		//this.defect = PSP_Panel.defect;
		try {
			jbInit();
		} catch (Exception ex) {
			new ExceptionDialog(ex);
			ex.printStackTrace();
		}
	}
	
	public PSP_DefectPanel(Defect defect) {
		try {
			this.defect = defect;
			jbInit();
		} catch (Exception ex) {
			new ExceptionDialog(ex);
			ex.printStackTrace();
		}
	}
	
	public PSP_DefectPanel(Psp pspVal) {
		this.defect = new DefectImpl (pspVal);
		jbInit();
	}

	/**
	 * Initialization of GUI components
	 */
	public void jbInit() {
		setLayout(null);
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 1290, 700);
		
		JTextArea defectKey = new JTextArea();
		defectKey.setText("Defect Types" +
		"\n10 Documentation\t60 Checking" +
		"\n20 Syntax\t\t70 Data" + 
		"\n30 Build, Package\t80 Function" + 
		"\n40 Assignment\t\t90 System" +
		"\n50 Interface\t\t100 Environment");
		
		defectKey.setBounds(879, 13, 343, 121);
		defectKey.setToolTipText("Defect Key");
		defectKey.setEditable(false);
		add(defectKey);
		
		JLabel userLabel = new JLabel("User:");
		userLabel.setBounds(37, 49, 56, 16);
		userLabel.setToolTipText("Your Name");
		add(userLabel);
		
		JLabel dateLabel = new JLabel("Date:");
		dateLabel.setToolTipText("Date");
		dateLabel.setBounds(37, 101, 56, 16);
		add(dateLabel);
		
		JLabel prjctLAbel = new JLabel("Project:");
		prjctLAbel.setToolTipText("Project name");
		prjctLAbel.setBounds(270, 49, 56, 16);
		add(prjctLAbel);
		
		JLabel programNoLabel = new JLabel("Project #:");
		//JLabel programNoLabel = new JLabel("" + my_psp.getpId());
		programNoLabel.setToolTipText("Program Number");
		programNoLabel.setBounds(268, 101, 87, 16);
		add(programNoLabel);
		
		userTextField = new JTextField();
		userTextField.setToolTipText("Enter your name\r\n");
		userTextField.setText("");
		userTextField.setColumns(10);
		userTextField.setBounds(92, 46, 166, 22);
		add(userTextField);
		
		dateTextField = new JTextField();
		dateTextField.setToolTipText("Current date\r\n");
		dateTextField.setText("");
		dateTextField.setColumns(10);
		dateTextField.setBounds(92, 98, 166, 22);
		dateTextField.setText(getDate());
		dateTextField.setEditable(false);
		add(dateTextField);
		
		prjctTextField = new JTextField();
		prjctTextField.setToolTipText("Name of the project"
				+ " your working on\r\n\r\n");
		prjctTextField.setText(defect.getPspValues().getName());
		prjctTextField.setColumns(10);
		prjctTextField.setBounds(344, 48, 166, 22);
		prjctTextField.setEditable(false);
		add(prjctTextField);
		
		prjctNumberTextField = new JTextField();
		prjctNumberTextField.setToolTipText("Project number (auto-generated)\r\n");
		prjctNumberTextField.setText(defect.getPspValues().getpId() + "");
		prjctNumberTextField.setColumns(10);
		prjctNumberTextField.setBounds(344, 98, 166, 22);
		prjctNumberTextField.setEditable(false);
		add(prjctNumberTextField);
		
		JLabel testingFrameTitleLbl = new JLabel
				("Defects Log");
		testingFrameTitleLbl.setToolTipText("Defects Log");
		testingFrameTitleLbl.setBounds(590, 16, 159, 16);
		add(testingFrameTitleLbl);
		
		containsLogsPanel = new JPanel();
		containsLogsPanel.setBounds(12, 147, 1236, 493);
		add(containsLogsPanel);
		containsLogsPanel.setLayout(null);
		containsLogsPanel.setBackground(Color.WHITE);
		
		
		eachLogPanel = new JPanel();
		eachLogPanel.setBounds(12, 13, 1153, 42);
		containsLogsPanel.add(eachLogPanel);
		eachLogPanel.setLayout(null);
		eachLogPanel.setBackground(Color.WHITE);
		
		JLabel prgrmLabel_1 = new JLabel("Program");
		prgrmLabel_1.setToolTipText("Program name");
		prgrmLabel_1.setBounds(25, 13, 80, 22);
		eachLogPanel.add(prgrmLabel_1);
		
		JLabel dateLabel_1 = new JLabel("Date");
		dateLabel_1.setToolTipText("Date");
		dateLabel_1.setBounds(216, 16, 56, 16);
		eachLogPanel.add(dateLabel_1);
		
		JLabel numberLabel_1 = new JLabel("Number");
		numberLabel_1.setToolTipText("Number");
		numberLabel_1.setBounds(348, 16, 56, 16);
		eachLogPanel.add(numberLabel_1);
		
		JLabel typeLabel_1 = new JLabel("Type");
		typeLabel_1.setToolTipText("Defect Type");
		typeLabel_1.setBounds(443, 16, 56, 16);
		eachLogPanel.add(typeLabel_1);
		
		JLabel injectLabel_1 = new JLabel("Inject");
		injectLabel_1.setToolTipText("Number of Defects Injected\r\n");
		injectLabel_1.setBounds(551, 16, 56, 16);
		eachLogPanel.add(injectLabel_1);
		
		JLabel removeLabel_1 = new JLabel("Remove");
		removeLabel_1.setToolTipText("Number of Defects Removed");
		removeLabel_1.setBounds(664, 16, 56, 16);
		eachLogPanel.add(removeLabel_1);
		
		JLabel fixLabel_1 = new JLabel("Fix");
		fixLabel_1.setToolTipText("Number of Defects Fixed");
		fixLabel_1.setBounds(799, 16, 56, 16);
		eachLogPanel.add(fixLabel_1);
		
		JLabel fixRefLabel_1 = new JLabel("Fix Ref.");
		fixRefLabel_1.setToolTipText("Fix reference number (auto-generated)");
		fixRefLabel_1.setBounds(918, 16, 56, 16);
		eachLogPanel.add(fixRefLabel_1);
		
		update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					update();
			}
		});
		update.setBounds(1047, 394, 97, 25);
		update.setToolTipText("Update Defect Characteristics");
		containsLogsPanel.add(update);
		
		mainDefectPanel = new JPanel();
		mainDefectPanel.setBorder(null);	
		mainDefectPanel.setBounds(12, 57, 1212, 324);
		containsLogsPanel.add(mainDefectPanel);
		mainDefectPanel.setBackground(Color.WHITE);
		mainDefectPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 13, 1120, 300);
		mainDefectPanel.add(panel_1);
		panel_1.setLayout(new BorderLayout());
		
		scrollPaneDefectLog = new JScrollPane();
		scrollPaneDefectLog.setBorder(null);
		panel_1.add(scrollPaneDefectLog);
		scrollPaneDefectLog.setHorizontalScrollBarPolicy
				(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);		
		
		eachDefect_panel = new JPanel();
		eachDefect_panel.setBorder(null);
		scrollPaneDefectLog.setViewportView(eachDefect_panel);
		eachDefect_panel.setLayout(null);
		eachDefect_panel.setBackground(Color.WHITE);
		
		JButton btnEditAll = new JButton("Edit All");
		btnEditAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				editAll();
			}
		});
		btnEditAll.setBounds(926, 394, 97, 25);
		containsLogsPanel.add(btnEditAll);
		
		createDefectLogPanel();		
		
		//If defect has some defects then set them
		if (defect.getRowObject().size() > 0) {
			updateDefectLogPanels();
		}
	}
		
	private void update()
	{
		boolean dirty = false;
		
		for (int i = 0; i < addButtonList.size(); i++) {
			//Adding some guards so we are not adding empty data
			if (!programTextFieldList.get(i).getText().isEmpty() &&
				!typeTextFieldList.get(i).getText().isEmpty() &&
				!injectTextFieldList.get(i).getText().isEmpty() &&
				!removeTextFieldList.get(i).getText().isEmpty() &&
				!fixTextFieldList.get(i).getText().isEmpty() &&
				!fixRefTextFieldList.get(i).getText().isEmpty()) {
			
				programTextFieldList.get(i).setEditable(false);
				typeTextFieldList.get(i).setEditable(false);
				injectTextFieldList.get(i).setEditable(false);
				removeTextFieldList.get(i).setEditable(false);
				fixTextFieldList.get(i).setEditable(false);
				fixRefTextFieldList.get(i).setEditable(false);
				
				//using edit to implement add and edit both
				defect.editRow (i, this.createTestRow(i));
				
				//If dirt is not set already, then set it, else no need
				if (!dirty) {
					dirty = true;
					setIsDirty(dirty);
				}
			}
		}
		
		//If we actually updated something, then
		if (dirty) {
			JOptionPane.showMessageDialog(App.getFrame(),
					Local.getString("Updated and Saved!"));
		}
	}
	
	/**
	 * This method helps you pull the back end back into the front end if there is any that exists.
	 * Looks like you were missing this, only issue is fixing the printing out double items when
	 * this runs.  Should be an easy fix, so I'll leave you with that aspect
	 */
	private void updateDefectLogPanels() {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < defect.getRowObject().size(); i++) {
			programTextFieldList.get(i).setText(defect.getRowObject().get(i).getProgram());
			dateTextFieldList_2.get(i).setText(getDate(defect.getRowObject().get(i).getDate()));
			numberLabelList.get(i).setText("                 "
					+ defect.getRowObject().get(i).getDefNumber());
			typeTextFieldList.get(i).setText(defect.getRowObject().get(i).getDefType());
			injectTextFieldList.get(i).setText(defect.getRowObject().get(i).getInjPhase());
			removeTextFieldList.get(i).setText(defect.getRowObject().get(i).getRemPhase());
			fixTextFieldList.get(i).setText(defect.getRowObject().get(i).getFix());
			fixRefTextFieldList.get(i).setText(defect.getRowObject().get(i).getFixRef());
			
			//Disabling text field objects from editing unless you click on edit button
			for (Component t : this.addDefectPanelsList.get(i).getComponents())
			{
				if (t instanceof JTextField) {
					((JTextField) t).setEditable(false);
				}
			}
			
			if (i == defect.getRowObject().size() - 1) {
				count = defect.getRowObject().get(i).getDefNumber() + 1;
			}
			buttonAction_Clicked ("ADD_DEFECT");
		}			
	}

	/**
	 * Adds a defect log
	 */
	//Similar to Cephas's implementation in PSP_PlanningWizardFrame.java
	private void createDefectLogPanel () {	
		JPanel holdItems = new JPanel();
		
		int width = 1153;
		int height = 35;
		int x = 0;
		int y = (addDefectPanelsList.size() == 0 ? 0 : 
			addDefectPanelsList.get(addDefectPanelsList.size() - 1).getY() + height + 5);

		addButton = new JButton("");
		addButton.setToolTipText("Add a Defect");
		addButton.setBorder(null);
		addButton.setBounds(962, 0, 97, 25);
		addButton.setBackground(Color.WHITE);
		addButtonList.add(addButton);
		
		editButton = new JButton("");
		editButton.setBorder(null);
		editButton.setBounds(1025, 0, 97, 25);
		editButton.setBackground(Color.WHITE);
		editButton.setToolTipText("Edit Defects");
		//From http://findicons.com/icon/180634/pencil_medium?id=377514
		editButton.setIcon(
	            new ImageIcon(
	                net.sf.memoranda.ui.AppFrame.class.getResource
	                ("resources/icons/pencilsmall.png")));
		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edit(e);
			}
		});
		editButtonList.add(editButton);
		

		projectLabel = new JLabel();
		projectLabel.setBounds(0, 0, 147, 22);
		projectLabel.setText("Current Project");
		projectLabel.setToolTipText("Project's name");
		projectLabelList.add(projectLabel);

		programTextField = new JTextField();
		programTextField.setBounds(0, 0, 147, 22);
		//programLabel.setText(defect.getPspValues().getName());
		programTextField.setToolTipText("Program's name");
		programTextFieldList.add(programTextField);
		
		dateTextField_2 = new JTextField();
		dateTextField_2.setBounds(198, 0, 56, 16);
		dateTextField_2.setText(getDate());
		dateTextField_2.setToolTipText("Date");
		dateTextFieldList_2.add(dateTextField_2);
		
		numberLabel = new JLabel();
		numberLabel.setBounds(298, 0, 87, 22);
		numberLabel.setText("                 "
				+ count);
		numberLabel.setToolTipText("Defect Number");
		numberLabelList.add(numberLabel);
		
		typeTextField = new JTextField();
		typeTextField.setBounds(410, 0, 87, 22);
		typeTextField.setColumns(10);
		typeTextField.setToolTipText("Defect Type");
		typeTextFieldList.add(typeTextField);
		
		injectTextField = new JTextField();
		injectTextField.setBounds(521, 0, 87, 22);
		injectTextField.setColumns(10);
		injectTextField.setToolTipText("Number of Defects Inject");
		injectTextFieldList.add(injectTextField);

		removeTextField = new JTextField();
		removeTextField.setBounds(635, 0, 87, 22);
		removeTextField.setColumns(10);
		removeTextField.setToolTipText("Defects Removed");
		removeTextFieldList.add(removeTextField);
		
		fixTextField = new JTextField();
		fixTextField.setBounds(738, 0, 130, 22);
		fixTextField.setColumns(10);
		fixTextField.setToolTipText("Defects fixed");
		fixTextFieldList.add(fixTextField);
		
		fixRefTextField = new JTextField();
		fixRefTextField.setBounds(890, 0, 70, 22);
		fixRefTextField.setToolTipText("Fix Reference Number");
		fixRefTextField.setColumns(10);
		fixRefTextField.setText("00" + count + "00");
		fixRefTextField.setEditable(false);
		fixRefTextFieldList.add(fixRefTextField);
		
		holdItems.setBackground(Color.WHITE);
		holdItems.setLayout(null);
		holdItems.add(programTextField);
		holdItems.add(dateTextField_2);
		holdItems.add(numberLabel);
		holdItems.add(typeTextField);
		holdItems.add(injectTextField);
		holdItems.add(removeTextField);
		holdItems.add(fixTextField);
		holdItems.add(fixRefTextField);
		holdItems.add(addButton);
		holdItems.add(editButton);
		holdItems.setBounds(x, y, width, height);
		addDefectPanelsList.add(holdItems);
				
		removeDefectActionListener(addButtonList);
		repaintPanel (addDefectPanelsList, addButtonList, eachDefect_panel);
		addDefectLogActionListner(addButtonList);
		eachDefect_panel.setPreferredSize(new Dimension (width, y + height));
	}
	
	private void edit(ActionEvent e)
	{
		for(int i = 0; i < addButtonList.size(); i++)
		{
			if (e.getSource() == editButtonList.get(i) && 
					(!typeTextFieldList.get(i).isEditable())) {
				programTextFieldList.get(i).setEditable(true);
				typeTextFieldList.get(i).setEditable(true);
				typeTextFieldList.get(i).setEditable(true);
				injectTextFieldList.get(i).setEditable(true);
				removeTextFieldList.get(i).setEditable(true);
				fixTextFieldList.get(i).setEditable(true);
				fixRefTextFieldList.get(i).setEditable(true);
				
				JOptionPane.showMessageDialog(App.getFrame(), 
						Local.getString("You can now edit this defect row"));
				
				break;
			}
		}				
	}
	
	private void editAll()
	{
		for(int i = 0; i < addButtonList.size(); i++)
		{
			//programTextFieldList.get(i).setEditable(true);
			typeTextFieldList.get(i).setEditable(true);
			typeTextFieldList.get(i).setEditable(true);
			injectTextFieldList.get(i).setEditable(true);
			removeTextFieldList.get(i).setEditable(true);
			fixTextFieldList.get(i).setEditable(true);
			fixRefTextFieldList.get(i).setEditable(true);
		}
		JOptionPane.showMessageDialog(App.getFrame(), 
				Local.getString("You can now edit all defects!"));
	}
	
	
	/**
	 * Removes a defect log
	 * @param e
	 */
	//Similar to Cephas's implementation in PSP_PlanningWizardFrame.java
	private void destroyDefectLogPanel (ActionEvent e) {	
		int width = 1153;
		int height = 35;
		int x = 0;
		int y = 0;
		
		removeDefectActionListener (addButtonList);
		for (int i = 0; i < addButtonList.size(); i++) {
			if (e.getSource() == addButtonList.get(i)) {
				addButtonList.remove(i);
				addDefectPanelsList.remove(i);
				programTextFieldList.remove(i);
				dateTextFieldList_2.remove(i);
				editButtonList.remove(i);
				numberLabelList.remove(i);
				typeTextFieldList.remove(i);
				injectTextFieldList.remove(i);
				removeTextFieldList.remove(i);
			    fixTextFieldList.remove(i);
				fixRefTextFieldList.remove(i);				
				
				if (i < defect.getRowObject().size()) {
					defect.removeRow(i);
					//If isDirty is not set already, then set it, else no need
					if (!getIsDirty()) {
						setIsDirty(true);
					}
				}				
				break;
			}
		}
		
		for (int i = 0; i < addButtonList.size(); i++) {
			addDefectPanelsList.get(i).setBounds(x, y, width, height);
			y += height + 5;
		}		
		
		repaintPanel (addDefectPanelsList, addButtonList, eachDefect_panel);
		addDefectLogActionListner(addButtonList);
		eachDefect_panel.setPreferredSize(new Dimension (width, y));		
	}
	
	/**
	 * Creates and returns a new test row object based on index location
	 * of defect panel row
	 * @param index - location from the defect panel on the screen
	 * @return - TestRowObject to be added or removed from this view
	 */
	private TestRowObject createTestRow(int index) {
		// TODO Auto-generated method stub		
		TestRowObject my_testRow = new TestRowObject();
		my_testRow.setProgram(programTextFieldList.get(index).getText());
		my_testRow.setDate(dateTextFieldList_2.get(index).getText());
		my_testRow.setDefNumber((
				Integer.parseInt(numberLabelList.get(index).getText().trim())));
		my_testRow.setDefType(typeTextFieldList.get(index).getText());
		my_testRow.setInjPhase(injectTextFieldList.get(index).getText());
		my_testRow.setRemPhase(removeTextFieldList.get(index).getText());
		my_testRow.setFix(fixTextFieldList.get(index).getText());
		my_testRow.setFixRef(fixRefTextFieldList.get(index).getText());	
		
		return my_testRow;
	}

	//Same as Cephas's implementation in PSP_PlanningWizardFrame.java
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
					PSP_DefectPanel.class.getResource(icon)));	
		}
		whichPnl.revalidate();
		whichPnl.repaint();
		scrollPaneDefectLog.setVerticalScrollBarPolicy
		(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	//Same as Cephas's implementation in PSP_PlanningWizardFrame.java
	//Adding action listeners to buttons
	private void addDefectLogActionListner (List<JButton> addDefectButton) {
		for (int i = 0; i < addDefectButton.size(); i++) {
			//If this is the last button then we know to it is the (+), else
			//it needs to respond to the (-)
			if (i == addDefectButton.size() - 1) {
				addDefectButton.get(i).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						buttonAction_Clicked ("ADD_DEFECT");
						count++;
						String num = "           " + count;
						fixRefTextField.setText("00" + count + "00");
						numberLabel.setText("      " + num);
						dateTextField_2.setText(getDate());
					}
				});
			} else {
				addDefectButton.get(i).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						destroyDefectLogPanel (e);
					}
				});
			}
		}		
	}
	
	//Same as Cephas's implementation in PSP_PlanningWizardFrame.java
	//removing action listeners from the panels
	private void removeDefectActionListener (List<JButton> removeDefectButton) {
		for (int i = 0; i < removeDefectButton.size(); i++) {
			for (ActionListener al : removeDefectButton.get(i).getActionListeners()) 
				removeDefectButton.get(i).removeActionListener(al);	
		}		
	}
	
	//Same as Cephas's implementation in PSP_PlanningWizardFrame.java
	private void buttonAction_Clicked (String defectPanel) {

		if (defectPanel.equals("ADD_DEFECT")) {	
			createDefectLogPanel ();	
		} 
		//TestRowObject rowObj = new TestRowObject();
		//defect.addRow(rowObj);
	}
		
	//Return date in a short format
	private String getDate () {
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		
		return (df.format(date));
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

	//Return date in a short format
	private String getDate (Date d) {
		DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
		
		return (df.format(d));
	}
}
