package net.sf.memoranda.ui;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.JPanel;

import net.sf.memoranda.util.Util;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;

public class PSP_DesignPanel extends JPanel implements FocusListener {
	

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
	
	BorderLayout borderLayout1 = new BorderLayout();
	DailyItemsPanel parentPanel = null;
	
	JPanel backPanel = new JPanel();
	JPanel designView = new JPanel();
	JPanel listPanel = new JPanel();
	JPanel viewPanel = new JPanel();
	
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
		
		
		listPanel.setBounds(0, 55, 139, 234);
		add(listPanel);
		
		if (fileList != null){
			listPanel.add(fileList);
			fileList.addFocusListener(this);
			listPanel.invalidate();
			listPanel.validate();
			listPanel.repaint();
		}else{
			Util.debug("file list is empty");
		}
		
		viewPanel.setBounds(149, 0, 291, 289);
		add(viewPanel);
        
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
			}
				
		}
		catch(Exception ex)
		{
			throw new RuntimeException("Error saving image, Check image type");
		}
		//reinitialize filelist after import is run
		try{
			fileList = new JList<String>(getFileList());
			fileList.addFocusListener(this);
			listPanel.invalidate();
			listPanel.validate();
			listPanel.repaint();
		}catch (Exception ex){
			ex.getMessage();
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
	@Override
	public void focusGained(FocusEvent event) {
		//display picture in main panel
		Util.debug("focus gained");
		try{
			ImageIcon icon = new ImageIcon(getPath() + File.separator + event.getSource().toString());
			JLabel imgLabel = new JLabel();
			imgLabel.setIcon(icon);
			viewPanel.add(imgLabel);
/*			viewPanel.setBackground(new BackGround(event.getSource().toString(), 
					viewPanel.getWidth(), viewPanel.getHeight()));
*/			viewPanel.setAutoscrolls(true);
		}catch(RuntimeException ex){
			Util.debug(ex.getMessage());
		}catch(Exception e){
			Util.debug(e.getMessage());
		}
		Util.debug("background added to panel... revalidating");
		viewPanel.invalidate();
		viewPanel.validate();
		viewPanel.repaint();
		Util.debug("revalidating done");
	}
	@Override
	public void focusLost(FocusEvent event) {
		// TODO Auto-generated method stub
		//do nothing
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
}

