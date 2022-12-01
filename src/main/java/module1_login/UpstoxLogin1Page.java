package module1_login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpstoxLogin1Page 
{
	//step1: variable declaration
		@FindBy(xpath="//input[@id='userCode']") private WebElement UN;  // private WebElement UN=driver.findElement(By.xpath(""));
		@FindBy(xpath="//input[@id='password']") private WebElement PWD;  // private WebElement PWD=driver.findElement(By.xpath(""));
		@FindBy(xpath="//div[text()='Sign into Upstox']") private WebElement loginBtn;  // private WebElement loginBtn=driver.findElement(By.xpath(""));
		
		//step2: variable initialization
		public UpstoxLogin1Page(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//step3: VARIABLE USAGE
		public void inpUpstoxLogin1PageUsername(String username) 
		{
			UN.sendKeys(username);
		}
		
		public void inpUpstoxLogin1PagePassword(String passowrd) 
		{
			PWD.sendKeys(passowrd);
		}
		
		public void clickUpstoxLogin1PageLoginBtn() 
		{
			loginBtn.click();
		}

}
