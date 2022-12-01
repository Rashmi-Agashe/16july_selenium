package LibraryFiles;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass
{
public WebDriver driver;
	
	public void initializeBrowser() throws IOException
	{
	    driver=new ChromeDriver();
		driver.get(UtilityClass.getPFData("URL"));
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}

}
