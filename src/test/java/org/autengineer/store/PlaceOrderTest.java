package org.autengineer.store;

import org.autengineer.util.OrderDataGenerator;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.io.File;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PlaceOrderTest {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8080/api/v3";
    }

    @Test
    public void testPlaceOrder() {
        // Generar el archivo order.json
        OrderDataGenerator.generateRandomOrderJson();

        // Realizar el pedido de una mascota
        given()
                .contentType(ContentType.JSON)
                .body(new File("src/main/resources/order.json")) // Leer el archivo order.json
            .when()
                .post("/store/order")
            .then()
                .statusCode(200)
                .log().body();
    }
}
