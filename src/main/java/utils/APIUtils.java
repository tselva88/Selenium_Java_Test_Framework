package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIUtils {
		
	public APIUtils() {
		RestAssured.baseURI = ConfigReader.getProperty("api_host");
	}
	
    public Response methodGET(String endpoint) {
        return RestAssured
                .given()
                .when()
                .get(endpoint)
                .then()
                .extract().response();
    }

    public Response methodPOST(String endpoint, String reqbody) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(reqbody)
                .when()
                .post(endpoint)
                .then()
                .extract().response();
    }
    
    public Response methodPUT(String endpoint, String reqbody) {
        return RestAssured
                .given()
                .header("Content-Type", "application/json")
                .body(reqbody)
                .when()
                .put(endpoint)
                .then()
                .extract().response();
    }
    
    public Response methodDELETE(String endpoint) {
        return RestAssured
                .given()
                .when()
                .delete(endpoint)
                .then()
                .extract().response();
    }

}