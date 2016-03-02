package net.sf.memoranda.ui;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;

public class PSP_DesignPanel extends JPanel implements FocusListener {
	
	/**
	 * 
	 * @author Joe Michaels
	 * @author Team-IO
	 * CST316 - Spring 2016
	 * This class is part of the PSP options view
	 * it is used when design view button is clicked
	 * 03/01/2016
	 */
	
	private static final long serialVersionUID = -4697829421699112193L;
	BorderLayout borderLayout1 = new BorderLayout();
	DailyItemsPanel parentPanel = null;
	
	JPanel backPanel = new JPanel();
	JPanel designView = new JPanel();
	JPanel listPanel = new JPanel();
	JPanel viewPanel = new JPanel();
	
	JButton btnImportDesign = new JButton("Import Design");
	JList<String> fileList;
	
	
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
            jbInit();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
		
    }
	private void jbInit() throws Exception 
	{
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
	            btnImportDesign_actionPerformed(e);
	        }
	    });
	}
	
	
	
	public void btnImportDesign_actionPerformed(ActionEvent e){
		importGraphic();
	}
	
	public void importGraphic(){
		//import file  and save in memoranda directory
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
				
		}
		catch(Exception ex)
		{
			throw new RuntimeException("Error saving image, Check image type");
		}
		//reinitialize filelist after import is run
		fileList = new JList<String>(getFileList());
		listPanel.invalidate();
		listPanel.validate();
		listPanel.repaint();
	}
	
	/*
	 * @return imports file names from folder, returns as string array
	 * Note: update path once tacked down. Should I also buffer the images in the file as well?
	 */
	public DefaultListModel<String> getFileList()
	{
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		String path = "projects" + File.separator + projectName + 
				File.separator + "images" + File.separator + "design";
		
		File data = new File(path);
		File[] files = data.listFiles();
		for(int i = 0; i < files.length; ++i)
		{
			listModel.addElement(files[i].toString());
		}
		
		return listModel;
	}
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
