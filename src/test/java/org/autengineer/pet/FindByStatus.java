import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FindByStatus {

    @BeforeClass
    public static void setup() {
        baseURI = "http://localhost:8080/api/v3";
    }

    @Test
    public void testFindPetsByStatus() {
        given()
                .queryParam("status", "pending")
            .when()
                .get("/pet/findByStatus")
            .then()
                .statusCode(200)
                .body("status", everyItem(equalTo("pending")))
                .log().body();
    }
}
