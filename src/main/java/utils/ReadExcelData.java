package utils;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ReadExcelData extends ExtentReporter{

	public static String[][] readData(String excelFileName) throws IOException {
		XSSFWorkbook wb = new XSSFWorkbook("./data/"+excelFileName+".xlsx");
		
		XSSFSheet ws = wb.getSheet("Sheet1");
		
		int rowNum = ws.getLastRowNum();
		
		short lastCellNum = ws.getRow(0).getLastCellNum();
		
		String [][]data = new String[rowNum][lastCellNum];
		
		for (int i = 1; i <=rowNum; i++) {
			for (int j = 0; j < lastCellNum; j++) {
				data[i-1][j]=ws.getRow(i).getCell(j).getStringCellValue();
			}
		}
wb.close();
return data;
	}
	
}
