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

import net.sf.memoranda.psp.DevRowObject;
import net.sf.memoranda.psp.Development;
import net.sf.memoranda.psp.TestRowObject;
import net.sf.memoranda.util.Util;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;

public class PSP_DevelopmentTable extends JPanel implements Serializable {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	static JTable table;
	private static boolean isDirty = false;

	protected Development devel;

	public PSP_DevelopmentTable() {
		jbInit();
	}

	public PSP_DevelopmentTable(Development devel) {
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

				// opens NewTaskDialog
				button_clicked("New Task");

			}
		});

		JButton btnCloseTask = new JButton("Complete Task");
		btnCloseTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// opens NewTaskDialog
				button_clicked("Close Task");

			}
		});

		JButton btnEditTask = new JButton("Edit Task");
		btnEditTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				button_clicked("Edit Task");

			}
		});

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

				// view description method will call new jframe with
				// task description text of selected row

				PSP_DevelopmentTaskDescription nw = new PSP_DevelopmentTaskDescription();
				nw.NewScreen();

			}

		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(btnViewDescription).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addComponent(btnNewTask).addGap(26)
										.addComponent(btnDeleteTask)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(btnEditTask)
										.addGap(18).addComponent(btnCloseTask).addContainerGap(397, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING,
										gl_contentPane
												.createSequentialGroup().addComponent(scrollPane,
														GroupLayout.PREFERRED_SIZE, 831, GroupLayout.PREFERRED_SIZE)
												.addContainerGap()))));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addGap(30)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnCloseTask)
								.addComponent(btnEditTask).addComponent(btnDeleteTask).addComponent(btnNewTask))
						.addGap(18, 34, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(btnViewDescription)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 393, GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] { { "Example0", "Example1", "Example2", "Example3", "Example4", "Example5", "Example6",
						"Example7", "Example8" }, },
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

		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		add(contentPane);
	}

	public static void insertRow() {

		((DefaultTableModel) table.getModel()).insertRow(table.getRowCount(),
				new Object[] { PSP_DevelopmentData.tdarray[0], PSP_DevelopmentData.tdarray[1],
						PSP_DevelopmentData.tdarray[2], null, PSP_DevelopmentData.tdarray[3], null,
						PSP_DevelopmentData.tdarray[4] });

	}

	public void removeRow() {
		DefaultTableModel model = (DefaultTableModel) PSP_DevelopmentTable.table.getModel();

		// rows = value of the rows that are selected/clicked
		int[] rows = table.getSelectedRows();

		for (int i = 0; i < rows.length; i++) {

			model.removeRow(rows[i] - i);
			if (i < devel.getRow().size()) {
				devel.removeRow(i);
				if (!getIsDirty()) {
					setIsDirty(true);
				}
			}

		}

	}

	public static void editRow(String cellvalue, int col) {

		// row = value of specific single row
		int row = table.getSelectedRow();

		// string and the row/column it goes to
		((DefaultTableModel) table.getModel()).setValueAt(cellvalue, row, col);

	}

	public static void closeTask(String actualHours, String actualEndDate) {
		int row = table.getSelectedRow();

		((DefaultTableModel) table.getModel()).setValueAt(actualHours, row, 7);
		((DefaultTableModel) table.getModel()).setValueAt(actualEndDate, row, 3);
		((DefaultTableModel) table.getModel()).setValueAt("COMPLETE", row, 5);
		// column 5 hold the "status", 8 est
		((DefaultTableModel) table.getModel()).setValueAt("100", row, 8);
	}

	public static Object getCellValues(int col) {
		int row = table.getSelectedRow();

		Object cellvalue = ((DefaultTableModel) table.getModel()).getValueAt(row, col);

		return cellvalue;
	}

	public static void setIsDirty(boolean dirty) {
		isDirty = dirty;
		if (isDirty) {
			PSP_Panel.setIsDirty(true);
			PSP_Panel.myPanel.setSaveEnabled();
		}
	}

	public static boolean getIsDirty() {
		return isDirty;
	}

	private void button_clicked(String a) {
		Util.debug("print " + a);
		if (a.equalsIgnoreCase("New Task")) {
			PSP_DevelopmentDialog nw = new PSP_DevelopmentDialog(this);
			nw.setVisible(true);

		} else if (a.equalsIgnoreCase("Close Task")) {

			PSP_DevelopmentDialogClose nw = new PSP_DevelopmentDialogClose();
			nw.index = table.getSelectedRow();
			nw.devel = devel;
			nw.setVisible(true);

		} else if (a.equalsIgnoreCase("Edit Task")) {

			PSP_DevelopmentEditDialog nw = new PSP_DevelopmentEditDialog();
			nw.indexCount = table.getSelectedRow();
			nw.myDevel = devel;
			nw.setVisible(true);

		}

		setIsDirty(true);

	}
}
