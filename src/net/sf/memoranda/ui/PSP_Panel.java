package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import net.sf.memoranda.psp.Design;
import net.sf.memoranda.psp.Planning;
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
import java.io.IOException;
import java.io.ObjectInputStream;
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
	private JPanel pnlWizard;
	public JToolBar toolBar;
	
	static PSP_PlanningWizardFrame pwf;
	static PspImpl pspI;
	static JPanel currentView;
	static Planning plan;
	static Design design;
	static Testing test;
	
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
	private void jbInit() throws Exception {
		pspI = new PspImpl();
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
		setEnabledFlag (lblOpenProject, getIsNeeded());
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
				
		pnlWizard = new JPanel();
		pnlWizard.setVisible(false);
		add(pnlWizard, BorderLayout.CENTER);
		pnlWizard.setLayout(new BorderLayout(0, 0));
	}
	
	private void setEnabledFlag(JLabel lblEnableThis, boolean flag) {
		// TODO Auto-generated method stub
		lblEnableThis.setEnabled(flag);
	}

	public void addJPanel (JPanel toAdd) {
		pnlWizard.removeAll();
		pnlWizard.add(toAdd, BorderLayout.CENTER);
		toAdd.setVisible(true);
		toolBar.setVisible(false);
		this.setEnabled(true);
		pnlWizard.setVisible(true);
		
		if (toAdd instanceof PSP_Planning) {
			toAdd.setName("PLANNING");
		} else if (toAdd instanceof PSP_DesignPanel) {
			toAdd.setName("DESIGN");
		} else if (toAdd instanceof PSPTestingFrame) {
			toAdd.setName("DEFECT");
		} //else if (toAdd instanceof PSP_Planning) {
			//toAdd.setName("PLANNING");
		//}
		currentView = toAdd;
		
		this.revalidate();
	}
	
	/**
	 * To start the PSP New project wizard once clicked and other 
	 * Mouse events for New Project on the auto hide tool bar
	 * @param event - Used to know which action to perform
	 */
	private void project_MouseEvent (String event) {
		if (event.equals("NEW PROJECT")) {
			App.getFrame().setEnabled(false);
			toolBar.setVisible (false);
			setEnabledFlag (lblOpenProject, getIsNeeded());
			(new PSP_NPWizardFrame(this)).setVisible(true);			
		} else if (event.equals("OPEN PROJECT")) {
			if (currentView != null) {
				Util.debug("CURRENT VIEW: " + currentView.getName());
			}
			openFileDialog();			
		} else if (event.equals("PLANNING")) {
			PSP_Planning pp = new PSP_Planning (plan);
			addJPanel (pp);				
		} else if (event.equals("DESIGN")) {
			addJPanel(new PSP_DesignPanel(this));
			System.out.println("Yeah Design");
		} else if (event.equals("DEFECT")) {
			addJPanel(new PSPTestingFrame());			
		} else if (event.equals("TIMELOG")) {
			//addJPanel(new PSPTestingFrame());			
		} 
	}
	
	public static void setPspValues (PspImpl pspI) {
		PSP_Panel.pspI = pspI;
	}
	
	public static void setNewPlanningWizard (PSP_PlanningWizardFrame pwf) {
		PSP_Panel.pwf = pwf;
	}
	
	private boolean getIsNeeded () {
		boolean isNeeded = false;
		try {			
			ObjectInputStream ois = new ObjectInputStream (new FileInputStream (
					System.getProperty("user.home") + File.separator + ".memoranda" + 
							File.separator + ".proj" + File.separator + "psp_id"));
			if (ois.readInt() > 100000001) {
				isNeeded = true;
				Util.debug("Is this really enabled");
			}
			ois.close();
		} catch (IOException e) {
			isNeeded = false;
		} 		
		return isNeeded;
	}
	
	/**
	 * Implementing open file dialog to help user select project to open
	 */
	private boolean openFileDialog () {
		//Using user.home instead of user.dir
		boolean projOpened = false;
		JFileChooser fc =  new JFileChooser(new File(System.getProperty
				("user.home") + File.separator + ".memoranda" + 
				File.separator + ".proj"));				// + File.separator + ".pspxFiles"));
		int returnVal = fc.showOpenDialog(this);
		
		ObjectInputStream ois = null;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				File openThis = fc.getSelectedFile();
				ois = new ObjectInputStream (new FileInputStream (openThis.getAbsolutePath()));	
				pspI = (PspImpl) ois.readObject();
				ois.close();
				Util.debug("INDEXER: " + pspI.getpId());
				if (currentView instanceof PSP_DesignPanel) {
					project_MouseEvent ("DESIGN");
				}  else if (currentView instanceof PSPTestingFrame) {
					project_MouseEvent ("DEFECT");
				} else if (currentView instanceof PSP_Planning) {
					project_MouseEvent ("PLANNING");
				} else {
					project_MouseEvent ("PLANNING");				
				}
				Util.debug("INDEXER: " + pspI.getpId());
				
				projOpened = true;
			} catch (ClassNotFoundException e) {
				Util.debug("CHECK THE OBJECT");
				projOpened = false;
			} catch (IOException e) {
				Util.debug("FILE NOT FOUND!");
				projOpened = false;
			}
		}
		
		if (toolBar.getComponentCount() < 3)
			setExtraTools ();
		
		return projOpened;
	}
	
	public void setExtraTools () {
		// TODO Auto-generated method stub
		JLabel lblPlanningProject = new JLabel("Planning");		
		
		lblPlanningProject.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlanningProject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				project_MouseEvent("PLANNING");
			}
		});
		lblPlanningProject.setLocation(new Point(150, 50));
		lblPlanningProject.setMinimumSize(new Dimension(100, 50));
		lblPlanningProject.setMaximumSize(new Dimension(100, 50));
		lblPlanningProject.setPreferredSize(new Dimension(100, 50));
		lblPlanningProject.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JLabel lblDesigningProject = new JLabel("Designing");
		lblDesigningProject.setHorizontalAlignment(SwingConstants.CENTER);
		lblDesigningProject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				project_MouseEvent("DESIGN");
			}
		});
		lblDesigningProject.setLocation(new Point (200, 50));
		lblDesigningProject.setMinimumSize(new Dimension(100, 50));
		lblDesigningProject.setMaximumSize(new Dimension(100, 50));
		lblDesigningProject.setPreferredSize(new Dimension(100, 50));
		lblDesigningProject.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JLabel lblDefectInProject = new JLabel("Defect");
		lblDefectInProject.setHorizontalAlignment(SwingConstants.CENTER);
		lblDefectInProject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				project_MouseEvent("DEFECT");
			}
		});
		lblDefectInProject.setLocation(new Point (250, 50));
		lblDefectInProject.setMinimumSize(new Dimension(100, 50));
		lblDefectInProject.setMaximumSize(new Dimension(100, 50));
		lblDefectInProject.setPreferredSize(new Dimension(100, 50));
		lblDefectInProject.setFont(new Font("Dialog", Font.BOLD, 12));	
		
		JLabel lblTimeLogProject = new JLabel("Time Log");		
		
		lblTimeLogProject.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimeLogProject.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				project_MouseEvent("TIMELOG");
			}
		});
		lblTimeLogProject.setLocation(new Point(150, 50));
		lblTimeLogProject.setMinimumSize(new Dimension(100, 50));
		lblTimeLogProject.setMaximumSize(new Dimension(100, 50));
		lblTimeLogProject.setPreferredSize(new Dimension(100, 50));
		lblTimeLogProject.setFont(new Font("Dialog", Font.BOLD, 12));
	
		toolBar.add(lblPlanningProject);
		toolBar.add(lblDesigningProject);
		toolBar.add(lblDefectInProject);
		toolBar.add(lblTimeLogProject);
	}
}