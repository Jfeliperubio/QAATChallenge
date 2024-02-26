package org.autengineer.user;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetUserByUsernameTest {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8080/api/v3"; // Ajusta la URL base según tu entorno
    }

    @Test
    public void testGetUserByUsername() {
        String username = "tana.heathcote"; // El nombre de usuario del usuario que quieres obtener

        given()
                .pathParam("username", username)
            .when()
                .get("/user/{username}")
            .then()
                .statusCode(200)
                .log().body();
    }
}

