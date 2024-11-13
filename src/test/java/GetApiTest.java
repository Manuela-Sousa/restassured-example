import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import utils.ReadPropertiesFile;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetApiTest {

    private static final String BASE_URI = ReadPropertiesFile.getPropertyValue("endpoint");
    private static final int EXPECTED_STATUS_CODE = 200;
    private static final int USER_ID = 2;
    private static final String EXPECTED_EMAIL = "janet.weaver@reqres.in";
    private static final String EXPECTED_FIRST_NAME = "Janet";
    private static final String EXPECTED_LAST_NAME = "Weaver";
    private static final String AVATAR_FIELD = "data.avatar";

    @Test
    public void getApiTest() {

        // Perform GET request and validate the response
        given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .when()
                .get("/users/" + USER_ID)
                .then()

                .statusCode(EXPECTED_STATUS_CODE)

                .body("data.id", equalTo(USER_ID))
                .body("data.email", equalTo(EXPECTED_EMAIL))
                .body("data.first_name", equalTo(EXPECTED_FIRST_NAME))
                .body("data.last_name", equalTo(EXPECTED_LAST_NAME))
                .body(AVATAR_FIELD, notNullValue())

                .log().all();
    }
}
