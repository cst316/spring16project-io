package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * PSP Time Log. Used for users to enter the time that they spent on the project.
 * @author Julie
 *
 */

public class PSP_TimeLog extends JFrame {

	private JPanel contentPane;
	private JTextField dateTextField;
	private JTextField startTimeTextField;
	private JTextField interruptTimeTextField;
	private JTextField endTimeTextField;
	private JTextField phaseTextField;

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
		lblTimeLogEntries.setBounds(139, 11, 157, 19);
		contentPane.add(lblTimeLogEntries);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(10, 55, 46, 14);
		contentPane.add(lblDate);
		
		JLabel lblTimeStarted = new JLabel("Time Started");
		lblTimeStarted.setBounds(74, 55, 70, 14);
		contentPane.add(lblTimeStarted);
		
		JLabel lblInterruptTime = new JLabel("Interrupt Time");
		lblInterruptTime.setBounds(154, 55, 88, 14);
		contentPane.add(lblInterruptTime);
		
		JLabel lblEndTime = new JLabel("End Time");
		lblEndTime.setBounds(234, 55, 62, 14);
		contentPane.add(lblEndTime);
		
		JLabel lblPhase = new JLabel("Phase");
		lblPhase.setBounds(319, 55, 46, 14);
		contentPane.add(lblPhase);
		
		dateTextField = new JTextField();
		dateTextField.setBounds(0, 88, 62, 20);
		contentPane.add(dateTextField);
		dateTextField.setColumns(10);
		
		startTimeTextField = new JTextField();
		startTimeTextField.setBounds(74, 88, 77, 20);
		contentPane.add(startTimeTextField);
		startTimeTextField.setColumns(10);
		
		interruptTimeTextField = new JTextField();
		interruptTimeTextField.setBounds(154, 88, 70, 20);
		contentPane.add(interruptTimeTextField);
		interruptTimeTextField.setColumns(10);
		
		endTimeTextField = new JTextField();
		endTimeTextField.setBounds(234, 88, 70, 20);
		contentPane.add(endTimeTextField);
		endTimeTextField.setColumns(10);
		
		phaseTextField = new JTextField();
		phaseTextField.setBounds(319, 88, 105, 20);
		contentPane.add(phaseTextField);
		phaseTextField.setColumns(10);
		
		JButton btnSaveButton = new JButton("Save");
		btnSaveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSaveButton.setBounds(215, 202, 89, 23);
		contentPane.add(btnSaveButton);
		
		JButton btnMoreEntries = new JButton("More Entries");
		btnMoreEntries.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMoreEntries.setBounds(74, 202, 105, 23);
		contentPane.add(btnMoreEntries);
	}
}
