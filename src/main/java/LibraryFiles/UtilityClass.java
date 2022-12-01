package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	
		
		public static String getTD(int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException
		{
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\TestDataMaven\\Book1.xlsx");
		    Sheet sh = WorkbookFactory.create(file).getSheet("Sheet5");
		    String value = sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
		    return value;
		}
		
		public static void captureScreenshot(WebDriver driver,int TCID) throws IOException
		{
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest=new File(System.getProperty("user.dir")+"\\FailedTestcasesScreenshot\\TestCaseID"+TCID+".jpg");
			FileHandler.copy(src, dest);
		}
		
		
		public static String getPFData(String  key) throws IOException
		{
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\Propertyfile.properties");
			
			Properties p=new Properties();
			p.load(file);
			
			String value = p.getProperty(key);
			return value;
		}

	}



