package com.main;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.bean.*;

public class FieldWriter extends FieldWriterVariables{
	
	public static void excelData()throws IOException {
	
		FieldWriter e1= new FieldWriter();
		
		
		String excelFilePath=FieldWriterVariables.data();
		FileInputStream inputstream=new FileInputStream(excelFilePath);
		XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=workbook.getSheetAt(0);	//XSSFSheet sheet=workbook.getSheet("Sheet1");
	////  USING FOR LOOP
		
			int rows=sheet.getLastRowNum();
			int cols=sheet.getRow(1).getLastCellNum();
			
			for(int r=0;r<=rows;r++)
			{
				XSSFRow row=sheet.getRow(r); //0
				
				for(int c=0;c<cols;c++)
				{
					XSSFCell cell=row.getCell(c);
					
					switch(cell.getCellType())
					{
					case STRING: 
						System.out.print(cell.getStringCellValue());
					break;
					case NUMERIC: 
						System.out.print(cell.getNumericCellValue());
					break;
					case BOOLEAN: 
						System.out.print(cell.getBooleanCellValue());
					break;
					}
					System.out.print(" | ");
				}
				System.out.println();
			} 


}

public static void main(String[] args)throws IOException 	{
	excelData();
	
}


}






