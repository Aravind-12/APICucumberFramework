package pojo;

import static io.restassured.RestAssured.given;

import org.junit.BeforeClass;

import io.restassured.RestAssured;

public class PayPal {

    public static String accToken;

    @BeforeClass
    public static void getTocken() {

        RestAssured.baseURI = "https://api.sandbox.paypal.com/";
        RestAssured.basePath = "v1/";

        final String clientID = "Ac4TLqr14VROrJJaJZY2moxrjzwN2_eMB5XD6cwIdyrm84ZWAU_lbYCwDh46OgsesEeb6OOMaFGb_0Ou";
        final String clientSec = "ED-q4CaRpHfeMB641NUyb28bBKeFQZhSuv3jHBYvqWkd7C4a22-F3h-yeDVT9KriLEfFgOrjmMF6C5s9";

        accToken = given().param("grant_type", "client_credentials")
                .auth().preemptive().basic(clientID, clientSec)
                .when().post("oauth2/token")
                .then().log().all().extract().path("access_token");

        System.out.println(accToken);

    }

}
