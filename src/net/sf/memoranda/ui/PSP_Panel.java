package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

//import net.sf.memoranda.util.Configuration;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

/**
 * 
 * @author Cephas Armstrong-Mensah
 * @author Team-IO
 * CST316 - Spring 2016, ASU Poly
 * This class lists the different options available in PSP View
 * 02/19/2016
 */
public class PSP_Panel extends JPanel {
	
	private static final long serialVersionUID = -1815200458278347624L;
	private JLabel lblNewProject;
	private JLabel designLabel;
	private JPanel pnlWizard;
	public JToolBar toolBar;
	private JLabel label;
	
	//private String projectName = "temp";
	
	/**
	 * General constructor for creating Panel
	 */
	public PSP_Panel() {
		try {
			jbInit();
		} catch (Exception ex) {
			new ExceptionDialog(ex);
			ex.printStackTrace();
		}
	}
	
	/**
	 * Constructor to create Panel and receiving PID from back end once it is tied in
	 * @param pid
	 */
	public PSP_Panel (String pid) {
		
	}
	
	/**
	 * Used to create GUI Layout and interface
	 * @throws Exception
	 */
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
		lblNewProject.setLocation(new Point(0, 50));
		lblNewProject.setPreferredSize(new Dimension(100, 50));
		lblNewProject.setMinimumSize(new Dimension(100, 50));
		lblNewProject.setMaximumSize(new Dimension(100, 50));
		lblNewProject.setFont(new Font("Dialog", Font.BOLD, 12));
		toolBar.add(lblNewProject);
				
		label = new JLabel("Open Project");
		label.setPreferredSize(new Dimension(100, 50));
		label.setMinimumSize(new Dimension(100, 50));
		label.setMaximumSize(new Dimension(100, 50));
		label.setFont(new Font("Dialog", Font.BOLD, 12));
		toolBar.add(label);
		
		designLabel = new JLabel("Open Design");
		designLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				designView_MouseClicked();
				
			}
		});
		designLabel.setMinimumSize(new Dimension(100, 50));
		designLabel.setMaximumSize(new Dimension(100, 50));
		designLabel.setPreferredSize(new Dimension(100, 50));
		designLabel.setFont(new Font("Dialog", Font.BOLD, 12));
		toolBar.add(designLabel);
		
		pnlWizard = new JPanel();
		pnlWizard.setVisible(false);
		add(pnlWizard, BorderLayout.CENTER);
		pnlWizard.setLayout(new BorderLayout(0, 0));
	}
	
	public void addJPanel (JPanel toAdd) {
		pnlWizard.add(toAdd, BorderLayout.CENTER);
		toAdd.setVisible(true);
		toolBar.setVisible(false);
		this.setEnabled(true);
		pnlWizard.setVisible(true);
		this.revalidate();
	}
	
	/**
	 * To start the PSP New project wizard once clicked and other 
	 * Mouse events for New Project on the auto hide tool bar
	 * @param event - Used to know which action to perform
	 */
	private void newProject_Mouse (String event) {
		if (event.equals("CLICKED")) {
			App.getFrame().setEnabled(false);
			toolBar.setVisible (false);
			(new PSP_NPWizardFrame(this)).setVisible(true);			
		} else if (event.equals("ENTERED")) {
			lblNewProject.setBackground(Color.WHITE);
		} else if (event.equals("EXITED")) {
			lblNewProject.setBackground(Color.RED);
		}
	}
	
	private void designView_MouseClicked(){
		
		new PSP_DesignPanel().setVisible(true);
	}
}
