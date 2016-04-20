package net.sf.memoranda.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.apache.commons.lang3.math.NumberUtils;
import net.sf.memoranda.psp.DevRowObject;
import net.sf.memoranda.util.Configuration;
import net.sf.memoranda.util.Util;
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
import javax.swing.UIManager;

import java.awt.Color;

public class PSP_DevelopmentDialog extends JFrame implements Serializable {

	private static final long serialVersionUID = -4064987826608820142L;
	private JPanel contentPane;
	private JTextField taskTextField;
	private JTextField descriptionTextField;
	private JTextField startDateTextField;
	private JTextField estDateTextField;
	private JTextField estTimeTextField;
	private DevRowObject myDevRow;
	private JComboBox<String> jcbPriority;

	public PSP_DevelopmentDialog() {
		this(new DevRowObject());
	}

	public PSP_DevelopmentDialog(DevRowObject myDevRow) {
		this.myDevRow = myDevRow;
		jbInit();
	}

	private void jbInit() {
		setLook();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 589, 408);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblCreateNewTask = new JLabel(" CREATE NEW TASK");
		lblCreateNewTask.setToolTipText("Create a new task\r\n");
		lblCreateNewTask.setFont(new Font("Tahoma", Font.BOLD, 15));

		JLabel lblTaskName = new JLabel("Task name:");
		lblTaskName.setToolTipText("Enter task name\r\n");
		lblTaskName.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblTaskDescription = new JLabel("Description:");
		lblTaskDescription.setToolTipText("Enter description");
		lblTaskDescription.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblStartDate = new JLabel("Start date:");
		lblStartDate.setToolTipText("Enter start date using mm/dd/yy format");
		lblStartDate.setHorizontalAlignment(SwingConstants.RIGHT);

		JLabel lblEstimatedTime = new JLabel("Estimated time:");
		lblEstimatedTime.setToolTipText("Enter the estimated time to complete the task");

		JLabel lblPriority = new JLabel("Priority:");
		lblPriority.setToolTipText("Enter the priority of the task");
		lblPriority.setHorizontalAlignment(SwingConstants.RIGHT);

		taskTextField = new JTextField();
		taskTextField.setToolTipText("Enter in the task name");
		taskTextField.setColumns(10);

		descriptionTextField = new JTextField();
		descriptionTextField.setToolTipText("Enter in the description");
		descriptionTextField.setColumns(10);

		startDateTextField = new JTextField();
		startDateTextField.setToolTipText("Enter the start date in mm/dd/yy format");
		startDateTextField.setColumns(10);

		JLabel lblEndDate_1 = new JLabel("Est End date:");
		lblEndDate_1.setToolTipText("Enter estimated end date using mm/dd/yy format");
		lblEndDate_1.setHorizontalAlignment(SwingConstants.RIGHT);

		estDateTextField = new JTextField();
		estDateTextField.setToolTipText("Enter the estimated end date in mm/dd/yy format");
		estDateTextField.setColumns(10);

		estTimeTextField = new JTextField();
		estTimeTextField.setToolTipText("Enter the estimated time");
		estTimeTextField.setColumns(10);

		JButton btnOk = new JButton("OK");
		btnOk.setToolTipText("Press OK to create task");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				insertRow();
			}
		});

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setToolTipText("Press Cancel to exit dialog");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		jcbPriority = new JComboBox<String>();
		jcbPriority.setToolTipText("Choose a priority value from the dropdown menu");
		jcbPriority.addItem("LOW");
		jcbPriority.addItem("MEDIUM");
		jcbPriority.addItem("HIGH");
		jcbPriority.setSelectedIndex(myDevRow.getPriority());
		jcbPriority.setBackground(Color.WHITE);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(193).addComponent(lblCreateNewTask))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(25).addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblTaskName, GroupLayout.PREFERRED_SIZE, 120,
												GroupLayout.PREFERRED_SIZE)
										.addGap(18)
										.addComponent(taskTextField, GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblStartDate, GroupLayout.PREFERRED_SIZE, 120,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(startDateTextField, GroupLayout.PREFERRED_SIZE, 85,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(estTimeTextField, GroupLayout.PREFERRED_SIZE, 85,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(btnOk, GroupLayout.PREFERRED_SIZE, 85,
														GroupLayout.PREFERRED_SIZE))
										.addGap(20)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addGroup(gl_contentPane.createSequentialGroup().addGap(20)
														.addComponent(lblEndDate_1, GroupLayout.PREFERRED_SIZE, 120,
																GroupLayout.PREFERRED_SIZE))
												.addGroup(gl_contentPane.createSequentialGroup().addGap(24)
														.addComponent(lblPriority, GroupLayout.PREFERRED_SIZE, 120,
																GroupLayout.PREFERRED_SIZE)))
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 85,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(estDateTextField, GroupLayout.PREFERRED_SIZE, 85,
														GroupLayout.PREFERRED_SIZE)
												.addComponent(jcbPriority, GroupLayout.PREFERRED_SIZE, 85,
														GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblEstimatedTime, GroupLayout.PREFERRED_SIZE, 120,
										GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblTaskDescription, GroupLayout.PREFERRED_SIZE, 120,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(descriptionTextField, GroupLayout.DEFAULT_SIZE, 332,
												Short.MAX_VALUE)))))
				.addGap(153)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addContainerGap().addComponent(lblCreateNewTask).addGap(27)
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
								.addComponent(lblEstimatedTime, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPriority, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(estTimeTextField, GroupLayout.PREFERRED_SIZE, 25,
										GroupLayout.PREFERRED_SIZE))
						.addComponent(jcbPriority, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addGap(35).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnOk)
						.addComponent(btnCancel))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}

	private void insertRow() {
		if (!taskTextField.getText().isEmpty()) {
			myDevRow.setTaskName(taskTextField.getText());
			if (!startDateTextField.getText().isEmpty()) {
				myDevRow.setStartDate(startDateTextField.getText());
			}
			if (!estDateTextField.getText().isEmpty()) {
				myDevRow.setEstDate(estDateTextField.getText());
			}
			myDevRow.setPriority(jcbPriority.getSelectedIndex());
			if (NumberUtils.isNumber(estTimeTextField.getText())) {
				Util.debug("IS NUMERIC");
				myDevRow.setEstimate(Integer.parseInt(estTimeTextField.getText()));
			}
			myDevRow.setDescription(descriptionTextField.getText());
			myDevRow.setStatus("OPEN");
			dispose();

			PSP_DevelopmentTable.insertRow(myDevRow);
		} else {
			taskTextField.requestFocus();
		}
	}

	private static void setLook() {
		try {
			if (Configuration.get("LOOK_AND_FEEL").equals("system"))
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			else if (Configuration.get("LOOK_AND_FEEL").equals("default"))
				UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			else if (Configuration.get("LOOK_AND_FEEL").toString().length() > 0)
				UIManager.setLookAndFeel(Configuration.get("LOOK_AND_FEEL").toString());
		} catch (Exception e) {
			new ExceptionDialog(e, "Error when initializing a pluggable look-and-feel. Default LF will be used.",
					"Make sure that specified look-and-feel library classes are on the CLASSPATH.");
		}
	}
}
