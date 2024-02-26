package org.autengineer.user;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class UpdateUserByUserNameTest {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8080/api/v3"; // Ajusta la URL base según tu configuración
    }

    @Test
    public void testUpdateUserByUsername() {
        String username = "kathi.blick"; // Nombre de usuario a actualizar
        String requestBody = "{\n" +
                "  \"id\": 123,\n" +
                "  \"username\": \"test_user\",\n" +
                "  \"firstName\": \"John\",\n" +
                "  \"lastName\": \"Doe\",\n" +
                "  \"email\": \"john.doe@example.com\",\n" +
                "  \"password\": \"password\",\n" +
                "  \"phone\": \"1234567890\",\n" +
                "  \"userStatus\": 1\n" +
                "}";

        given()
                .contentType(ContentType.JSON)
                .pathParam("username", username) // Establece el parámetro de ruta username
                .body(requestBody)
            .when()
                .put("/user/{username}") // Hace una solicitud PUT al endpoint /user/{username}
            .then()
                .statusCode(200) // Verifica que se reciba un código de estado 200 (OK) después de actualizar el usuario
                .log().body();
    }
}

