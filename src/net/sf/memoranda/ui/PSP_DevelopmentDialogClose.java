package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PSP_DevelopmentDialogClose extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4364375426252043089L;
	public static Object actualHours;
	public static Object actualEndDate;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField actualHoursTextField;
	private JTextField actualEndDateTextField;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PSP_DevelopmentDialogClose frame = new PSP_DevelopmentDialogClose();
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
	public PSP_DevelopmentDialogClose() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 536, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCloseTask = new JLabel("CLOSE TASK");
		lblCloseTask.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblComments = new JLabel("Comments:");
		
		JLabel lblActualEfforthours = new JLabel("Actual Effort (hours):");
		
		actualHoursTextField = new JTextField();
		//textField_1.setText("1");
		actualHoursTextField.setColumns(10);
		
		JButton btnOk = new JButton("Close Task");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String actualHours = actualHoursTextField.getText();
				String actualEndDate = actualEndDateTextField.getText();
				
				
				PSP_DevelopmentTable.closeTask(actualHours,actualEndDate);
				dispose();
				
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		
		actualEndDateTextField = new JTextField();
		actualEndDateTextField.setColumns(10);
		
		JLabel lblActualEndDate = new JLabel("Actual End Date:");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(200)
							.addComponent(lblCloseTask))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(78)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblComments)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblActualEndDate, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblActualEfforthours))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(actualEndDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(actualHoursTextField, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(174)
							.addComponent(btnOk)
							.addGap(34)
							.addComponent(btnCancel)))
					.addContainerGap(91, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(lblCloseTask)
					.addGap(12)
					.addComponent(lblComments)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblActualEfforthours)
						.addComponent(actualHoursTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(actualEndDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblActualEndDate))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnOk))
					.addGap(24))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
