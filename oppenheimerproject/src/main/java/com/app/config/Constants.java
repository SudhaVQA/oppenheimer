package com.app.config;

public class Constants {

	public static final String firefoxDriverPath=System.getProperty("user.dir")+"/src/test/resources/artifacts/geckodriver.exe";
	public static final String chromeDriverPath=System.getProperty("user.dir")+"/src/test/resources/artifacts/chromedriver.exe";
	public static final String csvDataFile=System.getProperty("user.dir")+"/src/test/resources/artifacts/TestData.csv";
	//"C:\\Users\\sudha\\eclipse-workspace\\oppenheimerproject\\src\\test\\resources\\artifacts"
	public static final String sSingleWorkingClassHeroInsertURL="http://localhost:8080/calculator/insert";
	public static final String sMultiWorkingClassHeroInsertURL="http://localhost:8080/calculator/insertMultiple";
	public static final String BaseURL="http://localhost:8080/";
	public static final String sMultiWorkingClassHeroGetURL="http://localhost:8080/calculator/taxRelief";
}
