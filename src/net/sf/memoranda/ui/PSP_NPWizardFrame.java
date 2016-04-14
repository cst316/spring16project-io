package net.sf.memoranda.ui;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

import net.sf.memoranda.psp.Psp;
import net.sf.memoranda.psp.PspImpl;
import net.sf.memoranda.util.Configuration;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 
 * @author Cephas Armstrong-Mensah
 * @author Team-IO
 * CST316 - Spring 2016, ASU Poly
 * This class is part of the PSP Startup wizard
 * it is invoked when a new PSP Project is started
 * 02/19/2016
 */
public class PSP_NPWizardFrame extends JFrame {

	private static final long serialVersionUID = 8329758838967365636L;

	private JPanel contentPane;
	private JLabel lblPID;
	private JLabel lblNewLabel;
	private static JTextField txtPrjName;
	private static JTextPane txtPrjDescription;
	private static PSP_Panel psp;
	
	public static PSP_NPWizardFrame npw = null;
	static int lastID = 0;
	
	/**
	 * General constructor
	 */
	public PSP_NPWizardFrame() {
		try {
			jbInit();
		} catch (Exception ex) {
			new ExceptionDialog(ex);
			ex.printStackTrace();
		}
	}
	
	public PSP_NPWizardFrame(PSP_Panel psp) {		
		try {
			setPspPanel(psp);
			jbInit();
		} catch (Exception ex) {
			new ExceptionDialog(ex);
			ex.printStackTrace();
		}
	}
	
	/**
	 * General constructor
	 */
	/*public PSP_NPWizardFrame(PSP_NPWizardFrame npw) {		
		newWizard = npw;
	}*/
	
	public static void setPspPanel (PSP_Panel p) {
		psp = p;
	}
	
	public static PSP_Panel getPspPanel () {
		return psp;
	}
		
	/**
	 * using init() style to create GUI details
	 */
	public void jbInit() {
		//this.setAlwaysOnTop(true);
		retrieveID();
		setLook();
		int xsize = 450, ysize = 300;
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((dim.width - xsize)/2, (dim.height - ysize)/2);		
		
		setTitle("New PSP Project Wizard");
		setResizable(false);
		
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener( new WindowAdapter(){
		    public void windowClosing(WindowEvent e){
		    	btnCancel_Clicked ();
		    }
		});
		setSize (xsize, ysize);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Label = new JLabel("Project ID:");
		Label.setHorizontalAlignment(SwingConstants.RIGHT);
		Label.setBounds(10, 25, 100, 25);
		contentPane.add(Label);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(125, 25, 80, 25);
		contentPane.add(panel);
		panel.setLayout(null);
		
		lblPID = new JLabel(lastID + "");
		lblPID.setBounds(0, 0, 80, 25);
		panel.add(lblPID);
		lblPID.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblNewLabel = new JLabel("Project Name:");	
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(10, 70, 100, 25);
		contentPane.add(lblNewLabel);
		
		txtPrjName = new JTextField("");
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
		txtPrjDescription.setText("");	//once the back-end is done, can get rid of this magic string
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
	
	private void retrieveID() {
		File idFile = new File(System.getProperty("user.home") + File.separator + 
				".memoranda" + File.separator + ".proj" + File.separator + "psp_id");
		try {
			if (!checkFile()) {			
				idFile.createNewFile();
				ObjectOutputStream dos = new ObjectOutputStream (new FileOutputStream(idFile));
				lastID = Psp.pID;
				System.out.println("ID: " + lastID);
				dos.writeInt(lastID);
				dos.close();
			} else {
				ObjectInputStream dis = new ObjectInputStream (new FileInputStream (idFile));
				lastID = dis.readInt();
				PspImpl.setLastID(lastID);
				dis.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	private void makeDir() {
		File dir = new File (System.getProperty("user.home") + 
				File.separator + ".memoranda" + File.separator + ".proj");
		if (!dir.exists()) {
			dir.mkdir();
		}
	}

	private boolean checkFile() {
		boolean ifExists = false;
		File yourFile = new File(System.getProperty("user.home") + File.separator + 
				".memoranda" + File.separator + ".proj" + File.separator + "psp_id");
		if(yourFile.exists()) {
		   ifExists = true;
		} else {
			makeDir();
		}
		return ifExists;
	}

	public int getPID() {
		return Integer.parseInt(lblPID.getText().trim());
	}
	
	public static String getProjName () {
		return txtPrjName.getText().trim();
	}
	
	public static String getProjDescription () {
		return txtPrjDescription.getText().trim();
	}
	
	/**
	 * Calling the next frame
	 */	
	protected void btnNext_Clicked() {
		if (!txtPrjName.getText().isEmpty() && !txtPrjDescription.getText().isEmpty()) {
			npw = this;
			if (PSP_PlanningWizardFrame.pwf == null) {
				new PSP_PlanningWizardFrame().setVisible(true);
			} else { 
				PSP_PlanningWizardFrame.pwf.setVisible(true);
			}
			dispose();
		} else {
			if (txtPrjName.getText().isEmpty())
				txtPrjName.requestFocus();
			else
				txtPrjDescription.requestFocus();
		}		
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
	
	/**
	 * Canceling the project creation
	 */
	protected void btnCancel_Clicked() {
		UIManager.put("OptionPane.background",Color.white);
		UIManager.put("Panel.background",Color.white);
		
		int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Confirm", JOptionPane.YES_NO_OPTION);
		
		if (confirm == JOptionPane.YES_OPTION) {
			if (PSP_PlanningWizardFrame.pwf != null) {
				PSP_PlanningWizardFrame.pwf = null;
			}
			npw = null;
			dispose();			
			App.getFrame().setEnabled(true);
		}
	}
}
