package library;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_config 
{
		
		@SuppressWarnings("deprecation")
		public static org.apache.commons.collections4.map.MultiValueMap<String, String> getExcelMap() throws Exception
		{
			
			File obj1=new File("C:\\Users\\user\\TestExcel3.xlsx");
			FileInputStream stream=new FileInputStream(obj1);
			XSSFWorkbook wb=new XSSFWorkbook(stream);
			XSSFSheet sheet=wb.getSheetAt(0);
			wb.close();
			int rows=sheet.getLastRowNum();
			int coloumns=sheet.getRow(0).getLastCellNum();
			
			@SuppressWarnings({ "unchecked", "rawtypes" })
			org.apache.commons.collections4.map.MultiValueMap< String, String> superMap=new org.apache.commons.collections4.map.MultiValueMap();
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
				superMap.put(keyString, valueString);
			    }
		    }
			return superMap;
		}
		
		
		public static String getvalue(String key, String CompareValue) throws Exception
		{
			
			@SuppressWarnings("unchecked")
			Collection<String> values=(Collection<String>) getExcelMap().get(key);
			List<String> listValue=values.stream().filter(X->X.equals(CompareValue)).collect(Collectors.toList());
			String stringValue=listValue.get(0);
	        return stringValue;
		}
}
