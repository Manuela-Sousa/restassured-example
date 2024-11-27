import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import utils.ReadPropertiesFile;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DeleteApiTest {

    private static final String BASE_URI = ReadPropertiesFile.getPropertyValue("endpoint");
    private static final int EXPECTED_STATUS_CODE = 204;
    private static final int USER_ID = 2;
    private static final String GET_URL = "/users/";

    @Test
    public void deleteApiTest() {

        given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .when()
                .delete(GET_URL + USER_ID)
                .then()

                .statusCode(EXPECTED_STATUS_CODE)
                .body(equalTo(""))

                .log().all();
    }
}
