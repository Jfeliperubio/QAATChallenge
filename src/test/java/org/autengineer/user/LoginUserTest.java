package org.autengineer.user;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class LoginUserTest {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8080/api/v3";
    }

    @Test
    public void testLoginUser() {
        String username = "tana.heathcote";
        String password = "agwgeodpio9";

        given()
                .contentType(ContentType.JSON)
                .body("{\"username\": \"" + username + "\", \"password\": \"" + password + "\"}")
            .when()
                .get("/user/login")
            .then()
                .statusCode(200) // O el código de estado correcto según la documentación de la API
                .log().body();
    }
}
