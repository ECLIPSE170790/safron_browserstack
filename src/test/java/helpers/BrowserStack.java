package helpers;

import config.BrowserStackConfig;
import org.aeonbits.owner.ConfigFactory;
import static io.restassured.RestAssured.given;

public class BrowserStack {
    public static String videoUrl(String sessionId) {

        return given()
                .auth().basic(ConfigFactory.create(BrowserStackConfig.class).login(), ConfigFactory.create(BrowserStackConfig.class).key())
                .when()
                .get(ConfigFactory.create(BrowserStackConfig.class).session() + sessionId + ".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response()
                .path("automation_session.video_url");
    }
}
