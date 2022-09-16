package com.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter{
	public static void fieldExport() throws IOException{
	XSSFWorkbook workbook=new XSSFWorkbook();
	XSSFSheet sheet=workbook.createSheet("Emp Info");
	
	 ArrayList<Object[]> empdata=new ArrayList<Object[]>();
     
	  empdata.add(new Object[]{"Empid","Name","Job"});
      empdata.add(new Object[]{101,"David","Enginner"});
      empdata.add(new Object[]{102,"Smith","Manager"});
      empdata.add(new Object[]{103,"Scott","Analyst"});
	
	
	
	/// using for...each loop
	
      int rownum=0;
      
      for(Object[] emp:empdata)
      {
    	  XSSFRow row=sheet.createRow(rownum++);
    	 int cellnum=0; 
    	  
    	  for(Object value:emp)
            {
    		  XSSFCell cell=row.createCell(cellnum++);
				
				if(value instanceof String)
						cell.setCellValue((String)value);
				if(value instanceof Integer)
						cell.setCellValue((Integer)value);
				if(value instanceof Boolean)
					cell.setCellValue((Boolean)value);	
    	  }
      }
	
      
	String filePath=".\\datafiles\\employee4.xlsx";
	FileOutputStream outstream=new FileOutputStream(filePath);
	workbook.write(outstream);
	
	outstream.close();
	
	System.out.println("Employee4.xls file written successfully...");

}
}


