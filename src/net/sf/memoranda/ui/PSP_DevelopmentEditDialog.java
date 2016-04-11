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

public class PSP_DevelopmentEditDialog extends JFrame implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4064987826608820142L;
	public static final Object col0 = null;
	private JPanel contentPane;
	private JTextField editTaskTextField;
	private JTextField editDescriptionTextField;
	private JTextField editStartDateTextField;
	private JTextField editEstDateTextField;
	private JTextField editEstTimeTextField;
	private JTextField editPriorityTextField;
	PSP_DevelopmentData tdata = new PSP_DevelopmentData();
	
	List<String> n = new ArrayList<String>();
	private JTextField editPercentField;
	private JTextField editStatusField;

	/**
	 * Launch the application.
	 */
	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PSP_DevelopmentEditDialog frame = new PSP_DevelopmentEditDialog();
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
	public PSP_DevelopmentEditDialog() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 589, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblCreateNewTask = new JLabel("EDIT TASK");
		lblCreateNewTask.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblTaskName = new JLabel("Edit task:");
		
		JLabel lblTaskDescription = new JLabel("Edit Description");
		
		JLabel lblStartDate = new JLabel("Edit start date:");
		
		JLabel lblEstimatedTime = new JLabel("Edit estimated time:");
		
		JLabel lblPriority = new JLabel("Edit Priority:");
		
		JLabel lblEditStatus = new JLabel("Edit status");
		

		//eidt dialog populates value from existing row
		editTaskTextField = new JTextField();
		Object ETT = PSP_DevelopmentTable.getCellValues(0);
		editTaskTextField.setText((String) ETT);
		editTaskTextField.setColumns(10);
		
		editDescriptionTextField = new JTextField();
		editDescriptionTextField.setColumns(10);
		
		editStartDateTextField = new JTextField();
		Object ESD = PSP_DevelopmentTable.getCellValues(1);
		editStartDateTextField.setText((String) ESD);
		//editStartDateTextField.setText("test");
		editStartDateTextField.setColumns(10);
		
		JLabel lblEndDate_1 = new JLabel("Edit Est End date:");
		
		editEstDateTextField = new JTextField();
		Object ESDTF = PSP_DevelopmentTable.getCellValues(2);
		editEstDateTextField.setText((String) ESDTF);
		//editEstDateTextField.setText("test");
		editEstDateTextField.setColumns(10);
		
		editEstTimeTextField = new JTextField();
		Object EETTF = PSP_DevelopmentTable.getCellValues(3);
		editEstTimeTextField.setText((String) EETTF);
		//editEstTimeTextField.setText("test");
		editEstTimeTextField.setColumns(10);
		
		editPriorityTextField = new JTextField();
		Object EPTF = PSP_DevelopmentTable.getCellValues(4);
		editPriorityTextField.setText((String) EPTF);
		//editPriorityTextField.setText("test");
		editPriorityTextField.setColumns(10);
		
		editStatusField = new JTextField();
		Object ESF = PSP_DevelopmentTable.getCellValues(5);
		editStatusField.setText((String) ESF);
		editStatusField.setColumns(10);
						
		JLabel lblEditComplete = new JLabel("Edit % Complete");
		editPercentField = new JTextField();
		Object EPF = PSP_DevelopmentTable.getCellValues(8);
		editPercentField.setText((String) EPF);
		editPercentField.setColumns(10);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
	          /*
	           * TODO: 
	           * Populate jtextfield values w/ values already inside that
	           * selected row. (DONE, ABOVE)
	           * Use savetaskdata's method to build array (SCRAPPED IDEA)
	           * 
	           * TODO: just pass the overwritten values of textfields
	           * directly to cells (IN PROGRESS)
	           * 
	          */
				
				String cellvalue0=editTaskTextField.getText();
				PSP_DevelopmentTable.editRow(cellvalue0, 0);
								
				String cellvalue1=editStartDateTextField.getText();
				PSP_DevelopmentTable.editRow(cellvalue1, 1);
				
				String cellvalue2=editEstDateTextField.getText();
				PSP_DevelopmentTable.editRow(cellvalue2, 2);
				
				//cell3
				
				String cellvalue4=editPriorityTextField.getText();
				PSP_DevelopmentTable.editRow(cellvalue4, 4);
				
				//cell 5, 6, 7
				
				String cellvalue5=editStatusField.getText();
				PSP_DevelopmentTable.editRow(cellvalue5, 5);
								
				String cellvalue6=editEstTimeTextField.getText();
				PSP_DevelopmentTable.editRow(cellvalue6, 6);
				
			
				String cellvalue8=editPercentField.getText();
				PSP_DevelopmentTable.editRow(cellvalue8, 8);
								
				dispose();
					            				
			}
		});
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			
			{
				
				//PSP_NewTaskTable.editRow();
				dispose();
				
			}
		});
		

		

		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(80)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTaskName)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(editTaskTextField, GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTaskDescription)
								.addComponent(lblStartDate)
								.addComponent(lblEditComplete, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(editDescriptionTextField, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(15)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addComponent(editStartDateTextField, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
											.addGroup(gl_contentPane.createSequentialGroup()
												.addPreferredGap(ComponentPlacement.RELATED)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
													.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(editPercentField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
														.addPreferredGap(ComponentPlacement.RELATED))
													.addComponent(editEstTimeTextField, 0, 0, Short.MAX_VALUE))))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnOk)
											.addPreferredGap(ComponentPlacement.RELATED)))
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(12)
											.addComponent(lblEndDate_1)
											.addPreferredGap(ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(editEstDateTextField, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
													.addPreferredGap(ComponentPlacement.RELATED))
												.addComponent(editPriorityTextField, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(44)
											.addComponent(btnCancel))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(24)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblEditStatus, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
													.addPreferredGap(ComponentPlacement.RELATED)
													.addComponent(editStatusField, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE))
												.addComponent(lblPriority))
											.addPreferredGap(ComponentPlacement.RELATED))))))
						.addComponent(lblEstimatedTime))
					.addGap(153))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(237)
					.addComponent(lblCreateNewTask)
					.addContainerGap(374, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCreateNewTask)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTaskName)
						.addComponent(editTaskTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTaskDescription)
							.addGap(91)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblStartDate)
								.addComponent(editStartDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(editEstDateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEndDate_1)))
						.addComponent(editDescriptionTextField, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEstimatedTime)
						.addComponent(lblPriority)
						.addComponent(editEstTimeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(editPriorityTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(editPercentField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEditComplete)
						.addComponent(lblEditStatus)
						.addComponent(editStatusField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOk)
						.addComponent(btnCancel))
					.addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
		}
		}