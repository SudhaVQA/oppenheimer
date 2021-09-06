package com.app.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.app.config.PropLocation;
import com.app.config.ReadPropValues;
import com.app.util.CommonUtils;
import com.app.util.Log;
import org.openqa.selenium.support.Color;

public class TC_UI_UserStory5 extends CommonUtils{
	PropLocation propFile=new PropLocation();
	ReadPropValues eleLocated=new ReadPropValues(propFile.elementLocation());
	WebElement button;
	@Parameters({"browser"})
	@BeforeTest
	public void setUp(String browser) throws InterruptedException, IOException {
		setBrowser(browser);
	}

	
	@Test
	public void verifyButtonColorIsRed() {
		try {
			Log.info("Inside verifyButtonColorIsRed ");
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		button=driver.findElement(By.xpath(eleLocated.readProperty("btnDispenseNow")));
		Actions actions=new Actions(driver);
		actions.moveToElement(button).perform();
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		String buttonColor = button.getCssValue("background-color");
        String expectedbuttonColor = "#c82333";
        Log.info("Button color: " + buttonColor);
        Log.info("Text color " + expectedbuttonColor);
        Log.info("Asserting the hex color of the background of button text is.."+expectedbuttonColor);
        String hexColorValue = Color.fromString(buttonColor).asHex();
        Log.info("Button color from UI in  hex: " + hexColorValue);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        //Verify if actual and expected color values are equal?
        Assert.assertEquals(hexColorValue, expectedbuttonColor);
    	Assert.assertEquals(buttonColor.equals(buttonColor),true);
		}catch (Exception e) {
   		 Log.info("Inside Exception of verifyButtonColorIsRed "+e.getMessage());
		}
	}
	@Test
	public void verifyButtonTextIsDispenseNow() {
		try {
			Log.info("Inside verifyButtonTextIsDispenseNow ");
		 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		 button=driver.findElement(By.xpath(eleLocated.readProperty("btnDispenseNow")));
		String btnText;
		
		btnText = eleLocated.readProperty("btnDispensenNowText");
	
	String btnTextFromUI=button.getAttribute("innerHTML");
	Log.info("Button text mfrom UI: "+btnTextFromUI);
	Log.info("Asserting the button text matched exactly the text: "+btnText);
	Assert.assertEquals(btnTextFromUI.equals(btnText),true);
	 driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		}catch (Exception e) {
	   		 Log.info("Inside Exception of verifyButtonTextIsDispenseNow "+e.getMessage());
			}
	}
	
	@Test
	public void verifyBtnClickRedirectsToPagewithText_Cashdispensed() 
	{
		try {
			Log.info("Inside verifyBtnClickRedirectsToPagewithText_Cashdispensed ");
			button=driver.findElement(By.xpath(eleLocated.readProperty("btnDispenseNow")));
    	Log.info("Clicking on button Dispense Now");
    	button.click();
    	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	WebElement txtDispenseNow=driver.findElement(By.xpath(eleLocated.readProperty("DispenseMsg")));
    	String dispenseMsgfromUI= txtDispenseNow.getAttribute("innerHTML");
    	Log.info("Dispense text from UI: "+dispenseMsgfromUI);
    	String givenText=eleLocated.readProperty("txtDispenseMsg");
    	Log.info("Asserting the message matched exactly the given text: "+givenText);
    	Assert.assertEquals(dispenseMsgfromUI.equals(givenText),true);
    	
    	// driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    	 
    	 Log.info("Assert successful..");	
    	 
		}
    	 catch (Exception e) {
    		 Log.info("Inside Exception of dispenseNow "+e.getMessage());
 		}
		driver.close();
	}


	
}
