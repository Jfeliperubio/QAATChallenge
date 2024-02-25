package org.autengineer.user;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.autengineer.util.UserDataGenerator;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateUserTest {

    // Indica si se debe sobrescribir el archivo. Si es false, no se sobrescribirá y se utilizará la data existente.
    // Si es true generará nueva data
    private static final boolean OVERWRITE_FILE = false;

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8080/api/v3";
    }

    @Test
    public void testAddUser() {
        // Si OVERWRITE_FILE es false y el archivo existe, leer el JSON del archivo
        String userJson;
        if (!OVERWRITE_FILE && UserDataGenerator.doesFileExist("user.json")) {
            userJson = UserDataGenerator.readJsonFromFile("user.json");
        } else {
            userJson = UserDataGenerator.generateRandomUserJson();
            // Escribir el JSON en el archivo solo si OVERWRITE_FILE es true o si el archivo no existe
            UserDataGenerator.writeJsonToFile(userJson, "user.json", OVERWRITE_FILE);
        }

        // Enviar la solicitud POST con el JSON generado o recuperado del archivo
        given()
                .contentType(ContentType.JSON)
                .body(userJson)
            .when()
                .post("/user")
            .then()
                .statusCode(200)
                .log().body();
    }
}