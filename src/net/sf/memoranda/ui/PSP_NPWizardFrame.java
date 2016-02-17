package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PSP_NPWizardFrame extends JFrame {

	private JPanel contentPane;
	private JLabel lblPID;
	private JLabel lblNewLabel;
	private JTextField txtPrjName;
	private JTextPane txtPrjDescription;
	
	//private JFrame nextFrame;
	
	static JFrame npw = null;
	
	public PSP_NPWizardFrame() {		
		try {
			jbInit();
		} catch (Exception ex) {
			new ExceptionDialog(ex);
			ex.printStackTrace();
		}
	}
		
	/**
	 * using init() style to create GUI details
	 */
	public void jbInit() {
		this.setAlwaysOnTop(true);
		int xsize = 450, ysize = 300;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width - xsize)/2, (dim.height - ysize)/2);		
		
		setTitle("New PSP Project Wizard");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize (xsize, ysize);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProjectId = new JLabel("Project ID:");
		lblProjectId.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProjectId.setBounds(10, 25, 100, 25);
		contentPane.add(lblProjectId);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(125, 25, 80, 25);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblPID = new JLabel("100000001");
		lblPID.setBounds(0, 0, 80, 25);
		panel.add(lblPID);
		lblPID.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel = new JLabel("Project Name:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 70, 100, 25);
		contentPane.add(lblNewLabel);
		
		txtPrjName = new JTextField();
		txtPrjName.setBounds(125, 70, 300, 25);
		contentPane.add(txtPrjName);
		txtPrjName.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDescription.setBounds(10, 150, 100, 25);
		contentPane.add(lblDescription);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(125, 115, 300, 75);
		contentPane.add(scrollPane);
		
		txtPrjDescription = new JTextPane();
		scrollPane.setViewportView(txtPrjDescription);
		txtPrjDescription.setBackground(Color.WHITE);
		
		JButton btnNext = new JButton("Next >>");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNext_Clicked ();
			}
		});
		btnNext.setBounds(330, 225, 100, 25);
		contentPane.add(btnNext);
		
		JButton btnNewButton_1 = new JButton("Cancel");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCancel_Clicked();
			}
		});
		btnNewButton_1.setBounds(125, 225, 100, 25);
		contentPane.add(btnNewButton_1);
	}
	
	protected void btnNext_Clicked() {
		if (!txtPrjName.getText().isEmpty() && !txtPrjDescription.getText().isEmpty()) {
			npw = this;
			if (PSP_PlanningWizardFrame.pwf == null) {
				(new PSP_PlanningWizardFrame (this, lblPID.getText().trim())).setVisible(true);
			} else { 
				PSP_PlanningWizardFrame.pwf.setVisible(true);
			}
			this.setVisible(false);
		} else {
			if (txtPrjName.getText().isEmpty())
				txtPrjName.requestFocus();
			else
				txtPrjDescription.requestFocus();
		}		
	}
	
	protected void btnCancel_Clicked() {		
		int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Confirm", JOptionPane.YES_NO_OPTION);
		
		if (confirm == JOptionPane.YES_OPTION) {
			if (PSP_PlanningWizardFrame.pwf == null)
				PSP_PlanningWizardFrame.pwf.dispose();
			this.dispose();
			App.getFrame().setEnabled(true);
		}
	}
}
