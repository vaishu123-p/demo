package commonutils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {

	public String getDataFromExcelFile(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fisex= new FileInputStream("src\\test\\resources\\vtigerXl.xlsx");
 	    Workbook wb=WorkbookFactory.create(fisex);
 	    Sheet sh= wb.getSheet(sheetname);
 	    Row rw= sh.getRow(rownum);
 	    Cell cl=rw.getCell(cellnum);
 	    String value=cl.getStringCellValue();
 	    return value;
		
	}

}
