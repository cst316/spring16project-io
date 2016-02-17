package net.sf.memoranda.util;

import java.io.File;
import java.io.FileFilter;

import javax.swing.JFileChooser;


public class ImportPictureFile {
	
	private File fileName;
	
	public static void importFile(String fileName)
	{
		//Had to look up the exact syntax to make filefilter object work properly
		FileFilter ff = new FileFilter() {
            public boolean accept(File file) {
               if (file.getName().endsWith(".png") || file.getName().endsWith(".jpg")) {
                  return true;
               }
               return false;
            }
         };
         
		JFileChooser fc = new JFileChooser();
		fc.setMultiSelectionEnabled(true);
//		fc.setFileFilter();
//		 fileName = fc.getTitle();
//		 if (selectedFile != null) {
//		    mainStage.display(selectedFile);
//		 }
	}
}
