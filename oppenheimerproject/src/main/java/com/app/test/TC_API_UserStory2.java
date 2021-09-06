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
		HashMap<String,String> data1=testDataSetup_Person("06052002","F","Testuser F19 MU2a","3234567890","10000.17896","10.123");
		HashMap<String,String> data2=testDataSetup_Person("06091986","M","Testuser M35 MU2b","4234567890","9896.12398","9.000");
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
	public void test_add_multipleWorkingClassHero_validMoreThan3Inputs()
	{
		Log.info("test_add_multipleWorkingClassHero_valid3Inputs");
		List<Map<String,String>> multidata=new ArrayList<Map<String, String>>();


		HashMap<String,String> data1=testDataSetup_Person("06041985","F","Testuser F36 MU3a","5234567890","17965.8963","289.15890");
		HashMap<String,String> data2=testDataSetup_Person("20081971","M","Testuser M50 MU3b","6234567890","189632.01450","639.14896");
		HashMap<String,String> data3=testDataSetup_Person("20021970","F","Testuser F51 MU3c","7234567890","9862589.890","1896.013960");
		HashMap<String,String> data4=testDataSetup_Person("01091946","M","Testuser M75 MU3b","8234567890","989632.996328","39.89698");
		HashMap<String,String> data5=testDataSetup_Person("01121944","F","Testuser F76 MU3c","9234567890","9862589.156","1630.606");
		HashMap<String,String> data6=testDataSetup_Person("24031990","M","Testuser M31 MU1a","2334567890","10000.00","9999.00");
		HashMap<String,String> data7=testDataSetup_Person("24031990","F","Testuser F31 MU1xTaxabove50","3334567890","10000.00","990.00");
		multidata.add(data1);
		multidata.add(data2);
		multidata.add(data3);
		multidata.add(data4);
		multidata.add(data5);
		multidata.add(data6);
		multidata.add(data7);
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

		HashMap<String,String> data1=testDataSetup_Person("24031990","F","Testuser F31 MU1a","1334567890","10000.00","1.00");
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
