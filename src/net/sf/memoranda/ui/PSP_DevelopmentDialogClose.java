package net.sf.memoranda.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.sf.memoranda.psp.DevRowObject;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class PSP_DevelopmentDialogClose extends JFrame {

	private static final long serialVersionUID = -4364375426252043089L;
	private JPanel contentPane;
	protected JTextField commentsTextField;
	protected JTextField actualHoursTextField;
	protected JTextField actualEndDateTextField;
	private DevRowObject myDevRow;
	
	public PSP_DevelopmentDialogClose() {
		this (new DevRowObject());
	}
	
	public PSP_DevelopmentDialogClose(DevRowObject myDevRow) {
		this.myDevRow = myDevRow;
		jbInit();
	}
	
	private void jbInit() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 536, 389);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCloseTask = new JLabel("CLOSE TASK");
		lblCloseTask.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		commentsTextField = new JTextField();
		commentsTextField.setColumns(10);
		
		JLabel lblComments = new JLabel("Comments:");
		
		JLabel lblActualEfforthours = new JLabel("Actual Effort (hours):");
		lblActualEfforthours.setHorizontalAlignment(SwingConstants.RIGHT);
		
		actualHoursTextField = new JTextField();
		actualHoursTextField.setColumns(10);
		
		JButton btnOk = new JButton("Close Task");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				closeTask();
				
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
		lblActualEndDate.setHorizontalAlignment(SwingConstants.RIGHT);
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
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblActualEndDate, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblActualEfforthours, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(actualEndDateTextField, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addComponent(actualHoursTextField, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(btnOk)
										.addGap(144)
										.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
									.addComponent(commentsTextField, GroupLayout.PREFERRED_SIZE, 339, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(107, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(25)
					.addComponent(lblCloseTask)
					.addGap(12)
					.addComponent(lblComments)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(commentsTextField, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblActualEfforthours, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(actualHoursTextField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(actualEndDateTextField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblActualEndDate, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnOk))
					.addGap(24))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	protected void closeTask() {		
		myDevRow.setCloseComment(this.commentsTextField.getText().trim());
				
		String actualEndDate = actualEndDateTextField.getText();
		if (!actualEndDateTextField.getText().trim().isEmpty()) {
			myDevRow.setEndDate(actualEndDate);
		} 
		
		String actualHours = actualHoursTextField.getText();
		if (!actualHours.trim().isEmpty()) {
			myDevRow.setActualComplete(Float.parseFloat(actualHours));
			myDevRow.setStatus("COMPLETE");
			myDevRow.setPercentComplete(100.0f);
			
			dispose();			
			PSP_DevelopmentTable.closeTask(myDevRow);			
		}
	}
}
