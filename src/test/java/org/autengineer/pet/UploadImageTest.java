package org.autengineer.pet;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.File;
import static io.restassured.RestAssured.given;

public class UploadImageTest {

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8080/api/v3";
    }

    @Test
    public void testUploadImage() {
        File imageFile = new File("src/main/resources/paco.jpg"); // Reemplaza con la ruta de tu imagen
        int petId = 7; // ID de la mascota a la que se le subirá la imagen

        given()
                .multiPart("file", imageFile, "image/jpeg") // Especifica el tipo de medio como image/jpeg
            .when()
                .post("/pet/{petId}/uploadImage", petId) // Utiliza el ID de la mascota en la URL
            .then()
                .statusCode(200)
                .log().body();
    }
}

