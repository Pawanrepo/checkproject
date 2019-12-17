import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
		public class LoadArtist {
			public static void main(String args[]) throws Exception {
			
		        try {
		        	Class.forName("com.mysql.jdbc.Driver");
		        Connection  con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/artinfo", "root","root");
		       //     con.setAutoCommit(false);
		        PreparedStatement pstm = null;

		        FileInputStream  input = new FileInputStream(new File("C:/Users/pkaushik/Downloads/tempfolder/upload_file_artist.xlsx"));
		           
		            XSSFWorkbook wb = new XSSFWorkbook(input);

		            XSSFSheet sheet = wb.getSheetAt(0);
		            Row row;
		            System.out.println("Hello");
		            String artistlastname = null;
		            String nationality = null;
		            String datedescription = null;
		            String speciality = null;
		            for(int z=3;z<= sheet.getLastRowNum();z++)
		            {
		            	row = sheet.getRow(z);
		            	artistlastname = row.getCell(1).getStringCellValue();
		            	nationality = row.getCell(2).getStringCellValue();
		            	datedescription = row.getCell(3).getStringCellValue();
		            	 speciality = row.getCell(4).getStringCellValue();
		            	    String sql = "INSERT INTO artist (artist_Surname, artist_nationality, artist_DateDesc, artist_Speciality) VALUES ('" + artistlastname + "','" + nationality + "','" + datedescription + "','" + speciality + "')";
		         //     System.out.println(sql);
		            	    pstm = (PreparedStatement) con.prepareStatement(sql);
		                pstm.execute();
		                System.out.println("Import rows " + z);
		            }
		         //   con.commit();
		            pstm.close();
		            con.close();
		            input.close();
		            System.out.println("Success import excel to mysql table");
		            
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		       
		    }
		}
		
		
			
