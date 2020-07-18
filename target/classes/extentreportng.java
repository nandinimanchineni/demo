package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentreportng {
	
	static ExtentReports extent;

	public static ExtentReports getReportObject()
	{
		
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "nandini");
		
		return extent;
	}
	
	@Test
	public void initialdemo()
	{
		
	
		
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Desktop\\Selenium Notes\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://qaclickacademy.com/");
		System.out.println(driver.getTitle());
		driver.close();

		
		
		extent.flush();
		
		
		
		
	}


		

	
}
