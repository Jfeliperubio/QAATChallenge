package org.autengineer.pet;

import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FindPetByIdTest {

    @BeforeClass
    public static void setUp() {
        baseURI = "http://localhost:8080/api/v3";
    }

    @Test
    public void testFindPetById() {
        int petId = 7; // ID de la mascota a buscar

        given()
                .pathParam("petId", petId)
            .when()
                .get("/pet/{petId}")
            .then()
                .statusCode(200)
                .body("id", equalTo(petId))
                .body("name", notNullValue())
                .body("category.id", notNullValue())
                .body("category.name", notNullValue())
                .body("photoUrls", notNullValue())
                .body("tags", notNullValue())
                .body("status", notNullValue())
                .log().body();
    }
}
