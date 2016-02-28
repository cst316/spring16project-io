package net.sf.memoranda.ui;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;

import javax.swing.JToggleButton;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;

import javax.swing.JSpinner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class PSPTestingFrame extends JFrame {
	private JTable table_1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;

	public PSPTestingFrame() {
		getContentPane().setLayout(null);
		this.setTitle("Testing Log");
		this.setBounds(0, 0, 1290, 700);
		
		JTextArea txtrD = new JTextArea();
		txtrD.setText("Defect Types" + "\n10 Documentation\t60 Checking" +
		"\n20 Syntax\t\t70 Data" + "\n30 Build, Package\t80 Function" + 
		"\n40 Assignment\t\t90 System" + "\n50 Interface\t\t100 Environment");
		
		txtrD.setBounds(897, 13, 343, 121);
		getContentPane().add(txtrD);
		
		JLabel lblStudent = new JLabel("Student:");
		lblStudent.setBounds(37, 49, 56, 16);
		getContentPane().add(lblStudent);
		
		JLabel label = new JLabel("Date:");
		label.setBounds(37, 101, 56, 16);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Program:");
		label_1.setBounds(270, 49, 56, 16);
		getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Program #:");
		label_2.setBounds(268, 101, 87, 16);
		getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setText("PSP Defect Recording Log");
		textField.setColumns(10);
		textField.setBounds(92, 46, 166, 22);
		getContentPane().add(textField);
		
		textField_1 = new JTextField();
		textField_1.setText("PSP Defect Recording Log");
		textField_1.setColumns(10);
		textField_1.setBounds(92, 98, 166, 22);
		getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText("PSP Defect Recording Log");
		textField_2.setColumns(10);
		textField_2.setBounds(344, 48, 166, 22);
		getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("PSP Defect Recording Log");
		textField_3.setColumns(10);
		textField_3.setBounds(344, 98, 166, 22);
		getContentPane().add(textField_3);
		
		JLabel lblPspDefectRecording = new JLabel("PSP Defect Recording Log");
		lblPspDefectRecording.setBounds(506, 16, 159, 16);
		getContentPane().add(lblPspDefectRecording);
		
		JLabel lblNewLabel = new JLabel("Project");
		lblNewLabel.setBounds(74, 158, 56, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(217, 158, 56, 16);
		getContentPane().add(lblDate);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setBounds(311, 158, 56, 16);
		getContentPane().add(lblNumber);
		
		JLabel lblNewLabel_1 = new JLabel("Type");
		lblNewLabel_1.setBounds(428, 158, 56, 16);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label_3 = new JLabel("Inject");
		label_3.setBounds(556, 158, 56, 16);
		getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Remove");
		label_4.setBounds(670, 158, 56, 16);
		getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Fix");
		label_5.setBounds(886, 158, 56, 16);
		getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("Fix Ref.");
		label_6.setBounds(1106, 158, 56, 16);
		getContentPane().add(label_6);
		
		JEditorPane textPane = new JEditorPane();
		textPane.setBounds(772, 187, 291, 62);
		getContentPane().add(textPane);
		
		textField_4 = new JTextField();
		textField_4.setBounds(27, 186, 147, 22);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(186, 187, 87, 22);
		getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(292, 187, 87, 22);
		getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(405, 186, 87, 22);
		getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(535, 186, 87, 22);
		getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(651, 186, 87, 22);
		getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setBounds(1095, 186, 70, 22);
		getContentPane().add(textField_10);
		textField_10.setColumns(10);
		
		JButton btnNewButton = new JButton();
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(1191, 186, 49, 22);
		btnNewButton.setIcon(new ImageIcon(net.sf.memoranda.ui.AppFrame.class.getResource("resources/icons/addbookmark.png")));
		getContentPane().add(btnNewButton);		
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 261, 1236, 379);
		getContentPane().add(panel);
		panel.setLayout(null);
		
	
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1203, 122, 21, 48);
		panel.add(scrollBar);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 13, 1153, 77);
		panel.add(panel_1);
		panel_1.setLayout(null);

		
		JLabel label_7 = new JLabel("Project");
		label_7.setBounds(66, 13, 49, 22);
		panel_1.add(label_7);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(12, 42, 147, 22);
		panel_1.add(textField_11);
		
		JLabel label_8 = new JLabel("Date");
		label_8.setBounds(220, 13, 56, 16);
		panel_1.add(label_8);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(188, 42, 87, 22);
		panel_1.add(textField_12);
		
		JLabel label_9 = new JLabel("Number");
		label_9.setBounds(321, 13, 56, 16);
		panel_1.add(label_9);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(298, 42, 87, 22);
		panel_1.add(textField_13);
		
		JLabel label_10 = new JLabel("Type");
		label_10.setBounds(433, 13, 56, 16);
		panel_1.add(label_10);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(410, 42, 87, 22);
		panel_1.add(textField_14);
		
		JLabel label_11 = new JLabel("Inject");
		label_11.setBounds(540, 13, 56, 16);
		panel_1.add(label_11);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(521, 42, 87, 22);
		panel_1.add(textField_15);
		
		JLabel label_12 = new JLabel("Remove");
		label_12.setBounds(652, 13, 56, 16);
		panel_1.add(label_12);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(635, 42, 87, 22);
		panel_1.add(textField_16);
		
		JLabel label_13 = new JLabel("Fix");
		label_13.setBounds(827, 13, 56, 16);
		panel_1.add(label_13);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(738, 42, 216, 22);
		panel_1.add(editorPane);
		
		JLabel label_14 = new JLabel("Fix Ref.");
		label_14.setBounds(973, 13, 56, 16);
		panel_1.add(label_14);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(966, 42, 70, 22);
		panel_1.add(textField_17);
		
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setBounds(1068, 41, 49, 22);
		button.setIcon(new ImageIcon(net.sf.memoranda.ui.AppFrame.class.getResource("resources/icons/addbookmark.png")));
		panel_1.add(button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(12, 122, 1153, 77);
		panel.add(panel_2);
		
		JLabel label_15 = new JLabel("Project");
		label_15.setBounds(66, 13, 49, 22);
		panel_2.add(label_15);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(12, 42, 147, 22);
		panel_2.add(textField_18);
		
		JLabel label_16 = new JLabel("Date");
		label_16.setBounds(220, 13, 56, 16);
		panel_2.add(label_16);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(188, 42, 87, 22);
		panel_2.add(textField_19);
		
		JLabel label_17 = new JLabel("Number");
		label_17.setBounds(321, 13, 56, 16);
		panel_2.add(label_17);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(298, 42, 87, 22);
		panel_2.add(textField_20);
		
		JLabel label_18 = new JLabel("Type");
		label_18.setBounds(433, 13, 56, 16);
		panel_2.add(label_18);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(410, 42, 87, 22);
		panel_2.add(textField_21);
		
		JLabel label_19 = new JLabel("Inject");
		label_19.setBounds(540, 13, 56, 16);
		panel_2.add(label_19);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(521, 42, 87, 22);
		panel_2.add(textField_22);
		
		JLabel label_20 = new JLabel("Remove");
		label_20.setBounds(652, 13, 56, 16);
		panel_2.add(label_20);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(635, 42, 87, 22);
		panel_2.add(textField_23);
		
		JLabel label_21 = new JLabel("Fix");
		label_21.setBounds(827, 13, 56, 16);
		panel_2.add(label_21);
		
		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(738, 42, 216, 22);
		panel_2.add(editorPane_1);
		
		JLabel label_22 = new JLabel("Fix Ref.");
		label_22.setBounds(973, 13, 56, 16);
		panel_2.add(label_22);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(966, 42, 70, 22);
		panel_2.add(textField_24);
		
		JButton button_1 = new JButton();
		button_1.setBounds(1068, 41, 49, 22);
		panel_2.add(button_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(12, 229, 1153, 77);
		panel.add(panel_3);
		
		JLabel label_23 = new JLabel("Project");
		label_23.setBounds(66, 13, 49, 22);
		panel_3.add(label_23);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setBounds(12, 42, 147, 22);
		panel_3.add(textField_25);
		
		JLabel label_24 = new JLabel("Date");
		label_24.setBounds(220, 13, 56, 16);
		panel_3.add(label_24);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(188, 42, 87, 22);
		panel_3.add(textField_26);
		
		JLabel label_25 = new JLabel("Number");
		label_25.setBounds(321, 13, 56, 16);
		panel_3.add(label_25);
		
		textField_27 = new JTextField();
		textField_27.setColumns(10);
		textField_27.setBounds(298, 42, 87, 22);
		panel_3.add(textField_27);
		
		JLabel label_26 = new JLabel("Type");
		label_26.setBounds(433, 13, 56, 16);
		panel_3.add(label_26);
		
		textField_28 = new JTextField();
		textField_28.setColumns(10);
		textField_28.setBounds(410, 42, 87, 22);
		panel_3.add(textField_28);
		
		JLabel label_27 = new JLabel("Inject");
		label_27.setBounds(540, 13, 56, 16);
		panel_3.add(label_27);
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		textField_29.setBounds(521, 42, 87, 22);
		panel_3.add(textField_29);
		
		JLabel label_28 = new JLabel("Remove");
		label_28.setBounds(652, 13, 56, 16);
		panel_3.add(label_28);
		
		textField_30 = new JTextField();
		textField_30.setColumns(10);
		textField_30.setBounds(635, 42, 87, 22);
		panel_3.add(textField_30);
		
		JLabel label_29 = new JLabel("Fix");
		label_29.setBounds(827, 13, 56, 16);
		panel_3.add(label_29);
		
		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setBounds(738, 42, 216, 22);
		panel_3.add(editorPane_2);
		
		JLabel label_30 = new JLabel("Fix Ref.");
		label_30.setBounds(973, 13, 56, 16);
		panel_3.add(label_30);
		
		textField_31 = new JTextField();
		textField_31.setColumns(10);
		textField_31.setBounds(966, 42, 70, 22);
		panel_3.add(textField_31);
		
		JButton button_2 = new JButton();
		button_2.setBounds(1068, 41, 49, 22);
		panel_3.add(button_2);
		// TODO Auto-generated constructor stub
	}
}
