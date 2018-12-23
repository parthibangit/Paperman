package library;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConfigExcel
{

	
	 static XSSFWorkbook workbook;
	 static XSSFSheet sheet1;
	 static int rowTotal;
	 static int columnTotal;

	public ConfigExcel(String excelPath) throws Exception
	{
		
		File excel=new File(excelPath);	
		FileInputStream load_excel=new FileInputStream(excel);
		workbook=new XSSFWorkbook(load_excel);	
		workbook.close();
	}

	public Cell getData(String sheetName,int row, int coloumn)
    {
			
		sheet1=workbook.getSheet(sheetName);
		Cell cell_value=sheet1.getRow(row).getCell(coloumn);
		return cell_value;	
	}
	
	public int getRowCount(String sheetName)
	{
		   XSSFSheet sheet1 = workbook.getSheet(sheetName);
	       int rowCount = sheet1.getLastRowNum()+1;
	       return rowCount;
	}
	 
	public int getColumnCount(String sheetName)
	{
	       sheet1 = workbook.getSheet(sheetName);
	       XSSFRow row = sheet1.getRow(0);
	       int colCount = row.getLastCellNum();
	       return colCount;
	}
}



