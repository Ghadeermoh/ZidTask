package utility;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ExcellUtility {
	
	static XSSFWorkbook excelWorkbook = null;
	static XSSFSheet excelSheet = null;
	static XSSFRow row = null;
	static XSSFCell cell = null;
	
	public static Object[][] getData() throws IOException 
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\ghadeermoh\\eclipse-workspace\\zidTesting\\src\\main\\java\\zidTestData\\TestData.xlsx"); // Your .xlsx file name along with path
		excelWorkbook = new XSSFWorkbook(fis);
		// Read sheet inside the workbook by its name
		excelSheet = excelWorkbook.getSheet("TestData"); //Your sheet name
		// Find number of rows in excel file
		System.out.println("First Row Number/index:"+ excelSheet.getFirstRowNum() + " *** Last Row Number/index:"
				+ excelSheet.getLastRowNum());
		int rowCount = excelSheet.getLastRowNum() - excelSheet.getFirstRowNum()+1;
		int colCount = excelSheet.getRow(0).getLastCellNum();
		System.out.println("Row Count is: " + rowCount
				+ " *** Column count is: " + colCount);
		Object data[][] = new Object[rowCount-1][colCount];
		for (int rNum = 2; rNum <= rowCount; rNum++) 
		{
			for (int cNum = 0; cNum < colCount; cNum++) 
			{
				System.out.print(getCellData("TestData", cNum, rNum) + " "); // Your sheet name
				data[rNum - 2][cNum] = getCellData("TestData", cNum, rNum); //Your sheet name
			}
			System.out.println();
		}
		return data;
	}
	
	public static String getCellData(String sheetName, int colNum, int rowNum) 
	{
		try
		{
			if (rowNum <= 0)
				return "";
			int index = excelWorkbook.getSheetIndex(sheetName);
			if (index == -1)
				return "";
			excelSheet = excelWorkbook.getSheetAt(index);
			row = excelSheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			cell = row.getCell(colNum);
			if (cell == null)
				return "";
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC
					|| cell.getCellType() == Cell.CELL_TYPE_FORMULA)
			{
				String cellText = String.valueOf(cell.getNumericCellValue());
				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			else
				return String.valueOf(cell.getBooleanCellValue());
		} catch (Exception e)
		{
			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum
					+ " does not exist in xls";
		}
	}
	
}
