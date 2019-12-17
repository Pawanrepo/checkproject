import java.io.File;
import java.io.IOException;
 
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.util.AreaReference;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFName;
 
public class WorkBookCreate {
 
    @SuppressWarnings("deprecation")
    public static void main(String[] args) throws IOException {
         
        final SpreadsheetVersion EXCEL2007;
         
     
        // setup code
        String cname = "LTE2600_CELL_AVAILABILITY_POST";
         
        org.apache.poi.ss.usermodel.Workbook wb = null;
        try {
             wb = WorkbookFactory.create(new File("C:\\Temp\\LTE2600_7D_Stability_KPI_Report.xlsx"));
        } catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        int namedCellIdx = wb.getNameIndex(cname);
        System.out.println("*************************"+namedCellIdx);
         
        System.out.println(namedCellIdx);
        org.apache.poi.ss.usermodel.Name aNamedCell = wb.getNameAt(namedCellIdx);
         
        System.out.println("Kaushik"+aNamedCell);
         
        AreaReference[] arefs = AreaReference.generateContiguous(aNamedCell.getRefersToFormula());
         
        System.out.println(arefs[0]);
         
        CellReference[] crefs = arefs[0].getAllReferencedCells();
        for (int i=0; i<crefs.length; i++) {
            Sheet s = wb.getSheet(crefs[i].getSheetName());
            Row r = s.getRow(crefs[i].getRow());
            Cell c = r.getCell(crefs[i].getCol());
             
            System.out.println("ppppp"+c);
        }
}

}
