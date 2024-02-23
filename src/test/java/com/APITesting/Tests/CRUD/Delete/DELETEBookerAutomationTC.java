package com.APITesting.Tests.CRUD.Delete;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class DELETEBookerAutomationTC {

    RequestSpecification requestSpecification;

    ValidatableResponse validatableResponse;

    String token = "f02eef0a02ba836";

    private String responseString;

    @Test
    public void PATCHBooking_PT1() {


        requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");

        requestSpecification.basePath("booking/3559");

        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.cookie("token", token);


        Response response = requestSpecification.when().delete();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);


    }
}
