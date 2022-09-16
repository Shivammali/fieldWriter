package com.main;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.bean.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FieldWriter extends FieldWriterVariables{
	
	public static void excelData()throws IOException {	
	System.setProperty("webdriver.chrome.driver","D:\\code\\Projects\\JAVA Projects\\eclipse\\fieldWriter\\files\\Driver\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	

	
		FieldWriter e1= new FieldWriter();
		
		
		String excelFilePath=FieldWriterVariables.data();
		FileInputStream inputstream=new FileInputStream(excelFilePath);
		XSSFWorkbook workbook=new XSSFWorkbook(inputstream);
		XSSFSheet sheet=workbook.getSheetAt(0);	//XSSFSheet sheet=workbook.getSheet("Sheet1");
	////  USING FOR LOOP
		
			int rows=sheet.getLastRowNum();
			int cols=sheet.getRow(1).getLastCellNum();
			boolean loginTrigger=false;
			for(int r=0;r<rows;r++)
			{
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
						
//						switch(cell.getCellType())
//						{	
//						
//						case NUMERIC: 
							System.out.print("Working With" + cell.getNumericCellValue());
//						break;
						
//						}
						
					}
					else if(c==2)  {
//						switch(cell.getCellType())
//						{
//						case STRING: 
//							//driver.findElement(By.id("email")).sendKeys(cell.getStringCellValue());
						driver.get(cell.getStringCellValue());
						
							System.out.print("Redirected to the page" + cell.getStringCellValue());
					
							driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("Shivam");
							driver.findElement(By.xpath("//input[@id='user_pass']")).sendKeys("Shivam123");
							driver.findElement(By.id("wp-submit")).click();
							
//						break;
//						
//						}
					}
					else if(c==3) {
//						switch(cell.getCellType())
//						{
//						case STRING: 
//							//driver.findElement(By.id("email")).sendKeys(cell.getStringCellValue());
							driver.findElement(By.xpath("//input[@id='title']")).sendKeys(cell.getStringCellValue());
							System.out.print("Exported values to First box" + cell.getStringCellValue());
//							
//						break;
//						
//						}
					}
					else if(c==4) {
//						switch(cell.getCellType())
//						{
//						case STRING: 
//							//driver.findElement(By.id("email")).sendKeys(cell.getStringCellValue());
							driver.findElement(By.id("content")).sendKeys(cell.getStringCellValue());
							System.out.print("Exported values to second box" + cell.getStringCellValue());
							driver.findElement(By.id("save-post")).click();
//						break;
//						
//						}
					}
				
					System.out.println("End of "+ c + "row");
					
					System.out.println("submitted the form");
				}
				System.out.println();
			} 
		
			

}

public static void main(String[] args)throws IOException 	{
	excelData();
	
	
}


}






