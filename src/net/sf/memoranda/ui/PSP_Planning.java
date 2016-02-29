package net.sf.memoranda.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.Dimension;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import net.sf.memoranda.psp.Planning;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class PSP_Planning extends JPanel implements ListSelectionListener {
	private JLabel lblImages;
	private JPanel pnlCurrMod;
	private JList lstImages;
	private JButton btnAddImage;
	private JButton btnAddMod;
	
	private static Planning planning;
	
	private String newFile = "";
	
	/**
	 * Create the panel.
	 */
	public PSP_Planning() {
		jInit();
	}
	
	public PSP_Planning (Planning planning) {
		PSP_Plannnig (planning);
		jInit();
	}
	
	
	public static void PSP_Plannnig (Planning pl) {
		planning = pl;
	}
	
	private void jInit () {
		
		JPanel panel = new JPanel();
		
		JSplitPane panImages = new JSplitPane();
		panImages.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panImages, GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addComponent(panImages, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
				.addComponent(panel, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 313, Short.MAX_VALUE)
		);
		
		JLabel label = new JLabel("MODULE ESTIMATES");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		btnAddMod = new JButton("Add Module");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMinimumSize(new Dimension(200, 300));
		scrollPane.setBorder(null);
		scrollPane.setPreferredSize(new Dimension(200, 250));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
						.addComponent(btnAddMod, GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 165, Short.MAX_VALUE)
					.addGap(105)
					.addComponent(btnAddMod)
					.addGap(22))
		);
		
		pnlCurrMod = new JPanel();
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
		
		JLabel label_2 = new JLabel("");
		label_2.setPreferredSize(new Dimension(50, 25));
		label_2.setMinimumSize(new Dimension(50, 25));
		label_2.setMaximumSize(new Dimension(50, 25));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label_2.setBounds(135, 0, 50, 25);
		pnlCurrMod.add(label_2);
		
		JLabel label_3 = new JLabel("Estimated Size:");
		label_3.setPreferredSize(new Dimension(130, 25));
		label_3.setMinimumSize(new Dimension(130, 25));
		label_3.setMaximumSize(new Dimension(130, 25));
		label_3.setBounds(0, 45, 130, 25);
		pnlCurrMod.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setPreferredSize(new Dimension(50, 25));
		label_4.setMinimumSize(new Dimension(50, 25));
		label_4.setMaximumSize(new Dimension(50, 25));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label_4.setBounds(135, 45, 50, 25);
		pnlCurrMod.add(label_4);
		
		JLabel label_5 = new JLabel("Estimated Defect:");
		label_5.setPreferredSize(new Dimension(130, 25));
		label_5.setMinimumSize(new Dimension(130, 25));
		label_5.setMaximumSize(new Dimension(130, 25));
		label_5.setBounds(0, 90, 130, 25);
		pnlCurrMod.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.setPreferredSize(new Dimension(50, 25));
		label_6.setMinimumSize(new Dimension(50, 25));
		label_6.setMaximumSize(new Dimension(50, 25));
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label_6.setBounds(135, 90, 50, 25);
		pnlCurrMod.add(label_6);
		
		JLabel label_7 = new JLabel("Estimated LoC/Hr:");
		label_7.setPreferredSize(new Dimension(130, 25));
		label_7.setMinimumSize(new Dimension(130, 25));
		label_7.setMaximumSize(new Dimension(130, 25));
		label_7.setBounds(0, 135, 130, 25);
		pnlCurrMod.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setPreferredSize(new Dimension(50, 25));
		label_8.setMinimumSize(new Dimension(50, 25));
		label_8.setMaximumSize(new Dimension(50, 25));
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		label_8.setBounds(135, 135, 50, 25);
		pnlCurrMod.add(label_8);
		panel.setLayout(gl_panel);
		
		lblImages = new JLabel("");
		panImages.setRightComponent(lblImages);
		
		JPanel panel_1 = new JPanel();
		panImages.setLeftComponent(panel_1);
		
		JLabel lblImageFiles = new JLabel("IMAGE FILES");
		lblImageFiles.setHorizontalAlignment(SwingConstants.CENTER);
		
		lstImages = new JList();
		
		btnAddImage = new JButton("Add Image");
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
	
	public void setFileNames (ArrayList <String> files) {
		lstImages.removeAll();
		
		lstImages = new JList (files.toArray());
		lstImages.addListSelectionListener(this);
	}
	

	public void setFile (String file) {
		newFile = file;
		lstImages.setSelectedValue(newFile,true);
	}
	
	public void setImages (String iconPath) {
		lblImages.setIcon(new ImageIcon(iconPath));		
	}
	
	public void setModules () {
		
	}
	
	public void getFileNames (ArrayList <String> files) {
		
	}
	
	public void getImages () {
		
	}
	
	public void getModules () {
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		int index = lstImages.getSelectedIndex();
		setImages (planning.getFilenames().get(index));		
	}
}
