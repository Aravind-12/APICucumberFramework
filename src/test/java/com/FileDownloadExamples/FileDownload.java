package com.FileDownloadExamples;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.junit.Assert;
import org.junit.Test;

public class FileDownload {

    @Test
    public void fileDownload() {

        // read input file
        File file = new File(System.getProperty("user.dir") + File.separator + "geckodriver-v0.26.0-win64.zip");
        // length od the input file

        int eSize = (int) file.length();
        System.out.println(eSize);

        // https://github.com/mozilla/geckodriver/releases/download/v0.26.0/geckodriver-v0.26.0-win64.zip

        byte[] ActValue = given().when()
                .get("https://github.com/mozilla/geckodriver/releases/download/v0.26.0/geckodriver-v0.26.0-win64.zip")
                .then()
                .extract().asByteArray();
        System.out.println(ActValue.length);

        Assert.assertEquals(eSize, ActValue.length);

    }

}
