package org.autengineer.user;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.autengineer.util.UserListDataGenerator;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CreateUserListTest {

    //Indica si se debe sobrescribir el archivo. Si es false, no se sobrescribirá y se utilizará la data existente.
    //Si es true generará nueva data
    private static final boolean OVERWRITE_FILE = true;
    private static final String FILE_NAME = "userslist.json";
    private static final int NUM_USERS = 5; // Número de usuarios a generar

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8080/api/v3";
    }

    @Test
    public void testCreateUserList() {
        // Generar la lista de usuarios y escribir en el archivo
        UserListDataGenerator.generateRandomUsersJson(NUM_USERS, FILE_NAME, OVERWRITE_FILE);

        // Leer el JSON del archivo
        String userListJson = UserListDataGenerator.readJsonFromFile(FILE_NAME);

        // Enviar la solicitud POST con la lista de usuarios
        given()
                .contentType(ContentType.JSON)
                .body(userListJson)
            .when()
                .post("/user/createWithList")
            .then()
                .statusCode(200)
                .log().body();
    }
}

