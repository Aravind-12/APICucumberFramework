package com.file.upload.exaples;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.junit.Test;

public class FileUpload {

    // file upload

    @Test
    public void fileUpload() {

        String APIKey = "458bc3ffd871bc3a6e8aa112c433168e21d98b16";

        File file = new File(System.getProperty("user.dir") + File.separator + "IMG_20200408_124548-min.jpg");
        System.out.println(file.length());

        given()
                .auth()
                .basic(APIKey, "")
                .multiPart("source_file", file)
                .multiPart("target_format", "png")
                .when()
                .post("https://sandbox.zamzar.com/v1/jobs")
                .then()
                .log()
                .all();

    }

}
