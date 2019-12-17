import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class readheaderexcelsheet {
	private static String upload_dir = null;
	private static String uploadFileName = "inputexcelfile.xlsx";
	private static String download_dir = null;
	private static String downloadFileName = "outputexcelfile.xlsx";
	private static Workbook workbook = null;
	private static Workbook workbookout = null;
	@SuppressWarnings("resource")
	public static void main(String args[]) {
	if(System.getProperty("os.name").contains("indow")) {
		upload_dir = "C:\\fileupload";
		}
		else {
			upload_dir = "/fs/im/fileupload";
		}
	 	if(System.getProperty("os.name").contains("indow"))	{
		download_dir = "C:\\filedownload";
		}
		else {
			download_dir = "/fs/im/filedownload";
		}
	 	FileInputStream inputFileStream = null;	
	 	try {
	 		if(System.getProperty("os.name").contains("indow"))	{
	 			inputFileStream = new FileInputStream(new File(upload_dir +"\\"+uploadFileName));
	 	}
		else {
			inputFileStream = new FileInputStream(new File(upload_dir +"/"+uploadFileName));
		}
	 	FileOutputStream outputFileStream = null;
	 	if(System.getProperty("os.name").contains("indow"))	{
    	outputFileStream = new FileOutputStream(download_dir +"\\"+ downloadFileName);
		}
		else {
			outputFileStream = new FileOutputStream(download_dir +"/"+ downloadFileName);
		}
	 	Sheet sheet = null;
	 	if (downloadFileName.endsWith("xlsx")) {
	        workbookout = new XSSFWorkbook();
	    } 
	 	else if (downloadFileName.endsWith("xls")) {
	        workbookout = new HSSFWorkbook();
	    }
	 	else {
	        throw new IllegalArgumentException("Error First The specified file is not Excel file");
	    }
	 	if (downloadFileName.endsWith("xlsx")) {
	 		sheet = workbookout.createSheet("Final Sheet");
	 	}
     else if (downloadFileName.endsWith("xls")) {
    	sheet = workbookout.createSheet("Final Sheet");
	    } 
     	else {
	        throw new IllegalArgumentException("Error Second The specified file is not Excel file");
	    } 
	 	Font headerFont = workbookout.createFont();
	    headerFont.setBold(true);
	    headerFont.setFontHeightInPoints((short) 14);
	    headerFont.setColor(IndexedColors.RED.getIndex());
	    CellStyle headerCellStyle = workbookout.createCellStyle();
	    headerCellStyle.setFont(headerFont);
	    Row row;
	    Row inputrow;
	    if (uploadFileName.endsWith("xlsx")) {
	        workbook = new XSSFWorkbook(inputFileStream);
	    }
	    else if (uploadFileName.endsWith("xls")) {
	        workbook = new HSSFWorkbook(inputFileStream);
	    }
	    else {
	        throw new IllegalArgumentException("Error Third The specified file is not Excel file");
	    }
	    int numberOfSheets = workbook.getNumberOfSheets();
	    for (int i = 0; i < numberOfSheets; i++) {
	        Sheet aSheet = workbook.getSheetAt(i);
	        int noOfColumns = aSheet.getRow(0).getPhysicalNumberOfCells();
	        if (uploadFileName.endsWith("xlsx")) {
	        	row = (XSSFRow) aSheet.getRow(0);
	        }
	        else if (uploadFileName.endsWith("xls")) {
	        	row = (HSSFRow) aSheet.getRow(0);
		    }
	        else {
		        throw new IllegalArgumentException("Error Fourth The specified file is not Excel file");
		    }
		    if (downloadFileName.endsWith("xlsx")) {
	        	inputrow = (XSSFRow) sheet.createRow(i);
	        }
	        else if (downloadFileName.endsWith("xls")) {
	        	inputrow = (HSSFRow) sheet.createRow(i);
		    }
	        else {
		        throw new IllegalArgumentException("Error Fifth The specified file is not Excel file");
		    } 
	        for (int t = 0; t < noOfColumns; t++) {
	        	Cell cell = null;
	        	cell = row.getCell(t);
	        	Cell cellNew = inputrow.createCell(t);
		        cellNew.setCellValue(cell.toString());
	        	cellNew.setCellStyle(headerCellStyle);
	        	sheet.autoSizeColumn(t);
	        }
	    }
	    workbookout.write(outputFileStream);
	    workbookout.close();
		workbook.close();
		inputFileStream.close();
		outputFileStream.close();  
		System.out.println("OutputfileCreated");
	 }
	 catch(Exception e)	{
		 System.out.println("Error Sixth"+e);
	 }
	}
}
