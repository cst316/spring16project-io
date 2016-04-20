package net.sf.memoranda.ui;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import net.sf.memoranda.psp.DevRowObject;
import net.sf.memoranda.psp.Development;
import net.sf.memoranda.psp.DevelopmentImpl;
import net.sf.memoranda.util.Util;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PSP_DevelopmentTable extends JPanel implements Serializable {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	static JTable table;
	private static boolean isDirty = false;

	protected static Development devel;

	public PSP_DevelopmentTable() {
		this(new DevelopmentImpl());
	}

	public PSP_DevelopmentTable(Development devel) {
		PSP_DevelopmentTable.devel = devel;
		jbInit();
	}

	public void jbInit() {
		setBounds(0, 0, PSP_Panel.currentView.getWidth(), PSP_Panel.currentView.getHeight());
		setBackground(Color.WHITE);

		int xSpace = (getWidth() - 1000) / 2;
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(xSpace, 0, 1000, getHeight() - 100);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);

		JButton btnNewTask = new JButton("New Task");
		btnNewTask.setToolTipText("Create a new task");
		btnNewTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_clicked("New Task");
			}
		});

		JButton btnCloseTask = new JButton("Complete Task");
		btnCloseTask.setToolTipText("Give a task a status of COMPLETE ");
		btnCloseTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button_clicked("Close Task");
			}
		});

		JButton btnEditTask = new JButton("Edit Task");
		btnEditTask.setToolTipText("Edit a task");
		btnEditTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button_clicked("Edit Task");
			}
		});

		JButton btnDeleteTask = new JButton("Delete Task");
		btnDeleteTask.setToolTipText("Remove a task");
		btnDeleteTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button_clicked("Delete Task");
			}
		});

		JButton btnViewDescription = new JButton("View Description");
		btnViewDescription.setToolTipText("View the description of a task");
		btnViewDescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				button_clicked("View Description");
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(
						gl_contentPane
								.createParallelGroup(
										Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(btnNewTask).addGap(39).addComponent(btnDeleteTask)
														.addGap(49).addComponent(btnViewDescription)
														.addPreferredGap(ComponentPlacement.RELATED,
																GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addComponent(btnEditTask).addGap(49)
														.addComponent(btnCloseTask))
												.addComponent(scrollPane, Alignment.TRAILING,
														GroupLayout.PREFERRED_SIZE, 831, GroupLayout.PREFERRED_SIZE))
										.addContainerGap(119, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(20)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnNewTask)
								.addComponent(btnCloseTask).addComponent(btnEditTask).addComponent(btnViewDescription)
								.addComponent(btnDeleteTask))
						.addGap(20).addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
						.addGap(50)));

		table = new JTable();
		table.setRowHeight(25);
		
		table.setModel(new DefaultTableModel(new Object[][] {{},},
				new String[] { "Task", "Start Date", "Est. End Date", "Actual End Date", "Priority", "Status",
						"Estimate (Hrs)", "Actual (Hrs)", "% Done" }) {
			private static final long serialVersionUID = 1L;

			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		table.getColumnModel().getColumn(2).setPreferredWidth(99);
		table.getColumnModel().getColumn(3).setPreferredWidth(104);
		table.getColumnModel().getColumn(5).setPreferredWidth(76);
		table.getColumnModel().getColumn(6).setPreferredWidth(102);
		table.getColumnModel().getColumn(7).setPreferredWidth(86);
		setLayout(null);

		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		add(contentPane);

		if (devel.getRow().size() > 0) {
			updateTableData();
		}
	}

	protected static void insertRow(DevRowObject devRow) {
		boolean dirty;
		
		if (devel.getRow().size() < 1) {
			((DefaultTableModel) table.getModel()).removeRow(0);
		}
			
		((DefaultTableModel) table.getModel()).insertRow(table.getRowCount(), getObject(devRow));
		
		dirty = devel.addRow(devRow);	
		
		if (!getIsDirty()) {
			setIsDirty(dirty);
		}
	}
	
	private static Object[] getObject (DevRowObject devRow) {
		Object[] tdarray = new Object[9];		
		tdarray[0] = devRow.getTaskName();
		tdarray[1] = (devRow.getStartDate() != null ? 
				getDateTime(devRow.getStartDate(), 0) : "");
		tdarray[2] = (devRow.getEstDate() != null ? 
				getDateTime (devRow.getEstDate(), 0) : "");
		tdarray[3] = (devRow.getEndDate() != null ? 
				getDateTime (devRow.getEndDate(), 0) : "");
		tdarray[4] = getPriorityItem (devRow.getPriority());
		tdarray[5] = devRow.getStatus();
		tdarray[6] = devRow.getEstimate() + "";
		tdarray[7] = devRow.getActualComplete() + "";
		tdarray[8] = devRow.getPercentComplete() + "";
		
		return tdarray;
	}

	private static void updateTableData() {
		for (int i = 0; i < devel.getRow().size(); i++) {
			updateRowData(devel.getRow().get(i));
		}
	}

	private static void updateRowData(DevRowObject devRow) {
		if ((String)(table.getModel().getValueAt(0, 0)) == null) {
			((DefaultTableModel) table.getModel()).removeRow(0);
		}		
		((DefaultTableModel) table.getModel()).insertRow(
				table.getRowCount(), getObject(devRow));	
	}

	private static String getPriorityItem (int priority) {
		String strItem = "";
		
		switch (priority) {
			case 0:
				strItem = "LOW";
				break;
			case 1:
				strItem = "MEDIUM";
				break;
			case 2:
				strItem = "HIGH";
				break;
			default:
				strItem = "NONE";
		}		
		return strItem;
	}

	private void removeRow() {
		DefaultTableModel model = (DefaultTableModel) PSP_DevelopmentTable.table.getModel();
		boolean dirty = false;

		int[] rows = table.getSelectedRows();

		for (int i = 0; i < rows.length; i++) {
			model.removeRow(rows[i] - i);
		}

		for (int i = 0; i < rows.length; i++) {
			if (i < devel.getRow().size()) {
				dirty = devel.removeRow(i);
				if (!getIsDirty()) {
					setIsDirty(dirty);
				}
			}
		}
		
		if (table.getRowCount() == 0) {
			((DefaultTableModel) table.getModel()).insertRow(0, new Object[9]);	
		}
	}

	protected static void editRow(DevRowObject devRow) {
		int row = table.getSelectedRow();
		boolean dirty = false;
		Object cellValue[] = getObject(devRow);
		
		for (int i = 0; i < 9; i++) {
			if (i==3 || i==7)
				continue;
			((DefaultTableModel) table.getModel()).setValueAt(cellValue[i], row, i);
		}
		
		if (row < devel.getRow().size()) {
			dirty = devel.editRow(row, devRow);
			
			if (!getIsDirty()) {
				setIsDirty(dirty);
			}
		}
	}

	protected static void closeTask(DevRowObject myDevRow) {
		int row = table.getSelectedRow();
		boolean dirty = false;
		
		((DefaultTableModel) table.getModel()).setValueAt(myDevRow.getActualComplete(), row, 7);
		((DefaultTableModel) table.getModel()).setValueAt(getDateTime(myDevRow.getEndDate(), 0), row, 3);
		((DefaultTableModel) table.getModel()).setValueAt(myDevRow.getStatus(), row, 5);
		((DefaultTableModel) table.getModel()).setValueAt(myDevRow.getPercentComplete(), row, 8);
		
		if (row < devel.getRow().size()) {
			dirty = devel.editRow(row, myDevRow);
			if (!getIsDirty()) {
				setIsDirty(dirty);
			}
		}				
	}

	public static Object getCellValues(int col) {
		int row = table.getSelectedRow();
		Object cellvalue = ((DefaultTableModel) table.getModel()).getValueAt(row, col);
		return cellvalue;
	}

	private void button_clicked(String a) {
		int index = table.getSelectedRow();
		DevRowObject myDevRow = new DevRowObject();
				
		if (index >= 0 && index < devel.getRow().size()) {
			myDevRow = devel.getRow().get(index); 
		}
		
		if (a.equalsIgnoreCase("New Task")) {
			(new PSP_DevelopmentDialog(myDevRow)).setVisible(true);
		} else if (a.equalsIgnoreCase("Close Task")) {
			if (index > -1 ) {
				(new PSP_DevelopmentDialogClose(myDevRow)).setVisible(true);
			}
		} else if (a.equalsIgnoreCase("Edit Task")) {
			if (index > -1) {
				(new PSP_DevelopmentEditDialog(myDevRow)).setVisible(true);			
			}
		} else if (a.equalsIgnoreCase("Delete Task")) {
			removeRow();
		} else if (a.equalsIgnoreCase("View Description")) {
			if (index > -1)  {
				(new PSP_DevelopmentTaskDescription (myDevRow)).setVisible(true);
			}
		}
	}
	
	protected static void editDescription (String str) {
		int index = table.getSelectedRow();
		devel.getRow().get(index).setDescription(str);
	}

	protected static String getDateTime(Date d, int code) {
		DateFormat df = null;
		switch (code) {
		case 0:
			df = DateFormat.getDateInstance(DateFormat.SHORT);
			break;
		case 1:
			df = DateFormat.getTimeInstance(DateFormat.SHORT);
			break;
		default:
			Util.debug("Never should have gotten here");
		}
		return (df.format(d));
	}

	public static void setIsDirty(boolean dirty) {
		isDirty = dirty;
		
		Util.debug("Interesting Phenom");
		if (isDirty) {
			PSP_Panel.setIsDirty(true);
			PSP_Panel.myPanel.setSaveEnabled();
		}
	}

	public static boolean getIsDirty() {
		return isDirty;
	}
}
