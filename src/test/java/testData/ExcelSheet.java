package testData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelSheet {
	
	public static Workbook book;
	public static Sheet sheet;
	
	public static Object[][] readinput(String Sheetname){
		FileInputStream file = null;
		try {
			file = new FileInputStream("C:\\Users\\rajit\\eclipse-workspace\\AmazonProject\\src\\test\\java\\testData\\SignIn Details.xlsx");
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
		book = WorkbookFactory.create(file);
		}
		catch (IOException a) {
			a.printStackTrace();
		}
		
		sheet = book.getSheet(Sheetname);
		
		Object[][] input = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i=0; i<sheet.getLastRowNum(); i++) {
			
			for(int a=0; a< sheet.getRow(0).getLastCellNum(); a++) {
				 input[i][a]=sheet.getRow(i+1).getCell(a).toString();
			}
		}
		
		return input;
	}

}
