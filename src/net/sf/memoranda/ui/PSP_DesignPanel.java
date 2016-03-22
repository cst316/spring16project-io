package net.sf.memoranda.ui;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import net.sf.memoranda.util.Util;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PSP_DesignPanel extends JPanel {
	

	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @author Joe Michaels
	 * @author Team-IO
	 * CST316 - Spring 2016
	 * This class is part of the PSP options view
	 * it is used when design view button is clicked
	 * 03/01/2016
	 */
	
	JPanel backPanel = new JPanel();
	JPanel designView = new JPanel();
	JPanel listPanel = new JPanel();
	JScrollPane viewPane = new JScrollPane();
	
	JButton btnImportDesign = new JButton("Import Design");
	JList<String> fileList;
	
	private String path;
	private int pID; // no setter made for pID yet. want to minimize ways to change this value.
	private static PSP_Panel pspForm;
	
	//***	
	private JList<String> lstImages;
	private DefaultListModel<String> fileModel;
	private List<String> files = new ArrayList<String> ();
	
	public PSP_DesignPanel(PSP_Panel psp){
		
		PSP_DesignPanel.pspForm = psp;
		this.pID = pspForm.pspI.getpId();
		setPath((Integer.toString(pID)));
		
		try {
            jbInit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
	}
	
	public PSP_DesignPanel() {
		setBackground(Color.WHITE);
		
		
		try {
            jbInit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
		
    }
	
	private void jbInit() throws Exception 
	{
		try{
			fileList = new JList<String>(getFileList());
		}catch (Exception e){
			e.getMessage();
		}
		backPanel.setMinimumSize(new Dimension(0, 0));
		backPanel.setBackground(Color.WHITE);
		listPanel.setMaximumSize(new Dimension(350, 0));
		listPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
		listPanel.setPreferredSize(new Dimension(350, 0));
		listPanel.setMinimumSize(new Dimension(350, 0));
		listPanel.setBackground(Color.WHITE);
		
		fileModel = new DefaultListModel<String>();
		lstImages = new JList<String>(fileModel);
		lstImages.setBackground(Color.WHITE);
		lstImages.setFixedCellWidth(256);
		//***	
		lstImages.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				int index = lstImages.getSelectedIndex();
				Util.debug("The Value: " + lstImages.getSelectedValue());
				setImage (files.get(index));	
			}
		});
		lstImages.setFixedCellHeight(25);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(Color.WHITE);
		viewPane.setBorder(null);
		
		viewPane.setBackground(Color.WHITE);
		viewPane.setLayout(null);
		btnImportDesign.setMinimumSize(new Dimension(150, 25));
		btnImportDesign.setMaximumSize(new Dimension(150, 25));
		btnImportDesign.setPreferredSize(new Dimension(150, 25));
		
		btnImportDesign.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	Util.debug("import click.");
	            //btnImportDesign_actionPerformed(e);
	        	btnImport_Clicked();
	        }
	    });
		setLayout(new BorderLayout(0, 0));
		GroupLayout gl_listPanel = new GroupLayout(listPanel);
		gl_listPanel.setHorizontalGroup(
			gl_listPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_listPanel.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(lstImages, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_listPanel.createSequentialGroup()
					.addGap(100)
					.addComponent(btnImportDesign, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(100, Short.MAX_VALUE))
		);
		gl_listPanel.setVerticalGroup(
			gl_listPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_listPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lstImages, GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
					.addGap(27)
					.addComponent(btnImportDesign, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		listPanel.setLayout(gl_listPanel);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(viewPane, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(viewPane, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		add(backPanel, BorderLayout.CENTER);
		backPanel.setLayout(new BorderLayout(0, 0));
		backPanel.add(listPanel, BorderLayout.WEST);
		backPanel.add(panel);
		
		/*//gets file list and displays selected file
		if (fileList != null){
			listPanel.removeAll();
			listPanel.add(fileList);
			fileList.addMouseListener(new MouseAdapter(){
		          @Override
		          public void mouseClicked(MouseEvent e) {
		        	  mouseEvent(e);
		          }
		    });
		}else{
			Util.debug("file list is empty");
		}*/
	}
	
	//***	
	private void btnImport_Clicked () {
		Util.debug("Entered");
		BufferedImage image = null;
		try {
			JFileChooser fileChooser = new JFileChooser(new File(System.getProperty
					("user.home") + File.separator + "Pictures"));
			File selectedFile = null;			
			int result = fileChooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) 
			{
				selectedFile = fileChooser.getSelectedFile();
				image = ImageIO.read(selectedFile);
				Util.debug("Selected file: " + selectedFile.getName());
				
				//pathways need to be updated to be relative.
				if(!Files.exists(Paths.get(getPath())))
				{
					File file = new File(getPath());
					file.mkdirs();
				}
				
				Util.debug("Up until now");
			
				if (selectedFile.getName().contains(".png"))
				{
					ImageIO.write(image, "png", new File(getPath() + File.separator + selectedFile.getName()));
				}
				else if (selectedFile.getName().contains(".jpg"))
				{
					ImageIO.write(image, "jpg", new File(getPath() + File.separator + selectedFile.getName()));
				}else if (selectedFile.getName().contains(".img"))
				{
					ImageIO.write(image, "img", new File(getPath() + File.separator + selectedFile.getName()));
				} else if (selectedFile.getName().contains(".tif"))
				{
					ImageIO.write(image, "tif", new File(getPath() + File.separator + selectedFile.getName()));
				}
				//fileList = new JList<String>(getFileList());
			}
			
			//if(fileList.getModel().getSize() != 0){				
				fileModel.addElement(selectedFile.getName().toString());
				files.add(getPath() + File.separator + selectedFile.getName());
				Util.debug("Made it here just fine");
			//}
			
		} catch (Exception ex) {
			throw new RuntimeException("Error saving image, Check image type");
		}
	}
	
	
	/*public void btnImportDesign_actionPerformed(ActionEvent e)
	{//import file  and save in memoranda directory
		BufferedImage image = null; 
		try
		{
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			
			int result = fileChooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) 
			{
				File selectedFile = fileChooser.getSelectedFile();
				image = ImageIO.read(selectedFile);
				System.out.println("Selected file: " + selectedFile.getName());
				
				//pathways need to be updated to be relative.
				if(!Files.exists(Paths.get(getPath())))
				{
					File file = new File(getPath());
					file.mkdirs();
				}
			
				if (selectedFile.getName().contains(".png"))
				{
					ImageIO.write(image, "png", new File(getPath() + File.separator + selectedFile.getName()));
				}
				else if (selectedFile.getName().contains(".jpg"))
				{
					ImageIO.write(image, "jpg", new File(getPath() + File.separator + selectedFile.getName()));
				}else if (selectedFile.getName().contains(".img"))
				{
					ImageIO.write(image, "img", new File(getPath() + File.separator + selectedFile.getName()));
				} else if (selectedFile.getName().contains(".tif"))
				{
					ImageIO.write(image, "tif", new File(getPath() + File.separator + selectedFile.getName()));
				}
				fileList = new JList<String>(getFileList());
			}
			if(fileList.getModel().getSize() != 0){
				
				listPanel.removeAll();
				listPanel.add(fileList);
				
				listPanel.invalidate();
				listPanel.validate();
				listPanel.repaint();
				
				Util.debug("ml.length = " + fileList.getMouseListeners().length);
				if(fileList.getMouseListeners().length == 0){
					Util.debug("ML is not null");
					fileList.addMouseListener(new MouseAdapter(){
				          @Override
				          public void mouseClicked(MouseEvent e) {
				        	  mouseEvent(e);
				          }
				    });
				}
			}
		}
		catch(Exception ex)
		{
			throw new RuntimeException("Error saving image, Check image type");
		}

	}*/
	
	/*
	 * @return imports file names from folder, returns as string array
	 * Note: update path once tacked down. Should I also buffer the images in the file as well?
	 */
	public DefaultListModel<String> getFileList()
	{
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		//need to narrow its search to display only picture files types like png, jpg, img etc...
		File data = new File(getPath());
		File[] files = data.listFiles();
		for(int i = 0; i < files.length; ++i)
		{
			listModel.addElement(files[i].getName());
		}
		
		return listModel;
	}
	
	public boolean setPath(String pId){
		this.path = System.getProperty("user.home") + File.separator + 
		".memoranda" + File.separator + ".proj" + File.separator + 
		 "." + pID +  File.separator + ".images" + File.separator 
			+ ".design";
		return true;
	}
	public String getPath(){
		return this.path;
	}
	
	public int getPID(){
		return this.pID;
	}
	
	//***	
	public void setImage (String img) {
		BackGround bg;
		try {
			viewPane.removeAll();
			Util.debug("Image: " + img);
			bg = new BackGround (img, 300, 500);
			bg.setPreferredSize(new Dimension(300, 500));
			bg.setMinimumSize(new Dimension(200, 600));
			bg.setMaximumSize(new Dimension(32767, 32767));
			bg.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			bg.setBackground(Color.white);
			bg.setVisible(true);
			
			bg.setLocation((viewPane.getWidth() - bg.getWidth())/2, ((viewPane.getHeight() - bg.getHeight())/2));
			viewPane.add(bg);
			Util.debug("Viewing");
			
			viewPane.revalidate();
			viewPane.repaint();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean mouseEvent(MouseEvent e){
		String fileName = (String) fileList.getSelectedValue();
        Util.debug("focus gained");
		Util.debug("image: " + getPath() + File.separator + fileName);
		try{
			ImageIcon icon = new ImageIcon(getPath() + File.separator 
					+ fileName);
			JLabel imgLabel = new JLabel("", icon, JLabel.CENTER);
			imgLabel.setIcon(icon);
			imgLabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
			viewPane.scrollRectToVisible(getBounds());
			viewPane.add(imgLabel);
		}catch(RuntimeException ex){
			Util.debug(ex.getMessage());
		}catch(Exception ex){
			Util.debug(ex.getMessage());
		}
		Util.debug("background added to panel... revalidating");
		viewPane.invalidate();
		viewPane.validate();
		viewPane.repaint();
		Util.debug("revalidating done");
		fileList.clearSelection();
		return true;
	}
}