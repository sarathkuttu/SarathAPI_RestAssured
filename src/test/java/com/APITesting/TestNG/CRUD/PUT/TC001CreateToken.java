package com.APITesting.TestNG.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TC001CreateToken {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    String token;

    Integer bookingid;


    public void CreateToken() {

        System.out.println("Create Token");


        requestSpecification = RestAssured.given();


        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";


        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");

        requestSpecification.basePath("auth");

        requestSpecification.contentType(ContentType.JSON);


        requestSpecification.body(payload).log().all();

        Response response = requestSpecification.when().post();

        validatableResponse = response.then().log().all();

        //Matchers RestAssured(Hamcrest)

        validatableResponse.body("token", Matchers.notNullValue());

        //TESTNG ASSERTION

        token = response.then().log().all().extract().path("token");

        Assert.assertNotNull(token);

        //ASSERJ

//assertThat(token).isNotNull().isNotBlank().isNotEmpty();


        System.out.println(token);


    }

    @BeforeTest
    public void GetBookingID() {

        CreateToken();

        System.out.println("Get Booking ID");

        requestSpecification = RestAssured.given();

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


        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);


        Response response = requestSpecification.when().post();

        validatableResponse = response.then().log().all();

        String responseString = response.asString();

        System.out.println(responseString);

        validatableResponse.statusCode(200);

        //Matchers RestAssured(Hamcrest)


        //TESTNG ASSERTION

        bookingid = response.then().log().all().extract().path("bookingid");

        Assert.assertNotNull(bookingid);

        //ASSERJ

        //assertThat(bookingid).isNotNull();


    }

    @Test
    public void PUTBooking_PT1() {

        String payload = "{\n" +
                "    \"firstname\" : \"AMMU\",\n" +
                "    \"lastname\" : \"T V\",\n" +
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

        requestSpecification.basePath("booking/" + bookingid);

        requestSpecification.contentType(ContentType.JSON);

        requestSpecification.cookie("token", token);

        requestSpecification.body(payload).log().all();

        Response response = requestSpecification.when().put();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        validatableResponse.body("firstname", Matchers.equalTo("AMMU"));


    }

}
