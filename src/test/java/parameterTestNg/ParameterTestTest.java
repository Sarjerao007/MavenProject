package parameterTestNg;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTestTest {
	
	WebDriver driver;
	@Parameters("browser")
	@BeforeMethod
	public void setup(String strBrowser) {
		if (strBrowser.equalsIgnoreCase("Chrome")) {
			driver=new ChromeDriver();
		}else if (strBrowser.equalsIgnoreCase("Chrome")) {
			driver=new FirefoxDriver();
		}
	
	driver.manage().window().maximize();
	}
  @Test
  public void ParameterTest() {
	  
		driver.navigate().to("https://www.google.com/");
		//driver.get("https://www.google.com/");
		WebElement webelement=driver.findElement(By.id("APjFqb"));
		webelement.sendKeys("Java Tutorial");
		webelement.sendKeys(Keys.ENTER);
		String title=driver.getTitle();
		System.out.println("The Page Title is  "+title);
  }
  
  @AfterMethod
  public void teardown() {
	  
	  driver.close();
  }
}
