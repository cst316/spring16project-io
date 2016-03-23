package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import java.awt.SystemColor;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class PSP_NewTaskDialog extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	PSP_NewTaskData tdata = new PSP_NewTaskData();
	
	List<String> n = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PSP_NewTaskDialog frame = new PSP_NewTaskDialog();
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
	public PSP_NewTaskDialog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 589, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCreateNewTask = new JLabel(" CREATE NEW TASK");
		lblCreateNewTask.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblTaskName = new JLabel("Task name:");
		
		JLabel lblTaskDescription = new JLabel("Description:");
		
		JLabel lblStartDate = new JLabel("Start date:");
		
		JLabel lblEstimatedTime = new JLabel("Estimated time:");
		
		JLabel lblPriority = new JLabel("Priority:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel lblEndDate_1 = new JLabel("End date:");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
	            String tdarray;
	            int count=0;
	            
	            // places whatever text is in the Jtextfield into a string variable
	            
	            tdarray=textField.getText();
	            
	            // saves the value of the string variable and calls method to build array, places
	            // var on the the index of the current count
	            
	            tdata.saveTaskData(tdarray, count);
	            
	            // arbitrarily setting next value of textfield and increasing counter for testing
	            
	            //textField.setText("whatever");
	            
	            //increase count to move down array index
	            
	            count++;
	            
	            tdarray=textField_1.getText();
	            tdata.saveTaskData(tdarray, count);
	            count++;
	            
	            tdarray=textField_2.getText();
	            tdata.saveTaskData(tdarray, count);
	            count++;
	            
	            tdarray=textField_3.getText();
	            tdata.saveTaskData(tdarray, count);
	            count++;
	            
	            tdarray=textField_4.getText();
	            tdata.saveTaskData(tdarray, count);
	            count++;
	            
	            tdarray=textField_5.getText();
	            tdata.saveTaskData(tdarray, count);
	            count++;
	            
	            // print array contents to console for testing
	            
	            PSP_NewTaskData.showTaskData(1);
				
				
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(193)
							.addComponent(lblCreateNewTask))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(80)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTaskName)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(textField, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTaskDescription)
										.addComponent(lblStartDate))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(15)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
														.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
														.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
															.addPreferredGap(ComponentPlacement.RELATED)
															.addComponent(textField_4, 0, 0, Short.MAX_VALUE))))
												.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
													.addComponent(btnOk)
													.addPreferredGap(ComponentPlacement.RELATED)))
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(12)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(lblEndDate_1, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
														.addComponent(lblPriority, Alignment.TRAILING))
													.addPreferredGap(ComponentPlacement.RELATED)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
														.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(63)
													.addComponent(btnCancel))))))
								.addComponent(lblEstimatedTime))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(140))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCreateNewTask)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTaskName)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTaskDescription)
							.addGap(91)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblStartDate)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEndDate_1)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstimatedTime)
						.addComponent(lblPriority)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancel)
						.addComponent(btnOk))
					.addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
