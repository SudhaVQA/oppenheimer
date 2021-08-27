package com.app.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.app.config.Constants;
import com.app.config.PropLocation;
import com.app.config.ReadPropValues;
import com.ibm.icu.text.SimpleDateFormat;

public class CommonUtils {
	protected WebDriver driver;
	static String parent;
	PropLocation propFile=new PropLocation();
	ReadPropValues eleLocated=new ReadPropValues(propFile.elementLocation());
	
	public void setBrowser(String browser) throws InterruptedException
	{
		DOMConfigurator.configure("log4j.xml");
		try {
			Log.info("Inside setBrowser..");	
			if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", Constants.firefoxDriverPath);
				driver = new FirefoxDriver();
				Log.info("Browser Configured: "+browser);
			}
				
			else if (browser.equalsIgnoreCase("Chrome")) {		
				System.setProperty("webdriver.chrome.driver",Constants.chromeDriverPath);
				driver = new ChromeDriver();
				Log.info("Browser Configured: "+browser);
			} 
			driver.get(Constants.BaseURL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		} catch (WebDriverException e) {
			String errorMessage=e.getMessage();
			Log.info(errorMessage);
		}catch (Exception e) {
			String errorMessage = String.format("Error in method setBrowser");
		       Log.info(errorMessage);
			}
	}
	public void waitForElement(By path) {
		try {
			Log.info("waitForElement: "+path);
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(path));
		}
		catch (Exception e) {
			String errorMessage = String.format("Error in method waitForElement");
		       Log.info(errorMessage);
			}
	}
	
	public void clickElement(By path) {
		try {
			
		Log.info("Inside click.."+path);
		waitForElement(path);
		driver.findElement(path).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		 catch (Exception e) {
				String errorMessage = String.format("Error in method clickElement");
		       Log.info(errorMessage);
			}	
	}
	public void tearDown() {
		try {
			Log.info("Inside tearDown..");	
		driver.quit();
		}catch(Exception e) {
			String errorMessage = String.format("Error in method tearDown");
		       Log.info(errorMessage);		      
		}
    }
	
	public HashMap<String,String> testDataSetup_Person(String sDOB,String sGender,String sName,String sNatId,String sSalary,String sTax) {

		HashMap<String,String> data=new HashMap<String, String>();
		data.put("birthday",sDOB);
		data.put("gender", sGender);
		data.put("name", sName);
		data.put("natid", sNatId);
		data.put("salary", sSalary);
		data.put("tax", sTax);
		return data;

	}
	
	public String calculateTax(String sDOB,String sGender,String sName,String sNatId,String sSalary,String sTax) throws ParseException {
		
		String sFinalTaxRelief;
		int iAge;
		double dSalary=Double.parseDouble(sSalary);
		double dTax=Double.parseDouble(sTax);
		String sDate1=sDOB;
		int iGenderBonus = 0;
		Date date1=new SimpleDateFormat("ddMMyyyy").parse(sDate1);
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		System.out.println(sDate1+"\t"+date1);
		Calendar c = Calendar.getInstance();
		  c.setTime(date1);
		  int year = c.get(Calendar.YEAR);
		  int month = c.get(Calendar.MONTH) + 1;
		  int date = c.get(Calendar.DATE);
		  LocalDate l1 = LocalDate.of(year, month, date);
		  LocalDate now1 = LocalDate.now();
		  Period diff1 = Period.between(l1, now1);
		  iAge=diff1.getYears();
		  System.out.println("age:" + iAge + "years");

		  
		double dVariable=0;
		double dTaxRelief=0;
		if(iAge<=18) {
			dVariable=1;
		}else if(iAge>18&&iAge<=35) {
			dVariable=0.8;
		}else if(iAge>35&&iAge<=50) {
			dVariable=0.5;
		}else if(iAge>50&&iAge<=75) {
			dVariable=0.367;
		}else if(iAge>75) {
			dVariable=0.05;
		}
		
		if(sGender.equalsIgnoreCase("F")) {
			iGenderBonus=500;
		}
		else if(sGender.equalsIgnoreCase("M")) {
			iGenderBonus=0;
		}
		dTaxRelief=((dSalary-dTax)*dVariable)+iGenderBonus;
		System.out.println("Calculated Tax Relief without truncation: "+dTaxRelief);
		decimalFormat.setRoundingMode(RoundingMode.UP);
		String sTaxReliefAfterRounding=decimalFormat.format(dTaxRelief);
		System.out.println("Calculated Tax Relief with truncation: "+sTaxReliefAfterRounding);
		Double dTaxReliefAfterRounding=Double.parseDouble(sTaxReliefAfterRounding);
		if(dTaxReliefAfterRounding>0.00&&dTaxReliefAfterRounding<50.00) {
			dTaxReliefAfterRounding=50.00;
		}
		sFinalTaxRelief=dTaxReliefAfterRounding.toString();
		return sFinalTaxRelief;
		
	}
	public String calculateNatid(String sDOB,String sGender,String sName,String sNatId,String sSalary,String sTax){
		
		Log.info("Inside calculateNatid");
		Log.info("Length of String: " + sNatId.length());
		
		String maskednatId = "";
		for (int i = 0; i < sNatId.length(); i++) {
			if(i<4) {
				maskednatId=maskednatId+sNatId.charAt(i);
			}else {
				maskednatId=maskednatId+"$";
			}
        }
		
		return maskednatId;
		
	}
	
}
