package co.agoraworld.tests.v_1_0.admin;

import co.agoraworld.Constants.v_0_1.AdminConstants;
import co.agoraworld.tests.pages.LoginPage;
import co.agoraworld.tests.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;


public class GeneralHealthCheckTests extends BaseTest {

    @Test
   public void checkBEHealthTest() {
        verifyStatus200(AdminConstants.API_1_0 + AdminConstants.ADMIN_GET_POST_COLLECTION_BY_ID);
        verifyStatus200(AdminConstants.API_1_0 + AdminConstants.ADMIN_GET_POST_COLLECTION_BY_TYPE);
    }

    public void verifyStatus200(String url) {
        Response response = collectionsGetResponse(url);
        response.then().assertThat().statusCode(200);
    }

    public Response collectionsGetResponse(String url) {
        Response response = given()
                .when()
                .accept("application/json")
                .header("Authorization", String.format("Bearer %s", token))
                .header("CF-Access-Client-Id", "12ed4393b363007d78d071511cf99016.access")
                .header("CF-Access-Client-Secret", "f19a1e156a2497d4677d286d90abcb51d4705302f0a17294a4cd5ffe2ca9e356")
                .get(url)
                .then()
                .extract().response();
        return response;
    }
    public void verifyResponseContents(){

    }

}
