package org.autengineer.pet;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.autengineer.util.PetGenerator;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class AddPet {

    //Indica si se debe sobrescribir el archivo. Si es false, no se sobrescribirá y se utilizará la data existente.
    //Si es true generara nueva data
    private static final boolean OVERWRITE_FILE = false;

    @BeforeClass
    public static void setUp() {
        RestAssured.baseURI = "http://localhost:8080/api/v3";
    }

    @Test
    public void testAddPet() {
        // Si OVERWRITE_FILE es false y el archivo existe, leer el JSON del archivo
        String petJson;
        if (!OVERWRITE_FILE && PetGenerator.doesFileExist("pet.json")) {
            petJson = PetGenerator.readJsonFromFile("pet.json");
        } else {
            petJson = PetGenerator.createRandomPetJson();
            // Escribir el JSON en el archivo solo si OVERWRITE_FILE es true o si el archivo no existe
            PetGenerator.writeJsonToFile(petJson, "pet.json", OVERWRITE_FILE);
        }

        // Enviar la solicitud POST con el JSON generado o recuperado del archivo
        given()
                .contentType(ContentType.JSON)
                .body(petJson)
                .when()
                .post("/pet")
                .then()
                .statusCode(200)
                .log().body();
    }
}
