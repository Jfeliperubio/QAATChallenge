package org.autengineer.pet;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeletePetTest {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8080/api/v3";
    }

    @Test
    public void testDeletePet() {
        given()
                .pathParam("petId", 8) // Reemplaza 8 con el ID de la mascota a eliminar
            .when()
                .delete("/pet/{petId}")
            .then()
                .statusCode(200)
                .log().body();
    }
}
