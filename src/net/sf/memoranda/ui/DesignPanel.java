package net.sf.memoranda.ui;

import java.awt.BorderLayout;
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
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;

public class DesignPanel extends JPanel implements FocusListener{
	BorderLayout borderLayout1 = new BorderLayout();
	DailyItemsPanel parentPanel = null;
	
	JPanel backPanel = new JPanel();
	JPanel designView = new JPanel();
	JPanel panel_1 = new JPanel();
	
	JButton btnImportDesign = new JButton("Import Design");
	JList<String> fileList = new JList<String>(getFileList());
	
	
	/*
	 * note: need to know current project name and/or pID, 
	 * may need to write xml importer for such info if I can't pull from super.
	 */
	
	int pID;
	String projectName;
	
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
				if(!Files.exists(Paths.get("C:\\Users\\Joe\\Documents\\memorandaFiles")))
				{
					File file = new File("C:\\Users\\Joe\\Documents\\memorandaFiles");
					file.mkdirs();
				}
			
				if (selectedFile.getName().contains(".png"))
				{
					ImageIO.write(image, "png", new File("C:\\Users\\Joe\\Documents\\memorandaFiles\\out.png"));
				}
				else if (selectedFile.getName().contains(".jpg"))
				{
					ImageIO.write(image, "jpg", new File("C:\\Users\\Joe\\Documents\\memorandaFiles\\out.jpg"));
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
	 * Note: update path once tacked down.
	 */
	public String[] getFileList()
	{
		ArrayList<String> fileArrList = new ArrayList<String>();
		String path = "C:\\Users\\Joe\\Documents\\memorandaFiles";
		
		File data = new File(path);
		File[] files = data.listFiles();
		for(int i = 0; i < files.length; ++i)
		{
			fileArrList.add(files[i].toString());
		}
		
		return (String[]) fileArrList.toArray();
	}
	@Override
	public void focusGained(FocusEvent arg0) {
		//display picture in main panel
		
	}
	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
