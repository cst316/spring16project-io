package net.sf.memoranda.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.sf.memoranda.psp.DevRowObject;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.io.Serializable;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class PSP_DevelopmentDialog extends JFrame implements Serializable {

	private static final long serialVersionUID = -4064987826608820142L;
	public static Object[] tdarray;
	protected JPanel contentPane;
	protected JTextField taskTextField;
	protected JTextField descriptionTextField;
	protected JTextField startDateTextField;
	protected JTextField estDateTextField;
	protected JTextField estTimeTextField;
	
	private DevRowObject myDevRow;
	private boolean isDirty;
	private JComboBox<String> jcbPriority;

	public PSP_DevelopmentDialog() {
		this (new DevRowObject());
	}
	
	public PSP_DevelopmentDialog(DevRowObject myDevRow) {
		this.myDevRow = myDevRow;
		jbInit();
	}

	private void jbInit() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 589, 408);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblCreateNewTask = new JLabel(" CREATE NEW TASK");
		lblCreateNewTask.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblTaskName = new JLabel("Task name:");
		lblTaskName.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblTaskDescription = new JLabel("Description:");
		lblTaskDescription.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblStartDate = new JLabel("Start date:");
		lblStartDate.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblEstimatedTime = new JLabel("Estimated time:");

		JLabel lblPriority = new JLabel("Priority:");
		lblPriority.setHorizontalAlignment(SwingConstants.RIGHT);

		taskTextField = new JTextField();
		taskTextField.setColumns(10);

		descriptionTextField = new JTextField();
		descriptionTextField.setColumns(10);

		startDateTextField = new JTextField();
		startDateTextField.setColumns(10);

		JLabel lblEndDate_1 = new JLabel("Est End date:");
		lblEndDate_1.setHorizontalAlignment(SwingConstants.RIGHT);

		estDateTextField = new JTextField();
		estDateTextField.setColumns(10);

		estTimeTextField = new JTextField();
		estTimeTextField.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buildArray();
			}
		});

		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)

			{
				dispose();
			}
		});
		
		jcbPriority = new JComboBox<String>();
		jcbPriority.addItem("LOW");
		jcbPriority.addItem("MEDIUM");
		jcbPriority.addItem("HIGH");
		jcbPriority.setSelectedIndex(myDevRow.getPriority());
		jcbPriority.setBackground(Color.WHITE);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(193)
							.addComponent(lblCreateNewTask))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(25)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTaskName, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(taskTextField, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblStartDate, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(startDateTextField, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addComponent(estTimeTextField, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
									.addGap(20)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(20)
											.addComponent(lblEndDate_1, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(24)
											.addComponent(lblPriority, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addComponent(estDateTextField, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
										.addComponent(jcbPriority, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblEstimatedTime, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblTaskDescription, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(descriptionTextField, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)))))
					.addGap(153))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCreateNewTask)
					.addGap(27)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTaskName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(taskTextField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTaskDescription, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(descriptionTextField, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStartDate, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(estDateTextField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEndDate_1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(startDateTextField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblEstimatedTime, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPriority, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(estTimeTextField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addComponent(jcbPriority, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnOk)
						.addComponent(btnCancel))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void buildArray() {

		if (!taskTextField.getText().isEmpty()) {
			myDevRow.setTaskName(taskTextField.getText());
			myDevRow.setStartDate(startDateTextField.getText());
			myDevRow.setEstDate(estDateTextField.getText());
			myDevRow.setPriority(jcbPriority.getSelectedIndex());
			myDevRow.setEstimate(Integer.parseInt(estTimeTextField.getText()));
			myDevRow.setDescription(descriptionTextField.getText());
			myDevRow.setStatus("OPEN");
			dispose();
			
			PSP_DevelopmentTable.insertRow(myDevRow);
		} else {
			taskTextField.requestFocus();
		}
	}

	public void setIsDirty(boolean dirty) {
		this.isDirty = dirty;
	}

	public boolean getIsDirty() {
		return this.isDirty;
	}
}
