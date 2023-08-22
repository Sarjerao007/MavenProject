package propertyFileExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PropertyClass {
	WebDriver driver;
	Properties prop;
	@BeforeMethod
	public void InitializeDriver() throws IOException{
	String path=System.getProperty("user.dir")+
			"//src//test//resources//config//config.properties";
	prop=new Properties();
	FileInputStream fin = new FileInputStream(path);
	prop.load(fin);
	String strBrowser = prop.getProperty("browser");
	if(strBrowser.equalsIgnoreCase("Chrome")) {
		driver=new ChromeDriver();
	}
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)) ;
	driver.manage().window().maximize();
}
	
  @Test
  public void loginPageTest() {
		driver.get("url");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//button[@class='radius']")).click();
	 boolean isdisp=driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
			 Assert.assertTrue(isdisp);
  }
  @AfterMethod
  public void teardown() {
	  driver.close();
	  
  }
  
}
