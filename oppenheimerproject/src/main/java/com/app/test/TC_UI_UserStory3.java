package com.app.test;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.app.config.Constants;
import com.app.config.PropLocation;
import com.app.config.ReadPropValues;
import com.app.util.CommonUtils;
import com.app.util.Log;

public class TC_UI_UserStory3 extends CommonUtils {
	PropLocation propFile=new PropLocation();
	ReadPropValues eleLocated=new ReadPropValues(propFile.elementLocation());
	
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browser) throws InterruptedException, IOException {
		setBrowser(browser);
	}
	
	@Test
	public void fileupload() {
		try {
		Log.info("Inside fileupload");
		Log.info("Before Upload asserting presence of records:" +eleLocated.readProperty("noRecordsHeaderTxt"));
		String actualText=driver.findElement(By.xpath(eleLocated.readProperty("noRecordsHeader"))).getAttribute("innerHTML");
		Log.info("Before Upload ,asserting header from UI: "+actualText+" is same as given Header: "+eleLocated.readProperty("noRecordsHeaderTxt"));
		assertTrue(actualText.contains(eleLocated.readProperty("noRecordsHeaderTxt")));
		Log.info("Assertion Complete");
		Thread.sleep(1000); 
		Log.info("Uploading the file..");
		String filename = Constants.csvDataFile;
	    File file = new File(filename);
	    String path = file.getAbsolutePath();
		WebElement chooseFile = 
				driver.findElement(By.xpath(eleLocated.readProperty("uploadFile")));
		//Thread.sleep(1000);
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Actions actions=new Actions(driver);
		actions.moveToElement(chooseFile).perform();
		//Thread.sleep(1000); 
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Log.info("Choosing the file to upload: "+path);
		chooseFile.sendKeys(path);;
		 
		   Log.info("Uploading File..");
		   
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		   Log.info("Clicking on Refresh Tax Relief Button");
		   driver.findElement(By.xpath(eleLocated.readProperty("btnRefreshTaxReliefTable"))).click();
		   
		  driver.navigate().refresh();
		   driver.get(Constants.BaseURL);
		   Thread.sleep(3000);
	
		   Log.info("Checking display of records loaded..");
		 
		   actions.moveToElement(driver.findElement(By.xpath(eleLocated.readProperty("tableCaption")))).perform();
		   driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		   if(driver.findElements(By.xpath(eleLocated.readProperty("tableCaption"))).size()>0)  {
			   Log.info("No records at the moment Header is not present..");
			   Log.info("***File is Uploaded Successfully****");
			   
			String uploadedRecordsData=  driver.findElement(By.xpath(eleLocated.readProperty("taxReliefZeroWorkingClass"))).getAttribute("innerHTML");
			Log.info("Uploaded Bulk data which is visible under Total Tax Relieves is: "+uploadedRecordsData);
		   }
		   else {
			   Log.info("No records at the moment Header is present..");
			   Log.info("File is NOT Uploaded Successfully");
		   }
		   
		}
		catch(Exception e) {
			Log.info("Inside Exception of fileUpload "+e.getMessage());
		}
		driver.close();   
	}
	
}
