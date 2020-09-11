package twitterExamples;

import static io.restassured.RestAssured.given;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import io.restassured.RestAssured;

public class TwitterExm {

    String cKey = "wh4cDKGZ0cBcAMSfHK7RTWRnc";
    String cSec = "25aVRkuloMxoDHdVoJFeScDQe71Eqj4OdoErn2Ij7sK9VTjY6p";
    String accToken = "4779408540-swXEbkgtyZaZ4YwPM0zWL72BLhYfcP6qLM0OxpT";
    String secToken = "gmmLEElzczM3Zl3RdQ0BPI8YaGO1RSEOhs420feDiCj0C";

    @BeforeClass
    public static void init() {
        RestAssured.baseURI = "https://api.twitter.com";
        RestAssured.basePath = "/1.1/statuses";
    }

    @Ignore
    @Test
    public void writeTwitter() {

        given().auth().oauth(cKey, cSec, accToken, secToken)
                .queryParam("status", "Hellp Aravind")
                .when().post("/update.json").then().log().all();

    }

    @Test
    public void getWriteTwitter() {

        given().auth().oauth(cKey, cSec, accToken, secToken)
                .queryParam("screen_name", "Aravind H S")
                .when().get("/user_timeline.json").then().log().all();

    }

}
