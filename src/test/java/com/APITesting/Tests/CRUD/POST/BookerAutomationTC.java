package com.APITesting.Tests.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class BookerAutomationTC {

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
        r.when().log().all().post();
        r.then().statusCode(200).log().all();

    }
}
