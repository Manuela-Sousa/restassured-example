import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import utils.ReadPropertiesFile;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class PostApiTest {

    private static final String BASE_URI = ReadPropertiesFile.getPropertyValue("endpoint");
    private static final String USER_NAME = "Manuela Sousa";
    private static final String USER_JOB = "QA Lead";
    private static final String POST_URL = "/users";
    private static final int EXPECTED_STATUS_CODE = 201;

    @Test
    public void postApiTest() {

        String requestBody = createRequestBody(USER_NAME, USER_JOB);

        given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post(POST_URL)
                .then()

                .statusCode(EXPECTED_STATUS_CODE)

                .body("name", equalTo(USER_NAME))
                .body("job", equalTo(USER_JOB))

                .body("id", notNullValue())

                .log().all();
    }

    private String createRequestBody(String name, String job) {
        return String.format("""
                {
                    "name": "%s",
                    "job": "%s"
                }
                """, name, job);
    }
}
