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
	
	Development devel;

	public PSP_NewTaskTable () {
		jbInit();
	}
	
	public PSP_NewTaskTable (Development devel) {
		this.devel = devel;
		jbInit();
	}

	public void jbInit() {
		setBounds(100, 100, 619, 517);
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
		
		JButton btnTest = new JButton("test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//figured out how to dynamically populate jtable
				//next step is to make it populate from tdarray instead of arbitrary strings
				
				insertRow();
				
				//((DefaultTableModel) table.getModel()).insertRow(table.getRowCount(),new Object[]{"Task X","Date X","etc."});
				
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 567, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewTask)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnCloseTask)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnEditTask)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDeleteTask)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnTest)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewTask)
						.addComponent(btnCloseTask)
						.addComponent(btnEditTask)
						.addComponent(btnDeleteTask)
						.addComponent(btnTest))
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, "", null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Task", "Start Date", "End Date", "Priority", "Status", "Estimate", "% Done", "Actual"
			}
		));
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		add(contentPane);
	}
	

	//method to insert row to table
	
	public static void insertRow() {
		
		((DefaultTableModel) table.getModel()).insertRow(table.getRowCount(),new Object[]{PSP_NewTaskData.tdarray[0],PSP_NewTaskData.tdarray[2],PSP_NewTaskData.tdarray[3],PSP_NewTaskData.tdarray[5],null,PSP_NewTaskData.tdarray[4]});
		
	}
}
