package com.jasonPath.search;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;

public class JsonPathExamples {

    static final String APIKEY = "75e3u4sgb2khg673cbv2gjup";

    @BeforeClass
    public static void init() {

        RestAssured.baseURI = "http://api.walmartlabs.com";
        RestAssured.basePath = "/v1";

    }

    /*@Test
    public void test001() {

        given().param("query", "ipod")
                .param("format", "json")
                .param("apiKey", APIKEY)
                .when().get("/search").then().body("numItems", equals(10));

    }*/

    @Test
    public void test002() {

        String query = given().param("query", "ipod")
                .param("format", "json")
                .param("apiKey", APIKEY)
                .when().get("/search").then().extract().path("query");

        System.out.println(query);
    }

    @Test
    public void test003() {

        String name = given().param("query", "ipod")
                .param("format", "json")
                .param("apiKey", APIKEY)
                .when().get("/search").then().extract().path("items[3].name");

        System.out.println(name);
    }

    @Test
    public void test004() {

        HashMap<String, String> giftOptions = given().param("query", "ipod")
                .param("format", "json")
                .param("apiKey", APIKEY)
                .when().get("/search").then().extract().path("items[3].giftOptions");

        System.out.println(giftOptions);
    }

    @Test
    public void test005() {

        int size = given().param("query", "ipod")
                .param("format", "json")
                .param("apiKey", APIKEY)
                .when().get("/search").then().extract().path("items.size()");

        System.out.println(size);
    }

    @Test
    public void test006() {

        List<String> names = given().param("query", "ipod")
                .param("format", "json")
                .param("apiKey", APIKEY)
                .when().get("/search").then().extract().path("items.name");

        System.out.println(names);
    }

    @Test
    public void test007() {

        List<HashMap<String, Object>> names = given().param("query", "ipod")
                .param("format", "json")
                .param("apiKey", APIKEY)
                .when().get("/search").then().extract().path("items.findAll{it.name== 'Apple iPod Touch 16GB A1421 - Space Gray (Refurbished) (5th Generation)'}");

        System.out.println(names);
    }

    @Test
    public void test008() {

        List<Float> price = given().param("query", "ipod")
                .param("format", "json")
                .param("apiKey", APIKEY)
                .when().get("/search").then().extract().path("items.findAll{it.name== 'Apple iPod Touch 16GB A1421 - Space Gray (Refurbished) (5th Generation)'}.salePrice");

        System.out.println(price);
    }

    @Test
    public void test009() {

        List<String> price = given().param("query", "ipod")
                .param("format", "json")
                .param("apiKey", APIKEY)
                .when().get("/search").then().extract().path("items.findAll{it.salePrice<150}.name");

        System.out.println(price);
    }
}
