import java.io.File;
import jxl.Sheet;
import jxl.Workbook;
public class streampostexcel {
	@SuppressWarnings("deprecation")
	public static void main(String args[]) {
	long startTime = System.nanoTime();
		System.out.println("StartTime"+startTime);
		int numberofsheet=0;
		Workbook workbook = null;
		try {
				workbook = Workbook.getWorkbook(new File("c://temp//streamexcel.xls"));
				numberofsheet = workbook.getNumberOfSheets();
				System.out.println("Number of sheets in this workbook"+numberofsheet);
				
				for(int i =0; i< numberofsheet; i++)
				{
					Sheet firstSheet = workbook.getSheet(i);
				for (int row = 0 ; row < firstSheet.getRows(); row ++ ) {
					for (int column = 0 ; column < firstSheet.getColumns(); column ++) {
						System.out.print(firstSheet.getCell(column, row).getContents() + "\t\t");
					}
					System.out.println();
					System.out.println(row);
				}
		}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			try {
			workbook.close();	
			} catch (Exception e) {
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
