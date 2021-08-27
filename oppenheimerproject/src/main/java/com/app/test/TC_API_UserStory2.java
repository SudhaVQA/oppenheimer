package com.app.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.config.Constants;
import com.app.config.PropLocation;
import com.app.config.ReadPropValues;
import com.app.util.CommonUtils;
import com.app.util.Log;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC_API_UserStory2 extends CommonUtils{
	PropLocation propFile=new PropLocation();
	ReadPropValues eleLocated=new ReadPropValues(propFile.elementLocation());
	String sValidResponse;
	
	TC_API_UserStory2() throws Exception
	{
		sValidResponse=eleLocated.readProperty("validResponse");
	}
	
	@Test(priority=1)
	public void test_add_multipleWorkingClassHero_valid2Inputs() throws Exception
	{
		Log.info("test_add_multipleWorkingClassHero_valid2Inputs");
		List<Map<String,String>> multidata=new ArrayList<Map<String, String>>();
		HashMap<String,String> data1=testDataSetup_Person("24031990","F","Testuser MU2a","2234567890","10000.00","10.00");
		HashMap<String,String> data2=testDataSetup_Person("12031990","M","Testuser MU2b","3234567890","10000.00","10.00");
		multidata.add(data1);
		multidata.add(data2);
		Log.info("Data inserted in body is: "+multidata);
		
		Response res=
				RestAssured.
				given()
				.contentType("application/json")
				.body(multidata)
				.when()
				.post(Constants.sMultiWorkingClassHeroInsertURL)
				.then()
				.statusCode(202)
				.log().body()
				.extract().response();
		String jsonString=res.asString();
		Log.info("Json string response:"+jsonString);
		Log.info("Asserting valid message in response equals "+sValidResponse);
		Assert.assertEquals(jsonString.equals(sValidResponse),true);

	}
	@Test(priority=2)
	public void test_add_multipleWorkingClassHero_valid3Inputs()
	{
		Log.info("test_add_multipleWorkingClassHero_valid3Inputs");
		List<Map<String,String>> multidata=new ArrayList<Map<String, String>>();


		HashMap<String,String> data1=testDataSetup_Person("24031990","F","Testuser MU3a","4234567890","10000.00","10.00");
		HashMap<String,String> data2=testDataSetup_Person("12031990","M","Testuser MU3b","5234567890","10000.00","10.00");
		HashMap<String,String> data3=testDataSetup_Person("12031990","M","Testuser MU3c","6234567890","10000.00","10.00");

		multidata.add(data1);
		multidata.add(data2);
		multidata.add(data3);
		Log.info("Data inserted in body is: "+multidata);
		Response res=
				RestAssured.
				given()
				.contentType("application/json")
				.body(multidata)
				.when()
				.post(Constants.sMultiWorkingClassHeroInsertURL)
				.then()
				.statusCode(202)
				.log().body()
				.extract().response();
		String jsonString=res.asString();
		Log.info("Json string response:"+jsonString);
		Log.info("Asserting valid message in response equals "+sValidResponse);
		Assert.assertEquals(jsonString.equals(sValidResponse),true);

	}
	@Test(priority=3)
	public void test_add_multipleWorkingClassHero_valid1Inputs()
	{
		Log.info("test_add_multipleWorkingClassHero_valid1Inputs");
		List<Map<String,String>> multidata=new ArrayList<Map<String, String>>();

		HashMap<String,String> data1=testDataSetup_Person("24031990","F","Testuser MU1a","7234567890","10000.00","10.00");
		multidata.add(data1);
		Log.info("Data inserted in body is: "+multidata);
		
		Response res=
				RestAssured.
				given()
				.contentType("application/json")
				.body(multidata)
				.when()
				.post(Constants.sMultiWorkingClassHeroInsertURL)
				.then()
				.statusCode(202)
				.log().body()
				.extract().response();
		String jsonString=res.asString();
		Log.info("Json string response:"+jsonString);
		Log.info("Asserting valid message in response equals "+sValidResponse);
		Assert.assertEquals(jsonString.equals(sValidResponse),true);

	}

}
