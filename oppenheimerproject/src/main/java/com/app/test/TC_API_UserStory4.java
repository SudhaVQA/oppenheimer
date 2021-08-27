package com.app.test;

import java.text.ParseException;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.config.Constants;
import com.app.config.PropLocation;
import com.app.config.ReadPropValues;
import com.app.util.CommonUtils;
import com.app.util.Log;


import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC_API_UserStory4 extends CommonUtils {

	
	PropLocation propFile=new PropLocation();
	ReadPropValues eleLocated=new ReadPropValues(propFile.elementLocation());
	
	@Test(priority=1)
	public void test_get_TaxRelief_WorkingClassHero() throws ParseException 
	{
		Log.info("Inside test_get_TaxRelief_WorkingClassHero..");
	//	HashMap<String,String> data=testDataSetup_Person("24031990","F","TestUser F_AG31","1234567890","10000.00","10.00");
	//	Log.info("Data inserted in body is: "+data);
		Response res=
				RestAssured.
				given()
				.contentType("application/json")
				.when()
				.get(Constants.sMultiWorkingClassHeroGetURL)
				.then()
				.statusCode(200)
				.log()
				.body()
				.extract().response();
				String jsonString=res.asString();
		Log.info("Json string response:"+jsonString);

		
		/*
		 * Log.info("Asserting valid message in response equals "+sValidResponse);
		 * Assert.assertEquals(jsonString.equals(sValidResponse),true);
		 */
		//(String sDOB,String sGender,String sName,String sNatId,String sSalary,String sTax)
		String calculatedExpecetdTax=calculateTax("24031944","F","CSVuserupload 01","9234567899","198914519.2","100.2987");
		String calculatedNatId=calculateNatid("24031944","F","CSVuserupload 01","9234567899","198914519.2","100.2987");
		Log.info("calculatedExpecetdTax: "+calculatedExpecetdTax);

		 List<String> jsonResponse = res.jsonPath().getList("$");
		 Log.info("jsonResponse size is:"+jsonResponse.size());
		 
		 String relief = res.jsonPath().getString("relief[0]");
		 Log.info("first tax relief from response: "+relief);
		 Log.info("Asserting calculated reflief: " +calculatedExpecetdTax+" is same as 1st relief from response: "+relief);
		 Assert.assertEquals(relief.equals(calculatedExpecetdTax),true);
		 
		 String natid = res.jsonPath().getString("natid[0]");
		 Log.info("first natid from response: "+natid);
		 Log.info("Asserting calculated natid: " +calculatedNatId+" is same as 1st natid from response: "+natid);
		 Assert.assertEquals(calculatedNatId.equals(natid),true);
		 
	}
}
