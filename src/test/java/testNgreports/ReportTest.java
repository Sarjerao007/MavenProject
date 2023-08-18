package testNgreports;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportTest {
	
	WebDriver driver;
	ExtentReports extenReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	@BeforeTest
	public void setupExtent() {
		extenReports=new ExtentReports();
		spark=new ExtentSparkReporter("test-output/SparkRport.html");
		extenReports.attachReporter(spark);
		
	}
	
	
	@BeforeMethod
	public void setup() {
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	}
  @Test
  public void TutorialTest() {
	  extenReports.createTest("Search Java tutorial");
		driver.navigate().to("https://www.google.com/");
		//driver.get("https://www.google.com/");
		WebElement webelement=driver.findElement(By.id("APjFqb"));
		webelement.sendKeys("Java Tutorial");
		webelement.sendKeys(Keys.ENTER);
		String title=driver.getTitle();
		System.out.println("The Page Title is  "+title);
  }
  @Test
  public void Cucmber() {
	  
	  extenReports.createTest("Search Cucumber");
			driver.navigate().to("https://www.google.com/");
			//driver.get("https://www.google.com/");
			WebElement webelement=driver.findElement(By.id("APjFqb"));
			webelement.sendKeys("Cucumber");
			webelement.sendKeys(Keys.ENTER);
			String title=driver.getTitle();
			System.out.println("The Page Title is  "+title);
  }
  
  @AfterMethod
  public void teardown() {
	  
	  driver.close();
  }
  
  @AfterTest
  public void finishExtent() {
	  extenReports.flush();
	  
  }
}
