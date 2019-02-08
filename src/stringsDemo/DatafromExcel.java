package stringsDemo;

import java.awt.print.Book;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DatafromExcel {

	static Workbook book;
	static Sheet sheet;
	static String rowName;
	static String colName;
	
	public String getData(String sheetName, String rowName, String colName) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fi = new FileInputStream(new File("C:\\Users\\Gopi Srinivas Putta\\eclipse-workspace\\Strings\\Data.xlsx"));
		
		book = WorkbookFactory.create(fi);
		sheet = book.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		String data = "";
		for(int i=0; i<rows; i++) {
			if(sheet.getRow(i).getCell(0).toString().equals(rowName)) {
				
				for(int j=0; j<cols; j++) {
					if(sheet.getRow(0).getCell(j).toString().equals(colName)) {
					 data = sheet.getRow(i).getCell(j).toString();
						break;
					}
				}
			}
		}
		return data;		
	}
}
