package com.main;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.bean.FieldWriterVariables;
import com.main.FieldWriter; 


public class ExcelWriter{
	
	
	public static void fieldExport( String cellNumberString,String linkLocation,int rowNumber) throws IOException{
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Posted links");
	
//	 ArrayList<Object[]> linkData=new ArrayList<Object[]>();
//   
//	 linkData.add(new Object[]{cellNumberString,linkLocation});
//	 linkData.add(new Object[]{"Empid","Name"});
	

	/// using for...each loop
	
      int rownum=rowNumber;
      
//      for(Object[] link:linkData)
//      {
//    	  XSSFRow row=sheet.createRow(rownum);
//    	 int cellnum=0; 
//    	  
//    	  for(Object value:link)
//            {
//    		  XSSFCell cell=row.createCell(cellnum++);
//				
//				if(value instanceof String)
//						cell.setCellValue((String)value);
//				if(value instanceof Integer)
//						cell.setCellValue((Integer)value);
//				if(value instanceof Boolean)
//					cell.setCellValue((Boolean)value);	
//				
//    	  }
//      }
      
      XSSFRow row=sheet.createRow(rownum);
	 row.createCell(0).setCellValue(cellNumberString);
	 row.createCell(1).setCellValue(linkLocation);
	 

	String filePath=FieldWriterVariables.exportData();;
	FileOutputStream outstream=new FileOutputStream(filePath);
	workbook.write(outstream);

	outstream.close();
	
	System.out.println("Data is written on" + rownum);

}
}


