package com.APITesting.gson.Easy;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Demo {

    RequestSpecification requestSpecification;

    ValidatableResponse validatableResponse;


    @Test
    public void Create() {

        CreateBookingSimple Booking = new CreateBookingSimple();
        Booking.setFirstname("Keerthana");

        Booking.setLastname("Aravind");

        Booking.setTotalprice(7000);

        Booking.setDepositpaid(true);

        Bookingdates bookingdate = new Bookingdates();
        bookingdate.setCheckin("2024-03-19");
        bookingdate.setCheckin("2024-03-19");

        Booking.setBookingdates(bookingdate);

        Booking.setAdditionalneeds("Breakfast");

        System.out.println(Booking);

        requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload).log().all();

        Response response = requestSpecification.when().post();

        Integer bookingid = response.then().extract().path("bookingid");

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        System.out.println("Your booking ID is " + bookingid);

    }

}



