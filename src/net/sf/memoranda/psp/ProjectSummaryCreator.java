package net.sf.memoranda.psp;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
/**
 * 
 * @author Julie
 * This class is used to create a project summary 
 * in PDF format for the Postmortem phase of PSP.
 * Tutorial used for reference can be found at:
 * http://www.vogella.com/tutorials/JavaPDF/article.html#createpdf
 *
 */
public class ProjectSummaryCreator {
	
	  public static void main(String[] args) {
		    try {
		      Document document = new Document();
		      PdfWriter.getInstance(document, new FileOutputStream(FILE));
		      document.open();
		      //
		      document.close();
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		  }
}
