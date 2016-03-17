package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Rectangle;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

import net.sf.memoranda.psp.PlanningImpl;
import net.sf.memoranda.psp.PspImpl;
import net.sf.memoranda.util.Configuration;
import net.sf.memoranda.util.Util;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

/**
 * 
 * @author Cephas Armstrong-Mensah
 * @author Team-IO
 * CST316 - Spring 2016, ASU Poly
 * This class is part of the PSP Startup wizard
 * it is invoked when a new PSP Project is started
 * 02/19/2016
 */
public class PSP_PlanningWizardFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2269259832152879602L;
	
	private JPanel contentPane;
	private JTextField txtEstTime;
	private JTextField txtEstSize;
	private JTextField txtEstDefect;
	private JTextField txtEstLocHr;
	
	static JFrame pwf = null;
	private JTextField txtDescription;
	private JTextField txtModuleSize;
	private JButton btnAddModule;
	private JPanel pnlEachFile;
	private JLabel lblFilename;
	private JTextField txtFilePath;	
	private JButton btnFileFind;

	private List <JTextField> modDescription = new ArrayList <JTextField>();
	private List <JTextField> modSize = new ArrayList <JTextField>();
	private List <JTextField> filePath = new ArrayList<JTextField>();
	private List <JPanel> modAdd = new ArrayList <JPanel> ();
	private List <JPanel> fileAdd = new ArrayList <JPanel> ();
	private List <JButton> modAction = new ArrayList <JButton> ();
	private List <JButton> fileAction = new ArrayList <JButton> ();
	private List <JButton> fileFind = new ArrayList <JButton> ();
	private List <String> planFiles = new ArrayList <String>();
	
	private JButton btnFileAdd;
	private JPanel pnlEachModule;
	private JPanel pnlModule;
	private JPanel pnlFiles;
	private JScrollPane spModule;
	private JScrollPane spFile;
	
	private JLabel lblProjId;
	
	/**
	 * General constructor
	 */
	public PSP_PlanningWizardFrame() {
		try {
			jbInit();
		} catch (Exception ex) {
			new ExceptionDialog(ex);
			ex.printStackTrace();
		}
	}
		
	/**
	 * Creating the different components 
	 */	
	private void jbInit() {
		setLook ();
		//this.setAlwaysOnTop(true);
		setTitle("New PSP Project Wizard - Planning");
		int xsize = 500, ysize = 600;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width - xsize)/2, (dim.height - ysize)/2);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener( new WindowAdapter()
		{
		    public void windowClosing(WindowEvent e)
		    {
		    	buttonAction_Clicked ("CANCEL");
		    }
		});
		setSize(xsize, ysize);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBounds(new Rectangle(0, 0, xsize, ysize));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pnlEstimates = new JPanel();
		pnlEstimates.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlEstimates.setBackground(Color.WHITE);
		pnlEstimates.setBounds(10, 40, 475, 150);
		contentPane.add(pnlEstimates);
		pnlEstimates.setLayout(null);
		
		JLabel lblEstTime = new JLabel("Estimated Time:");
		lblEstTime.setBounds(10, 10, 140, 25);
		pnlEstimates.add(lblEstTime);
		
		JLabel lblEstLochr = new JLabel("Estimated LOC/HR:");
		lblEstLochr.setBounds(10, 45, 140, 25);
		pnlEstimates.add(lblEstLochr);
		
		JLabel lblEstSize = new JLabel("Estimated Size:");
		lblEstSize.setBounds(10, 80, 140, 25);
		pnlEstimates.add(lblEstSize);
		
		JLabel lblEstDefect = new JLabel("Estimated Defect:");
		lblEstDefect.setBounds(10, 115, 140, 25);
		pnlEstimates.add(lblEstDefect);
		
		txtEstTime = new JTextField();
		txtEstTime.setBounds(180, 10, 80, 25);
		pnlEstimates.add(txtEstTime);
		txtEstTime.setColumns(10);
		
		txtEstSize = new JTextField();
		txtEstSize.setColumns(10);
		txtEstSize.setBounds(180, 80, 80, 25);
		pnlEstimates.add(txtEstSize);
		
		txtEstDefect = new JTextField();
		txtEstDefect.setColumns(10);
		txtEstDefect.setBounds(180, 115, 80, 25);
		pnlEstimates.add(txtEstDefect);
		
		txtEstLocHr = new JTextField();
		txtEstLocHr.setColumns(10);
		txtEstLocHr.setBounds(180, 45, 80, 25);
		pnlEstimates.add(txtEstLocHr);
		
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
		lblProjectId.setBounds(300, 5, 85, 25);
		contentPane.add(lblProjectId);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(400, 5, 80, 25);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblProjId = new JLabel(PspImpl.getLastID() + "");
		lblProjId.setBounds(0, 0, 80, 25);
		panel_2.add(lblProjId);
		lblProjId.setHorizontalAlignment(SwingConstants.CENTER);
		
		pnlModule = new JPanel();
		pnlModule.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlModule.setBounds(10, 330, 480, 190);
		contentPane.add(pnlModule);
		pnlModule.setBackground(Color.WHITE);
		pnlModule.setLayout(null);
		
		JLabel lblModule = new JLabel("MODULE");
		lblModule.setBounds(205, 5, 70, 25);
		pnlModule.add(lblModule);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(10, 35, 85, 25);
		pnlModule.add(lblDescription);
		
		JLabel lblSize = new JLabel("Size");
		lblSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblSize.setBounds(305, 35, 80, 25);
		pnlModule.add(lblSize);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 60, 450, 125);
		pnlModule.add(panel_1);
		panel_1.setLayout(new BorderLayout());
		
		spModule = new JScrollPane();
		spModule.setBorder(null);
		panel_1.add(spModule);
		spModule.setHorizontalScrollBarPolicy
				(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);		
		
		pnlEachModule = new JPanel();
		spModule.setViewportView(pnlEachModule);
		pnlEachModule.setLayout(null);
		pnlEachModule.setBackground(Color.WHITE);
		
		addPnlModule ();
		
		pnlFiles = new JPanel();
		pnlFiles.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlFiles.setBounds(10, 200, 475, 120);
		contentPane.add(pnlFiles);
		pnlFiles.setBackground(Color.WHITE);
		pnlFiles.setLayout(null);
		
		JLabel lblFiles = new JLabel("FILES");
		lblFiles.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiles.setBounds(210, 5, 55, 15);
		pnlFiles.add(lblFiles);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 20, 450, 90);
		pnlFiles.add(panel_3);
		panel_3.setLayout(new BorderLayout());
		
		spFile = new JScrollPane();
		spFile.setBorder(null);
		panel_3.add(spFile);
		spFile.setHorizontalScrollBarPolicy
				(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		pnlEachFile = new JPanel();
		spFile.setViewportView(pnlEachFile);
		pnlEachFile.setBackground(Color.WHITE);
		pnlEachFile.setLayout(null);
		
		addPnlFile();

		setResizable (false);		
	}
	
	/**
	 * Adding in the File names
	 */
	private void addPnlFile () {
		int width = 450;
		int height = 25;
		int x = 0;
		int y = (fileAdd.size() == 0 ? 0 : 
			fileAdd.get(fileAdd.size() - 1).getY() + height + 5);
				
		lblFilename = new JLabel("Filename:");
		lblFilename.setBorder(null);
		lblFilename.setBackground(Color.WHITE);
		lblFilename.setBounds(0, 0, 85, 25);
						
		txtFilePath = new JTextField();
		txtFilePath.setBounds(95, 0, 250, 25);
		txtFilePath.setColumns(10);
		filePath.add(txtFilePath);		
		
		btnFileAdd = new JButton("");
		btnFileAdd.setBackground(Color.WHITE);
		btnFileAdd.setBorder(null);
		btnFileAdd.setBounds(360, 0, 25, 25);
		fileAction.add(btnFileAdd);
		
		btnFileFind = new JButton("Open");
		btnFileFind.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnFileFind.setBounds(390, 0, 60, 25);
		fileFind.add(btnFileFind);
					
		JPanel holdItems = new JPanel();
		holdItems.setBackground(Color.WHITE);
		holdItems.setLayout(null);
		holdItems.add(txtFilePath);
		holdItems.add(lblFilename);		
		holdItems.add(btnFileAdd);
		holdItems.add(btnFileFind);
		holdItems.setBounds(x, y, width, height);
		fileAdd.add(holdItems);
		
		remActionListener (fileAction);
		remActionListener (fileFind);
		repaintPanel (fileAdd, fileAction, pnlEachFile);
		addFileActionListner(fileAction, 0);
		addFileActionListner(fileFind, 1);
		pnlEachFile.setPreferredSize(new Dimension (width, y + height));
	}
	
	/**
	 * Removing a specific row of items from the display
	 * @param e - takes in an ActionEvent as to know which specific
	 * item to remove from the display of file items
	 *  
	 */
	private void removePnlFile (ActionEvent e) {	
		int width = 450;
		int height = 25;
		int x = 0;
		int y = 0;
		
		remActionListener (fileAction);
		remActionListener (fileFind);
		for (int i = 0; i < fileAction.size(); i++) {
			if (e.getSource() == fileAction.get(i)) {
				fileAction.remove(i);
				fileAdd.remove(i);
				filePath.remove(i);
				fileFind.remove(i);
				if (planFiles.size() > 0) {
					planFiles.remove(i);
				}
				break;
			}
		}
		
		for (int i = 0; i < fileAction.size(); i++) {
			fileAdd.get(i).setBounds(x, y, width, height);
			y += height + 5;
		}
		
		repaintPanel (fileAdd, fileAction, pnlEachFile);
		addFileActionListner(fileAction, 0);
		addFileActionListner(fileFind, 1);		
		pnlEachFile.setPreferredSize(new Dimension (width, y));
		spFile.setVerticalScrollBarPolicy
			(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	/**
	 * Adding in the Module Items
	 */
	private void addPnlModule () {	
		int width = 450;
		int height = 25;
		int x = 0;
		int y = (modAdd.size() == 0 ? 0 : 
			modAdd.get(modAdd.size() - 1).getY() + height + 5);

		btnAddModule = new JButton("");
		btnAddModule.setBorder(null);
		btnAddModule.setBounds(395, 0, 25, 25);
		btnAddModule.setBackground(Color.WHITE);
		modAction.add(btnAddModule);
	
		txtDescription = new JTextField();
		txtDescription.setBounds(0, 0, 275, 25);
		txtDescription.setColumns(10);
		modDescription.add(txtDescription);
		
		txtModuleSize = new JTextField();
		txtModuleSize.setBounds(295, 0, 80, 25);
		txtModuleSize.setColumns(10);
		modSize.add(txtModuleSize);
		
		JPanel holdItems = new JPanel();
		holdItems.setBackground(Color.WHITE);
		holdItems.setLayout(null);
		holdItems.add(txtDescription);
		holdItems.add(txtModuleSize);
		holdItems.add(btnAddModule);
		holdItems.setBounds(x, y, width, height);
		modAdd.add(holdItems);
		
		remActionListener(modAction);
		repaintPanel (modAdd, modAction, pnlEachModule);
		addModActionListner(modAction);
		pnlEachModule.setPreferredSize(new Dimension (width, y + height));
		spModule.setVerticalScrollBarPolicy
			(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	/**
	 * Removing a specific row of items from the display
	 * @param e - takes in an ActionEvent as to know which specific
	 * item to remove from the display of file items
	 */
	private void removePnlModule (ActionEvent e) {	
		int width = 450;
		int height = 25;
		int x = 0;
		int y = 0;
		
		remActionListener (modAction);
		for (int i = 0; i < modAction.size(); i++) {
			if (e.getSource() == modAction.get(i)) {
				modAction.remove(i);
				modAdd.remove(i);
				modDescription.remove(i);
				modSize.remove(i);
				break;
			}
		}
		
		for (int i = 0; i < modAction.size(); i++) {
			modAdd.get(i).setBounds(x, y, width, height);
			y += height + 5;
		}		
		
		repaintPanel (modAdd, modAction, pnlEachModule);
		addModActionListner(modAction);
		pnlEachModule.setPreferredSize(new Dimension (width, y));
		spModule.setVerticalScrollBarPolicy
			(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	/**
	 * Repaints the Current JPanel due to the changes for add and remove
	 * @param repaintPnl - List of items within that panel
	 * @param iconBtn - buttons that need to have action listeners enabled
	 * @param whichPnl - panel to repaint changes onto
	 */
	private void repaintPanel (List<JPanel> repaintPnl, List<JButton> iconBtn, JPanel whichPnl) {
		String icon = "/net/sf/memoranda/ui/resources/icons/minus.png";			
		
		whichPnl.removeAll();
		for (int i = 0; i < repaintPnl.size(); i++) {
			whichPnl.add(repaintPnl.get(i));
			if (i == repaintPnl.size() - 1) { 
				icon = "/net/sf/memoranda/ui/resources/icons/plus.png";
				repaintPnl.get(i).getComponent(0).requestFocus();
			}
			iconBtn.get(i).setIcon(new ImageIcon(
					PSP_PlanningWizardFrame.class.getResource(icon)));	
		}
		whichPnl.revalidate();
		whichPnl.repaint();
	}
	
	/**
	 * Adding action listeners
	 * @param addB - module buttons to add action listener to
	 */
	private void addModActionListner (List<JButton> addB) {
		for (int i = 0; i < addB.size(); i++) {
			if (i == addB.size() - 1) {
				addB.get(i).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						buttonAction_Clicked ("ADD_MOD");
					}
				});
			} else {
				addB.get(i).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						removePnlModule (e);
					}
				});
			}
		}		
	}
	
	/**
	 * Adding action listeners
	 * @param addB - file buttons to add action listener to
	 */
	private void addFileActionListner (List<JButton> addB, int code) {
		for (int i = 0; i < addB.size(); i++) {
			if (code == 0) {
				if (i == addB.size() - 1) {
					addB.get(i).addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							buttonAction_Clicked ("ADD_FILE");
						}
					});
				} else {
					addB.get(i).addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							removePnlFile (e);
						}
					});
				}	
			} else if (code == 1) {
				addB.get(i).addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						for (int i=0; i< addB.size(); i++)
						{
							if (e.getSource() == addB.get(i))
								buttonAction_Clicked ("OPEN_FILE " + i);
						}						
					}
				});
			}
		}		
	}
	
	/**
	 * Remove action listeners before re-doing any changes to panel
	 * @param remB - List of items to remove action listeners from
	 */
	private void remActionListener (List<JButton> remB) {
		for (int i = 0; i < remB.size(); i++) {
			for (ActionListener al : remB.get(i).getActionListeners()) 
				remB.get(i).removeActionListener(al);			
		}		
	}
	
	/**
	 * Sets the look and feel for this frame based on look and feel for parent frame
	 */
	private void setLook () {
		try {
			if (Configuration.get("LOOK_AND_FEEL").equals("system"))
				UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
			else if (Configuration.get("LOOK_AND_FEEL").equals("default"))
				UIManager.setLookAndFeel(
					UIManager.getCrossPlatformLookAndFeelClassName());					
			else if (
				Configuration.get("LOOK_AND_FEEL").toString().length() > 0)
				UIManager.setLookAndFeel(
					Configuration.get("LOOK_AND_FEEL").toString());
		} catch (Exception e) {		    
			new ExceptionDialog(e, "Error when initializing a pluggable look-and-feel. Default LF will be used.", 
					"Make sure that specified look-and-feel library classes are on the CLASSPATH.");
		}
	}
	
	/**
	 * Implementing open file dialog to help user select file location or name
	 * @param i - the index of the text field to place the result in
	 */
	private void openFileDialog (int i) {
		JFileChooser fc = new JFileChooser(
				new File(System.getProperty("user.home") + File.separator + "Pictures"));    
		int returnVal = fc.showOpenDialog(this);
		
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = fc.getSelectedFile();
			filePath.get(i).setText(file.getName());
			planFiles.add(file.getAbsolutePath());
		}
	}
	
	/**
	 * Controls some action events, intermediary method
	 * @param pan - has the value for which condition needs to be entered
	 */
	private void buttonAction_Clicked (String pan) {
		pwf = this;
		if (pan.equals("BACK")) {
			PSP_NPWizardFrame.npw.setVisible(true);
			this.setVisible(false);
		} else if (pan.equals("FINISH")) {
			callFinish();			
		} else if (pan.equals("CANCEL")) {
			UIManager.put("OptionPane.background",Color.white);
			UIManager.put("Panel.background",Color.white);
			
			int confirm = JOptionPane.showConfirmDialog(null, 
					"Are you sure you want to exit?","Confirm", JOptionPane.YES_NO_OPTION);
			
			if (confirm == JOptionPane.YES_OPTION) {
				pwf = null;
				PSP_NPWizardFrame.npw.dispose();
				dispose();
				App.getFrame().setEnabled(true);
			}
		} else if (pan.equals("ADD_MOD")) {	
			addPnlModule ();	
		} else if (pan.equals("ADD_FILE")) {	
			addPnlFile ();
		} else if (pan.contains("OPEN_FILE")) {
			openFileDialog (Integer.parseInt(pan.trim().substring(10, pan.length())));
		} else {
			//Do nothing
		}
	}
	
	private void callFinish() {
		ObjectOutputStream oos = null;
		try {			
			App.getFrame().setEnabled(true);
			PSP_NPWizardFrame.npw.dispose();
			PspImpl psp = new PspImpl (PSP_NPWizardFrame.getProjName(), PSP_NPWizardFrame
					.getProjDescription(), Integer.parseInt(lblProjId.getText().trim()));
			
			createProjectFiles(PspImpl.getLastID());			
			oos = new ObjectOutputStream (new FileOutputStream (new File (
					System.getProperty("user.home") +  File.separator + ".memoranda" + 
							File.separator + ".proj" + File.separator + ".pspxFiles" + 
							File.separator + "." + getPID() + ".pspx")));
			oos.writeObject(psp);
			
			PSP_Panel.setNewPlanningWizard(this);
			PSP_Panel.setPspValues(psp);
			
			float time = getEstTime();
			int loc = getEstLocHr();
			int size = getEstSize();
			int defect = getEstDefect ();
			oos.flush();
			oos.close();
			
			if (time != -1.0 && loc != -1 && size != -1 && defect != -1) {			
				PlanningImpl plan = new PlanningImpl (time, loc, size, defect,
						getFilenames(), getProjDescription(), getPID());
				oos = new ObjectOutputStream (new FileOutputStream (
						System.getProperty("user.home") +  File.separator +	".memoranda" + 
						File.separator + ".proj" + File.separator + '.' + getPID () + 
						File.separator + '.' + getPID() + "_planning"));
				oos.writeObject(plan);
				oos.flush();
				oos.close();
				
				PspImpl.setLastID(PspImpl.getLastID() + 1);
				writepID(PspImpl.getLastID());
				PSP_Panel p = PSP_NPWizardFrame.getPspPanel();
				PSP_Panel.plan = plan;
				p.addJPanel(new PSP_Planning (plan));
				addToolItems();
				PSP_NPWizardFrame.npw = null;			
				pwf = null;
				dispose();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new ExceptionDialog (e, "Something happened", "");
		}			
	}
	
	private int getPID() {
		int n = -1;
		try {
			n = Integer.parseInt(lblProjId.getText().trim());
		} catch (NumberFormatException e) {
			new ExceptionDialog(e, "Parsing error" , "");
		}
		return n;
	}

	public float getEstTime () {
		float n = -1.0f;
		try {
			n = Float.parseFloat(txtEstTime.getText().trim());
		} catch (NumberFormatException e) {
			new ExceptionDialog(e, "Parsing error" , "");
			this.txtEstTime.requestFocus();
			this.txtEstTime.selectAll();
		}
		return n;
	}
	
	public int getEstSize() {
		int n = -1;
		try {
			n = Integer.parseInt(txtEstSize.getText().trim());
		} catch (NumberFormatException e) {
			new ExceptionDialog(e, "Parsing error" , "");
			this.txtEstSize.requestFocus();
			this.txtEstSize.selectAll();
		}
		return n;
	}
	
	public int getEstLocHr () {
		int n = -1;
		try {
			n = Integer.parseInt(txtEstLocHr.getText().trim());
		} catch (NumberFormatException e) {
			new ExceptionDialog(e, "Parsing error" , "");
			this.txtEstLocHr.requestFocus();
			this.txtEstLocHr.selectAll();
		}
		return n;
	}

	public int getEstDefect () {
		int n = -1;
		try {
			n = Integer.parseInt(txtEstDefect.getText().trim());
		} catch (NumberFormatException e) {
			new ExceptionDialog(e, "Parsing error" , "");
			this.txtEstDefect.requestFocus();
			this.txtEstDefect.selectAll();			
		}
		return n;
	}
	
	private void addToolItems() {
		// TODO Auto-generated method stub
		JLabel lblPlanningProject = new JLabel("Planning");		
		PSP_Panel p = PSP_NPWizardFrame.getPspPanel();
		
		if (PspImpl.getLastID() > 100000001) {
			lblPlanningProject.setHorizontalAlignment(SwingConstants.CENTER);
			lblPlanningProject.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					p.project_MouseEvent("PLANNING");
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
					p.project_MouseEvent("DESIGN");
				}
			});
			lblDesigningProject.setLocation(new Point (200, 50));
			lblDesigningProject.setMinimumSize(new Dimension(100, 50));
			lblDesigningProject.setMaximumSize(new Dimension(100, 50));
			lblDesigningProject.setPreferredSize(new Dimension(100, 50));
			lblDesigningProject.setFont(new Font("Dialog", Font.BOLD, 12));
			
			JLabel lblTestingProject = new JLabel("Testing");
			lblTestingProject.setHorizontalAlignment(SwingConstants.CENTER);
			lblTestingProject.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					p.project_MouseEvent("TESTING");
				}
			});
			lblTestingProject.setLocation(new Point (250, 50));
			lblTestingProject.setMinimumSize(new Dimension(100, 50));
			lblTestingProject.setMaximumSize(new Dimension(100, 50));
			lblTestingProject.setPreferredSize(new Dimension(100, 50));
			lblTestingProject.setFont(new Font("Dialog", Font.BOLD, 12));		
		
			p.toolBar.add(lblPlanningProject);
			p.toolBar.add(lblDesigningProject);
			p.toolBar.add(lblTestingProject);	
		}
	}

	private void createProjectFiles(int lastID) {
		File dir = new File (System.getProperty("user.home") + 
				File.separator + ".memoranda" + File.separator + ".proj");
		File sub = null;
		try {			
			if (!dir.exists()) {
				dir.mkdir();				
			} 
			
			sub = new File (dir.getPath() + File.separator + ".pspxFiles");
			if (!sub.exists()){
				sub.mkdir();
			}			
						
			sub = new File (dir.getPath() + File.separator + '.' + getPID() + 
					File.separator + ".images" + File.separator + ".design");
			if (!sub.exists()){
				sub.mkdirs();
			}
			
			sub = new File (dir.getPath() + File.separator + '.' + getPID() + 
					File.separator + ".images" + File.separator + ".plan");
			if(!sub.exists()){
				sub.mkdirs();
			}			
			
			sub = new File (dir + File.separator + '.' + getPID() +
					File.separator + '.' + getPID() + "_planning");
			sub.createNewFile();			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}

	private void writepID(int lastID) {
		File idFile = new File(System.getProperty("user.home") + File.separator + 
				".memoranda" + File.separator + ".proj" + File.separator + "psp_id");
		ObjectOutputStream dos = null;
		try {
			if (!idFile.exists()) {			
				idFile.createNewFile();
			} 
			
			dos = new ObjectOutputStream (new FileOutputStream(idFile));
			dos.writeInt(lastID);
			dos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 		
	}

	public HashMap<String, Integer> getProjDescription() {
		HashMap<String, Integer> modDesc = new HashMap<String, Integer>();
		
		for (int i = 0; i < modDescription.size(); i++)
		{
			String mod = modDescription.get(i).getText();
			String size = modSize.get(i).getText();
			if (!mod.isEmpty() && !size.isEmpty())
				modDesc.put(mod, Integer.parseInt(size));
		}		
		
		return modDesc;
	}

	public ArrayList<String> getFilenames() {
		ArrayList <String> fileNames = new ArrayList<String> ();
		for (int i = 0; i < filePath.size(); i++) {
			if (!filePath.get(i).getText().trim().isEmpty()) {
				fileNames.add(planFiles.get(i).trim());
			}
		}
		return fileNames;
	}
}