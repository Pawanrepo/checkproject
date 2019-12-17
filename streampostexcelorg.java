import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import com.monitorjbl.xlsx.StreamingReader;
public class streampostexcelorg {
	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
		String fileName = "c://temp//streamexcel.xlsx";
		
		long startTime = System.nanoTime();
		System.out.println("StartTime"+startTime);
		Statement stmt = null;
		Connection connection = null;
		try {
			
			
			InputStream is = new FileInputStream(new File(fileName));
			StreamingReader reader = StreamingReader.builder()
				.rowCacheSize(10000)    // number of rows to keep in memory (defaults to 10000)
				.bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
				.sheetIndex(0)        // index of sheet to use (defaults to 0)
				.sheetName("Sheet1")  // name of sheet to use (overrides sheetIndex)
				.read(is);            // InputStream or File for XLSX file (required)
			try {
	   			connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/tempdatabase", "postgres","root");
	   			
	   		} 
	   		catch (SQLException e) {
	   			e.printStackTrace();
	   		} 
				
				for (Row r : reader) {
					int i=0;
					String columnvalue[]= new String[22];
					for (Cell c : r) {
						try {
							Class.forName("org.postgresql.Driver");
						} 
						catch (ClassNotFoundException e) {
							e.printStackTrace();
						}
						columnvalue[i]= 	c.getStringCellValue();
			   			i++;
					}
					
					try {
						stmt = connection.createStatement();
					} 
					catch (SQLException e) {
						e.printStackTrace();
					}
					String sql = "INSERT INTO streamexcel " + "VALUES ('"+ columnvalue[0] +"','"+ columnvalue[1]+"','"+ columnvalue[2]+"','"+ columnvalue[3]+"','"+ columnvalue[4]+"','"+ columnvalue[5]+"','"+ columnvalue[6]+"','"+ columnvalue[7]+"','"+ columnvalue[8]+"','"+ columnvalue[9]+"','"+ columnvalue[10]+"','"+ columnvalue[11]+"','"+ columnvalue[12]+"','"+ columnvalue[13]+"','"+ columnvalue[14]+"','"+ columnvalue[15]+"','"+ columnvalue[16]+"','"+ columnvalue[17]+"','"+ columnvalue[18]+"','"+ columnvalue[19]+"','"+ columnvalue[20]+"','"+ columnvalue[21]+"')";
		    		try {
		    			stmt.executeUpdate(sql);
					} 
		    		catch (SQLException e) {
		    			e.printStackTrace();
					}
		    		System.out.println("databaseupdated");
			}
				
		}
		
		
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				stmt.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		long EndTime = System.nanoTime();
		System.out.println("EndTime"+EndTime);
		long totalTime = EndTime - startTime;
		System.out.println("totalTimeinnano"+totalTime);
		double seconds = (double)totalTime / 1000000000.0;
		System.out.println("totaltimeinsecond"+ seconds);
	}
}
