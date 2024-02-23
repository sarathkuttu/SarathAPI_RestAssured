package com.APITesting.Tests.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class POSTBookerAutomationTC2 {

    private String responseString;

    @Test
    public void PostBooking_PT1() {

        String payload = "{\n" +
                "    \"firstname\" : \"SARATH\",\n" +
                "    \"lastname\" : \"T V\",\n" +
                "    \"totalprice\" : 10000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-02-20\",\n" +
                "        \"checkout\" : \"2024-02-25\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        RequestSpecification r = RestAssured.given().log().all();

        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking");
        r.contentType(ContentType.JSON);
        r.body(payload);
        Response response = r.when().post();

        ValidatableResponse validatableResponse = response.then();

        String responseString = response.asString();

        System.out.println("RESPONSES ARE THE BELOW");
        System.out.println(responseString);

        validatableResponse.statusCode(200);

        //validatableResponse.body("token",)
    }
}
