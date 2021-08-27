package com.app.test;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.config.Constants;
import com.app.config.PropLocation;
import com.app.config.ReadPropValues;
import com.app.util.CommonUtils;
import com.app.util.Log;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC_API_UserStory1 extends CommonUtils{
	PropLocation propFile=new PropLocation();
	ReadPropValues eleLocated=new ReadPropValues(propFile.elementLocation());
	String sValidResponse;
	String sErrorInvalidPatternBirthday;
	String sErrorInvalidGender;
	TC_API_UserStory1() throws Exception
	{
		sValidResponse=eleLocated.readProperty("validResponse");
		sErrorInvalidPatternBirthday=eleLocated.readProperty("errorInvalidPatternBirthday");
		sErrorInvalidGender=eleLocated.readProperty("errorInvalidGender");
	}
	
	@Test(priority=1)
	public void test_add_singleWorkingClassHero_validInputs() 
	{
		Log.info("Inside test_add_singleWorkingClassHero_validInputs..");
		HashMap<String,String> data=testDataSetup_Person("24031990","F","TestUser F_AG31","1234567890","10000.00","10.00");
		Log.info("Data inserted in body is: "+data);
		Response res=
				RestAssured.
				given()
				.contentType("application/json")
				.body(data)
				.when()
				.post(Constants.sSingleWorkingClassHeroInsertURL)
				.then()
				.statusCode(202)
				.log()
				.body()
				.extract().response();
		String jsonString=res.asString();
		Log.info("Json string response:"+jsonString);
		Log.info("Asserting valid message in response equals "+sValidResponse);
		Assert.assertEquals(jsonString.equals(sValidResponse),true);

	}
	@Test(priority=2)
	public void test_add_singleWorkingClassHero_invalidPatternBirthday() 
	{
		Log.info("Inside test_add_singleWorkingClassHero_invalidPatternBirthday..");
		HashMap<String,String> data=testDataSetup_Person("24-03-1990","F","TestUser InvalidDOBPattern","1234567890","10000.00","10.00");
		Log.info("Data inserted in body is: "+data);
		Response res=
				RestAssured.
				given()
				.contentType("application/json")
				.body(data)
				.when()
				.post(Constants.sSingleWorkingClassHeroInsertURL)
				.then()
				.statusCode(500)
				.log()
				.body()
				.extract().response();
		String jsonString=res.asString();
		Log.info("Json string response:"+jsonString);
		Log.info("Asserting error message in response contains "+sErrorInvalidPatternBirthday);
		Assert.assertEquals(jsonString.contains(sErrorInvalidPatternBirthday),true);

	}
	@Test(priority=3)
	public void test_add_singleWorkingClassHero_invalidGender() 
	{
		Log.info("Inside test_add_singleWorkingClassHero_invalidGender..");
		HashMap<String,String> data=testDataSetup_Person("24031990","Female","TestUser InvalidGender","1234567890","10000.00","10.00");
		Log.info("Data inserted in body is: "+data);
		Response res=
				RestAssured.
				given()
				.contentType("application/json")
				.body(data)
				.when()
				.post(Constants.sSingleWorkingClassHeroInsertURL)
				.then()
				.statusCode(500)
				.log()
				.body()
				.extract().response();
		String jsonString=res.asString();
		Log.info("Json string response:"+jsonString);
		Log.info("Asserting error message in response contains "+sErrorInvalidGender);
		Assert.assertEquals(jsonString.contains(sErrorInvalidGender),true);
		
	}
}
