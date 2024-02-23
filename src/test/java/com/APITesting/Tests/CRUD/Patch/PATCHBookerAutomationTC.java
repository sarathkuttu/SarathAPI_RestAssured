package com.APITesting.Tests.CRUD.Patch;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class PATCHBookerAutomationTC {

    RequestSpecification requestSpecification;

    ValidatableResponse validatableResponse;

    String token = "7718c9ce0b898f7";

    private String responseString;

    @Test
    public void PATCHBooking_PT1() {

        String payload = "{\n" +
                "    \"firstname\" : \"SARALA\",\n" +
                "    \"lastname\" : \"NALINI\"\n" +
                "}";

        requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");

        requestSpecification.basePath("booking/1916");

        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.cookie("token", token);

        requestSpecification.body(payload).log().all();

        Response response = requestSpecification.when().patch();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        validatableResponse.body("firstname", Matchers.equalTo("SARALA"));
        validatableResponse.body("lastname", Matchers.equalTo("NALINI"));




    }
}
