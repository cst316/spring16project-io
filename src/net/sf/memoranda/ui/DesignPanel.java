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

public class DesignPanel extends JPanel implements FocusListener{
	
	BorderLayout borderLayout1 = new BorderLayout();
	DailyItemsPanel parentPanel = null;
	
	JPanel backPanel = new JPanel();
	JPanel designView = new JPanel();
	JPanel panel_1 = new JPanel();
	JPanel viewPanel = new JPanel();
	
	JButton btnImportDesign = new JButton("Import Design");
	JList<String> fileList = new JList<String>(getFileList());
	
	
	/*
	 * note: need to know current project name and/or pID, 
	 * may need to write xml importer for such info if I can't pull from super.
	 */
	
	//not sure how to get these right now
	private int pID;
	private String projectName;
	
	public DesignPanel(DailyItemsPanel _parentPanel) {
		setLayout(null);
		
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
		fileList.addFocusListener(this);
		
		backPanel.setBounds(0, 0, 91, 44);
		add(backPanel);
		backPanel.setLayout(null);
		
		btnImportDesign.setBounds(0, 11, 89, 23);
		backPanel.add(btnImportDesign);
		
		
		panel_1.setBounds(0, 55, 91, 234);
		add(panel_1);
		
		panel_1.add(fileList);
		
		
		viewPanel.setBounds(101, 0, 339, 289);
		add(viewPanel);
        
		btnImportDesign.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            btnImportDesign_actionPerformed(e);
	        }
	    });
	}
	
	
	
	public void btnImportDesign_actionPerformed(ActionEvent e)
	{
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
				
				//pathways need to be updated to be relative. left here for testing purposes
				if(!Files.exists(Paths.get("projects\\"+projectName+"\\images\\design")))
				{
					File file = new File("projects\\"+projectName+"\\images\\design");
					file.mkdirs();
				}
			
				if (selectedFile.getName().contains(".png"))
				{
					ImageIO.write(image, "png", new File("projects\\"+projectName+"\\images\\design"));
				}
				else if (selectedFile.getName().contains(".jpg"))
				{
					ImageIO.write(image, "jpg", new File("projects\\"+projectName+"\\images\\design"));
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
		String path = "projects\\"+projectName+"\\images\\design";
		
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
			viewPanel.add(new BackGround(event.getSource().toString(), viewPanel.getWidth(), viewPanel.getHeight()));	
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
}
