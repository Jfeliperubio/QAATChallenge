package org.autengineer.pet;


import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FindByTags {

    @BeforeClass
    public static void setup() {
        baseURI = "http://localhost:8080/api/v3";
    }

    @Test
    public void testFindPetsByTags() {
        given()
                .queryParam("tags", "friendly")
            .when()
                .get("/pet/findByTags")
            .then()
                .statusCode(200)
                .body("[0].tags[0].name", equalTo("friendly"))
                .log().body();
    }
    }



