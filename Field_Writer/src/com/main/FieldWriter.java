package com.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.bean.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class FieldWriter extends FieldWriterVariables{
	
	public static void excelData()throws IOException {	
	System.setProperty("webdriver.chrome.driver","D:\\code\\Projects\\JAVA Projects\\eclipse\\fieldWriter\\files\\Driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	

	
	
		
		ExcelWriter excelWriter=new ExcelWriter();
		String excelFilePath=FieldWriterVariables.importData();
		FileInputStream inputstream=new FileInputStream(excelFilePath);
		XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=workbook.getSheetAt(0);	//XSSFSheet sheet=workbook.getSheet("Sheet1");
	////  USING FOR LOOP

			int rows=sheet.getLastRowNum();
			int cols=sheet.getRow(1).getLastCellNum();
			boolean loginTrigger=false;
			String linkLocation;
			double cellNumber = 0 ;
			int rowNumber=0;
			String cellNumberString="";
			
			
			
			
			
			for(int r=0;r<=rows;r++)
			{
				rowNumber=r;
				XSSFRow row=sheet.getRow(r); //0

				   try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				for(int c=0;c<cols;c++)
				{
					
					XSSFCell cell=row.getCell(c);
					
					if(c==0){

							System.out.print("Working With" + cell.getNumericCellValue());
							cellNumber=cell.getNumericCellValue();
							cellNumberString =String.valueOf(cellNumber);
						System.out.println(cellNumber);
					}
					else if(c==2)  {
				

						driver.get(cell.getStringCellValue());
						
							System.out.print("Redirected to the page" + cell.getStringCellValue());
//					if(loginTrigger=false) {
//							driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("Shivam");
//							driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("Shivam123");
//							   try {
//									Thread.sleep(3000);
//								} catch (InterruptedException e) {
//									// TODO Auto-generated catch block
//									e.printStackTrace();
//								}
//							driver.findElement(By.id("wp-submit")).click();
//							loginTrigger=true;
//					} for wordpress login menu

					}
					else if(c==3) {

//							driver.findElement(By.xpath("//input[@id='title']")).sendKeys(cell.getStringCellValue());
							driver.findElement(By.name("MultiLine")).sendKeys(cell.getStringCellValue());
							System.out.print("Exported values to First box" + cell.getStringCellValue());

					}
					else if(c==4) {

//							driver.findElement(By.id("content")).sendKeys(cell.getStringCellValue());
						driver.findElement(By.name("MultiLine1")).sendKeys(cell.getStringCellValue());
							System.out.print("Exported values to second box" + cell.getStringCellValue());
							   try {
									Thread.sleep(3000);
								} catch (InterruptedException e) {
								
									e.printStackTrace();
								}
							   driver.findElement(By.xpath("//button[contains(@value,'submit')]")).click();
							   System.out.println("submitted the form");
							   try {
									Thread.sleep(3000);
								} catch (InterruptedException e) {
								
									e.printStackTrace();
								}
							   WebElement link= driver.findElement(By.className("btnLink"));
							   linkLocation = link.getAttribute("href");
							   System.out.println("Link Location "+linkLocation);
							   
							   int rownum=rowNumber;
							   
							   XSSFRow row2=sheet.createRow(rownum);
								 row2.createCell(0).setCellValue(cellNumberString);
								 row2.createCell(1).setCellValue(linkLocation);
								 

								String filePath=FieldWriterVariables.exportData();;
								FileOutputStream outstream=new FileOutputStream(filePath);
								workbook.write(outstream);

								outstream.close();
								
								System.out.println("Data is written on" + rownum);
							   
							   
							   
							   
							   
							   
							   
							   
							   
							   
							   
							   
							   
							   
								// excelWriter.fieldExport(cellNumberString,linkLocation,rowNumber);
								
//							driver.findElement(By.id("save-post")).click();
					}
				
				
					
					
					
					 
				
				}
				System.out.println("End of "+ r + "row");
				System.out.println();
			} 
				
		
			

}

public static void main(String[] args)throws IOException 	{
	excelData();
	//ExcelWriter excelWriter=new ExcelWriter();
	
	
	
}


}






