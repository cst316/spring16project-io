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
	
	private static String FILE = "c:/temp/PSPProjectSummary.pdf";
	private static Font headingFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
		      Font.BOLD);
	private static Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
		      Font.NORMAL);
	  
	  
	/**
	 * 
	 * @param author the name of the author if the PSP Summary Form
	 * @param programName the name of the program being summarized
	 * @param date the date that the summary is being created
	 * 
	 * Creates a PSP Summary Form with all specified data
	 * 
	 */
	public static void createFileSummary(String author, String programName, String date, int [] estimatedTime, int [] actualTime){
		try {
			Document document = new Document();
		    PdfWriter.getInstance(document, new FileOutputStream(FILE));
		    document.open();
		    //do stuff to document
		    addPDFTitle(document, author, programName, date);
		    
		    createTimeTable(estimatedTime, actualTime);
		    document.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param document the document that was created in createFileSummary
	 * @param author the name of the author if the PSP Summary Form
	 * @param programName the name of the program being summarized
	 * @param date the date that the summary is being created
	 * 
	 * Adds the title section of the PSP Summary Form
	 * 
	 */
	private static void addPDFTitle(Document document, String author, String programName, String date){
		 Paragraph title = new Paragraph();
		 addEmptyLine(title, 1);
		 title.setAlignment(Element.ALIGN_CENTER);
		 title.add(new Paragraph("PSP Summary Form", headingFont));
		 
		 document.addAuthor(author);
		 
		 addEmptyLine(title, 2);
		 
		 Paragraph introSection = new Paragraph();
		 introSection.add(new Paragraph("Name: " + author, normalFont));
		 introSection.add(new Paragraph("Program Name: " + programName, normalFont));
		 introSection.add(new Paragraph("Date: " + date, normalFont));

	}
	
	/**
	 * 
	 * @param estimatedTime the estimated times that it would take for a task
	 * @param actualTime the actual time that it took for a task
	 * 
	 * Creates the table with Estimated Time, Actual Time, To Date, and
	 * % To Date
	 * 
	 */
	private static void createTimeTable(int [] estimatedTime, int [] actualTime){
		
		Paragraph table1 = new Paragraph();
		
		PdfPTable timeTable = new PdfPTable(3);
		
	    PdfPCell tableHeading = new PdfPCell(new Phrase("Time in Phase\n(Minutes)", headingFont));
	    tableHeading.setHorizontalAlignment(Element.ALIGN_CENTER);
	    timeTable.addCell(tableHeading);
	    
	    tableHeading = new PdfPCell(new Phrase("Estimated", headingFont));
	    tableHeading.setHorizontalAlignment(Element.ALIGN_CENTER);
	    timeTable.addCell(tableHeading);
	    
	    tableHeading = new PdfPCell(new Phrase("Actual", headingFont));
	    tableHeading.setHorizontalAlignment(Element.ALIGN_CENTER);
	    timeTable.addCell(tableHeading);
	    
	    tableHeading = new PdfPCell(new Phrase("To Date", headingFont));
	    tableHeading.setHorizontalAlignment(Element.ALIGN_CENTER);
	    timeTable.addCell(tableHeading);
	    
	    tableHeading = new PdfPCell(new Phrase("% To Date", headingFont));
	    tableHeading.setHorizontalAlignment(Element.ALIGN_CENTER);
	    timeTable.addCell(tableHeading);
	    timeTable.setHeaderRows(1);
	    
	    for(int i = 0; i < 8; ++i){
	    	switch(i){	    	
	    	case 0:
	    		timeTable.addCell("Planning");
	    		break;
	    	case 1:
	    		timeTable.addCell("Design");
	    		break;
	    	case 2:
	    		timeTable.addCell("Code");
	    		break;
	    	case 3:
	    		timeTable.addCell("Code Review");
	    		break;
	    	case 4:
	    		timeTable.addCell("Compile");
	    		break;
	    	case 5:
	    		timeTable.addCell("Test");
	    		break;
	    	case 6:
	    		timeTable.addCell("Postmortem");
	    		break;
	    	case 7:
	    		timeTable.addCell("TOTAL");
	    		break;
	    	}
	    	timeTable.addCell(String.valueOf(estimatedTime[i]));
	    	timeTable.addCell(String.valueOf(actualTime[i]));
	    	
	    	
	    	for(int totalSoFar = i; totalSoFar >= 0; --totalSoFar){
	    		//sum up the actual time
	    	}
	    	
	    	
	    }
	    
	    table1.add(timeTable);
		
	}
	
	/**
	 * 
	 * @param paragraphName name of paragraph being targeted
	 * @param numLines the number of blank lines to be added
	 * 
	 * Adds the specified number of blank lines to the specified paragraph
	 * 
	 */
	private static void addEmptyLine(Paragraph paragraphName, int numLines) {
		for (int i = 0; i < numLines; i++) {
			paragraphName.add(new Paragraph(" "));
		}
	}
}
