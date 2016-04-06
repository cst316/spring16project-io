 package net.sf.memoranda.ui;
 
 import java.awt.BorderLayout;
 import java.awt.EventQueue;
 
 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import javax.swing.border.EmptyBorder;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
 import javax.swing.GroupLayout.Alignment;
 import javax.swing.JScrollPane;
 import javax.swing.JTable;
 import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import net.sf.memoranda.psp.Development;
 
 import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
 import java.awt.event.ActionListener;
 import java.io.Serializable;
 import java.awt.event.ActionEvent;
 
 public class PSP_DevelopmentTable extends JPanel implements Serializable {
 
 	/**
 	 * 
 	 */
 	private static final long serialVersionUID = 1223267046325848388L;
 	private JPanel contentPane;
 	private static JTable table;
 	private static boolean isDirty = false;
 	
 	Development devel;
 
 	public PSP_DevelopmentTable () {
 		jbInit();
 	}
 	
 	public PSP_DevelopmentTable (Development devel) {
 		this.devel = devel;
 		jbInit();
 	}
 
 	public void jbInit() {
 		setBounds(100, 100, 1197, 517);
 		contentPane = new JPanel();
 		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 		
 		JScrollPane scrollPane = new JScrollPane();
 		
 		JButton btnNewTask = new JButton("New Task");
 		btnNewTask.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent e) {
 								
 				 //opens NewTaskDialog
 				PSP_DevelopmentDialog nw = new PSP_DevelopmentDialog();
 				nw.NewScreen();
 				
 				
 			}
 		});
 		
 		JButton btnCloseTask = new JButton("Complete Task");
 		btnCloseTask.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				
 			 //opens NewTaskDialog
 			PSP_DevelopmentDialogClose nw = new PSP_DevelopmentDialogClose();
 			nw.NewScreen();
 				
 			}
 		});
 		
 		JButton btnEditTask = new JButton("Edit Task");
 		
 		JButton btnDeleteTask = new JButton("Delete Task");
 		btnDeleteTask.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) 
 			
 			{
 				
 				removeRow();
 				
 			}
 		});
 		
 		JButton btnViewDescription = new JButton("View Description");
 		btnViewDescription.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) 
 			
 			{
 				
 				//view description method will call new jframe with
 				//task description text of selected row
 				
 				PSP_DevelopmentTaskDescription nw = new PSP_DevelopmentTaskDescription();
 	 			nw.NewScreen();
 				
 				
 			}
 			
 			
 			
 		});
 		GroupLayout gl_contentPane = new GroupLayout(contentPane);
 		gl_contentPane.setHorizontalGroup(
 			gl_contentPane.createParallelGroup(Alignment.LEADING)
 				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
 					.addContainerGap()
 					.addComponent(btnViewDescription)
 					.addPreferredGap(ComponentPlacement.RELATED)
 					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
 						.addGroup(gl_contentPane.createSequentialGroup()
 							.addComponent(btnNewTask)
 							.addGap(26)
 							.addComponent(btnDeleteTask)
 							.addPreferredGap(ComponentPlacement.UNRELATED)
 							.addComponent(btnEditTask)
 							.addGap(18)
 							.addComponent(btnCloseTask)
 							.addContainerGap(397, Short.MAX_VALUE))
 						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
 							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 831, GroupLayout.PREFERRED_SIZE)
 							.addContainerGap())))
 		);
 		gl_contentPane.setVerticalGroup(
 			gl_contentPane.createParallelGroup(Alignment.LEADING)
 				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
 					.addGap(30)
 					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
 						.addComponent(btnCloseTask)
 						.addComponent(btnEditTask)
 						.addComponent(btnDeleteTask)
 						.addComponent(btnNewTask))
 					.addGap(18, 34, Short.MAX_VALUE)
 					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
 						.addComponent(btnViewDescription)
 						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE))
 					.addContainerGap())
 		);
 		
 		table = new JTable();
 		table.setModel(new DefaultTableModel(
 			new Object[][] {
 				{"Example", "Example", "Example", "Example", "Example", "Example", "Example", "Example", "Example"},
 			},
 			new String[] {
 				"Task", "Start Date", "Est. End Date", "Actual End Date", "Priority", "Status", "Estimate (Hrs)", "Actual (Hrs)", "% Done"
 			}
 		));
 		table.getColumnModel().getColumn(2).setPreferredWidth(99);
 		table.getColumnModel().getColumn(3).setPreferredWidth(104);
 		table.getColumnModel().getColumn(5).setPreferredWidth(76); //status column
 		table.getColumnModel().getColumn(6).setPreferredWidth(102);
 		table.getColumnModel().getColumn(7).setPreferredWidth(86);
 		
 		
 		/*
 		 * Dropdown on priority/status columns starts here
 		 *  
 		 */
 		
 		TableColumn statusColumn = table.getColumnModel().getColumn(5); //5 is status
 		JComboBox comboBox1 = new JComboBox();
 		comboBox1.addItem("OPEN");
 		comboBox1.addItem("COMPLETE");
 		statusColumn.setCellEditor(new DefaultCellEditor(comboBox1));
 		
 		TableColumn priorityColumn = table.getColumnModel().getColumn(4); //4 is priority
 		JComboBox comboBox2 = new JComboBox();
 		comboBox2.addItem("LOW");
 		comboBox2.addItem("MEDIUM");
 		comboBox2.addItem("HIGH");
 		priorityColumn.setCellEditor(new DefaultCellEditor(comboBox2));
 		
 		TableColumn estpercentColumn1 = table.getColumnModel().getColumn(8); //8 is percent complete estimate
 		JComboBox comboBox3 = new JComboBox();
 		comboBox3.addItem("25");
 		comboBox3.addItem("50");
 		comboBox3.addItem("75");
 		comboBox3.addItem("100");
 		estpercentColumn1.setCellEditor(new DefaultCellEditor(comboBox3));
 		
 		
 		
 		
 		scrollPane.setViewportView(table);
 		contentPane.setLayout(gl_contentPane);
 		add(contentPane);
 	}
 	
 	public static void insertRow() {
 		
 		((DefaultTableModel) table.getModel()).insertRow(table.getRowCount(),new Object[]{PSP_DevelopmentData.tdarray[0],PSP_DevelopmentData.tdarray[1],PSP_DevelopmentData.tdarray[2],null,PSP_DevelopmentData.tdarray[3],null,PSP_DevelopmentData.tdarray[4]});
 		
 	}
 	
 	public void removeRow()
 	{
 		   DefaultTableModel model = (DefaultTableModel) PSP_DevelopmentTable.table.getModel();
 		   
 		   //rows = value of the rows that are selected/clicked
 		   int[] rows = table.getSelectedRows();
 		   
 		   for(int i=0;i<rows.length;i++)
 		   {
 		   
 			   model.removeRow(rows[i]-i);
 			   
 		   }
 	}
 	
	public static void editRow() 
	{
		//not finished
		String existingrow1; //TODO: getvalueat at (row, col0), (row, col1), etc.
		
		//row = value of specific single row
		int row = table.getSelectedRow();
		
		//takes in string value that goes into cell, the row's number and the row's column
		((DefaultTableModel) table.getModel()).setValueAt("DEL", row, 3);
								
	}
	
	public static void closeTask() 
	{
		int row = table.getSelectedRow();
		
		((DefaultTableModel) table.getModel()).setValueAt("COMPLETE", row, 5);
		//column 5 hold the "status"
								
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
