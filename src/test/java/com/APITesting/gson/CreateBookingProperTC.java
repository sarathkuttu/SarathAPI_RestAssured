package com.APITesting.gson;

import com.APITesting.gson.Easy.Bookingdates;
import com.APITesting.gson.Easy.CreateBookingSimple;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateBookingProperTC {

    RequestSpecification requestSpecification;

    ValidatableResponse validatableResponse;

    @Test
    public void CreateBookingTC1() {

//PayloAD
        CreateBookingSimple Booking = new CreateBookingSimple();
        Booking.setFirstname("Keerthana");

        Booking.setLastname("Aravind");

        Booking.setTotalprice(7000);

        Booking.setDepositpaid(true);

        Bookingdates bookingdate = new Bookingdates();
        bookingdate.setCheckin("2024-03-19");
        bookingdate.setCheckin("2024-03-27");

        Booking.setBookingdates(bookingdate);

        Booking.setAdditionalneeds("Breakfast");

        System.out.println(Booking);

        //Object--->JSON

        Gson gson = new Gson();

        String jsonStringBooking = gson.toJson(Booking);


        System.out.println(jsonStringBooking);

        requestSpecification = RestAssured.given();

        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringBooking).log().all();

        Response response = requestSpecification.when().post();

        //JSON---->Object
        String jsonResponseString = response.asString();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        CreateBookingSimple bookingresponseObject = gson.fromJson(jsonResponseString, CreateBookingSimple.class);

        Assert.assertEquals(bookingresponseObject.getFirstname(),"Keerthana");

        Assert.assertEquals(bookingresponseObject.getLastname(),"Aravind");

    }


}
