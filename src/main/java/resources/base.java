package resources;



import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class base {

	public WebDriver driver;	
	public Properties prop;
	
	public WebDriver initializedriver() throws IOException
	{
		 prop=new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\endtoendproj\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	String browsername=prop.getProperty("browser");
	
	
	if(browsername.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\Selenium Notes\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
	}
	else if(browsername.equals("firefox"))
	{
		//firefox code
	}
	else if(browsername.equals("IE"))
	{
		//IE code
	}
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	return driver;
	}
	
	public void getscreenshotpath(String testcasename,WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationfile=System.getProperty("user.dir")+"\\reports\\"+testcasename+".png";
		//FileUtils.copyFile(source, new File(destinationfile));
		
		FileUtils.copyFile(source, new File(destinationFile));
		
		
	}
}
