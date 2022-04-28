package helpers;

import static io.restassured.RestAssured.given;
//log-pass is here
public class Browserstack {

    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic("olga_ouHam9", "iDs7wY8LzQqGhHiJ1369")
                .when()
                .get("https://api-cloud.browserstack.com/app-automate/sessions/" + sessionId +".json")
                .then()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
