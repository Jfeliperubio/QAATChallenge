package org.autengineer.store;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class FindPurchaseOrderByIdTest {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8080/api/v3";
    }

    @Test
    public void testFindPurchaseOrderById() {
        int orderId = 876; // Reemplaza 123 con el ID del pedido que deseas buscar

        given()
                .pathParam("orderId", orderId)
            .when()
                .get("/store/order/{orderId}")
            .then()
                .statusCode(200) // Verifica que se reciba un código de estado 200 (OK)
                .body("id", equalTo(orderId)) // Verifica que el ID del pedido sea igual al ID proporcionado
                .log().body();
    }
}


