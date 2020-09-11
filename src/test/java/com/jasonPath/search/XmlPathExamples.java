package com.jasonPath.search;

import static io.restassured.RestAssured.given;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class XmlPathExamples {

    static final String APIKEY = "75e3u4sgb2khg673cbv2gjup";

    @BeforeClass
    public static void init() {

        RestAssured.baseURI = "http://api.walmartlabs.com";
        RestAssured.basePath = "/v1";

    }

    @Test
    public void test001() {

        String numItems = given().param("query", "ipod")
                .param("format", "xml")
                .param("apiKey", APIKEY)
                .when().get("/search").then().extract().path("searchresponse.numItems");

        System.out.println(numItems);
    }

    @Test
    public void test002() {

        String name = given().param("query", "ipod")
                .param("format", "xml")
                .param("apiKey", APIKEY)
                .when().get("/search").then().extract().path("searchresponse.items.item[0].name");

        System.out.println(name);
    }

    @Test
    public void test003() {

        String name = given().param("query", "ipod")
                .param("format", "xml")
                .param("apiKey", APIKEY)
                .when().get("/search").then().extract().path("searchresponse.items.item[0].name");

        System.out.println(name);
    }

}
