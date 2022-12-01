package module1_login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpstoxWelcomePage 
{
@FindBy(xpath="(//div[contains(text(),'No')])[2]") private WebElement NoAmGood;
	
	
	public UpstoxWelcomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickUpstoxWelcomePageNoAmGood() 
	{
		NoAmGood.click();
	}

}
