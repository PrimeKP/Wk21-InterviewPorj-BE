package com.virgin.myfirsttest;

import com.virgin.testbase.TestBase;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.parsing.Parser.JSON;
import static org.hamcrest.Matchers.*;


public class MyFirstTest extends TestBase {


    static ValidatableResponse response;

// This test verifies response for GET data and asserts the values given
    @Test()
    public void test01() {
        RestAssured.registerParser("text/plain", JSON); // this will convert text data to json
        response = given()
                .when()
                .get("/GetBingoLobbyFeed.do")//no need to pass full path as it is run in TestBase so only testing /list endpoint
                .then().log().all().statusCode(200);

        //verifying different scenarios from get request
        response.body("bingoLobbyInfoResource.streams[0].streamName", equalTo("Adventure"));
        response.body("bingoLobbyInfoResource.streams[0].streamId", equalTo(194));
        response.body("bingoLobbyInfoResource.ventureId", equalTo(14));
        response.body("bingoLobbyInfoResource.streams[0].stakes[0].prizes.firstLine", hasKey("EUR"));
        response.body("bingoLobbyInfoResource.streams[0].fullHouse.2", notNullValue());


    }

}
