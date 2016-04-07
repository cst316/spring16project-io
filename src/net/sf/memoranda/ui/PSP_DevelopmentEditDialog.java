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
	private JPanel contentPane;
	private JTextField editTaskTextField;
	private JTextField editDescriptionTextField;
	private JTextField editStartDateTextField;
	private JTextField editEstDateTextField;
	private JTextField editEstTimeTextField;
	private JTextField editPriorityTextField;
	PSP_DevelopmentData tdata = new PSP_DevelopmentData();
	
	List<String> n = new ArrayList<String>();

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
		
		JLabel lblEndDate_1 = new JLabel("Edit End date:");
		
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
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
	          /*
	           * TODO: 
	           * Populate jtextfield values w/ values already inside that
	           * selected row.  Use savetaskdata's method to build array, send
	           * string to respective row/column with editrow method, etc, etc.
	           * 
	          */
				
				
				
				

	            				
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
		    .addComponent(editTaskTextField, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE))
		   .addGroup(gl_contentPane.createSequentialGroup()
		    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		     .addComponent(lblTaskDescription)
		     .addComponent(lblStartDate))
		    .addPreferredGap(ComponentPlacement.UNRELATED)
		    .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
		     .addComponent(editDescriptionTextField, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
		     .addGroup(gl_contentPane.createSequentialGroup()
		      .addGap(15)
		      .addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
		       .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
		        .addComponent(editStartDateTextField, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
		        .addGroup(gl_contentPane.createSequentialGroup()
		         .addPreferredGap(ComponentPlacement.RELATED)
		         .addComponent(editEstTimeTextField, 0, 0, Short.MAX_VALUE)))
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
		          .addComponent(editEstDateTextField, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
		          .addPreferredGap(ComponentPlacement.RELATED))
		         .addComponent(editPriorityTextField, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)))
		       .addGroup(gl_contentPane.createSequentialGroup()
		        .addGap(44)
		        .addComponent(btnCancel))))))
		   .addComponent(lblEstimatedTime))
		  .addGap(153))
		 .addGroup(gl_contentPane.createSequentialGroup()
		  .addGap(237)
		  .addComponent(lblCreateNewTask)
		  .addContainerGap(245, Short.MAX_VALUE))
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
		  .addPreferredGap(ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
		  .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
		   .addComponent(btnOk)
		   .addComponent(btnCancel))
		  .addGap(26))
		);
		contentPane.setLayout(gl_contentPane);
		}
		}