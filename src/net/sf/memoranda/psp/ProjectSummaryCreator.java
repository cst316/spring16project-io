package net.sf.memoranda.psp;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
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
	
	
	private static String FILE = System.getProperty("user.home") + File.separator + ".memoranda" + File.separator + ".proj" + File.separator + ".temp";
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
	public static void createFileSummary(String author, String programName, String date, 
			double[] estimatedTime, double[] actualTime, int [] estimatedDefects,
			int[] actualDefects, double[] estimatedTotal, double[] actualTotal){
		try {
			Document document = new Document();
			checkFolderSystem();
		    PdfWriter.getInstance(document, new FileOutputStream(FILE + File.separator + "PSPProjectSummary.pdf"));
		    document.open();
		    addPDFTitle(document, author, programName, date);
		    createTimeTable(document, estimatedTime, actualTime);
		    createDefectTable(document, estimatedDefects, actualDefects);
		    createSummaryTable(document, estimatedTotal, actualTotal);
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
	    
		Paragraph title = new Paragraph("PSP Summary Form", headingFont);
	    title.setAlignment(Element.ALIGN_CENTER);
	    addEmptyLine(title, 1);
	    try {
			document.add(title);
		} catch (DocumentException e) {
			e.printStackTrace();
		}

	    
	    Paragraph introSection = new Paragraph();
	    introSection.add(new Paragraph("Name: " + author, normalFont));
	    introSection.add(new Paragraph("Program Name: " + programName, normalFont));
	    introSection.add(new Paragraph("Date: " + date, normalFont));
	    
	    try {
			document.add(introSection);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	   
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
	private static void createTimeTable(Document document, double [] estimatedTime, double [] actualTime){
		
		Paragraph table1 = new Paragraph();
		PdfPTable timeTable = new PdfPTable(5);
		addEmptyLine(table1, 2);
		double totalEstimated = 0;
		double totalActual = 0;
		double actualToDate = 0;
		double totalActualToDate = 0;
		double actualToDatePercent = 0;

		 addEmptyLine(table1, 1);
		
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
	    
  	  	//Save total actual to date
	    totalActualToDate = actualTime[7];

	    
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
	    	if(i != 7){
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
	    
	    try {
			document.add(table1);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param actualDefects array of defects injected
	 * 
	 * Creates the defect table with the Estimated column, the 
	 * Actual Defects Injected, the To Date Defects Injected, and the
	 * %To Date Defects Injected
	 */
	private static void createDefectTable(Document document, int [] estimatedDefects, int [] actualDefects){
		Paragraph table2 = new Paragraph();
		addEmptyLine(table2, 2);
		PdfPTable defectTable = new PdfPTable(5);
		
		int totalEstimated = 0;
		int totalActual = 0;
		double actualToDate = 0;
		double totalActualToDate = 0;
		double actualToDatePercent = 0;
		
		addEmptyLine(table2, 2);
		
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
	    
  	  	//Save total actual to date
	    totalActualToDate = actualDefects[7];

	    
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
	    	
	    	//Add estimated time to table
	    	String formattedEstimatedDefects = String.valueOf(estimatedDefects[i]);
	    	defectTable.addCell(formattedEstimatedDefects);
	    	totalEstimated += estimatedDefects[i];
	    		    	
	    	
	    	//Add actual time to table
	    	String formattedAcutalTime = String.valueOf(actualDefects[i]);
	    	defectTable.addCell(formattedAcutalTime);
	    	totalActual += actualDefects[i];
	    	
	    	//Calculate how much time has been spent to date
	    	if(i != 7){
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
	    
	    try {
			document.add(table2);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
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
	
	private static void createSummaryTable(Document document, double[] estimatedTotal, double[] actualTotal){
		Paragraph table3 = new Paragraph();
		addEmptyLine(table3, 2);
		PdfPTable summaryTable = new PdfPTable(4);
		
		addEmptyLine(table3, 3);
		
		//Add headers to table
	    PdfPCell tableHeading = new PdfPCell(new Phrase("SUMMARY", normalFont)); //First row, first column is blank
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
	    	
	    	String formattedEstimatedTotal = String.format("%.2f", estimatedTotal[i]);
	    	summaryTable.addCell(formattedEstimatedTotal);
	    	
	    	String formattedActualTotal = String.format("%.2f", actualTotal[i]);
	    	summaryTable.addCell(formattedActualTotal);
	    	
	    	summaryTable.addCell("***");
	    }
	    
	    table3.add(summaryTable);
	    
	    try {
			document.add(table3);
		} catch (DocumentException e) {
			e.printStackTrace();
		}
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
	
	/**
	 * Checks to see if all the files in the file path exist. If they don't,
	 * create them
	 * @return success whether or not mkdir was successful.
	 */
	
	public static boolean checkFolderSystem(){
		boolean success= true;
		try{
			if(!Files.exists(Paths.get(FILE))){
				File file = new File(FILE);
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
