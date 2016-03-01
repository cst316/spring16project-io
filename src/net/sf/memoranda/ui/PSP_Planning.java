package net.sf.memoranda.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JList;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.sf.memoranda.psp.Planning;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class PSP_Planning extends JPanel implements ListSelectionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9206832951836984647L;
	
	private JLabel lblImages;
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
	
	private int modX;
	private int modY;
	private int modWidth;
	private int modHeight = 25;	
	
	/**
	 * Create the panel.
	 */
	public PSP_Planning() {
		jInit();
	}
	
	public PSP_Planning (Planning planning) {
		this.plan = planning;
		jInit();
	}	
	
	private void jInit () {	
		modY = 180;
		JPanel panel = new JPanel();
		JSplitPane panImages = new JSplitPane();
		panImages.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panImages, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panImages, Alignment.LEADING)
				.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		
		JLabel label = new JLabel("MODULE ESTIMATES");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnAddMod = new JButton("Add Module");
		btnAddMod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMaximumSize(new Dimension(200, 250));
		scrollPane.setMinimumSize(new Dimension(200, 250));
		scrollPane.setBorder(null);
		scrollPane.setPreferredSize(new Dimension(200, 250));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
						.addComponent(label, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
						.addComponent(btnAddMod, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
					.addComponent(btnAddMod)
					.addGap(22))
		);
		
		pnlCurrMod = new JPanel();
		pnlCurrMod.setMaximumSize(new Dimension(200, 250));
		pnlCurrMod.setBorder(null);
		pnlCurrMod.setPreferredSize(new Dimension(200, 250));
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
		panel.setLayout(gl_panel);
		
		addModules();
		
		lblImages = new JLabel("");
		panImages.setRightComponent(lblImages);
		
		JPanel panel_1 = new JPanel();
		panImages.setLeftComponent(panel_1);
		
		JLabel lblImageFiles = new JLabel("IMAGE FILES");
		lblImageFiles.setHorizontalAlignment(SwingConstants.CENTER);
		
		listModel = new DefaultListModel<String>();
		lstImages = new JList<String>(listModel);
		addFilenames (plan.getFilenames());
		lstImages.addListSelectionListener(this);
		
		btnAddImage = new JButton("Add Image");
		btnAddImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openFileDialog();
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(lstImages, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
						.addComponent(lblImageFiles, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
						.addComponent(btnAddImage, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblImageFiles)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lstImages, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(btnAddImage)
					.addGap(22))
		);
		panel_1.setLayout(gl_panel_1);
		setLayout(groupLayout);
	}
	
	public void addFilenames (ArrayList <String> files) {
		listModel.clear();	
		for (int i = 0; i < files.size(); i++) {
			File f = new File (files.get(i));	
			listModel.addElement(f.getName());			
		}
	}
	
	public void addFile (String file) {
		File f = new File (file);	
		listModel.addElement(f.getName());	
	}
	
	public void setImages (String iconPath) {
		lblImages.setIcon(new ImageIcon(iconPath));		
	}
	
	public void addModules () {
		HashMap <String, Integer> hm = plan.getAdditionalMod();
		for (String key : hm.keySet()) {
			addModule (key, hm.get(key));
		}
	}
	
	public ArrayList <JLabel> buildLabel (String des, int size) {
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
		ArrayList <JLabel> addThis = buildLabel (des, size);
		pnlCurrMod.add(addThis.get(0));
		pnlCurrMod.add(addThis.get(1));
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
	 * @param i - the index of the text field to place the result in
	 */
	private void openFileDialog () {
		JFileChooser fc =  new JFileChooser(new File(System.getProperty
				("user.dir") + File.separator + ".memoranda"));  
		int returnVal = fc.showOpenDialog(this);
		File file;
				
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			file = fc.getSelectedFile();			
			plan.setFilename (file.getAbsolutePath());
			addFile (plan.getFilename(plan.getFilenames().size() - 1));
		}
	}
}
