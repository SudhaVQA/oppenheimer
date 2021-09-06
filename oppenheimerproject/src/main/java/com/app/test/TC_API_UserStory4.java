package com.app.test;

import java.text.ParseException;
import java.util.List;
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
	public void validate_TaxReliefandNatId_WorkingClassHeroFromExcelUpload() throws ParseException 
	{
		Log.info("Inside validate_TaxReliefandNatId_WorkingClassHeroFromExcelUpload..");
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

		String calculatedExpecetdTax=calculateTax("24031944","F","CSVuserupload 01","9234567899","198914519.2","100.2987");
		String calculatedNatId=calculateNatid("24031944","F","CSVuserupload 01","9234567899","198914519.2","100.2987");
		Log.info("calculatedExpectedTax: "+calculatedExpecetdTax);

		 List<String> jsonResponse = res.jsonPath().getList("$");
		 Log.info("jsonResponse size is:"+jsonResponse.size());
		 
		 String relief = res.jsonPath().getString("relief[0]");
		 Log.info("Tax relief from response: "+relief);
		 Log.info("Asserting calculated relief: " +calculatedExpecetdTax+" is same as relief from response: "+relief);
		 Assert.assertEquals(relief.equals(calculatedExpecetdTax),true);
		 
		 String natid = res.jsonPath().getString("natid[0]");
		 Log.info("Natid from response: "+natid);
		 Log.info("Asserting calculated natid: " +calculatedNatId+" is same as natid from response: "+natid);
		 Assert.assertEquals(calculatedNatId.equals(natid),true);
		 
	}
	
	@Test
	public void validate_TaxReliefandNatId_WorkingClassHero_FemaleAge17() throws ParseException 
	{
		Log.info("Inside validate_TaxReliefandNatId_WorkingClassHero_FemaleAge17..");
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

		String calculatedExpecetdTax=calculateTax("16012004","F","TestUser F_AG17","1234567890","10000.00","10.00");
		String calculatedNatId=calculateNatid("16012004","F","TestUser F_AG17","1234567890","10000.00","10.00");
		Log.info("calculatedExpectedTax: "+calculatedExpecetdTax);

		 List<String> jsonResponse = res.jsonPath().getList("$");
		 Log.info("jsonResponse size is:"+jsonResponse.size());
		 
		 String relief = res.jsonPath().getString("relief[2]");
		 Log.info("Tax relief from response: "+relief);
		 Log.info("Asserting calculated reflief: " +calculatedExpecetdTax+" is same as relief from response: "+relief);
		 Assert.assertEquals(relief.equals(calculatedExpecetdTax),true);
		 
		 String natid = res.jsonPath().getString("natid[2]");
		 Log.info("Natid from response: "+natid);
		 Log.info("Asserting calculated natid: " +calculatedNatId+" is same as natid from response: "+natid);
		 Assert.assertEquals(calculatedNatId.equals(natid),true);
		 
	}
	@Test
	public void validate_TaxReliefandNatId_WorkingClassHero_MaleAge18() throws ParseException 
	{
		Log.info("Inside validate_TaxReliefandNatId_WorkingClassHero_MaleAge18..");
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


		String calculatedExpecetdTax=calculateTax("16012004","M","TestUser M_AG18","2234567890","10000.00","10.00");
		String calculatedNatId=calculateNatid("16012004","M","TestUser M_AG18","2234567890","10000.00","10.00");
		Log.info("calculatedExpectedTax: "+calculatedExpecetdTax);

		 List<String> jsonResponse = res.jsonPath().getList("$");
		 Log.info("jsonResponse size is:"+jsonResponse.size());
		 
		 String relief = res.jsonPath().getString("relief[3]");
		 Log.info("Tax relief from response: "+relief);
		 Log.info("Asserting calculated relief: " +calculatedExpecetdTax+" is same as relief from response: "+relief);
		 Assert.assertEquals(relief.equals(calculatedExpecetdTax),true);
		 
		 String natid = res.jsonPath().getString("natid[3]");
		 Log.info("Natid from response: "+natid);
		 Log.info("Asserting calculated natid: " +calculatedNatId+" is same as natid from response: "+natid);
		 Assert.assertEquals(calculatedNatId.equals(natid),true);
		 
	}
	@Test
	public void validate_TaxReliefandNatId_WorkingClassHero_FemaleAge19() throws ParseException 
	{
		Log.info("Inside validate_TaxReliefandNatId_WorkingClassHero_FemaleAge19..");
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

		String calculatedExpecetdTax=calculateTax("06052002","F","Testuser F19 MU2a","3234567890","10000.17896","10.123");
		String calculatedNatId=calculateNatid("06052002","F","Testuser F19 MU2a","3234567890","10000.17896","10.123");
		Log.info("calculatedExpecetdTax: "+calculatedExpecetdTax);

		 List<String> jsonResponse = res.jsonPath().getList("$");
		 Log.info("jsonResponse size is:"+jsonResponse.size());
		 
		 String relief = res.jsonPath().getString("relief[4]");
		 Log.info("Tax relief from response: "+relief);
		 Log.info("Asserting calculated reflief: " +calculatedExpecetdTax+" is same as relief from response: "+relief);
		 Assert.assertEquals(relief.equals(calculatedExpecetdTax),true);
		 
		 String natid = res.jsonPath().getString("natid[4]");
		 Log.info("Natid from response: "+natid);
		 Log.info("Asserting calculated natid: " +calculatedNatId+" is same as natid from response: "+natid);
		 Assert.assertEquals(calculatedNatId.equals(natid),true);
		 
	}
	@Test
	public void validate_TaxReliefandNatId_WorkingClassHero_MaleAge35() throws ParseException 
	{
		Log.info("Inside validate_TaxReliefandNatId_WorkingClassHero_MaleAge35..");
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

		String calculatedExpecetdTax=calculateTax("06091986","M","Testuser M35 MU2b","4234567890","9896.12398","9.000");
		String calculatedNatId=calculateNatid("06091986","M","Testuser M35 MU2b","4234567890","9896.12398","9.000");
		Log.info("calculatedExpecetdTax: "+calculatedExpecetdTax);

		 List<String> jsonResponse = res.jsonPath().getList("$");
		 Log.info("jsonResponse size is:"+jsonResponse.size());
		 
		 String relief = res.jsonPath().getString("relief[5]");
		 Log.info("Tax relief from response: "+relief);
		 Log.info("Asserting calculated reflief: " +calculatedExpecetdTax+" is same as relief from response: "+relief);
		 Assert.assertEquals(relief.equals(calculatedExpecetdTax),true);
		 
		 String natid = res.jsonPath().getString("natid[5]");
		 Log.info("Natid from response: "+natid);
		 Log.info("Asserting calculated natid: " +calculatedNatId+" is same as natid from response: "+natid);
		 Assert.assertEquals(calculatedNatId.equals(natid),true);
		 
	}
	@Test
	public void validate_TaxReliefandNatId_WorkingClassHero_FemaleAge36() throws ParseException 
	{
		Log.info("Inside validate_TaxReliefandNatId_WorkingClassHero_FemaleAge36..");
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

		String calculatedExpecetdTax=calculateTax("06041985","F","Testuser F36 MU3a","5234567890","17965.8963","289.15890");
		String calculatedNatId=calculateNatid("06041985","F","Testuser F36 MU3a","5234567890","17965.8963","289.15890");
		Log.info("calculatedExpecetdTax: "+calculatedExpecetdTax);

		 List<String> jsonResponse = res.jsonPath().getList("$");
		 Log.info("jsonResponse size is:"+jsonResponse.size());
		 
		 String relief = res.jsonPath().getString("relief[6]");
		 Log.info("Tax relief from response: "+relief);
		 Log.info("Asserting calculated reflief: " +calculatedExpecetdTax+" is same as relief from response: "+relief);
		 Assert.assertEquals(relief.equals(calculatedExpecetdTax),true);
		 
		 String natid = res.jsonPath().getString("natid[6]");
		 Log.info("Natid from response: "+natid);
		 Log.info("Asserting calculated natid: " +calculatedNatId+" is same as natid from response: "+natid);
		 Assert.assertEquals(calculatedNatId.equals(natid),true);
		 
	}
	@Test
	public void validate_TaxReliefandNatId_WorkingClassHero_MaleAge50() throws ParseException 
	{
		Log.info("Inside validate_TaxReliefandNatId_WorkingClassHero_MaleAge50..");
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

		String calculatedExpecetdTax=calculateTax("20081971","M","Testuser M50 MU3b","6234567890","189632.01450","639.14896");
		String calculatedNatId=calculateNatid("20081971","M","Testuser M50 MU3b","6234567890","189632.01450","639.14896");
		Log.info("calculatedExpecetdTax: "+calculatedExpecetdTax);

		 List<String> jsonResponse = res.jsonPath().getList("$");
		 Log.info("jsonResponse size is:"+jsonResponse.size());
		 
		 String relief = res.jsonPath().getString("relief[7]");
		 Log.info("Tax relief from response: "+relief);
		 Log.info("Asserting calculated reflief: " +calculatedExpecetdTax+" is same as relief from response: "+relief);
		 Assert.assertEquals(relief.equals(calculatedExpecetdTax),true);
		 
		 String natid = res.jsonPath().getString("natid[7]");
		 Log.info("Natid from response: "+natid);
		 Log.info("Asserting calculated natid: " +calculatedNatId+" is same as natid from response: "+natid);
		 Assert.assertEquals(calculatedNatId.equals(natid),true);
		 
	}
	@Test
	public void validate_TaxReliefandNatId_WorkingClassHero_FemaleAge51() throws ParseException 
	{
		Log.info("Inside validate_TaxReliefandNatId_WorkingClassHero_FemaleAge51..");
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

		String calculatedExpecetdTax=calculateTax("20021970","F","Testuser F51 MU3c","7234567890","9862589.890","1896.00");
		String calculatedNatId=calculateNatid("20021970","F","Testuser F51 MU3c","7234567890","9862589.890","1896.013960");
		Log.info("calculatedExpecetdTax: "+calculatedExpecetdTax);

		 List<String> jsonResponse = res.jsonPath().getList("$");
		 Log.info("jsonResponse size is:"+jsonResponse.size());
		 
		 String relief = res.jsonPath().getString("relief[8]");
		 Log.info("Tax relief from response: "+relief);
		 Log.info("Asserting calculated reflief: " +calculatedExpecetdTax+" is same as relief from response: "+relief);
		 Assert.assertEquals(relief.equals(calculatedExpecetdTax),true);
		 
		 String natid = res.jsonPath().getString("natid[8]");
		 Log.info("Natid from response: "+natid);
		 Log.info("Asserting calculated natid: " +calculatedNatId+" is same as natid from response: "+natid);
		 Assert.assertEquals(calculatedNatId.equals(natid),true);
		 
	}
	@Test
	public void validate_TaxReliefandNatId_WorkingClassHero_MaleAge75() throws ParseException 
	{
		Log.info("Inside validate_TaxReliefandNatId_WorkingClassHero_MaleAge75..");
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

		String calculatedExpecetdTax=calculateTax("01091946","M","Testuser M75 MU3b","8234567890","989632.996328","39.89698");
		String calculatedNatId=calculateNatid("01091946","M","Testuser M75 MU3b","8234567890","989632.996328","39.89698");
		Log.info("calculatedExpecetdTax: "+calculatedExpecetdTax);

		 List<String> jsonResponse = res.jsonPath().getList("$");
		 Log.info("jsonResponse size is:"+jsonResponse.size());
		 
		 String relief = res.jsonPath().getString("relief[9]");
		 Log.info("Tax relief from response: "+relief);
		 Log.info("Asserting calculated reflief: " +calculatedExpecetdTax+" is same as relief from response: "+relief);
		 Assert.assertEquals(relief.equals(calculatedExpecetdTax),true);
		 
		 String natid = res.jsonPath().getString("natid[9]");
		 Log.info("Natid from response: "+natid);
		 Log.info("Asserting calculated natid: " +calculatedNatId+" is same as natid from response: "+natid);
		 Assert.assertEquals(calculatedNatId.equals(natid),true);
		 
	}
	@Test
	public void validate_TaxReliefandNatId_WorkingClassHero_FemaleAge76() throws ParseException 
	{
		Log.info("Inside validate_TaxReliefandNatId_WorkingClassHero_FemaleAge76..");
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

		String calculatedExpecetdTax=calculateTax("01121944","F","Testuser F76 MU3c","9234567890","9862589.156","1630.606");
		String calculatedNatId=calculateNatid("01121944","F","Testuser F76 MU3c","9234567890","9862589.156","1630.606");
		Log.info("calculatedExpecetdTax: "+calculatedExpecetdTax);

		 List<String> jsonResponse = res.jsonPath().getList("$");
		 Log.info("jsonResponse size is:"+jsonResponse.size());
		 
		 String relief = res.jsonPath().getString("relief[10]");
		 Log.info("Tax relief from response: "+relief);
		 Log.info("Asserting calculated reflief: " +calculatedExpecetdTax+" is same as relief from response: "+relief);
		 Assert.assertEquals(relief.equals(calculatedExpecetdTax),true);
		 
		 String natid = res.jsonPath().getString("natid[10]");
		 Log.info("Natid from response: "+natid);
		 Log.info("Asserting calculated natid: " +calculatedNatId+" is same as natid from response: "+natid);
		 Assert.assertEquals(calculatedNatId.equals(natid),true);
		 
	}
	@Test
	public void validate_TaxReliefandNatId_WorkingClassHero_FemaleAge31Tax1() throws ParseException 
	{
		Log.info("Inside validate_TaxReliefandNatId_WorkingClassHero_FemaleAge31Tax1..");
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

		String calculatedExpecetdTax=calculateTax("24031990","F","Testuser F31 MU1a","1334567890","10000.00","1.00");
		String calculatedNatId=calculateNatid("24031990","F","Testuser F31 MU1a","1334567890","10000.00","1.00");
		Log.info("calculatedExpecetdTax: "+calculatedExpecetdTax);

		 List<String> jsonResponse = res.jsonPath().getList("$");
		 Log.info("jsonResponse size is:"+jsonResponse.size());
		 
		 String relief = res.jsonPath().getString("relief[13]");
		 Log.info("Tax relief from response: "+relief);
		 Log.info("Asserting calculated reflief: " +calculatedExpecetdTax+" is same as relief from response: "+relief);
		 Assert.assertEquals(relief.equals(calculatedExpecetdTax),true);
		 
		 String natid = res.jsonPath().getString("natid[13]");
		 Log.info("Natid from response: "+natid);
		 Log.info("Asserting calculated natid: " +calculatedNatId+" is same as natid from response: "+natid);
		 Assert.assertEquals(calculatedNatId.equals(natid),true);
		 
	}
	@Test
	public void validate_TaxReliefandNatId_WorkingClassHero_MaleAge31TaxAboveZeroLessthanFifty() throws ParseException 
	{
		Log.info("Inside validate_TaxReliefandNatId_WorkingClassHero_MaleAge31TaxAboveZeroLessthanFifty..");
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

		String calculatedExpecetdTax=calculateTax("24031990","M","Testuser M31 MU1a","2334567890","10000.00","9999.00");
		String calculatedNatId=calculateNatid("24031990","M","Testuser M31 MU1a","2334567890","10000.00","9999.00");
		Log.info("calculatedExpecetdTax: "+calculatedExpecetdTax);

		 List<String> jsonResponse = res.jsonPath().getList("$");
		 Log.info("jsonResponse size is:"+jsonResponse.size());
		 
		 String relief = res.jsonPath().getString("relief[11]");
		 Log.info("Tax relief from response: "+relief);
		 Log.info("Asserting calculated reflief: " +calculatedExpecetdTax+" is same as relief from response: "+relief);
		 Assert.assertEquals(relief.equals(calculatedExpecetdTax),true);
		 
		 String natid = res.jsonPath().getString("natid[11]");
		 Log.info("Natid from response: "+natid);
		 Log.info("Asserting calculated natid: " +calculatedNatId+" is same as natid from response: "+natid);
		 Assert.assertEquals(calculatedNatId.equals(natid),true);
		 
	}
	@Test
	public void validate_TaxReliefandNatId_WorkingClassHero_FemaleAge31TaxAbove50() throws ParseException 
	{
		Log.info("Inside validate_TaxReliefandNatId_WorkingClassHero_MaleAge31TaxAbove50..");
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

		String calculatedExpecetdTax=calculateTax("24031990","F","Testuser F31 MU1xTaxabove50","3334567890","10000.00","990.00");
		String calculatedNatId=calculateNatid("24031990","F","Testuser F31 MU1xTaxabove50","3334567890","10000.00","990.00");
		Log.info("calculatedExpecetdTax: "+calculatedExpecetdTax);

		 List<String> jsonResponse = res.jsonPath().getList("$");
		 Log.info("jsonResponse size is:"+jsonResponse.size());
		 
		 String relief = res.jsonPath().getString("relief[12]");
		 Log.info("Tax relief from response: "+relief);
		 Log.info("Asserting calculated reflief: " +calculatedExpecetdTax+" is same as relief from response: "+relief);
		 Assert.assertEquals(relief.equals(calculatedExpecetdTax),true);
		 
		 String natid = res.jsonPath().getString("natid[12]");
		 Log.info("Natid from response: "+natid);
		 Log.info("Asserting calculated natid: " +calculatedNatId+" is same as natid from response: "+natid);
		 Assert.assertEquals(calculatedNatId.equals(natid),true);
		 
	}
	
}
