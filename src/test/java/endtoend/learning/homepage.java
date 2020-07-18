package endtoend.learning;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobject.landingpage;
import resources.base;

public class homepage extends base{
	public WebDriver driver;
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initial() throws IOException {
		driver=initializedriver();
		driver.get(prop.getProperty("url"));
		
	}
	
	@Test(dataProvider="getdata")
	public void basepagenavigation(String emailaddress, String password, String text) throws IOException
		{
		driver.get(prop.getProperty("url"));	
		landingpage lp=new landingpage(driver);
		
		lp.getlogin().click();		
	lp.emailaddress().sendKeys(emailaddress);
	lp.pass().sendKeys(password);
	lp.submit().click();
	
	log.info(text);
	
	}
	
	@AfterTest
	public void teardown() {
		driver.close();
		
	}
	
	
	@DataProvider
	public Object[][] getdata()
	{
		
		Object[][] data=new Object[2][3];
		data[0][0]="username1";
		data[0][1]="password1";
		data[0][2]="restricted user";
		
		data[1][0]="username2";
		data[1][1]="password2";
		data[1][2]="non restricted user";
		
		return data;
		
	}

}

