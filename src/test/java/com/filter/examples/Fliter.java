package com.filter.examples;

import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class Fliter {

    public static StringWriter requestWriter;
    public static PrintStream requestCapture;
    public static StringWriter responsetWriter;
    public static PrintStream responseCapture;
    public static StringWriter errorWriter;
    public static PrintStream errorCapture;

    @BeforeClass
    public static void init() {

        RestAssured.baseURI = "http://localhost:8082";
        RestAssured.basePath = "/student";

    }

    @Before
    public void beforeEachTest() {
        requestWriter = new StringWriter();
        requestCapture = new PrintStream(new WriterOutputStream(requestWriter), true);
        responsetWriter = new StringWriter();
        responseCapture = new PrintStream(new WriterOutputStream(responsetWriter), true);
        errorWriter = new StringWriter();
        errorCapture = new PrintStream(new WriterOutputStream(errorWriter), true);
    }

    @Test
    public void getStudent() {

        RestAssured.given()
                .filter(new RequestLoggingFilter(requestCapture))
                .filter(new ResponseLoggingFilter(responseCapture))
                .filter(new ErrorLoggingFilter(errorCapture))
                .log().all()
                .when().get("/lists")
                .asString();

        System.err.println(requestWriter.toString());
        System.err.println(responsetWriter.toString());
        System.err.println(errorWriter.toString().toUpperCase());

    }

}
