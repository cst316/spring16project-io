package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import net.sf.memoranda.psp.Design;
import net.sf.memoranda.psp.Planning;
import net.sf.memoranda.psp.PlanningImpl;
import net.sf.memoranda.psp.Psp;
import net.sf.memoranda.psp.PspImpl;
import net.sf.memoranda.psp.Testing;
import net.sf.memoranda.util.Util;

//import net.sf.memoranda.util.Configuration;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.SystemColor;

/**
 * 
 * @author Cephas Armstrong-Mensah
 * @author Team-IO
 * CST316 - Spring 2016, ASU Poly
 * This class lists the different options available in PSP View
 * 02/19/2016
 */
public class PSP_Panel extends JPanel{
	
	private static final long serialVersionUID = -1815200458278347624L;
	private JLabel lblNewProject;
	private JLabel lblOpenProject;
	private JLabel lblSaveProject;
	private JPanel pnlWizard;
	public JToolBar toolBar;
	
	static PSP_PlanningWizardFrame pwf;
	
	static Planning plan;
	static Design design;
	static Testing test;
	
	static PspImpl pspI;

	static boolean isDirty;
 	
	
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
		lblNewProject.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewProject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				project_MouseEvent("NEW PROJECT");
			}
		});
		lblNewProject.setLocation(new Point(50, 50));
		lblNewProject.setPreferredSize(new Dimension(100, 50));
		lblNewProject.setMinimumSize(new Dimension(100, 50));
		lblNewProject.setMaximumSize(new Dimension(150, 50));
		lblNewProject.setFont(new Font("Dialog", Font.BOLD, 12));
		toolBar.add(lblNewProject);
		
		lblOpenProject = new JLabel("Open Project");
		if (getIsNeeded()) {
			lblOpenProject.setEnabled(true);
		} else {
			lblOpenProject.setEnabled(false);
		}
		lblOpenProject.setHorizontalAlignment(SwingConstants.CENTER);
		lblOpenProject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				project_MouseEvent("OPEN PROJECT");
			}
		});
		lblOpenProject.setLocation(new Point (100, 50));
		lblOpenProject.setMinimumSize(new Dimension(100, 50));
		lblOpenProject.setMaximumSize(new Dimension(100, 50));
		lblOpenProject.setPreferredSize(new Dimension(100, 50));
		lblOpenProject.setFont(new Font("Dialog", Font.BOLD, 12));
		toolBar.add(lblOpenProject);
		
		lblSaveProject = new JLabel("Save Project");
		//lblSaveProject.setEnabled(false);
		lblSaveProject.setHorizontalAlignment(SwingConstants.CENTER);
		lblSaveProject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				project_MouseEvent("SAVE PROJECT");
			}
		});
		lblSaveProject.setLocation(new Point (100, 50));
		lblSaveProject.setMinimumSize(new Dimension(100, 50));
		lblSaveProject.setMaximumSize(new Dimension(100, 50));
		lblSaveProject.setPreferredSize(new Dimension(100, 50));
		lblSaveProject.setFont(new Font("Dialog", Font.BOLD, 12));
		toolBar.add(lblSaveProject);
		
		pnlWizard = new JPanel();
		pnlWizard.setVisible(false);
		add(pnlWizard, BorderLayout.CENTER);
		pnlWizard.setLayout(new BorderLayout(0, 0));
	}
	
	public void addJPanel (String panelType) {
		switch (panelType) {
			case "Planning":
				addJPanel (new PSP_Planning (plan));
				break;
			case "Testing":
				addJPanel (new PSPTestingFrame ());
				break;
			case "Design":
				break;
			default:
		}
	}
	
	public void addJPanel (JPanel toAdd) {
		pnlWizard.removeAll();
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
	public void project_MouseEvent (String event) {
		if (event.equals("NEW PROJECT")) {
			App.getFrame().setEnabled(false);
			toolBar.setVisible (false);
			(new PSP_NPWizardFrame(this)).setVisible(true);			
		} else if (event.equals("OPEN PROJECT")) {
			openFileDialog();
			System.out.println("Yeah Open Project");
		} else if (event.equals("SAVE PROJECT")) {
			System.out.println("Yeah Save Project");
		} else if (event.equals("PLANNING")) {
			Util.debug("PID: " + pspI);
			PSP_Planning pp = new PSP_Planning (plan);
			addJPanel (pp);				
		} else if (event.equals("DESIGN")) {
			addJPanel(new PSP_DesignPanel(this));
			System.out.println("Yeah Design");
		} else if (event.equals("TESTING")) {
			addJPanel(new PSPTestingFrame());			
		} 
	}
	
	private boolean getIsNeeded () {
		boolean isNeeded;
		try {			
			ObjectInputStream ois = new ObjectInputStream (new FileInputStream (
					System.getProperty("user.home") + File.separator + ".memoranda" + 
							File.separator + ".proj" + File.separator + "psp_id"));
			isNeeded = true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			isNeeded = false;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			isNeeded = false;
		} 		
		return isNeeded;
	}
	
	public static void setPspValues (PspImpl pspI) {
		PSP_Panel.pspI = pspI;
	}
	
	public static void setNewPlanningWizard (PSP_PlanningWizardFrame pwf) {
		PSP_Panel.pwf = pwf;
	}
	
	/**
	 * Implementing open file dialog to help user select project to open
	 */
	private boolean openFileDialog () {
		//Using user.home instead of user.dir
		boolean projOpened = false;
		JFileChooser fc =  new JFileChooser(new File(System.getProperty
				("user.home") + File.separator + ".memoranda" + 
				File.separator + ".proj" + File.separator + ".pspxFiles"));
		int returnVal = fc.showOpenDialog(this);
		ObjectInputStream ois = null;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				ois = new ObjectInputStream (new FileInputStream (fc.getSelectedFile()));				
				setPspValues ((PspImpl) ois.readObject());
				ois.close();
				projOpened = true;
			} catch (ClassNotFoundException e) {
				Util.debug("CHECK THE OBJECT");
				projOpened = false;
			} catch (IOException e) {
				Util.debug("FILE NOT FOUND!");
				projOpened = false;
			}
		}
		
		return projOpened;
	}
	
	private static boolean saveDialog () {
		boolean isSaved;
		JFileChooser fc = new JFileChooser(new File(
				System.getProperty("user.home") + File.separator + ".memoranda" + 
						File.separator + ".proj" + File.separator + ".pspxFiles"));
		int saveVal = 0;//fc.showSaveDialog(this);
		if (saveVal == JFileChooser.APPROVE_OPTION) {
			isSaved = true;
			isDirty = false;
		}else {
			isSaved = false;
		}
		return isSaved;
	}
	
	/*private void saveAsDialog () {
		//Using user.home instead of user.dir
		FileDialog fc =  new FileDialog ();	
	}*/
	
	private static boolean checkIsDirty () {
		return isDirty;
	}
}