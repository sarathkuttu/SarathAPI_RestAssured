package com.APITesting.Tests.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class BookerAutomationTestCases {
    @Test
    public void GetAllBooking_PT1() {
        RequestSpecification r = RestAssured.given();

        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking/124").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);

    }

    @Test
    public void GetAllBooking_NT1() {
        RequestSpecification r = RestAssured.given();

        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking/-124").log().all();
        r.when().get();
        r.then().log().all().statusCode(404);

    }

    @Test
    public void GetAllBooking_NT2() {
        RequestSpecification r = RestAssured.given();

        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("booking/a").log().all();
        r.when().get();
        r.then().log().all().statusCode(404);

    }
}
