import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import utils.ReadPropertiesFile;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutApiTest {

    private static final String BASE_URI = ReadPropertiesFile.getPropertyValue("endpoint");
    private static final String EMAIL = "george.bluth@reqres.in";
    private static final String FIRST_NAME = "Manuela Sousa";
    private static final String LAST_NAME = "Bluth";
    private static final String AVATAR = "https://reqres.in/img/faces/1-image.jpg";
    private static final String USER_ID = "2";
    private static final String POST_URL = "/users/";
    private static final int EXPECTED_STATUS_CODE = 200;

    @Test
    public void putApiTest() {

        String requestBody = createRequestBody(EMAIL, FIRST_NAME, LAST_NAME, AVATAR);

        given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON).log().all()
                .body(requestBody)
                .when()
                .put(POST_URL + USER_ID)
                .then()

                .statusCode(EXPECTED_STATUS_CODE)

                .body("email", equalTo(EMAIL))
                .body("first_name", equalTo(FIRST_NAME))
                .body("last_name", equalTo(LAST_NAME))
                .body(("avatar"), equalTo(AVATAR))

                .log().all();
    }

    private String createRequestBody(String email, String firstName, String lastName, String avatar) {
        return String.format("""
                {
                    "email": "%s",
                    "first_name": "%s",
                    "last_name": "%s",
                    "avatar": "%s"
                }
                """, email, firstName, lastName, avatar);
    }
}
