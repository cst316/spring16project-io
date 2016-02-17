package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class PSP_Panel extends JPanel {
	private JLabel lblNewProject;
	private JLabel lblOpenProject;
	private JPanel pnlWizard;
	public JToolBar toolBar;
	
	public PSP_Panel() {
		try {
			jbInit();
		} catch (Exception ex) {
			new ExceptionDialog(ex);
			ex.printStackTrace();
		}
	}
	
	public PSP_Panel (String pid) {
		
	}
	
	void jbInit() throws Exception {
		setBackground(Color.WHITE);
		setLayout(new BorderLayout(0, 0));
		
		toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBar.setBorder(null);
		toolBar.setBackground(SystemColor.controlHighlight);
		add(toolBar, BorderLayout.WEST);
		
		lblNewProject = new JLabel("New Project");
		lblNewProject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newProject_Mouse("CLICKED");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				newProject_Mouse("ENTERED");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				newProject_Mouse("EXITED");
			}
		});
		lblNewProject.setPreferredSize(new Dimension(100, 50));
		lblNewProject.setLocation(new Point(0, 20));
		lblNewProject.setMinimumSize(new Dimension(100, 50));
		lblNewProject.setMaximumSize(new Dimension(100, 50));
		lblNewProject.setBounds(new Rectangle(0, 20, 0, 0));
		lblNewProject.setFont(new Font("Dialog", Font.BOLD, 14));
		toolBar.add(lblNewProject);
		
		lblOpenProject = new JLabel("Open Project");
		lblOpenProject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		lblOpenProject.setMinimumSize(new Dimension(100, 50));
		lblOpenProject.setMaximumSize(new Dimension(100, 50));
		lblOpenProject.setPreferredSize(new Dimension(100, 50));
		toolBar.add(lblOpenProject);
		
		pnlWizard = new JPanel();
		pnlWizard.setVisible(false);
		//pnlWizard.setBackground(Color.WHITE);
		add(pnlWizard, BorderLayout.CENTER);
	}
	
	private void newProject_Mouse (String event) {
		if (event.equals("CLICKED")) {
			App.getFrame().setEnabled(false);
			pnlWizard.setVisible(true);	
			toolBar.setVisible (false);
			(new PSP_NPWizardFrame()).setVisible(true);
		} else if (event.equals("ENTERED")) {
			lblNewProject.setBackground(Color.WHITE);
		} else if (event.equals("EXITED")) {
			lblNewProject.setBackground(Color.RED);
		}
	}
}
