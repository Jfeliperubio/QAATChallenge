package org.autengineer.pet;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UpdatePetFormDataTest {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8080/api/v3";
    }

    @Test
    public void testUpdatePetWithForm() {
        given()
                .contentType(ContentType.URLENC)
                .queryParam("name", "doggie")
                .queryParam("status", "available")
            .when()
                .post("/pet/8") // Reemplaza 8 con el ID de la mascota a actualizar
            .then()
                .statusCode(200)
                .log().body();
    }
}
