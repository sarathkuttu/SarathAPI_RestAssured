package com.APITesting.Tests.CRUD.GET;

import io.restassured.RestAssured;

public class RATestcase {

    public static void main(String[] args) {

        RestAssured.given().baseUri("https://api.zippopotam.us/").basePath("/IN/56037")
                .when().log().all().get()

                .then().log().all().statusCode(200);
    }
}
