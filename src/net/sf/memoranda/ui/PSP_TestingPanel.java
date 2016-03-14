package net.sf.memoranda.ui;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;

import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;

import net.sf.memoranda.util.Local;

import java.awt.Color;

import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;

public class PSP_TestingPanel extends JPanel {
	
	private JTextField studentTextField;
	private JTextField dateTextField;
	private JTextField programTextField;
	private JTextField programNumberTextField;
	private JTextField projectTextField_1;
	private JTextField dateTextField_1;
	private JTextField numberTextField_1;
	private JTextField typeTextField_1;
	private JTextField injectTextField_1;
	private JTextField removeTextField_1;
	private JTextField fixRefTextField_1;
	private JTextField projectTextField_2;
	private JTextField dateTextField_2;
	private JTextField numberTextField_2;
	private JTextField typeTextField_2;
	private JTextField injectTextField_2;
	private JTextField removeTextField_2;
	private JTextField fixRefTextField_2;
	private JTextField projectTextField_3;
	private JTextField dateTextField_3;
	private JTextField numberTextField_3;
	private JTextField typeTextField_3;
	private JTextField injectTextField_3;
	private JTextField removeTextField_3;
	private JTextField fixRefTextField_3;
	private JTextField projectTextField_4;
	private JTextField dateTextField_4;
	private JTextField numberTextField_4;
	private JTextField typeTextField_4;
	private JTextField injectTextField_4;
	private JTextField removeTextField_4;
	private JTextField fixRefTextField_4;
	
	private JPanel containsLogsPanel;
	private JPanel eachLogPanel_1;
	
	//Taken from PSP_NPWizardFrame by Cephas M. to make frame compatible to the main panel
	private static PSP_Panel psp;

	public PSP_TestingPanel() {		
		try {
			jbInit();
		} catch (Exception ex) {
			new ExceptionDialog(ex);
			ex.printStackTrace();
		}
	}
	
	//Modeled after PSP_NPWizardFrame by Cephas M. to make frame compatible to the main panel
	public PSP_TestingPanel(PSP_Panel psp) {		
		try {
			setPspPanel(psp);
			jbInit();
		} catch (Exception ex) {
			new ExceptionDialog(ex);
			ex.printStackTrace();
		}
	}
	
	//Taken from PSP_NPWizardFrame by Cephas M. to make frame compatible to the main panel
	public static void setPspPanel (PSP_Panel p) {
		psp = p;
	}
	
	//Taken from PSP_NPWizardFrame by Cephas M. to make frame compatible to the main panel
	public static PSP_Panel getPspPanel () {
		return psp;
	}
	
	
	public void jbInit() {
		setLayout(null);
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 1290, 700);
		
		JTextArea defectContentKey = new JTextArea();
		defectContentKey.setText("Defect Types" + "\n10 Documentation\t60 Checking" +
		"\n20 Syntax\t\t70 Data" + "\n30 Build, Package\t80 Function" + 
		"\n40 Assignment\t\t90 System" + "\n50 Interface\t\t100 Environment");
		
		defectContentKey.setBounds(897, 13, 343, 121);
		defectContentKey.setEditable(false);

		
		JLabel studentLabel = new JLabel("Student:");
		studentLabel.setBounds(37, 49, 56, 16);
		add(studentLabel);
		
		JLabel dateLabel = new JLabel("Date:");
		dateLabel.setBounds(37, 101, 56, 16);
		add(dateLabel);
		
		JLabel programLabel = new JLabel("Program:");
		programLabel.setBounds(270, 49, 56, 16);
		add(programLabel);
		
		JLabel programNoLabel = new JLabel("Program #:");
		programNoLabel.setBounds(268, 101, 87, 16);
		add(programNoLabel);
		
		studentTextField = new JTextField();
		studentTextField.setText("");
		studentTextField.setColumns(10);
		studentTextField.setBounds(92, 46, 166, 22);
		add(studentTextField);
		
		dateTextField = new JTextField();
		dateTextField.setText("");
		dateTextField.setColumns(10);
		dateTextField.setBounds(92, 98, 166, 22);
		add(dateTextField);
		
		programTextField = new JTextField();
		programTextField.setText("");
		programTextField.setColumns(10);
		programTextField.setBounds(344, 48, 166, 22);
		add(programTextField);
		
		programNumberTextField = new JTextField();
		programNumberTextField.setText("");
		programNumberTextField.setColumns(10);
		programNumberTextField.setBounds(344, 98, 166, 22);
		add(programNumberTextField);
		
		JLabel testingFrameTitleLbl = new JLabel("Testing and Defects Page");
		testingFrameTitleLbl.setBounds(590, 16, 159, 16);
		add(testingFrameTitleLbl);
		
		containsLogsPanel = new JPanel();
		containsLogsPanel.setBounds(12, 147, 1236, 493);
		add(containsLogsPanel);
		containsLogsPanel.setLayout(null);
		containsLogsPanel.setBackground(Color.WHITE);
		
	
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1203, 192, 21, 48);
		containsLogsPanel.add(scrollBar);
		
		
		eachLogPanel_1 = new JPanel();
		eachLogPanel_1.setBounds(12, 13, 1153, 77);
		containsLogsPanel.add(eachLogPanel_1);
		eachLogPanel_1.setLayout(null);
		eachLogPanel_1.setBackground(Color.WHITE);

		
		JLabel projectLabel_1 = new JLabel("Project");
		projectLabel_1.setBounds(66, 13, 49, 22);
		eachLogPanel_1.add(projectLabel_1);
		
		projectTextField_1 = new JTextField();
		projectTextField_1.setColumns(10);
		projectTextField_1.setBounds(12, 42, 147, 22);
		eachLogPanel_1.add(projectTextField_1);
		
		JLabel dateLabel_1 = new JLabel("Date");
		dateLabel_1.setBounds(220, 13, 56, 16);
		eachLogPanel_1.add(dateLabel_1);
		
		dateTextField_1 = new JTextField();
		dateTextField_1.setColumns(10);
		dateTextField_1.setBounds(188, 42, 87, 22);
		eachLogPanel_1.add(dateTextField_1);
		
		JLabel numberLabel_1 = new JLabel("Number");
		numberLabel_1.setBounds(321, 13, 56, 16);
		eachLogPanel_1.add(numberLabel_1);
		
		numberTextField_1 = new JTextField();
		numberTextField_1.setColumns(10);
		numberTextField_1.setBounds(298, 42, 87, 22);
		eachLogPanel_1.add(numberTextField_1);
		
		JLabel typeLabel_1 = new JLabel("Type");
		typeLabel_1.setBounds(433, 13, 56, 16);
		eachLogPanel_1.add(typeLabel_1);
		
		typeTextField_1 = new JTextField();
		typeTextField_1.setColumns(10);
		typeTextField_1.setBounds(410, 42, 87, 22);
		eachLogPanel_1.add(typeTextField_1);
		
		JLabel injectLabel_1 = new JLabel("Inject");
		injectLabel_1.setBounds(540, 13, 56, 16);
		eachLogPanel_1.add(injectLabel_1);
		
		injectTextField_1 = new JTextField();
		injectTextField_1.setColumns(10);
		injectTextField_1.setBounds(521, 42, 87, 22);
		eachLogPanel_1.add(injectTextField_1);
		
		JLabel removeLabel_1 = new JLabel("Remove");
		removeLabel_1.setBounds(652, 13, 56, 16);
		eachLogPanel_1.add(removeLabel_1);
		
		removeTextField_1 = new JTextField();
		removeTextField_1.setColumns(10);
		removeTextField_1.setBounds(635, 42, 87, 22);
		eachLogPanel_1.add(removeTextField_1);
		
		JLabel fixLabel_1 = new JLabel("Fix");
		fixLabel_1.setBounds(827, 13, 56, 16);
		eachLogPanel_1.add(fixLabel_1);
		
		JTextField fixEditorPane_1 = new JTextField();
		fixEditorPane_1.setBounds(738, 42, 216, 22);
		eachLogPanel_1.add(fixEditorPane_1);
		
		JLabel fixRefLabel_1 = new JLabel("Fix Ref.");
		fixRefLabel_1.setBounds(973, 13, 56, 16);
		eachLogPanel_1.add(fixRefLabel_1);
		
		fixRefTextField_1 = new JTextField();
		fixRefTextField_1.setColumns(10);
		fixRefTextField_1.setBounds(966, 42, 70, 22);
		eachLogPanel_1.add(fixRefTextField_1);
		
		JButton addButton = new JButton();
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		addButton.setBounds(1068, 30, 49, 33);
		addButton.setContentAreaFilled(false);
		addButton.setIcon( new ImageIcon(net.sf.memoranda.ui.AppFrame.class.getResource("resources/icons/plus.png")));
		eachLogPanel_1.add(addButton);
		
		JPanel eachLogPanel_2 = new JPanel();
		eachLogPanel_2.setLayout(null);
		eachLogPanel_2.setBounds(12, 122, 1153, 77);
		eachLogPanel_2.setBackground(Color.WHITE);
		containsLogsPanel.add(eachLogPanel_2);
		
		JLabel projectLabel_2 = new JLabel("Project");
		projectLabel_2.setBounds(66, 13, 49, 22);
		eachLogPanel_2.add(projectLabel_2);
		
		projectTextField_2 = new JTextField();
		projectTextField_2.setColumns(10);
		projectTextField_2.setBounds(12, 42, 147, 22);
		eachLogPanel_2.add(projectTextField_2);
		
		JLabel dateLabel_2 = new JLabel("Date");
		dateLabel_2.setBounds(220, 13, 56, 16);
		eachLogPanel_2.add(dateLabel_2);
		
		dateTextField_2 = new JTextField();
		dateTextField_2.setColumns(10);
		dateTextField_2.setBounds(188, 42, 87, 22);
		eachLogPanel_2.add(dateTextField_2);
		
		JLabel numberLabel_2 = new JLabel("Number");
		numberLabel_2.setBounds(321, 13, 56, 16);
		eachLogPanel_2.add(numberLabel_2);
		
		numberTextField_2 = new JTextField();
		numberTextField_2.setColumns(10);
		numberTextField_2.setBounds(298, 42, 87, 22);
		eachLogPanel_2.add(numberTextField_2);
		
		JLabel typeLabel_2 = new JLabel("Type");
		typeLabel_2.setBounds(433, 13, 56, 16);
		eachLogPanel_2.add(typeLabel_2);
		
		typeTextField_2 = new JTextField();
		typeTextField_2.setColumns(10);
		typeTextField_2.setBounds(410, 42, 87, 22);
		eachLogPanel_2.add(typeTextField_2);
		
		JLabel injectLabel_2 = new JLabel("Inject");
		injectLabel_2.setBounds(540, 13, 56, 16);
		eachLogPanel_2.add(injectLabel_2);
		
		injectTextField_2 = new JTextField();
		injectTextField_2.setColumns(10);
		injectTextField_2.setBounds(521, 42, 87, 22);
		eachLogPanel_2.add(injectTextField_2);
		
		JLabel removeLabel_2 = new JLabel("Remove");
		removeLabel_2.setBounds(652, 13, 56, 16);
		eachLogPanel_2.add(removeLabel_2);
		
		removeTextField_2 = new JTextField();
		removeTextField_2.setColumns(10);
		removeTextField_2.setBounds(635, 42, 87, 22);
		eachLogPanel_2.add(removeTextField_2);
		
		JLabel fixLabel_2 = new JLabel("Fix");
		fixLabel_2.setBounds(827, 13, 56, 16);
		eachLogPanel_2.add(fixLabel_2);
		
		JTextField fixEditorPane_2 = new JTextField();
		fixEditorPane_2.setBounds(738, 42, 216, 22);
		eachLogPanel_2.add(fixEditorPane_2);
		
		JLabel fixRefLabel_2 = new JLabel("Fix Ref.");
		fixRefLabel_2.setBounds(973, 13, 56, 16);
		eachLogPanel_2.add(fixRefLabel_2);
		
		fixRefTextField_2 = new JTextField();
		fixRefTextField_2.setColumns(10);
		fixRefTextField_2.setBounds(966, 42, 70, 22);
		eachLogPanel_2.add(fixRefTextField_2);
		
		JButton addButton_2 = new JButton();
		addButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addButton_2.setBounds(1068, 30, 49, 33);
		addButton_2.setContentAreaFilled(false);
		addButton_2.setIcon( new ImageIcon(net.sf.memoranda.ui.AppFrame.class.getResource("resources/icons/plus.png")));
		eachLogPanel_2.add(addButton_2);
		
		JPanel eachLogPanel_3 = new JPanel();
		eachLogPanel_3.setLayout(null);
		eachLogPanel_3.setBounds(12, 229, 1153, 77);
		eachLogPanel_3.setBackground(Color.WHITE);
		containsLogsPanel.add(eachLogPanel_3);
		
		JLabel projectLabel_3 = new JLabel("Project");
		projectLabel_3.setBounds(66, 13, 49, 22);
		eachLogPanel_3.add(projectLabel_3);
		
		projectTextField_3 = new JTextField();
		projectTextField_3.setColumns(10);
		projectTextField_3.setBounds(12, 42, 147, 22);
		eachLogPanel_3.add(projectTextField_3);
		
		JLabel dateLabel_3 = new JLabel("Date");
		dateLabel_3.setBounds(220, 13, 56, 16);
		eachLogPanel_3.add(dateLabel_3);
		
		dateTextField_3 = new JTextField();
		dateTextField_3.setColumns(10);
		dateTextField_3.setBounds(188, 42, 87, 22);
		eachLogPanel_3.add(dateTextField_3);
		
		JLabel numberLabel_3 = new JLabel("Number");
		numberLabel_3.setBounds(321, 13, 56, 16);
		eachLogPanel_3.add(numberLabel_3);
		
		numberTextField_3 = new JTextField();
		numberTextField_3.setColumns(10);
		numberTextField_3.setBounds(298, 42, 87, 22);
		eachLogPanel_3.add(numberTextField_3);
		
		JLabel typeLabel_3 = new JLabel("Type");
		typeLabel_3.setBounds(433, 13, 56, 16);
		eachLogPanel_3.add(typeLabel_3);
		
		typeTextField_3 = new JTextField();
		typeTextField_3.setColumns(10);
		typeTextField_3.setBounds(410, 42, 87, 22);
		eachLogPanel_3.add(typeTextField_3);
		
		JLabel injectLabel_3 = new JLabel("Inject");
		injectLabel_3.setBounds(540, 13, 56, 16);
		eachLogPanel_3.add(injectLabel_3);
		
		injectTextField_3 = new JTextField();
		injectTextField_3.setColumns(10);
		injectTextField_3.setBounds(521, 42, 87, 22);
		eachLogPanel_3.add(injectTextField_3);
		
		JLabel removeLabel_3 = new JLabel("Remove");
		removeLabel_3.setBounds(652, 13, 56, 16);
		eachLogPanel_3.add(removeLabel_3);
		
		removeTextField_3 = new JTextField();
		removeTextField_3.setColumns(10);
		removeTextField_3.setBounds(635, 42, 87, 22);
		eachLogPanel_3.add(removeTextField_3);
		
		JLabel fixLabel_3 = new JLabel("Fix");
		fixLabel_3.setBounds(827, 13, 56, 16);
		eachLogPanel_3.add(fixLabel_3);
		
		JTextField fixEditorPane_3 = new JTextField();
		fixEditorPane_3.setBounds(738, 42, 216, 22);
		eachLogPanel_3.add(fixEditorPane_3);
		
		JLabel fixRefLabel_3 = new JLabel("Fix Ref.");
		fixRefLabel_3.setBounds(973, 13, 56, 16);
		eachLogPanel_3.add(fixRefLabel_3);
		
		fixRefTextField_3 = new JTextField();
		fixRefTextField_3.setColumns(10);
		fixRefTextField_3.setBounds(966, 42, 70, 22);
		eachLogPanel_3.add(fixRefTextField_3);
		
		JButton addButton_3 = new JButton();
		addButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addButton_3.setBounds(1068, 35, 49, 28);
		addButton_3.setContentAreaFilled(false);
		addButton_3.setIcon( new ImageIcon(net.sf.memoranda.ui.AppFrame.class.getResource("resources/icons/plus.png")));
		eachLogPanel_3.add(addButton_3);
		
		JPanel eachLogPanel_4 = new JPanel();
		eachLogPanel_4.setLayout(null);
		eachLogPanel_4.setBounds(12, 352, 1153, 77);
		eachLogPanel_4.setBackground(Color.WHITE);
		containsLogsPanel.add(eachLogPanel_4);
		
		JLabel projectLabel_4 = new JLabel("Project");
		projectLabel_4.setBounds(66, 13, 49, 22);
		eachLogPanel_4.add(projectLabel_4);
		
		projectTextField_4 = new JTextField();
		projectTextField_4.setColumns(10);
		projectTextField_4.setBounds(12, 42, 147, 22);
		eachLogPanel_4.add(projectTextField_4);
		
		JLabel dateLabel_4 = new JLabel("Date");
		dateLabel_4.setBounds(220, 13, 56, 16);
		eachLogPanel_4.add(dateLabel_4);
		
		dateTextField_4 = new JTextField();
		dateTextField_4.setColumns(10);
		dateTextField_4.setBounds(188, 42, 87, 22);
		eachLogPanel_4.add(dateTextField_4);
		
		JLabel numberLabel_4 = new JLabel("Number");
		numberLabel_4.setBounds(321, 13, 56, 16);
		eachLogPanel_4.add(numberLabel_4);
		
		numberTextField_4 = new JTextField();
		numberTextField_4.setColumns(10);
		numberTextField_4.setBounds(298, 42, 87, 22);
		eachLogPanel_4.add(numberTextField_4);
		
		JLabel typeLabel_4 = new JLabel("Type");
		typeLabel_4.setBounds(433, 13, 56, 16);
		eachLogPanel_4.add(typeLabel_4);
		
		typeTextField_4 = new JTextField();
		typeTextField_4.setColumns(10);
		typeTextField_4.setBounds(410, 42, 87, 22);
		eachLogPanel_4.add(typeTextField_4);
		
		JLabel injectLabel_4 = new JLabel("Inject");
		injectLabel_4.setBounds(540, 13, 56, 16);
		eachLogPanel_4.add(injectLabel_4);
		
		injectTextField_4 = new JTextField();
		injectTextField_4.setColumns(10);
		injectTextField_4.setBounds(521, 42, 87, 22);
		eachLogPanel_4.add(injectTextField_4);
		
		JLabel removeLabel_4 = new JLabel("Remove");
		removeLabel_4.setBounds(652, 13, 56, 16);
		eachLogPanel_4.add(removeLabel_4);
		
		removeTextField_4 = new JTextField();
		removeTextField_4.setColumns(10);
		removeTextField_4.setBounds(635, 42, 87, 22);
		eachLogPanel_4.add(removeTextField_4);
		
		JLabel fixLabel_4 = new JLabel("Fix");
		fixLabel_4.setBounds(827, 13, 56, 16);
		eachLogPanel_4.add(fixLabel_4);
		
		JTextField fixEditorPane_4 = new JTextField();
		fixEditorPane_4.setBounds(738, 42, 216, 22);
		eachLogPanel_4.add(fixEditorPane_4);
		
		JLabel fixRefLabel_4 = new JLabel("Fix Ref.");
		fixRefLabel_4.setBounds(973, 13, 56, 16);
		eachLogPanel_4.add(fixRefLabel_4);
		
		fixRefTextField_4 = new JTextField();
		fixRefTextField_4.setColumns(10);
		fixRefTextField_4.setBounds(966, 42, 70, 22);
		eachLogPanel_4.add(fixRefTextField_4);
		
		JButton addButton_4 = new JButton();
		addButton_4.setBounds(1068, 30, 49, 33);
		addButton_4.setContentAreaFilled(false);
		addButton_4.setIcon( new ImageIcon(net.sf.memoranda.ui.AppFrame.class.getResource("resources/icons/plus.png")));
		eachLogPanel_4.add(addButton_4);
		
		JButton update = new JButton("Update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		update.setBounds(1019, 455, 97, 25);
		update.setToolTipText("Update values");
		containsLogsPanel.add(update);
		
		JTextArea defectsKey = new JTextArea();
		defectsKey.setBounds(879, 13, 342, 116);
		defectsKey.setText("Defect Types" + "\n10 Documentation\t60 Checking" + 
				"\n20 Syntax\t\t70 Data" + "\n30 Build, Package\t80 Function" +  
				"\n40 Assignment\t\t90 System" + "\n50 Interface\t\t100 Environment");
		defectsKey.setEditable(false);
		add(defectsKey);
		
	}
}
