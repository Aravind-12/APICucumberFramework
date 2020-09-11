package jsonAssertExamples;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONException;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import io.restassured.RestAssured;
import junit.framework.Assert;

public class JasonAsserExmp {

    @Test
    public void getStudent() throws IOException, JSONException {
        String expectedVal = new String(Files.readAllBytes(Paths.get(System.getProperty("user.dir") +
                File.separator + "FileNew.txt")));

        String actualValue = RestAssured.given().when().get("http://localhost:8082/student/list").asString();

        System.out.println(actualValue);

        Assert.assertEquals(expectedVal, actualValue);
        JSONAssert.assertEquals(expectedVal, actualValue, JSONCompareMode.LENIENT);
    }
}
