package library;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_config 
{
		
		public static Map<String, Map<String, String>> getExcelMap() throws Exception
		{
			
			File obj1=new File("C:\\Users\\user\\TestExcel3.xlsx");
			FileInputStream stream=new FileInputStream(obj1);
			XSSFWorkbook wb=new XSSFWorkbook(stream);
			XSSFSheet sheet=wb.getSheetAt(0);
			wb.close();
			int rows=sheet.getLastRowNum();
			int coloumns=sheet.getRow(0).getLastCellNum();
			
			Map<String, Map<String, String>> superMap=new java.util.HashMap<String, Map<String, String>>();
			Map<String, String> childMap=new HashMap<String, String>();
			for(int i=0; i<rows; i++)
			{
				
			   for (int j=0; j<coloumns; j++)
			    {
				Cell keyCell=sheet.getRow(0).getCell(j);
				Cell valueCell=sheet.getRow(i+1).getCell(j);
				
				if(valueCell.getCellType()==Cell.CELL_TYPE_NUMERIC)
				{
					valueCell.setCellType(Cell.CELL_TYPE_STRING);
				}
				String keyString=keyCell.getStringCellValue();
				String valueString=valueCell.getStringCellValue();
				childMap.put(keyString, valueString);
			    }
			
			   superMap.put("MasterValue", childMap);
		    }
			return superMap;
		}
		
		
		public static String getvalue(String key) throws Exception
		{
			
			Map<String, String> mapValue=getExcelMap().get("MasterValue");
			String retValue=mapValue.get(key);
			return retValue;
		}
}
