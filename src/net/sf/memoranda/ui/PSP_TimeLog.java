package net.sf.memoranda.ui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.sf.memoranda.psp.TimeLog;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PSP_TimeLog extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static boolean isDirty = false;
	private JPanel contentPane;
	private JTextField dateTextField;
	private JTextField startTimeTextField;
	private JTextField interruptTimeTextField;
	private JTextField endTimeTextField;
	private JTextField phaseTextField;
	private JButton bttnDone;
	private JButton bttnMoreEntries;
	
	private TimeLog timelog;
	

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
		jInit();
	}
	
	public void jInit () {
		setLayout(new BorderLayout(0, 0));
		contentPane = new JPanel();
        
        JLabel lblTimeLogEntries = new JLabel("Time Log Entries");
        lblTimeLogEntries.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 18));
        lblTimeLogEntries.setHorizontalAlignment(SwingConstants.CENTER);
        
        JLabel lblDate = new JLabel("Date");
        
        JLabel lblStartTime = new JLabel("Start Time");
        
        JLabel lblInterruptTime = new JLabel("Interrupt Time");
        
        JLabel lblEndTime = new JLabel("End Time");
        
        JLabel lblPhase = new JLabel("Phase");
        
        dateTextField = new JTextField();
        dateTextField.setColumns(10);
        
        startTimeTextField = new JTextField();
        startTimeTextField.setColumns(10);
        
        interruptTimeTextField = new JTextField();
        interruptTimeTextField.setColumns(10);
        
        endTimeTextField = new JTextField();
        endTimeTextField.setColumns(10);
        
        phaseTextField = new JTextField();
        phaseTextField.setColumns(10);
        
        bttnMoreEntries = new JButton();
        bttnMoreEntries.setText("More Entries");
        
        bttnDone = new JButton();
        bttnDone.setText("Done");
        
        add(contentPane);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(83)
        					.addComponent(bttnMoreEntries, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
        					.addGap(120)
        					.addComponent(bttnDone, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addGap(34)
        					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
        						.addComponent(lblTimeLogEntries)
        						.addGroup(gl_contentPane.createSequentialGroup()
        							.addComponent(lblDate)
        							.addGap(53)
        							.addComponent(lblStartTime)
        							.addGap(31)
        							.addComponent(lblInterruptTime)
        							.addGap(33)))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblEndTime, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
        					.addGap(15)
        					.addComponent(lblPhase, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_contentPane.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(dateTextField, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(startTimeTextField, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(interruptTimeTextField, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(endTimeTextField, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(phaseTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
        			.addGap(24))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addComponent(lblTimeLogEntries, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        			.addGap(5)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        					.addComponent(lblStartTime, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblInterruptTime, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblPhase, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblEndTime, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)))
        			.addGap(5)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
        				.addComponent(dateTextField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(startTimeTextField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(interruptTimeTextField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(endTimeTextField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
        				.addComponent(phaseTextField, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addGap(60)
        			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
        				.addComponent(bttnMoreEntries, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        				.addComponent(bttnDone, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
        );
        contentPane.setLayout(gl_contentPane);
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
