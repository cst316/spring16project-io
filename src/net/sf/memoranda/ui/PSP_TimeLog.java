package net.sf.memoranda.ui;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.itextpdf.text.Font;

public class PSP_TimeLog extends JPanel {
	
	private JPanel contentPane;
	private JTextField dateTextField;
	private JTextField startTimeTextField;
	private JTextField interruptTimeTextField;
	private JTextField endTimeTextField;
	private JTextField phaseTextField;
	private JButton bttnDone;
	private JButton bttnMoreEntries;
	

	/**
	 * Create the panel.
	 */
	public PSP_TimeLog() {
		contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        
        JLabel lblTimeLogEntries = new JLabel("Time Log Entries");
        lblTimeLogEntries.setFont(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 18));
        lblTimeLogEntries.setHorizontalAlignment(SwingConstants.CENTER);
        lblTimeLogEntries.setBounds(94, 11, 229, 26);
        contentPane.add(lblTimeLogEntries);
        
        JLabel lblDate = new JLabel("Date");
        lblDate.setBounds(17, 61, 46, 14);
        contentPane.add(lblDate);
        
        JLabel lblStartTime = new JLabel("Start Time");
        lblStartTime.setBounds(73, 61, 67, 14);
        contentPane.add(lblStartTime);
        
        JLabel lblInterruptTime = new JLabel("Interrupt Time");
        lblInterruptTime.setBounds(150, 61, 86, 14);
        contentPane.add(lblInterruptTime);
        
        JLabel lblEndTime = new JLabel("End Time");
        lblEndTime.setBounds(265, 61, 46, 14);
        contentPane.add(lblEndTime);
        
        JLabel lblPhase = new JLabel("Phase");
        lblPhase.setBounds(358, 61, 46, 14);
        contentPane.add(lblPhase);
        
        dateTextField = new JTextField();
        dateTextField.setBounds(10, 86, 67, 20);
        contentPane.add(dateTextField);
        dateTextField.setColumns(10);
        
        startTimeTextField = new JTextField();
        startTimeTextField.setBounds(83, 86, 67, 20);
        contentPane.add(startTimeTextField);
        startTimeTextField.setColumns(10);
        
        interruptTimeTextField = new JTextField();
        interruptTimeTextField.setBounds(160, 86, 86, 20);
        contentPane.add(interruptTimeTextField);
        interruptTimeTextField.setColumns(10);
        
        endTimeTextField = new JTextField();
        endTimeTextField.setBounds(254, 86, 86, 20);
        contentPane.add(endTimeTextField);
        endTimeTextField.setColumns(10);
        
        phaseTextField = new JTextField();
        phaseTextField.setBounds(354, 86, 86, 20);
        contentPane.add(phaseTextField);
        phaseTextField.setColumns(10);
        
        bttnDone = new JButton();
        bttnDone.setText("Done");
        bttnDone.setBounds(237,193,86,20);
        contentPane.add(bttnDone);
        
        bttnMoreEntries = new JButton();
        bttnMoreEntries.setText("More Entries");
        bttnMoreEntries.setBounds(73,193,112,20);
        contentPane.add(bttnMoreEntries);

	}

}
