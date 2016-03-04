package net.sf.memoranda.ui;

import java.awt.BorderLayout;
<<<<<<< HEAD
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
=======

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
>>>>>>> us-45
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
<<<<<<< HEAD
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;

public class PSP_DesignPanel extends JPanel implements FocusListener {
=======

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.sf.memoranda.util.Util;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;

public class PSP_DesignPanel extends JPanel{
	

	private static final long serialVersionUID = 1L;
>>>>>>> us-45
	
	/**
	 * 
	 * @author Joe Michaels
	 * @author Team-IO
	 * CST316 - Spring 2016
	 * This class is part of the PSP options view
	 * it is used when design view button is clicked
	 * 03/01/2016
	 */
	
<<<<<<< HEAD
	private static final long serialVersionUID = -4697829421699112193L;
	BorderLayout borderLayout1 = new BorderLayout();
	DailyItemsPanel parentPanel = null;
	
	JPanel backPanel = new JPanel();
	JPanel designView = new JPanel();
	JPanel listPanel = new JPanel();
	JPanel viewPanel = new JPanel();
=======
	JPanel backPanel = new JPanel();
	JPanel designView = new JPanel();
	JPanel listPanel = new JPanel();
	JScrollPane viewPane = new JScrollPane();
>>>>>>> us-45
	
	JButton btnImportDesign = new JButton("Import Design");
	JList<String> fileList;
	
<<<<<<< HEAD
	
	/*
	 * note: need to know current project name and/or pID, 
	 * may need to write xml importer for such info if I can't pull from super.
	 */
	
	//not sure how to get these right now, probably don't need the pid
	private int pID;
	private String projectName;
	
	public PSP_DesignPanel() {
		setLayout(null);
		//this.projectName = projectName;
		try {
            //parentPanel = _parentPanel;
            //pID = parentPanel;
=======
	private String path;
	private int pID; // no setter made for pID yet. want to minimize ways to change this value.
	private static PSP_Panel pspForm;

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
		
		
		try {
>>>>>>> us-45
            jbInit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
		
    }
	private void jbInit() throws Exception 
	{
<<<<<<< HEAD
		System.out.println("jbinit");
		//init gui and needed filesystem
		checkFolderSystem();
		fileList = new JList<String>(getFileList());
		
		fileList.addFocusListener(this);
		
		backPanel.setBounds(0, 0, 91, 44);
		add(backPanel);
		backPanel.setLayout(null);
		
		btnImportDesign.setBounds(0, 11, 89, 23);
		backPanel.add(btnImportDesign);
		
		
		listPanel.setBounds(0, 55, 91, 234);
		add(listPanel);
		
		listPanel.add(fileList);
		
		viewPanel.setBounds(101, 0, 339, 289);
		add(viewPanel);
        
		btnImportDesign.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(ActionEvent e) {
=======
		try{
			fileList = new JList<String>(getFileList());
		}catch (Exception e){
			e.getMessage();
		}
		
		setLayout(null);
		backPanel.setBounds(0, 0, 139, 44);
		add(backPanel);
		backPanel.setLayout(null);
		
		btnImportDesign.setBounds(10, 11, 119, 23);
		backPanel.add(btnImportDesign);
		
		
		listPanel.setBounds(0, 55, 139, 650);
		add(listPanel);
		
		//gets file list and displays selected file
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
		}
		
		viewPane.setBounds(149, 0, 765, 705);
		add(viewPane);
		viewPane.setLayout(null);
		
        
		btnImportDesign.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	Util.debug("import click.");
>>>>>>> us-45
	            btnImportDesign_actionPerformed(e);
	        }
	    });
	}
	
	
	
<<<<<<< HEAD
	public void btnImportDesign_actionPerformed(ActionEvent e){
		importGraphic();
	}
	
	public void importGraphic(){
		//import file  and save in memoranda directory
=======
	public void btnImportDesign_actionPerformed(ActionEvent e)
	{//import file  and save in memoranda directory
>>>>>>> us-45
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
<<<<<<< HEAD
			
				if (selectedFile.getName().contains(".png"))
				{
					ImageIO.write(image, "png", new File("projects" + 
							File.separator +"projectName" + File.separator + "images" +
							File.separator + "design"));
				}
				else if (selectedFile.getName().contains(".jpg"))
				{
					ImageIO.write(image, "jpg", new File("projects" + 
							File.separator + "projectName" + File.separator + "images" + 
							File.separator + "design"));
				}
			}
				
=======
				
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
>>>>>>> us-45
		}
		catch(Exception ex)
		{
			throw new RuntimeException("Error saving image, Check image type");
		}
<<<<<<< HEAD
		//reinitialize filelist after import is run
		fileList = new JList<String>(getFileList());
		listPanel.invalidate();
		listPanel.validate();
		listPanel.repaint();
=======

>>>>>>> us-45
	}
	
	/*
	 * @return imports file names from folder, returns as string array
	 * Note: update path once tacked down. Should I also buffer the images in the file as well?
	 */
	public DefaultListModel<String> getFileList()
	{
		DefaultListModel<String> listModel = new DefaultListModel<String>();
<<<<<<< HEAD
		String path = "projects" + File.separator + projectName + 
				File.separator + "images" + File.separator + "design";
		
		File data = new File(path);
		File[] files = data.listFiles();
		for(int i = 0; i < files.length; ++i)
		{
			listModel.addElement(files[i].toString());
=======
		//need to narrow its search to display only picture files types like png, jpg, img etc...
		File data = new File(getPath());
		File[] files = data.listFiles();
		for(int i = 0; i < files.length; ++i)
		{
			listModel.addElement(files[i].getName());
>>>>>>> us-45
		}
		
		return listModel;
	}
<<<<<<< HEAD
	@Override
	public void focusGained(FocusEvent event) {
		//display picture in main panel
		
		try{
			viewPanel.add(new BackGround(event.getSource().toString(), 
					viewPanel.getWidth(), viewPanel.getHeight()));	
		}catch(RuntimeException ex){
			ex.getMessage();
		}catch(Exception e){
			e.getMessage();
		}
		viewPanel.invalidate();
		viewPanel.validate();
		viewPanel.repaint();
		
	}
	@Override
	public void focusLost(FocusEvent event) {
		// TODO Auto-generated method stub
		
	}
	public boolean checkFolderSystem(){
		boolean success= true;
		try{
			if(!Files.exists(Paths.get("projects" + File.separator + 
					projectName +  File.separator + "images" + File.separator + "design")))
			{
				File file = new File("projects" + File.separator + 
						"projectName" + File.separator + "images"  + File.separator + "design");
				file.mkdirs();
			}
		}catch(RuntimeException e){
			e.getMessage();
			success = false;
		}catch(Exception e){
			e.getMessage();
			success = false;
		}
		return success;
	}
}
=======
	
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

>>>>>>> us-45
