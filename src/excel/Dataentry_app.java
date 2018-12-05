package excel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataentry_app {
	WebDriver driver;
	@Test(dataProvider="credentieanls")
	public void dataentry(String username,String password) {
		 System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
	     driver = new ChromeDriver();


	     driver.manage().window().maximize();
	     driver.get("https://www.freecrm.com/index.html");
	     driver.findElement(By.name("username")).sendKeys(username);
	     driver.findElement(By.name("password")).sendKeys(password);
	     driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	     driver.findElement(By.xpath("//input[@type='submit']")).click();
	     Assert.assertTrue(driver.getTitle().contains("CRMPRO"));
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	@DataProvider(name="credentieanls")
	public Object retrivedata() {
		Utility a1=new Utility("data/New Microsoft Excel Worksheet.xlsx");
		int rows=a1.getrownum(0);
		Object[][] data= new Object[rows][2];
		for(int i=0;i<rows;i++) {
			data[i][0]=a1.getdata(0, i,0);
			data[i][1]=a1.getdata(0, 1, 1);
		}
		
		return data;
		
	}
	}


