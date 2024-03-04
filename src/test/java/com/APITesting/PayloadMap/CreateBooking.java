package com.APITesting.PayloadMap;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class CreateBooking {

    RequestSpecification requestSpecification;

    ValidatableResponse validatableResponse;

    @Test
    public void CreateBooking() {


        Map<String, Object> jsonbodyusingMap = new HashMap<>();

        jsonbodyusingMap.put("firstname", "SARATH");
        jsonbodyusingMap.put("lastname", "T V");
        jsonbodyusingMap.put("totalprice", 5000);
        jsonbodyusingMap.put("depositpaid", true);

        Map<String, Object> bookingdateMap = new HashMap<>();
        bookingdateMap.put("checkin", 2024 - 04 - 20);
        bookingdateMap.put("checkout", 2024 - 04 - 30);
        jsonbodyusingMap.put("bookingdates", bookingdateMap);

        jsonbodyusingMap.put("additionalneeds", "Breakfast");
        requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonbodyusingMap).log().all();

        Response response = requestSpecification.when().post();

        Integer bookingid = response.then().extract().path("bookingid");

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        System.out.println("Your booking ID is " + bookingid);

    }

}
