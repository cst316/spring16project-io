 package net.sf.memoranda.ui;
 
 import java.awt.BorderLayout;
 import java.awt.EventQueue;
 
 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import javax.swing.border.EmptyBorder;
 import javax.swing.GroupLayout;
 import javax.swing.GroupLayout.Alignment;
 import javax.swing.JScrollPane;
 import javax.swing.JTable;
 import javax.swing.table.DefaultTableModel;
 
 import net.sf.memoranda.psp.Development;
 
 import javax.swing.JButton;
 import javax.swing.LayoutStyle.ComponentPlacement;
 import java.awt.event.ActionListener;
 import java.io.Serializable;
 import java.awt.event.ActionEvent;
 
 public class PSP_NewTaskTable extends JPanel implements Serializable {
 
 	/**
 	 * 
 	 */
 	private static final long serialVersionUID = 1223267046325848388L;
 	private JPanel contentPane;
 	private static JTable table;
 	private static boolean isDirty = false;
 	
 	Development devel;
 
 	public PSP_NewTaskTable () {
 		jbInit();
 	}
 	
 	public PSP_NewTaskTable (Development devel) {
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
 				PSP_NewTaskDialog nw = new PSP_NewTaskDialog();
 				nw.NewScreen();
 				
 				
 			}
 		});
 		
 		JButton btnCloseTask = new JButton("Complete Task");
 		btnCloseTask.addActionListener(new ActionListener() {
 			public void actionPerformed(ActionEvent arg0) {
 				
 			 //opens NewTaskDialog
 			PSP_NewTaskDialogClose nw = new PSP_NewTaskDialogClose();
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
 		GroupLayout gl_contentPane = new GroupLayout(contentPane);
 		gl_contentPane.setHorizontalGroup(
 			gl_contentPane.createParallelGroup(Alignment.LEADING)
 				.addGroup(gl_contentPane.createSequentialGroup()
 					.addContainerGap()
 					.addComponent(btnNewTask)
 					.addGap(18)
 					.addComponent(btnDeleteTask)
 					.addGap(14)
 					.addComponent(btnEditTask)
 					.addGap(18)
 					.addComponent(btnCloseTask)
 					.addContainerGap(403, Short.MAX_VALUE))
 				.addGroup(gl_contentPane.createSequentialGroup()
 					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
 					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 831, GroupLayout.PREFERRED_SIZE)
 					.addContainerGap())
 		);
 		gl_contentPane.setVerticalGroup(
 			gl_contentPane.createParallelGroup(Alignment.LEADING)
 				.addGroup(gl_contentPane.createSequentialGroup()
 					.addContainerGap()
 					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
 						.addComponent(btnNewTask)
 						.addComponent(btnEditTask)
 						.addComponent(btnDeleteTask)
 						.addComponent(btnCloseTask))
 					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
 					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
 					.addContainerGap())
 		);
 		
 		table = new JTable();
 		table.setModel(new DefaultTableModel(
 			new Object[][] {
 				{null, null, null, "", null, null, null, null, null},
 			},
 			new String[] {
 				"Task", "Start Date", "Est. End Date", "Actual End Date", "Priority", "Status", "Estimate (Hrs)", "Actual (Hrs)", "% Done"
 			}
 		));
 		table.getColumnModel().getColumn(2).setPreferredWidth(99);
 		table.getColumnModel().getColumn(3).setPreferredWidth(104);
 		table.getColumnModel().getColumn(6).setPreferredWidth(102);
 		table.getColumnModel().getColumn(7).setPreferredWidth(86);
 		scrollPane.setViewportView(table);
 		contentPane.setLayout(gl_contentPane);
 		add(contentPane);
 	}
 	
 	public static void insertRow() {
 		
 		((DefaultTableModel) table.getModel()).insertRow(table.getRowCount(),new Object[]{PSP_NewTaskData.tdarray[0],PSP_NewTaskData.tdarray[1],PSP_NewTaskData.tdarray[2],null,PSP_NewTaskData.tdarray[3],null,PSP_NewTaskData.tdarray[4]});
 		
 	}
 	
 	public void removeRow()
 	{
 		   DefaultTableModel model = (DefaultTableModel) PSP_NewTaskTable.table.getModel();
 		   
 		   int[] rows = table.getSelectedRows();
 		   
 		   for(int i=0;i<rows.length;i++)
 		   {
 		   
 			   model.removeRow(rows[i]-i);
 			   
 		   }
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
