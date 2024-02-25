package org.autengineer.store;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeletePurchaseOrderByIdTest {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8080/api/v3";
    }

    @Test
    public void testDeletePurchaseOrderById() {
        int orderId = 10; // Reemplaza 123 con el ID del pedido que deseas eliminar

        given()
                .pathParam("orderId", orderId)
            .when()
                .delete("/store/order/{orderId}")
            .then()
                .statusCode(200) // Verifica que se reciba un código de estado 200 (OK) después de eliminar el pedido
                .log().body();
    }
}

