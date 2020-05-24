package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	static FileInputStream fis = null ; 
	
	public FileInputStream getFileInputStream(String fileName) 
	{
		String filePath = System.getProperty("user.dir")+Constants.Path_TestData+fileName+".xlsx"; 
		File srcFile = new File(filePath);
		
		try {
			fis = new FileInputStream(srcFile);
		} catch (FileNotFoundException e) {
			System.out.println("Test Data file not found.");
			System.exit(0);
		}
		return fis ; 
	}
	
	public Object[][] getExcelData(String fileName, String sheetName) throws IOException
	{
		fis = getFileInputStream(fileName); 
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheet(sheetName); 
		
		int TotalNumberOfRows = (sheet.getLastRowNum()+1);
		int TotalNumberOfCols = sheet.getRow(0).getPhysicalNumberOfCells(); ; 
		
		String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols] ; 
		
		for (int i = 0; i < TotalNumberOfRows; i++) 
		{
			for (int j = 0; j < TotalNumberOfCols; j++) {
				XSSFRow row = sheet.getRow(i);
				arrayExcelData[i][j] = row.getCell(j).toString(); 
			}
		}
		String[][] arrayExcelDataExceptFirstRow = new String[TotalNumberOfRows-1][] ; 
		for (int i = 0; i < arrayExcelDataExceptFirstRow.length; ++i) {
			arrayExcelDataExceptFirstRow[i] = new String[arrayExcelData[i].length];

            for (int j = 0; j < arrayExcelDataExceptFirstRow[i].length; ++j) {
            	arrayExcelDataExceptFirstRow[i][j] = arrayExcelData[i+1][j];
            }
        }
		
		wb.close();
		return arrayExcelDataExceptFirstRow; 
	}
}
