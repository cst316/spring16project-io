package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class PSP_TimeLog extends JFrame {

	private JPanel contentPane;
	private JTextField dateTextField;
	private JTextField startTimeTextField;
	private JTextField interruptTimeTextField;
	private JTextField endTimeTextField;
	private JTextField phaseTextField;
	private JButton bttnDone;
	private JButton bttnMoreEntries;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PSP_TimeLog frame = new PSP_TimeLog();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PSP_TimeLog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTimeLogEntries = new JLabel("Time Log Entries");
		lblTimeLogEntries.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimeLogEntries.setFont(new Font("Tahoma", Font.PLAIN, 18));
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
		lblPhase.setBounds(344, 61, 46, 14);
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
		endTimeTextField.setBounds(259, 86, 86, 20);
		contentPane.add(endTimeTextField);
		endTimeTextField.setColumns(10);
		
		phaseTextField = new JTextField();
		phaseTextField.setBounds(338, 86, 86, 20);
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
