package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingpage {

public WebDriver driver;
	
	By signin=By.cssSelector("a[href*='sign_in']");
	By emailaddress=By.name("email");
	By pass=By.name(" password");
	By submit=By.name("commit");
	By title=By.cssSelector(".text-center>h2");
	By navigationbar=By.xpath("//*[@id='homepage']/header/div[2]");
	
	

	public landingpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
	

	public WebElement getlogin() {
		// TODO Auto-generated method stub
		return driver.findElement(signin);
	}
	public WebElement emailaddress() {
		// TODO Auto-generated method stub
		return driver.findElement(emailaddress);
	}
	
	public WebElement pass() {
		// TODO Auto-generated method stub
		return driver.findElement(pass);
	}
	public WebElement submit() {
		// TODO Auto-generated method stub
		return driver.findElement(submit);
	}
	
	public WebElement gettitle() {
		// TODO Auto-generated method stub
		return driver.findElement(title);
	}
	public WebElement navigationbar() {
		// TODO Auto-generated method stub
		return driver.findElement(navigationbar);
	}
	
	
}

