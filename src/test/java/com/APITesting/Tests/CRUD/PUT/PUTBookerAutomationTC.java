package com.APITesting.Tests.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PUTBookerAutomationTC {

    RequestSpecification requestSpecification;

    ValidatableResponse validatableResponse;

    String token = "a24aad672c090c3";

    private String responseString;

    @Test
    public void PUTBooking_PT1() {

        String payload = "{\n" +
                "    \"firstname\" : \"KEERTHANA\",\n" +
                "    \"lastname\" : \"CHAKKU\",\n" +
                "    \"totalprice\" : 10000,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-02-01\",\n" +
                "        \"checkout\" : \"2024-02-10\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");

        requestSpecification.basePath("booking/1646");

        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.cookie("token", token);

        requestSpecification.body(payload).log().all();

        Response response = requestSpecification.when().put();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        validatableResponse.body("firstname", Matchers.equalTo("KEERTHANA"));
        validatableResponse.body("lastname", Matchers.equalTo("CHAKKU"));




    }
}
