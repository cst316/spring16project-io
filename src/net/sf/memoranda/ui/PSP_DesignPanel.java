package net.sf.memoranda.ui;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

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
	            btnImportDesign_actionPerformed(e);
	        }
	    });
	}
	
	
	
	public void btnImportDesign_actionPerformed(ActionEvent e)
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

	}
	
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

