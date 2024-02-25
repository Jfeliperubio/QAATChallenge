package org.autengineer.pet;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UpdatePet {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8080/api/v3";
    }

    @Test
    public void testUpdatePet() {
        // Ruta del archivo pet.json
        String filePath = "src/main/resources/pet.json";

        // Lee el contenido del archivo pet.json
        File petJsonFile = new File(filePath);

        given()
                .contentType(ContentType.JSON)
                .body(petJsonFile)
            .when()
                .put("/pet")
            .then()
                .statusCode(200)
                .body("id", equalTo(7))
                .body("name", equalTo("doggie"))
                .body("category.id", equalTo(1))
                .body("category.name", equalTo("Dogs"))
                .body("photoUrls[0]", equalTo("http://example.com/doggie.jpg"))
                .body("tags[0].id", equalTo(0))
                .body("tags[0].name", equalTo("friendly"))
                .body("status", equalTo("available"))
                .log().body();
    }
}
