package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PSP_DevelopmentTaskDescription extends JFrame {

	private JPanel contentPane;
	private JTextField txtTextPopulatedFrom;


	public static void NewScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PSP_DevelopmentTaskDescription frame = new PSP_DevelopmentTaskDescription();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public PSP_DevelopmentTaskDescription() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 494, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtTextPopulatedFrom = new JTextField();
		txtTextPopulatedFrom.setText("text populated from task description of selected row goes here");
		//change set text to pull string from value of row's task description
		txtTextPopulatedFrom.setBounds(55, 60, 376, 186);
		contentPane.add(txtTextPopulatedFrom);
		txtTextPopulatedFrom.setColumns(10);
		
		JLabel lblTaskDescription = new JLabel("TASK DESCRIPTION");
		lblTaskDescription.setBounds(176, 20, 131, 27);
		contentPane.add(lblTaskDescription);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				dispose();
			}
			
		});
		btnOk.setBounds(195, 262, 97, 25);
		contentPane.add(btnOk);
	}
}
