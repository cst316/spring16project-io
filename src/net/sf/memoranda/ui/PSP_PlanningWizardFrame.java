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
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;

import net.sf.memoranda.util.Configuration;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JScrollPane;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;

public class PSP_PlanningWizardFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtEstTime;
	private JTextField txtEstLocHr;
	private JTextField txtEstSize;
	private JTextField txtEstDefect;
	
	private PSP_NPWizardFrame goBack;
	
	static JFrame pwf = null;
	private JTextField txtDescription;
	private JTextField txtModuleSize;
	private JButton btnAddModule;
	private JPanel pnlEachFile;
	private JLabel lblFilename;
	private JTextField txtFilePath;
	

	List <JTextField> test = new ArrayList<JTextField>();	
	private List <JPanel> moduleAdd = new ArrayList <JPanel> ();
	private List <JPanel> filesAdd = new ArrayList <JPanel> ();
	private List <JButton> modAction = new ArrayList <JButton> ();
	private List <JButton> fileAction = new ArrayList <JButton> ();
	private String pid;
	private JButton btnFileAdd;
	private JPanel pnlEachModule;
	private JPanel pnlModule;
	private JPanel pnlFiles;
	private JScrollPane spFile;
	private JScrollPane spModule;
	private JPanel panel_1;
		
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
		setLook ();
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
		panel.setBounds(10, 40, 475, 160);
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
		lblProjectId.setBounds(300, 5, 85, 25);
		contentPane.add(lblProjectId);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.setBounds(400, 5, 80, 25);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("100000001");
		lblNewLabel.setBounds(0, 0, 80, 25);
		panel_2.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		pnlModule = new JPanel();
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
		
		panel_1 = new JPanel();
		panel_1.setBounds(10, 60, 450, 125);
		pnlModule.add(panel_1);
		panel_1.setLayout(new BorderLayout());//(0, 0));
		
		spModule = new JScrollPane();
		spModule.setBorder(null);
		panel_1.add(spModule);
		spModule.setHorizontalScrollBarPolicy
				(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);		
		
		pnlEachModule = new JPanel();
		spModule.setViewportView(pnlEachModule);
		pnlEachModule.setLayout(null);
		pnlEachModule.setBackground(Color.WHITE);
		
		addPnlModules ();
		
		spFile = new JScrollPane();
		spFile.setBounds(10, 210, 475, 110);
		contentPane.add(spFile);
		
		pnlFiles = new JPanel();
		spFile.setViewportView(pnlFiles);
		pnlFiles.setBackground(Color.WHITE);
		pnlFiles.setLayout(null);
		
		JLabel lblFiles = new JLabel("Files");
		lblFiles.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiles.setBounds(210, 5, 55, 15);
		pnlFiles.add(lblFiles);
		
		pnlEachFile = new JPanel();
		pnlEachFile.setBorder(null);
		pnlEachFile.setBackground(Color.WHITE);
		//pnlEachFile.setBounds(10, 30, 450, 25);
		pnlEachFile.setLayout(null);
		//filesAdd.add(pnlEachFile);
		pnlFiles.add(pnlEachFile);//filesAdd.get(0));
				
		lblFilename = new JLabel("Filename:");
		lblFilename.setBorder(null);
		lblFilename.setBackground(Color.WHITE);
		lblFilename.setBounds(0, 0, 85, 25);
		pnlEachFile.add(lblFilename);
		
		txtFilePath = new JTextField();
		txtFilePath.setBounds(100, 0, 250, 25);
		pnlEachFile.add(txtFilePath);
		txtFilePath.setColumns(10);
		
		btnFileAdd = new JButton("");
		btnFileAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonAction_Clicked ("ADD_FILE");
			}
		});
		btnFileAdd.setBackground(Color.WHITE);
		btnFileAdd.setBorder(null);
		btnFileAdd.setIcon(new ImageIcon(
				PSP_PlanningWizardFrame.class.getResource(
				"/net/sf/memoranda/ui/resources/icons/plus.png")));
		btnFileAdd.setBounds(425, 0, 25, 25);
		pnlEachFile.add(btnFileAdd);

		setResizable (false);
	}
	
	private void addPnlFiles () {
		int width = pnlEachModule.getWidth();
		int height = pnlEachModule.getHeight();
		int x = pnlEachModule.getX();
		int y = pnlEachModule.getY() + height + 5;
		
		pnlEachFile.setBounds(x, y, width, height);
		filesAdd.add(pnlEachFile);
		pnlFiles.add(filesAdd.get(filesAdd.size() - 1));
	}
	
	private void addPnlModules () {	
		int width = 425;
		int height = 25;
		int x = 0;
		int y = (moduleAdd.size() == 0 ? 0 : 
			moduleAdd.get(moduleAdd.size() - 1).getY() + height + 5);
		String icon;
		
		btnAddModule = new JButton("");
		btnAddModule.setBorder(null);
		btnAddModule.setBounds(395, 0, 25, 25);
		btnAddModule.setBackground(new Color(255, 255, 255));
		modAction.add(btnAddModule);
	
		txtDescription = new JTextField();
		txtDescription.setBounds(0, 0, 275, 25);
		txtDescription.setColumns(10);

		test.add(txtDescription);
		
		txtModuleSize = new JTextField();
		txtModuleSize.setBounds(295, 0, 80, 25);
		txtModuleSize.setColumns(10);
		
		JPanel holdItems = new JPanel();
		holdItems.setBackground(Color.WHITE);
		holdItems.setLayout(null);
		holdItems.add(txtDescription);
		holdItems.add(txtModuleSize);
		holdItems.add(btnAddModule);
		holdItems.setBounds(x, y, width, height);
		
		for (int i = 0; i < modAction.size(); i++) {
			for (ActionListener al : modAction.get(i).getActionListeners()) 
				modAction.get(i).removeActionListener(al);			
		}
		
		//pnlEachModule.invalidate();
				
		moduleAdd.add(holdItems);
				
		for (int i = 0; i < moduleAdd.size(); i++) {
			if (i < moduleAdd.size() - 1) {
				icon = "/net/sf/memoranda/ui/resources/icons/plus.png";
				test.get(i).setText("True");
			} else {
				icon = "/net/sf/memoranda/ui/resources/icons/plus.png";
				test.get(i).setText("False");
			}
			
			modAction.get(i).setIcon(new ImageIcon(
							PSP_PlanningWizardFrame.class.getResource(icon)));
			pnlEachModule.add(moduleAdd.get(i));
			modAction.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonAction_Clicked ("ADD_MOD");
				}
			});
		}
		
		//pnlEachModule.validate();
		pnlEachModule.repaint();

		pnlEachModule.setPreferredSize(new Dimension (450, y + height));
		spModule.setVerticalScrollBarPolicy
			(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	private void removeModule () {	
		int width = 425;
		int height = 25;
		int x = 0;
		int y = (moduleAdd.size() == 0 ? 0 : 
			moduleAdd.get(moduleAdd.size() - 1).getY() + height + 5);
		
		btnAddModule = new JButton("");
		btnAddModule.setBorder(null);
		btnAddModule.setBounds(395, 0, 25, 25);
		btnAddModule.setBackground(new Color(255, 255, 255));
		modAction.add(btnAddModule);
	
		txtDescription = new JTextField();
		txtDescription.setBounds(0, 0, 275, 25);
		txtDescription.setColumns(10);
		
		txtModuleSize = new JTextField();
		txtModuleSize.setBounds(295, 0, 80, 25);
		txtModuleSize.setColumns(10);
		
		JPanel holdItems = new JPanel();
		holdItems.setBackground(Color.WHITE);
		holdItems.setLayout(null);
		holdItems.add(txtDescription);
		holdItems.add(txtModuleSize);
		holdItems.add(btnAddModule);
		holdItems.setBounds(x, y, width, height);
		
		for (int i = 0; i < modAction.size(); i++) {
			for (ActionListener al : modAction.get(i).getActionListeners()) 
				modAction.get(i).removeActionListener(al);			
		}
		
		//pnlEachModule.invalidate();
				
		moduleAdd.add(holdItems);
				
		for (int i = 0; i < moduleAdd.size(); i++) {
			pnlEachModule.add(moduleAdd.get(i));
			modAction.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					buttonAction_Clicked ("ADD_MOD");
				}
			});	
			btnAddModule.setIcon(new ImageIcon(PSP_PlanningWizardFrame.class.getResource("/net/sf/memoranda/ui/resources/icons/plus.png")));
			
		}
		
		//pnlEachModule.validate();
		pnlEachModule.repaint();

		pnlEachModule.setPreferredSize(new Dimension (450, y + height));
		spModule.setVerticalScrollBarPolicy
			(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
	}
	
	
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
	
	private void buttonAction_Clicked (String pan) {
		pwf = this;
		if (pan.equals("BACK")) {
			PSP_NPWizardFrame.npw.setVisible(true);
			this.setVisible(false);
		} else if (pan.equals("FINISH")) {
			PSP_NPWizardFrame.npw.dispose();
			pwf = null;
			PSP_NPWizardFrame.npw = null;
			dispose();
		} else if (pan.equals("CANCEL")) {
			int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Confirm", JOptionPane.YES_NO_OPTION);
			
			if (confirm == JOptionPane.YES_OPTION) {
				pwf = null;
				PSP_NPWizardFrame.npw.dispose();
				dispose();
				App.getFrame().setEnabled(true);
			}
		} else if (pan.equals("ADD_MOD")) {			
			addPnlModules ();
			
		} else if (pan.equals("ADD_FILE")) {	
			addPnlFiles ();
		}			
	}
}
