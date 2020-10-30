import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestGetRequests {

    @Test
    public void makeGetToHome() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;
        Response response = null;
        try {
            response = RestAssured.given()
                    .when()
                    .get("/");
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertTrue(response.body().print().contains("successfully"));
    }

    @Test
    public void makeGetToInfoPage() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;

        Response response = null;
        try {
            response = RestAssured.given()
                    .when()
                    .get("/info");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(200, response.getStatusCode());
        Assert.assertTrue(response.body().print().contains("info page"));
    }

    @Test
    public void nagativeGetRequest() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3000;

        Response response = null;
        try {
            response = RestAssured.given()
                    .when()
                    .get("/unknowURI");
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(404, response.getStatusCode());
    }

}
