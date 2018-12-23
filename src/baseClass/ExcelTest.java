package baseClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import library.Excel_config;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelTest 
{

	@Test(dataProvider="excel_value")
	public void data()
	{
		System.out.println();
		
		
	}
	
	
	
	
   @DataProvider(name="excel_value")
	public Object[][] excel() throws Exception
	{
	
		File obj1=new File("C:\\Users\\user\\TestExcel.xlsx");
		FileInputStream stream=new FileInputStream(obj1);
		XSSFWorkbook wb=new XSSFWorkbook(stream);
		XSSFSheet sheet=wb.getSheetAt(0);
		wb.close();
		int rows=sheet.getLastRowNum();
		int coloumns=sheet.getRow(0).getLastCellNum();
		
		Object[][] dataObject=new Object[rows][1];
		
		for(int i=0; i<rows; i++)
		{
		List<String> test_Data=new ArrayList<String>();
		List<Excel_config> test_data1=new ArrayList<Excel_config>();
		for (int j=0; j<coloumns; j++)
		{
		
//			Cell cell1=sheet.getRow(0).getCell(j);
//			Cell cell2=sheet.getRow(i+1).getCell(j);
			Cell cellType=sheet.getRow(i).getCell(j);
			
			if(cellType.getCellType()==Cell.CELL_TYPE_NUMERIC)
			{
				
				cellType.setCellType(Cell.CELL_TYPE_STRING);
				
			}
			
			String data_value=cellType.getStringCellValue();
			
			test_Data.add(data_value);
			test_data1.add((Excel_config) test_Data);
		}
		
		dataObject[i][0]=test_data1;

		}
		return dataObject;		
	}	
}
