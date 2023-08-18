package commonUtil;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;

public class Utility{
	
	public static String getScreenshotPath(WebDriver driver) {
		TakesScreenshot screen = (TakesScreenshot)driver;
		File src=screen.getScreenshotAs(OutputType.FILE);
		String scrfile= System.getProperty("user.dir")
		+"/screenshots"
		+System.currentTimeMillis()
		+ ".png";
		
		File dest=new File(scrfile);
		try {
			FileUtils.copyFile(src, dest);
		}
	catch(IOException e) {
		e.printStackTrace();
		}
		
		return scrfile;
		
	}
}
