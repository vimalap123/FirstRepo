package datadriven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class dd {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream file=new FileInputStream("C:\\Users\\Admin\\Desktop\\Book1.xlsx");
	    XSSFWorkbook workbook=new XSSFWorkbook(file);
	    XSSFSheet sheet=workbook.getSheet("Sheet1"); //providing sheet name//for index method getSheetAt(o)
	    // XSSFSheet sheet=workbook.getSheetAt(0);
	 
	    int rowcount=sheet.getLastRowNum();//return the row count
	    //int cellcount=sheet.getRow(0).getLastCellNum();//RETURNS CELL COUNT
	 
	    for(int i=1;i<=rowcount;i++) 
	    {
		XSSFRow currentrow= sheet.getRow(i); //focus on current row
	
		String username=currentrow.getCell(0).toString();
		String password=currentrow.getCell(1).toString();
		//read the value from a cell
		System.out.println(username);
		System.out.println(password);
		
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.manage().window().maximize();
	    driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys(username);
		driver.findElement(By.name("inputPassword")).sendKeys(password);
		driver.findElement(By.className("signInBtn")).click();
		//driver.quit();
	
	   }
	 }

	}
