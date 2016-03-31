package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class PSP_NewTaskDialog extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4064987826608820142L;
	//public static Object[] tdarray;
	private JPanel contentPane;
	private JTextField taskTextField;
	private JTextField descriptionTextField;
	private JTextField startDateTextField;
	private JTextField estDateTextField;
	private JTextField estTimeTextField;
	private JTextField priorityTextField;
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
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		taskTextField = new JTextField();
		taskTextField.setColumns(10);
		
		descriptionTextField = new JTextField();
		descriptionTextField.setColumns(10);
		
		startDateTextField = new JTextField();
		startDateTextField.setColumns(10);
		
		JLabel lblEndDate_1 = new JLabel("Est End date:");
		
		estDateTextField = new JTextField();
		estDateTextField.setColumns(10);
		
		estTimeTextField = new JTextField();
		estTimeTextField.setColumns(10);
		
		priorityTextField = new JTextField();
		priorityTextField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
	            String tdarray;
	            int count=0;
	            
	            // places whatever text is in the Jtextfield into a string variable
	            
	            tdarray=taskTextField.getText();
	            
	            // saves the value of the string variable and calls method to build array, places
	            // var on the the index of the current count
	            
	            tdata.saveTaskData(tdarray, count);
	                     
	            //increase count to move down array index and populate other fields
	            
	            count++;
	                    
	            tdarray=startDateTextField.getText();
	            tdata.saveTaskData(tdarray, count);
	            count++;
	            
	            tdarray=estDateTextField.getText();
	            tdata.saveTaskData(tdarray, count);
	            count++;
	            
                tdarray=priorityTextField.getText();
	            tdata.saveTaskData(tdarray, count);
	            count++;
	            
	            tdarray=estTimeTextField.getText();
	            tdata.saveTaskData(tdarray, count);
	            count++;
	            
	            // print array contents to console for testing
	            
	            for(int i=0; i<6; i++)
	            {
	            	PSP_NewTaskData.showTaskData(i);
	            }
	            
	            //insert array contents to row
	            
	            PSP_NewTaskTable.insertRow();
	            dispose();
	            				
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			
			{
				
				dispose();
				
			}
		});
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
									.addComponent(taskTextField, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblTaskDescription)
										.addComponent(lblStartDate))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(descriptionTextField, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(15)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
													.addComponent(startDateTextField, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
													.addGroup(gl_contentPane.createSequentialGroup()
														.addPreferredGap(ComponentPlacement.RELATED)
														.addComponent(estTimeTextField, 0, 0, Short.MAX_VALUE)))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(btnOk)
													.addPreferredGap(ComponentPlacement.RELATED)))
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
															.addGap(12)
															.addComponent(lblEndDate_1))
														.addGroup(gl_contentPane.createSequentialGroup()
															.addGap(24)
															.addComponent(lblPriority)))
													.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
													.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addGroup(gl_contentPane.createSequentialGroup()
															.addComponent(estDateTextField, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
															.addPreferredGap(ComponentPlacement.RELATED))
														.addComponent(priorityTextField, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(44)
													.addComponent(btnCancel))))))
								.addComponent(lblEstimatedTime))))
					.addGap(153))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCreateNewTask)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTaskName)
						.addComponent(taskTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTaskDescription)
							.addGap(91)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblStartDate)
								.addComponent(startDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(estDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEndDate_1)))
						.addComponent(descriptionTextField, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstimatedTime)
						.addComponent(lblPriority)
						.addComponent(estTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(priorityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOk)
						.addComponent(btnCancel))
					.addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
