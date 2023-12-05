package package1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class demo3 {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
       FileInputStream fis=new FileInputStream("src\\test\\resources\\maven.xlsx");
		
		Workbook wb=WorkbookFactory.create(fis);
		
		Sheet sh=wb.getSheet("Sheet1");
		
		Row rw=sh.getRow(0);
		
		Cell cl=rw.getCell(1);
		
		String data=cl.getStringCellValue();
		
		System.out.println(data);
		

	}


}
