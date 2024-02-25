package org.autengineer.store;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class GetInventoryByStatusTest {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8080/api/v3";
    }

    @Test
    public void testInventory() {
        given()
            .when()
                .get("/store/inventory")
            .then()
                .statusCode(200)
                .body("approved", greaterThanOrEqualTo(0))
                .body("placed", greaterThanOrEqualTo(0))
                .body("delivered", greaterThanOrEqualTo(0))
                .log().body();
    }
}

