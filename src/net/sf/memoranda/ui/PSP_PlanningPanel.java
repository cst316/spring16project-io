package net.sf.memoranda.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Dimension;

import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.sf.memoranda.psp.Planning;
import net.sf.memoranda.util.Util;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Component;

public class PSP_PlanningPanel extends JPanel implements ListSelectionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9206832951836984647L;
	private JPanel pnlCurrMod;
	private JList<String> lstImages;
	private DefaultListModel<String> listModel;
	private JButton btnAddImage;
	private JButton btnAddMod;
	
	private Planning plan;
	private JLabel lblEstLocHr;
	private JLabel lblEstDefect;
	private JLabel lblEstTime;
	private JLabel lblEstSize;
	private JTextField txtNewEst;
	private JTextField txtNewSize;
	
	private int modX;
	private int modY;
	private int modWidth;
	private int modHeight = 25;	
	
	private static BackGround bg;
	private JPanel panel_2;
	private JPanel pnlModules;
		
	/**
	 * Create the panel.
	 */
	public PSP_PlanningPanel() {
		jInit();
	}
	
	public PSP_PlanningPanel (Planning plan) {
		this.plan = plan;
		jInit();
	}	
	
	private void jInit () {	
		setBackground(Color.WHITE);
		
		modY = 180;
		pnlModules = new JPanel();
		pnlModules.setBackground(Color.WHITE);
		JSplitPane panImages = new JSplitPane();
		panImages.setAlignmentY(Component.CENTER_ALIGNMENT);
		panImages.setAlignmentX(Component.CENTER_ALIGNMENT);
		panImages.setMaximumSize(new Dimension(32767, 32767));
		panImages.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(pnlModules, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panImages, GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
					.addGap(0))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panImages, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
						.addComponent(pnlModules, GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE))
					.addGap(12))
		);
		setLayout(groupLayout);
		
		JLabel label = new JLabel("MODULE ESTIMATES");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnAddMod = new JButton("Add Module");
		btnAddMod.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addAdditionalEst ();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMaximumSize(new Dimension(200, 350));
		scrollPane.setMinimumSize(new Dimension(200, 250));
		scrollPane.setBorder(null);
		scrollPane.setPreferredSize(new Dimension(200, 350));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_pnlModules = new GroupLayout(pnlModules);
		gl_pnlModules.setHorizontalGroup(
			gl_pnlModules.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlModules.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlModules.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
						.addComponent(label, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
						.addComponent(btnAddMod, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_pnlModules.setVerticalGroup(
			gl_pnlModules.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlModules.createSequentialGroup()
					.addGap(10)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnAddMod)
					.addGap(22))
		);
		
		pnlCurrMod = new JPanel();
		pnlCurrMod.setAlignmentX(Component.LEFT_ALIGNMENT);
		pnlCurrMod.setBackground(Color.WHITE);
		pnlCurrMod.setMaximumSize(new Dimension(200, 350));
		pnlCurrMod.setBorder(null);
		pnlCurrMod.setPreferredSize(new Dimension(200, 350));
		scrollPane.setViewportView(pnlCurrMod);
		pnlCurrMod.setLayout(null);
		
		JLabel label_1 = new JLabel("Estimated Time:");
		label_1.setPreferredSize(new Dimension(130, 25));
		label_1.setMinimumSize(new Dimension(130, 25));
		label_1.setMaximumSize(new Dimension(130, 25));
		label_1.setBounds(0, 0, 130, 25);
		pnlCurrMod.add(label_1);
		
		lblEstTime = new JLabel(plan.getEstTime() + "");
		lblEstTime.setPreferredSize(new Dimension(80, 25));
		lblEstTime.setMinimumSize(new Dimension(50, 25));
		lblEstTime.setMaximumSize(new Dimension(80, 25));
		lblEstTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstTime.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblEstTime.setBounds(135, 0, 80, 25);
		pnlCurrMod.add(lblEstTime);
		
		JLabel label_3 = new JLabel("Estimated Size:");
		label_3.setPreferredSize(new Dimension(130, 25));
		label_3.setMinimumSize(new Dimension(130, 25));
		label_3.setMaximumSize(new Dimension(130, 25));
		label_3.setBounds(0, 45, 130, 25);
		pnlCurrMod.add(label_3);
		
		lblEstSize = new JLabel(plan.getEstSize() + "");
		lblEstSize.setPreferredSize(new Dimension(80, 25));
		lblEstSize.setMinimumSize(new Dimension(50, 25));
		lblEstSize.setMaximumSize(new Dimension(80, 25));
		lblEstSize.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstSize.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblEstSize.setBounds(135, 45, 80, 25);
		pnlCurrMod.add(lblEstSize);
		
		JLabel label_5 = new JLabel("Estimated Defect:");
		label_5.setPreferredSize(new Dimension(130, 25));
		label_5.setMinimumSize(new Dimension(130, 25));
		label_5.setMaximumSize(new Dimension(130, 25));
		label_5.setBounds(0, 90, 130, 25);
		pnlCurrMod.add(label_5);
		
		lblEstDefect = new JLabel(plan.getEstDefect() + "");
		lblEstDefect.setPreferredSize(new Dimension(80, 25));
		lblEstDefect.setMinimumSize(new Dimension(50, 25));
		lblEstDefect.setMaximumSize(new Dimension(80, 25));
		lblEstDefect.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstDefect.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblEstDefect.setBounds(135, 90, 80, 25);
		pnlCurrMod.add(lblEstDefect);
		
		JLabel label_7 = new JLabel("Estimated LoC/Hr:");
		label_7.setPreferredSize(new Dimension(130, 25));
		label_7.setMinimumSize(new Dimension(130, 25));
		label_7.setMaximumSize(new Dimension(130, 25));
		label_7.setBounds(0, 135, 130, 25);
		pnlCurrMod.add(label_7);
		
		lblEstLocHr = new JLabel(plan.getLocHr() + "");
		lblEstLocHr.setPreferredSize(new Dimension(80, 25));
		lblEstLocHr.setMinimumSize(new Dimension(50, 25));
		lblEstLocHr.setMaximumSize(new Dimension(80, 25));
		lblEstLocHr.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstLocHr.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		lblEstLocHr.setBounds(135, 135, 80, 25);
		pnlCurrMod.add(lblEstLocHr);
		pnlModules.setLayout(gl_pnlModules);
		
		addModules();
		
		JPanel panel_1 = new JPanel();
		panel_1.setMinimumSize(new Dimension(250, 10));
		panel_1.setPreferredSize(new Dimension(250, 10));
		panel_1.setMaximumSize(new Dimension(250, 0));
		panel_1.setAlignmentX(Component.LEFT_ALIGNMENT);
		panel_1.setBackground(Color.WHITE);
		panImages.setLeftComponent(panel_1);
		
		JLabel lblImageFiles = new JLabel("IMAGE FILES");
		lblImageFiles.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblImageFiles.setHorizontalAlignment(SwingConstants.CENTER);
		
		listModel = new DefaultListModel<String>();
		lstImages = new JList<String>(listModel);
		lstImages.setFixedCellWidth(230);
		lstImages.setFixedCellHeight(25);
		lstImages.setMaximumSize(new Dimension(230, 0));
		lstImages.setPreferredSize(new Dimension(230, 0));
		addFilenames (plan.getFilenames());
		lstImages.addListSelectionListener(this);
		
		btnAddImage = new JButton("Add Image");
		btnAddImage.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAddImage.setPreferredSize(new Dimension(110, 25));
		btnAddImage.setMinimumSize(new Dimension(110, 25));
		btnAddImage.setMaximumSize(new Dimension(110, 25));
		btnAddImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFileDialog();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lstImages, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
								.addComponent(lblImageFiles, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(70)
							.addComponent(btnAddImage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addComponent(lblImageFiles, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(lstImages, GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnAddImage, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		panel_1.setLayout(gl_panel_1);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panImages.setRightComponent(panel_2);
		panel_2.setLayout(null);
	}
	
	private void addAdditionalEst () {
		int ans = -1;
		int size = -1;
		String t1 = "", t2 = "";
		
		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		pnl.setMinimumSize(new Dimension(300, 80));
		pnl.setMaximumSize(new Dimension(300, 80));
		pnl.setPreferredSize(new Dimension(300, 80));	
		pnl.setBackground(Color.white);
		
		JLabel lblEnterEstimate = new JLabel("Enter Estimate:");
		lblEnterEstimate.setBounds(10, 10, 115, 25);
		pnl.add(lblEnterEstimate);
		
		JLabel label_2 = new JLabel("Enter Size:");
		label_2.setBounds(12, 45, 115, 25);
		pnl.add(label_2);
		
		txtNewEst = new JTextField();
		txtNewEst.setBounds(140, 10, 150, 25);
		pnl.add(txtNewEst);
		txtNewEst.setColumns(10);
		
		txtNewSize = new JTextField();
		txtNewSize.setColumns(10);
		txtNewSize.setBounds(140, 45, 150, 25);
		pnl.add(txtNewSize);
		
		UIManager.put("OptionPane.background",Color.white);
		UIManager.put("Panel.background",Color.white);
		
		do {			
			try {
				ans = JOptionPane.showConfirmDialog(null,pnl,"Add Aditional Modules",JOptionPane.OK_CANCEL_OPTION);
				t1 = txtNewEst.getText().trim();
				t2 = txtNewSize.getText().trim();							
				if (ans != JOptionPane.CANCEL_OPTION)
					size = (t2.isEmpty() ? -1 : Integer.parseInt(t2));
			} catch (NumberFormatException e) {
				//new ExceptionDialog (e, "Could not Parse Integer", "");
				txtNewSize.requestFocus();
				txtNewSize.selectAll();
			}			
		} while (size < 0 && ans != JOptionPane.CANCEL_OPTION);
			
		if (ans == JOptionPane.OK_OPTION && !(t1.isEmpty())) {
			if (plan.setAdditionalMod(txtNewEst.getText().trim(), Integer.parseInt(txtNewSize.getText().trim()))) {
				addModule (txtNewEst.getText().trim(), Integer.parseInt(txtNewSize.getText().trim()));
				Util.debug("Added: " + txtNewEst.getText() + "\t" + txtNewSize.getText());
			}			
		}	
	}	

	private void addFilenames (ArrayList <String> files) {
		listModel.clear();	
		for (int i = 0; i < files.size(); i++) {
			File f = new File (files.get(i));	
			listModel.addElement(f.getName());			
		}
	}
	
	private void addFile (String file) {
		File f = new File (file);	
		listModel.addElement(f.getName());	
	}
	
	private void setImages (String img) {
		try {
			panel_2.removeAll();
			bg = new BackGround (img, panel_2);
			bg.setPreferredSize(new Dimension(300, 500));
			bg.setMinimumSize(new Dimension(200, 600));
			bg.setMaximumSize(new Dimension(32767, 32767));
			bg.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			bg.setBackground(Color.white);
			
			panel_2.add(bg);
			bg.setLocation((panel_2.getWidth() - bg.getWidth())/2, ((panel_2.getHeight() - bg.getHeight())/2));
			
			panel_2.revalidate();
			panel_2.repaint();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void addModules () {
		HashMap <String, Integer> hm = plan.getAdditionalMod();
		for (String key : hm.keySet()) {
			addModule (key, hm.get(key));		
		}
	}
	
	private ArrayList <JLabel> buildLabel (String des, int size) {
		ArrayList <JLabel> mod = new ArrayList<JLabel>();
		
		modWidth = 130;
		modX = 0;
		
		JLabel label_1 = new JLabel(des);
		label_1.setPreferredSize(new Dimension(modWidth, modHeight));
		label_1.setBounds(modX, modY, modWidth, modHeight);
				
		modWidth = 80;
		modX = 135;
		
		JLabel newEst = new JLabel (size + "");
		newEst.setPreferredSize(new Dimension(modWidth, modHeight));
		newEst.setHorizontalAlignment(SwingConstants.CENTER);
		newEst.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		newEst.setBounds(modX, modY, modWidth, modHeight);
		
		mod.add(label_1);
		mod.add(newEst);
		
		modY += 40;
		
		return mod; 
	}
	
	public void addModule (String des, int size) {
		ArrayList <JLabel> addThis = buildLabel (des + ":", size);
		
		pnlCurrMod.add(addThis.get(0));
		pnlCurrMod.add(addThis.get(1));
		pnlCurrMod.revalidate();
		pnlCurrMod.repaint();
	}
	
	public void getFileNames () {
		
	}
	
	public void getImages () {
		
	}
	
	public void getModules () {
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int index = lstImages.getSelectedIndex();
		setImages (plan.getFilenames().get(index));		
	}
	
	/**
	 * Implementing open file dialog to help user select file location or name
	 */
	private void openFileDialog () {
		//Using user.home instead of user.dir
		JFileChooser fc =  new JFileChooser(new File(System.getProperty
				("user.home") + File.separator + "Pictures"));
		int returnVal = fc.showOpenDialog(this);
		File file;
				
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();			
			if (plan.setFilename (file.getAbsolutePath())) {
				addFile (plan.getFilename(plan.getFilenames().size() - 1));
			}
		}
	}
}
