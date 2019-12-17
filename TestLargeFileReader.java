import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class TestLargeFileReader {
 /*  public void processOneSheet(String filename) throws Exception {
        OPCPackage pkg = OPCPackage.open(filename);
        XSSFReader r = new XSSFReader( pkg );
        SharedStringsTable sst = r.getSharedStringsTable();
 
        XMLReader parser = fetchSheetParser(sst);
 
        // rId2 found by processing the Workbook
        // Seems to either be rId# or rSheet#
        InputStream sheet2 = r.getSheet("rSheet1");
        InputSource sheetSource = new InputSource(sheet2);
        parser.parse(sheetSource);
        sheet2.close();
    } */
	  static int idx ;
    public void processAllSheets(String filename) throws Exception {
        OPCPackage pkg = OPCPackage.open(filename);
        XSSFReader r = new XSSFReader( pkg );
        SharedStringsTable sst = r.getSharedStringsTable();
         
        XMLReader parser = fetchSheetParser(sst);
 
        Iterator<InputStream> sheets = r.getSheetsData();
        while(sheets.hasNext()) {
            System.out.println("Processing new sheet:\n");
            InputStream sheet = sheets.next();
            InputSource sheetSource = new InputSource(sheet);
            parser.parse(sheetSource);
            sheet.close();
            System.out.println("");
        }
    }
 
    public XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException {
        XMLReader parser =
    //       XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser");
        XMLReaderFactory.createXMLReader();
        ContentHandler handler = new SheetHandler(sst);
        parser.setContentHandler(handler);
        return parser;
    }
 
    /** 
     * See org.xml.sax.helpers.DefaultHandler javadocs 
     */
    private static class SheetHandler extends DefaultHandler {
        private SharedStringsTable sst;
        private String lastContents;
        private boolean nextIsString;
         
        private SheetHandler(SharedStringsTable sst) {
            this.sst = sst;
        }
         
        public void startElement(String uri, String localName, String name,
                Attributes attributes) throws SAXException {
            // c => cell
        	System.out.println("jjjj"+name);
            if(name.equals("c")) {
                // Print the cell reference
                System.out.print(attributes.getValue("r") + " - ");
                // Figure out if the value is an index in the SST
            //    System.out.println("inside"+ attributes.getValue("t"));
                String cellType = attributes.getValue("t");
                System.out.println("pawanStringt"+cellType);
                System.out.println("pawan"+lastContents);
                if(cellType != null && cellType.equals("s")) {
                    nextIsString = true;
                } else { 
                    nextIsString = false;
                }
            } 
            // Clear contents cache
         //   System.out.println("kaushik"+ lastContents);
           lastContents = "";
            
        }
         
        public void endElement(String uri, String localName, String name)
                throws SAXException {
            // Process the last contents as required.
            // Do now, as characters() may be called more than once
            if(nextIsString) {
            	
            	System.out.println("rajni"+lastContents);
            	if(!(lastContents instanceof String))
            	{
                idx = Integer.parseInt(lastContents);
            	}
                lastContents = new XSSFRichTextString(sst.getEntryAt(idx)).toString();
            }
 
            // v => contents of a cell
            // Output after we've seen the string contents
            if(name.equals("v")) {
            	;
                System.out.println(lastContents);
            }
        }
 
        public void characters(char[] ch, int start, int length)
                throws SAXException {
            lastContents += new String(ch, start, length);
        }
    }
     
    public static void main(String[] args)  {
        try {
        	long startTime = System.nanoTime();
        	System.out.println("StartTime"+startTime);
            TestLargeFileReader howto = new TestLargeFileReader();
            howto.processAllSheets("c://temp//streamexcel.xlsx");
            long EndTime = System.nanoTime();
    		System.out.println("EndTime"+EndTime);
    		long totalTime = EndTime - startTime;
    		System.out.println("totalTimeinnano"+totalTime);
    		double seconds = (double)totalTime / 1000000000.0;
    		System.out.println("totaltimeinsecond"+ seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
         
         
    }
}