package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class PSP_PlanningWizardFrame extends JFrame {

	private JPanel contentPane;
	private String pid;
	private JTextField txtEstTime;
	private JTextField txtEstLocHr;
	private JTextField txtEstSize;
	private JTextField txtEstDefect;
	
	private PSP_NPWizardFrame goBack;
	
	static JFrame pwf = null;
	private JTextField textField;
	private JTextField txtModuleSize;
	
	/**
	 * Create the frame.
	 */
	public PSP_PlanningWizardFrame() {
		try {
			jbInit();
		} catch (Exception ex) {
			new ExceptionDialog(ex);
			ex.printStackTrace();
		}
	}
		
	public PSP_PlanningWizardFrame (PSP_NPWizardFrame goBack, String pid) {
		try {
			this.goBack = goBack;
			this.pid = pid;
			jbInit();
		} catch (Exception ex) {
			new ExceptionDialog(ex);
			ex.printStackTrace();
		}		
	}
	
	private void jbInit() {
		this.setAlwaysOnTop(true);
		setTitle("New PSP Project Wizard - Planning");
		int xsize = 500, ysize = 600;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width - xsize)/2, (dim.height - ysize)/2);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(xsize, ysize);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(new Rectangle(0, 0, xsize, ysize));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 50, 475, 150);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblEstTime = new JLabel("Estimated Time:");
		lblEstTime.setBounds(10, 10, 140, 25);
		panel.add(lblEstTime);
		
		JLabel lblEstLochr = new JLabel("Estimated LOC/HR:");
		lblEstLochr.setBounds(10, 45, 140, 25);
		panel.add(lblEstLochr);
		
		JLabel lblEstSize = new JLabel("Estimated Size:");
		lblEstSize.setBounds(10, 80, 140, 25);
		panel.add(lblEstSize);
		
		JLabel lblEstDefect = new JLabel("Estimated Defect:");
		lblEstDefect.setBounds(10, 115, 140, 25);
		panel.add(lblEstDefect);
		
		txtEstTime = new JTextField();
		txtEstTime.setBounds(180, 10, 80, 25);
		panel.add(txtEstTime);
		txtEstTime.setColumns(10);
		
		txtEstLocHr = new JTextField();
		txtEstLocHr.setColumns(10);
		txtEstLocHr.setBounds(180, 80, 80, 25);
		panel.add(txtEstLocHr);
		
		txtEstSize = new JTextField();
		txtEstSize.setColumns(10);
		txtEstSize.setBounds(180, 115, 80, 25);
		panel.add(txtEstSize);
		
		txtEstDefect = new JTextField();
		txtEstDefect.setColumns(10);
		txtEstDefect.setBounds(180, 45, 80, 25);
		panel.add(txtEstDefect);
		
		JButton button = new JButton("<< Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction_Clicked ("BACK");
			}
		});
		button.setBounds(12, 525, 100, 25);
		contentPane.add(button);
		
		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction_Clicked ("FINISH");
			}
		});
		btnFinish.setBounds(390, 525, 100, 25);
		contentPane.add(btnFinish);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction_Clicked ("CANCEL");
			}
		});
		btnCancel.setBounds(200, 525, 100, 25);
		contentPane.add(btnCancel);
		
		JLabel lblProjectId = new JLabel("Project ID:");
		lblProjectId.setBounds(300, 10, 85, 25);
		contentPane.add(lblProjectId);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(400, 10, 80, 25);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("100000001");
		lblNewLabel.setBounds(0, 0, 80, 25);
		panel_2.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 330, 480, 175);
		contentPane.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		
		JLabel lblModule = new JLabel("MODULE");
		lblModule.setBounds(205, 5, 70, 25);
		panel_1.add(lblModule);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(10, 35, 85, 25);
		panel_1.add(lblDescription);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblSize.setBounds(315, 35, 80, 25);
		panel_1.add(lblSize);
		
		textField = new JTextField();
		textField.setBounds(10, 60, 275, 25);
		panel_1.add(textField);
		textField.setColumns(10);
		
		txtModuleSize = new JTextField();
		txtModuleSize.setBounds(315, 60, 80, 25);
		panel_1.add(txtModuleSize);
		txtModuleSize.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(430, 60, 35, 25);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnModuleAdd = new JButton("");
		btnModuleAdd.setBorder(null);
		btnModuleAdd.setBackground(Color.WHITE);
		btnModuleAdd.setBounds(0, 0, 25, 25);
		btnModuleAdd.setIcon(new ImageIcon(PSP_PlanningWizardFrame.class.getResource("/net/sf/memoranda/ui/resources/icons/plus.png")));
		panel_3.add(btnModuleAdd);
		

		setResizable (false);
	}	
	
	private void buttonAction_Clicked (String pan) {
		pwf = this;
		if (pan.equals("BACK")) {
			PSP_NPWizardFrame.npw.setVisible(true);
			this.setVisible(false);
		} else if (pan.equals("FINISH")) {
			goBack.dispose();
			this.dispose();
		} else if (pan.equals("CANCEL")) {
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Confirm", JOptionPane.YES_NO_OPTION);
			
			if (confirm == JOptionPane.YES_OPTION) {
				PSP_NPWizardFrame.npw.dispose();
				this.dispose();
				App.getFrame().setEnabled(true);
			}
		}
	}
}
