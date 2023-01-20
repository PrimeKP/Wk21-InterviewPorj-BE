package com.virgin.testbase;

import com.virgin.utils.TestUtils;
import io.restassured.RestAssured;
import org.junit.BeforeClass;


public class TestBase extends TestUtils {

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://www.virgingames.com"; //can be move to config file
        RestAssured.basePath = "/bingo"; //this will be set up in individual class // this is common here so setup here
                                            //else we can set up this in MyFirstTest (respective test)
    }
}
