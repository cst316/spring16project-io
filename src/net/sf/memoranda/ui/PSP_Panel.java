package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import net.sf.memoranda.psp.Design;
import net.sf.memoranda.psp.Planning;
import net.sf.memoranda.psp.PspImpl;
import net.sf.memoranda.psp.Defect;
import net.sf.memoranda.util.Util;

//import net.sf.memoranda.util.Configuration;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;
import java.awt.Component;

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
	static Defect test;	
	private JLabel label;
	private JLabel lable1;
	
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
		
		if (toAdd instanceof PSP_PlanningPanel) {
			toAdd.setName("PLANNING");
		} else if (toAdd instanceof PSP_DesignPanel) {
			toAdd.setName("DESIGN");
		} else if (toAdd instanceof PSP_DefectPanel) {
			toAdd.setName("DEFECT");
		} //else if (toAdd instanceof PSP_TimeLogPanel) {
			//toAdd.setName("TIMELOG");
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
			File fs = new File (System.getProperty("user.home") +  File.separator + ".memoranda" + 
					File.separator + ".proj" + File.separator + '.' + pspI.getpId() + 
					File.separator + '.' + pspI.getpId() + "_planning");
			ObjectInputStream ois;
			try {			
				ois = new ObjectInputStream (new FileInputStream (fs));
				plan = (Planning) ois.readObject();
								
				PSP_PlanningPanel pp = new PSP_PlanningPanel (plan);
				addJPanel (pp);		
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		} else if (event.equals("DESIGN")) {
			addJPanel(new PSP_DesignPanel(this));
			System.out.println("Yeah Design");
		} else if (event.equals("DEFECT")) {
			File defect_filePath = new File (System.getProperty("user.home") +  File.separator + ".memoranda" + 
					File.separator + ".proj" + File.separator + '.' + pspI.getpId() + 
					File.separator + '.' + pspI.getpId() + "_defect");

				PSP_DefectPanel defectPanel = new PSP_DefectPanel(test);
				addJPanel (defectPanel);							
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
		JFileChooser fc =  new JFileChooser(new File(
				System.getProperty ("user.home") + File.separator + ".memoranda" + 
				File.separator + ".proj" + File.separator + ".pspxFiles"));
		int returnVal = fc.showOpenDialog(this);
		
		ObjectInputStream ois = null;
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				File openThis = fc.getSelectedFile();
				ois = new ObjectInputStream (new FileInputStream (openThis.getAbsolutePath()));	
				pspI = (PspImpl) ois.readObject();
				ois.close();

				if (currentView instanceof PSP_DesignPanel) {
					project_MouseEvent ("DESIGN");
				}  else if (currentView instanceof PSP_DefectPanel) {
					project_MouseEvent ("DEFECT");
				} else if (currentView instanceof PSP_PlanningPanel) {
					project_MouseEvent ("PLANNING");
				} /*else if (currentView instanceof PSP_TimeLogPanel) {
					project_MouseEvent ("PLANNING");				
				} */else {
					PSP_SnapIn snap = new PSP_SnapIn();
					snap.lblStartDate.setText(pspI.getStDate().get().toString());
					snap.lblProjectID.setText(pspI.getpId()+"");
					snap.txtProjectName.setText(pspI.getName().toString());
					snap.txtDescription.setText(pspI.getDescription());
					
					addJPanel (snap);
				}
				
				projOpened = true;
				if (toolBar.getComponentCount() <= 3)
					setExtraTools ();
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
		lblPlanningProject.setLocation(new Point (200, 50));
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
				Util.debug("DEFECT CLICKED");
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
		toolBar.revalidate();
	}
	
	private class PSP_SnapIn extends JPanel {
		JPanel contentPane;
		JTextField txtProjectName;
		JLabel lblStartDate;
		JLabel lblProjectID;
		JButton btnEdit;
		JButton btnSave;
		JButton btnEndProject;
		JTextArea txtDescription;
		
		public PSP_SnapIn () {
			jInit();
		}
		
		public void jInit () {
			setSize(new Dimension ((int) (pnlWizard.getWidth() * 0.8), (int) (pnlWizard.getHeight() * 0.8)));
			contentPane = new JPanel();
			contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			
			JPanel panel1 = new JPanel();
			
			lblStartDate = new JLabel("");
			lblStartDate.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblStartDate.setHorizontalAlignment(SwingConstants.CENTER);
			
			JLabel label = new JLabel("Start Date:");
			
			JLabel label1 = new JLabel("Project ID:");
			label1.setHorizontalAlignment(SwingConstants.RIGHT);
			
			lblProjectID = new JLabel("");
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
						.addPreferredGap(ComponentPlacement.RELATED, 131, Short.MAX_VALUE)
						.addComponent(label1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblProjectID, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			gl_panel1.setVerticalGroup(
				gl_panel1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel1.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel1.createParallelGroup(Alignment.LEADING)
							.addGroup(Alignment.TRAILING, gl_panel1.createParallelGroup(Alignment.BASELINE)
								.addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblStartDate, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.TRAILING, gl_panel1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblProjectID, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
								.addComponent(label1, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))))
			);
			panel1.setLayout(gl_panel1);
			JPanel panel = new JPanel();
			
			btnSave = new JButton("Save");
			btnSave.setAlignmentX(Component.CENTER_ALIGNMENT);
			btnSave.setPreferredSize(new Dimension(100, 25));
			
			btnEndProject = new JButton("End Project");
			btnEndProject.setAlignmentX(Component.RIGHT_ALIGNMENT);
			btnEndProject.setPreferredSize(new Dimension(100, 25));
			
			btnEdit = new JButton("Edit Details");
			btnEdit.setPreferredSize(new Dimension(100, 25));
			
			GroupLayout gl_panel = new GroupLayout(panel);
			gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(90)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
						.addGap(90)
						.addComponent(btnEndProject, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addContainerGap())
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnEdit, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnEndProject, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSave, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			);
			panel.setLayout(gl_panel);
			JPanel panel2 = new JPanel();
			
			JLabel label2 = new JLabel("Project Name:");
			
			txtProjectName = new JTextField();
			txtProjectName.setEditable(false);
			txtProjectName.setColumns(10);
			
			JLabel label3 = new JLabel("Project Description:");
			
			txtDescription = new JTextArea();
			txtDescription.setEditable(false);
			GroupLayout gl_panel2 = new GroupLayout(panel2);
			gl_panel2.setHorizontalGroup(
				gl_panel2.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_panel2.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_panel2.createParallelGroup(Alignment.TRAILING)
							.addComponent(txtDescription, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
							.addGroup(Alignment.LEADING, gl_panel2.createSequentialGroup()
								.addComponent(label2)
								.addGap(11)
								.addComponent(txtProjectName, GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE))
							.addComponent(label3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
						.addContainerGap())
			);
			gl_panel2.setVerticalGroup(
				gl_panel2.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel2.createSequentialGroup()
						.addGap(10)
						.addGroup(gl_panel2.createParallelGroup(Alignment.BASELINE)
							.addComponent(label2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtProjectName, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
						.addGap(34)
						.addComponent(label3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtDescription, GroupLayout.DEFAULT_SIZE, 234, Short.MAX_VALUE)
						.addContainerGap())
			);
			panel2.setLayout(gl_panel2);
			GroupLayout gl_contentPane = new GroupLayout(contentPane);
			gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel1, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGap(16)
						.addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(25)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(50, Short.MAX_VALUE))
			);
			contentPane.setLayout(gl_contentPane);
		}
		
	}
}