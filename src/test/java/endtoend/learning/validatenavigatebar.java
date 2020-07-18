package endtoend.learning;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobject.landingpage;
import resources.base;

public class validatenavigatebar extends base {
	public WebDriver driver;
	
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initial() throws IOException {
		driver=initializedriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void basepagenavigation() throws IOException {
		
	
	
	
	landingpage lp=new landingpage(driver);
	
	Assert.assertTrue(lp.navigationbar().isDisplayed());
	
	log.info("navigation bar is displayed");
	
	
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		
	}
	
	

}
