package Module1_Login_Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import module1_login.UpstoxHomePage;
import module1_login.UpstoxLogin1Page;
import module1_login.UpstoxLogin2Page;
import module1_login.UpstoxWelcomePage;

public class UpstoxLoginTest extends BaseClass
{
	UpstoxLogin1Page login1;
	UpstoxLogin2Page login2;
	UpstoxWelcomePage welcome;
	UpstoxHomePage home;
	int TCID;
			
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException
	{
	    initializeBrowser();
		 login1 =new UpstoxLogin1Page(driver);
		 login2  =new UpstoxLogin2Page(driver);
		 welcome =new UpstoxWelcomePage(driver);
	     home = new UpstoxHomePage(driver);
	}
	
	@BeforeMethod
	public void loginToApp() throws EncryptedDocumentException, IOException, InterruptedException 
	{
		login1.inpUpstoxLogin1PageUsername(UtilityClass.getPFData("UN"));
		login1.inpUpstoxLogin1PagePassword(UtilityClass.getPFData("PWD"));
		login1.clickUpstoxLogin1PageLoginBtn();
		login2.inpUpstoxLogin2PageYOB(UtilityClass.getPFData("YOB"));
		Thread.sleep(3000);
		welcome.clickUpstoxWelcomePageNoAmGood();
}
	
	@Test
	public void verifyUserID() throws EncryptedDocumentException, IOException
	{
		TCID=101;
		String actPN = home.getUpstoxHomePageActPN();
		String expPN =UtilityClass.getTD(0,3);
		Assert.assertEquals(actPN, expPN,"Failed: both results are diff");
	}
	
	@AfterMethod
	public void logoutFromApp(ITestResult s1) throws IOException 
	{
		if(s1.getStatus()==ITestResult.FAILURE)
		{
			UtilityClass.captureScreenshot(driver, TCID);
		}
		//logout code
	}
	
	@AfterClass
	public void closeBrowser()
	{
		//driver.quit();
	}

}
