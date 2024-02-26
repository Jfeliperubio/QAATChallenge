package org.autengineer.user;

import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class DeleteUserTest {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8080/api/v3";
    }

    @Test
    public void testDeleteUserByUsername() {
        String username = "kathi.blick"; // Nombre de usuario a eliminar

        given()
                .pathParam("username", username) // Establece el parámetro de ruta username
            .when()
                .delete("/user/{username}") // Hace una solicitud DELETE al endpoint /user/{username}
            .then()
                .statusCode(200) // Verifica que se reciba un código de estado 204 (No Content) después de eliminar el usuario
                .log().body();
    }
}
