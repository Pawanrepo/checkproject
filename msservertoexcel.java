
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class msservertoexcel {
	public static void main (String args[]) {
	
		String upload_dir = null;
		 File fi = null;
		 String localfileName = "msserverfile.xlsx";
		 FileOutputStream fileIn = null;
		 upload_dir = "C:/fileupload/";
		int f =1;
	//	int k =0;
		XSSFWorkbook workbooknew;
		BufferedWriter bw = null;
		FileWriter fw = null;
		 
	//	 fw = new FileWriter(localfileName);
	//	bw = new BufferedWriter(fw);
	//	bw.write(content);
		try {

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
			e.printStackTrace();
					}
    	
    	Connection connection = null;
    	Statement statement = null;

		try {
			System.out.println(System.currentTimeMillis());
			connection = DriverManager.getConnection(
					"jdbc:sqlserver://10.157.2.19:1433;databaseName=marsdb","sa","TMp258369");
				//	"jdbc:postgresql://10.135.146.68:5432/ssdp", "usr_ssdp","ssdp123");
					} catch (SQLException e) {

			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		
		if (connection != null) {
			System.out.println("You made it, take control your database now!");
			
			try {
				statement = connection.createStatement();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				System.out.println("hello-1");
				String sqlQueries = "select TMob_Cell_ID,NGR_Northing,NGR_Easting from [backup].[CM_NSN_DARWIN_SITES_TMP]";
				ResultSet rs = statement.executeQuery(sqlQueries);
				ResultSetMetaData metadata = rs.getMetaData();
				 
				int columnCount = metadata.getColumnCount();
				workbooknew = new XSSFWorkbook();
				Sheet sheet = workbooknew.createSheet("Column_Name");
				  Font headerFont = workbooknew.createFont();
				    headerFont.setBold(true);
				    headerFont.setFontHeightInPoints((short) 14);
				    headerFont.setColor(IndexedColors.RED.getIndex());

				    // Create a CellStyle with the font
				    CellStyle headerCellStyle = workbooknew.createCellStyle();
				    headerCellStyle.setFont(headerFont);
				    Row headerRow = sheet.createRow(0);
				
				for (int t=0,i=1; i<=columnCount; i++,t++) {
					 
					  String columnName = metadata.getColumnName(i);
					  
					  Cell cell = headerRow.createCell(t);
				        cell.setCellValue(columnName);
				        cell.setCellStyle(headerCellStyle);
					 
					  System.out.println("pawankaushik"+columnName);
					 
					}
				
				while (rs.next()) {
					Row headerRowdata = sheet.createRow(f);
					for (int k=0,j=1; j<=columnCount; k++,j++) {
					
					Cell cell = headerRowdata.createCell(k);
					cell.setCellValue(rs.getString(metadata.getColumnName(j)));
					}
					f++;
				
				
				}
				for(int s = 0; s < columnCount; s++) {
			        sheet.autoSizeColumn(s);
			    }
				
			      
			     try {
			    	  fileIn = new FileOutputStream(upload_dir +"\\"+ localfileName);
			 			
			     		
			 		
			 		
				 workbooknew.write(fileIn);
				  

				    // Closing the workbook
				    workbooknew.close();
				    fileIn.close();
			     } catch(Exception e1)
			     {
			    	 System.out.println("Exception in weriting file"+e1);
			     }
				
				
					
					 
					 
					 
				}
				
				
				
			 catch (SQLException e) {
				e.printStackTrace();
			}
		
		} else {
			System.out.println("Failed to make connection!");
		}
		try {
			connection.close();
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	
}
}