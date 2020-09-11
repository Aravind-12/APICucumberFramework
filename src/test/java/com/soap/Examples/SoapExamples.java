package com.soap.Examples;

import org.junit.Test;

import io.restassured.RestAssured;

public class SoapExamples {

    String wsdl = "";
    String payLoad = "";

    @Test
    public void soapEx() {

        RestAssured.given().contentType("text/xml")
                .body(payLoad)
                .when()
                .post(wsdl)
                .then()
                .log()
                .all();
    }

}
