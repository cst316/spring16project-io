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
	public static void createFileSummary(String author, String programName, String date, double[] estimatedTime, double[] actualTime,
			int[] actualDefects, double[] estimatedTotal, double[] actualTotal){
		try {
			Document document = new Document();
		    PdfWriter.getInstance(document, new FileOutputStream(FILE));
		    document.open();
		    addPDFTitle(document, author, programName, date);
		    createTimeTable(estimatedTime, actualTime);
		    createDefectTable(actualDefects);
		    createSummaryTable(estimatedTotal, actualTotal);
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
	 * Creates the Time Table with Estimated Time, Actual Time, To Date, and
	 * % To Date
	 * 
	 */
	private static void createTimeTable(double [] estimatedTime, double [] actualTime){
		
		Paragraph table1 = new Paragraph();
		PdfPTable timeTable = new PdfPTable(5);
		
		double totalEstimated = 0;
		double totalActual = 0;
		double actualToDate = 0;
		double totalActualToDate = 0;
		double actualToDatePercent = 0;

		 addEmptyLine(table1, 5);
		
		//Add headers to table
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
	    
  	  	//Calculate total actual to date
	    for(int j = 0; j < 7; ++j){ 
	    	totalActualToDate += actualTime[j];
	    }
	    
	    //Add the data to the table
	    for(int i = 0; i < 8; ++i){
	    	//Add Table labels in first column
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
	    	
	    	//Add estimated time to table
	    	String formattedEstimatedTime = String.format("%.2f",estimatedTime[i]);
	    	timeTable.addCell(formattedEstimatedTime);
	    	totalEstimated += estimatedTime[i];
	    	
	    	//Add actual time to table
	    	String formattedAcutalTime = String.format("%.2f", actualTime[i]);
	    	timeTable.addCell(formattedAcutalTime);
	    	totalActual += actualTime[i];
	    	
	    	//Calculate how much time has been spent to date
	    	for(int totalSoFar = i; totalSoFar >= 0; --totalSoFar){
	    		actualToDate += actualTime[i];
	    	}
	    	
	    	//Add To Date to table
	    	String formattedActualToDate = String.format("%.2f", actualToDate);
	    	timeTable.addCell(formattedActualToDate);
	    	
	    	//Calculate %To Date
		    actualToDatePercent = (actualToDate/totalActualToDate)*100;
		    
		    //Add %To Date to table
		    String formattedActualToDatePercent = String.format("%.2f", actualToDatePercent);
		    timeTable.addCell(formattedActualToDatePercent);
	    	
	    }
	    
	    table1.add(timeTable);
	}
	
	/**
	 * 
	 * @param actualDefects array of defects injected
	 * 
	 * Creates the defect table with the Estimated column starred out (***) and
	 * with the Actual Defects Injected, the To Date Defects Injected, and the
	 * %To Date Defects Injected
	 */
	private static void createDefectTable(int [] actualDefects){
		Paragraph table2 = new Paragraph();
		PdfPTable defectTable = new PdfPTable(5);
		
		double totalActual = 0;
		double actualToDate = 0;
		double totalActualToDate = 0;
		double actualToDatePercent = 0;
		
		addEmptyLine(table2, 5);
		
		//Add headers to table
	    PdfPCell tableHeading = new PdfPCell(new Phrase("Defects Injected", headingFont));
	    tableHeading.setHorizontalAlignment(Element.ALIGN_CENTER);
	    defectTable.addCell(tableHeading);
	    
	    tableHeading = new PdfPCell(new Phrase("Estimated", headingFont));
	    tableHeading.setHorizontalAlignment(Element.ALIGN_CENTER);
	    defectTable.addCell(tableHeading);
	    
	    tableHeading = new PdfPCell(new Phrase("Actual", headingFont));
	    tableHeading.setHorizontalAlignment(Element.ALIGN_CENTER);
	    defectTable.addCell(tableHeading);
	    
	    tableHeading = new PdfPCell(new Phrase("To Date", headingFont));
	    tableHeading.setHorizontalAlignment(Element.ALIGN_CENTER);
	    defectTable.addCell(tableHeading);
	    
	    tableHeading = new PdfPCell(new Phrase("% To Date", headingFont));
	    tableHeading.setHorizontalAlignment(Element.ALIGN_CENTER);
	    defectTable.addCell(tableHeading);
	    defectTable.setHeaderRows(1);
	    
  	  	//Calculate total actual to date
	    for(int j = 0; j < 7; ++j){ 
	    	totalActualToDate += actualDefects[j];
	    }
	    
	    //Add the data to the table
	    for(int i = 0; i < 8; ++i){
	    	//Add Table labels in first column
	    	switch(i){	    	
	    	case 0:
	    		defectTable.addCell("Planning");
	    		break;
	    	case 1:
	    		defectTable.addCell("Design");
	    		break;
	    	case 2:
	    		defectTable.addCell("Code");
	    		break;
	    	case 3:
	    		defectTable.addCell("Code Review");
	    		break;
	    	case 4:
	    		defectTable.addCell("Compile");
	    		break;
	    	case 5:
	    		defectTable.addCell("Test");
	    		break;
	    	case 6:
	    		defectTable.addCell("Postmortem");
	    		break;
	    	case 7:
	    		defectTable.addCell("TOTAL");
	    		break;
	    	}
	    	
	    	//Add estimated defects to table - at this point, they are starred out (***)
	    	defectTable.addCell("***");
	    	
	    	
	    	//Add actual time to table
	    	String formattedAcutalTime = String.format("%.2f", actualDefects[i]);
	    	defectTable.addCell(formattedAcutalTime);
	    	totalActual += actualDefects[i];
	    	
	    	//Calculate how much time has been spent to date
	    	for(int totalSoFar = i; totalSoFar >= 0; --totalSoFar){
	    		actualToDate += actualDefects[i];
	    	}
	    	
	    	//Add To Date to table
	    	String formattedActualToDate = String.format("%.2f", actualToDate);
	    	defectTable.addCell(formattedActualToDate);
	    	
	    	//Calculate %To Date
		    actualToDatePercent = (actualToDate/totalActualToDate)*100;
		    
		    //Add %To Date to table
		    String formattedActualToDatePercent = String.format("%.2f", actualToDatePercent);
		    defectTable.addCell(formattedActualToDatePercent);
		    
	    }
	    
	    table2.add(defectTable);
	}
	
	/**
	 * 
	 * @param estimatedTotal the estimated total program size (LOC), 
	 * lines of code per hour (LOC/hour), and defects per thousand lines of code
	 * (KLOC)
	 * @param actualTotal the actual total program size (LOC), 
	 * lines of code per hour (LOC/hour), and defects per thousand lines of code
	 * (KLOC)
	 * 
	 * Creates a table summarizing the program size, the lines of code per hour,
	 * the number of defects per thousand lines of code, and those totals to date.
	 * To Date is starred out currently (***)
	 */
	
	private static void createSummaryTable(double[] estimatedTotal, double[] actualTotal){
		Paragraph table3 = new Paragraph();
		PdfPTable summaryTable = new PdfPTable(4);
		
		addEmptyLine(table3, 7);
		
		//Add headers to table
	    PdfPCell tableHeading = new PdfPCell(new Phrase("")); //First row, first column is blank
	    summaryTable.addCell(tableHeading);
	    
	    tableHeading = new PdfPCell(new Phrase("Estimated", headingFont));
	    tableHeading.setHorizontalAlignment(Element.ALIGN_CENTER);
	    summaryTable.addCell(tableHeading);
	    
	    tableHeading = new PdfPCell(new Phrase("Actual", headingFont));
	    tableHeading.setHorizontalAlignment(Element.ALIGN_CENTER);
	    summaryTable.addCell(tableHeading);
	    
	    tableHeading = new PdfPCell(new Phrase("To Date", headingFont));
	    tableHeading.setHorizontalAlignment(Element.ALIGN_CENTER);
	    summaryTable.addCell(tableHeading);
	    
	    //Add data to the table
	    for(int i = 0; i < 3; ++i){
	    	switch(i){
	    	case 0:
	    		summaryTable.addCell("Program Size (LOC)");
	    		break;
	    	case 1:
	    		summaryTable.addCell("LOC/Hour");
	    		break;
	    	case 2:
	    		summaryTable.addCell("Defect/KLOC");
	    		break;
	    	}
	    	
	    	String formattedEstimatedTotal = String.format(".2f", estimatedTotal[i]);
	    	summaryTable.addCell(formattedEstimatedTotal);
	    	
	    	String formattedActualTotal = String.format(".2f", actualTotal[i]);
	    	summaryTable.addCell(formattedActualTotal);
	    	
	    	summaryTable.addCell("***");
	    }
	    
	    table3.add(summaryTable);
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
