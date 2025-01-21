package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import utils.APIUtils;
import utils.BaseSetup;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import data.ReadData;

public class APITest extends BaseSetup {
	
	APIUtils apiutils;
	
    @BeforeClass
    public void setupTest() {
    	apiutils = new APIUtils();
        test = extent.createTest("Verify API - GET, POST Requests").assignCategory("API_Test");
    }

    @Test(dataProvider = "GETAPIData", dataProviderClass = ReadData.class)
    public void testGETRequest(String endpoint, String expCode) {
        Response response = apiutils.methodGET(endpoint);

        test.log(Status.INFO, "GET Request performed on: " + RestAssured.baseURI + endpoint);
        test.log(Status.INFO, "Response: " + response.prettyPrint());

        String statusCode = String.valueOf(response.getStatusCode());
        Assert.assertEquals(statusCode, expCode, "Expected status code "+expCode+" but received code is : " + statusCode);
        test.log(Status.PASS, "GET Request Status Code Validation: " + statusCode);
    }

    @Test(dataProvider = "POSTAPIData", dataProviderClass = ReadData.class)
    public void testPOSTRequest(String endpoint, String reqbody, String expCode, String expuserId) {
        Response response = apiutils.methodPOST(endpoint, reqbody);                      

        test.log(Status.INFO, "POST Request performed on: " + RestAssured.baseURI + endpoint);
        test.log(Status.INFO, "Request Body: " + reqbody);
        test.log(Status.INFO, "Response: " + response.prettyPrint());

        String statusCode = String.valueOf(response.getStatusCode());
        Assert.assertEquals(statusCode, expCode, "Expected status code "+expCode+" but received code is : " + statusCode);
        test.log(Status.PASS, "POST Request Status Code Validation: " + statusCode);

        String userId = String.valueOf(response.jsonPath().getString("userId"));
        Assert.assertEquals(userId, expuserId, "User ID in the response body is incorrect");
        test.log(Status.PASS, "POST Request Response Validation: User ID matches as expected.");
    }
}
