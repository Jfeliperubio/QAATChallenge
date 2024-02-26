package org.autengineer.user;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class LogoutUserTest {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8080/api/v3";
    }

    @Test
    public void testLogoutUser() {
        given()
            .when()
                .get("/user/logout")
            .then()
                .statusCode(200)
                .log().body();
    }
}

