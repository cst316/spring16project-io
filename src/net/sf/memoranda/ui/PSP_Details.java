package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;

import net.sf.memoranda.psp.Psp;
import net.sf.memoranda.util.Util;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PSP_Details extends JPanel {
	JTextField txtProjectName;
	JLabel lblStartDate;
	JLabel lblProjectID;
	JButton btnEdit;
	JButton btnUpdate;
	JButton btnEndProject;
	JTextArea txtDescription;
	
	Psp pspI;
	static String strDirty;
	static boolean isToggled = false;
	static boolean isDirty = false;
	
	public PSP_Details (Psp pspI) {
		this.pspI = pspI;
		strDirty = "";
		jInit();
	}
	
	public void jInit () {
		//setSize(new Dimension ((int) (pnlWizard.getWidth() * 0.8), (int) (pnlWizard.getHeight() * 0.8)));
		//int vgap = (int) ((java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.8 - 500) / 2);
		
		int hgap;
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setPreferredSize(new Dimension(520, 460));
		//panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_ActionClicked("UPDATE");
			}
		});
		btnUpdate.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnUpdate.setEnabled(isToggled);
		btnUpdate.setPreferredSize(new Dimension(115, 25));
		
		btnEndProject = new JButton("End Project");
		btnEndProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				button_ActionClicked("END");
			}
		});
		btnEndProject.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnEndProject.setPreferredSize(new Dimension(115, 25));
		
		btnEdit = new JButton("Edit Details");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEdit.setText(isToggled ? "Edit Details" : "Cancel");			
				button_ActionClicked(!isToggled ? "EDIT" : "CANCEL");
			}
		});
		btnEdit.setPreferredSize(new Dimension(115, 25));
		
		hgap = (int)   ((500 - (btnEdit.getPreferredSize().getWidth() + btnEndProject.getPreferredSize().
				getWidth() + btnUpdate.getPreferredSize().getWidth())) / 2);			
				//(int)   (145 / 2);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(hgap)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addGap(hgap)
					.addComponent(btnEndProject, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
					.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnEndProject, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addComponent(btnUpdate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		panel.setLayout(gl_panel);
		
		JPanel panel2 = new JPanel();		
		panel2.setBackground(Color.WHITE);
		JLabel label2 = new JLabel("Project Name:");		
		txtProjectName = new JTextField();
		txtProjectName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtProjectName.setBackground(Color.WHITE);
		txtProjectName.setEditable(false);
		txtProjectName.setColumns(10);
		
		JLabel label3 = new JLabel("Project Description:");		
		txtDescription = new JTextArea();
		txtDescription.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				focus_EventHandle ("GAINED");
			}
			@Override
			public void focusLost(FocusEvent e) {
				focus_EventHandle ("LOST");
			}
		});
		txtDescription.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		txtDescription.setBackground(Color.WHITE);
		txtDescription.setEditable(false);
		
		GroupLayout gl_panel2 = new GroupLayout(panel2);
		gl_panel2.setHorizontalGroup(
			gl_panel2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel2.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel2.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel2.createSequentialGroup()
									.addComponent(label2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtProjectName, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel2.createSequentialGroup()
							.addContainerGap()
							.addComponent(label3, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		gl_panel2.setVerticalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel2.createParallelGroup(Alignment.BASELINE)
						.addComponent(label2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtProjectName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addGap(25)
					.addComponent(label3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(25)
					.addComponent(txtDescription, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel2.setLayout(gl_panel2);
		
		JPanel panel1 = new JPanel();		
		panel1.setBackground(Color.WHITE);
		lblStartDate = new JLabel("");
		lblStartDate.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblStartDate.setBackground(Color.WHITE);
		lblStartDate.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblStartDate.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel("Start Date:");
		
		JLabel label1 = new JLabel("Project ID:");
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lblProjectID = new JLabel("");
		lblProjectID.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblProjectID.setBackground(Color.WHITE);
		lblProjectID.setHorizontalAlignment(SwingConstants.CENTER);
		lblProjectID.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		GroupLayout gl_panel1 = new GroupLayout(panel1);
		gl_panel1.setHorizontalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblStartDate, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
					.addComponent(label1, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblProjectID, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel1.setVerticalGroup(
			gl_panel1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel1.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel1.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblStartDate, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblProjectID, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(label1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
		);
		panel1.setLayout(gl_panel1);
		
		hgap = (int) ((java.awt.Toolkit.getDefaultToolkit().
				getScreenSize().getWidth() * 0.8 - 450) / 2);		
		//(int) (400 / 2);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(hgap)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
					.addGap(150))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(30)
					.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addGap(100)
					.addComponent(panel2, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
					.addGap(20)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		setLayout(new BorderLayout (0, 0));
		add(panel_1, BorderLayout.CENTER);		
	}

	protected void focus_EventHandle(String focus) {
		switch (focus) {
			case ("GAINED"):
				strDirty = txtDescription.getText().trim();
				break;
			case ("LOST"):
				if (!isDirty && !(strDirty.equalsIgnoreCase(txtDescription.getText().trim()))) {
					isDirty = true;
				}
				break;
			default:
				Util.debug("We shouldn't be here at all focus_EvenHandle");
		}
		
		Util.debug("Are we dirty? " + isDirty);		
	}

	protected void button_ActionClicked(String action) {
		switch (action.toUpperCase()) {
			case ("CANCEL"):
				txtDescription.setText(pspI.getDescription());
				isToggled = false;
				break;
			case ("EDIT"):
				isToggled = true;
				txtDescription.selectAll();
				txtDescription.requestFocus();
				break;
			case ("END"):
				isToggled = false;
				break;
			case ("UPDATE"):
				isToggled = false;
				pspI.setDescription(txtDescription.getText().trim());
				txtProjectName.setEditable(false);
				txtDescription.setEditable(false);
				break;
			default:
				Util.debug("What are you doing here, PSP_Details");
		}
		btnUpdate.setEnabled(isToggled);
		txtDescription.setEditable(isToggled);
		btnEdit.setText(isToggled ? "Cancel" : "Edit Details");		
	}		
}