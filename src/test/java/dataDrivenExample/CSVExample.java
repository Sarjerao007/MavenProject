package dataDrivenExample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class CSVExample {
	WebDriver driver;
	//Properties prop;
	@BeforeMethod
	public void InitializeDriver() throws IOException{
//	String path=System.getProperty("user.dir")+
//			"//src//test//resources//config.properties";
//	prop=new Properties();
//	FileInputStream fin = new FileInputStream(path);
//	prop.load(fin);
//	String strBrowser = prop.getProperty("browser");
//	if(strBrowser.equalsIgnoreCase("Chrome")) {
//		driver=new ChromeDriver();
//	}
	
	driver=new ChromeDriver();
	
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)) ;
	driver.manage().window().maximize();
}
	
  @Test(dataProvider="getData")
  public void loginPageTest(String strUser, String strPass) {
		driver.get("https://the-internet.herokuapp.com/login");
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(strUser);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(strPass);
		driver.findElement(By.xpath("//button[@class='radius']")).click();
	 boolean isdisp=driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
			 Assert.assertTrue(isdisp);
  }
  @DataProvider(name="getData")
  public Object[][] getData() throws CsvValidationException, IOException {
	  String path=System.getProperty("user.dir")+
				"//src//test//resources//TestData//LoginData.csv";
	  CSVReader reader=new CSVReader(new FileReader(path));
	  String arr[];
	  ArrayList<Object> dataList= new ArrayList<Object>();
	  while((arr =reader.readNext())!=null){
		  Object[] record = {arr[0],arr[1]};
		  dataList.add(record);
	  }
	  return dataList.toArray(new Object[dataList.size()][]);
	  }
	  
  @AfterMethod
  public void teardown() {
	  driver.close();
	  
  }
  
}
