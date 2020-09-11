package proxyExamples;

import static io.restassured.RestAssured.given;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.ProxySpecification;
import io.restassured.specification.RequestSpecification;

public class ProxyTestExa {

    public static RequestSpecBuilder repec;
    public static RequestSpecification res;

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost:8082/student/";
        // RestAssured.proxy("localhost", 5555);
        ProxySpecification prx = new ProxySpecification("localhost", 5555, "http");

        repec = new RequestSpecBuilder();
        repec.setProxy(prx);
        res = repec.build();

    }

    @Test
    public void sensRequest() {

        ProxySpecification prx = new ProxySpecification("localhost", 5555, "http");

        given()
                // .spec(res)
                .proxy(prx).when().get("list").then().log().all();
    }

}
