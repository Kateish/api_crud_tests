package co.agoraworld.tests.v_0_1;

import co.agoraworld.tests.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class UserCheckoutAgreementTests extends BaseTest {
    @Test
    public void checkStatusOfUserAgreement(){
        Response response = checkResponse("https://dev.agoraworld.dev/api/0.1/user/checkout/agreement");
        response.prettyPrint();
        assertThat(response.getBody().jsonPath().get("status"), is(false));
        assertThat(response.getBody().jsonPath().get("agreement_url"), is("https://docs.google.com/document/d/10gJMxqnxiMmJutt56muDMuYwFdMVZIei/edit#heading=h.gjdgxs"));
    }
    @Test
    public void setStatusOfUserAgreementAndCheck(){
        String status = "true";
        Response response = putResponse("https://dev.agoraworld.dev/api/0.1/user/checkout/agreement/"+status);
        response.prettyPrint();
        assertThat(response.getBody().jsonPath().get("status"), is(true));
        assertThat(response.getBody().jsonPath().get("agreement_url"), is("https://docs.google.com/document/d/10gJMxqnxiMmJutt56muDMuYwFdMVZIei/edit#heading=h.gjdgxs"));
        status = "false";
        Response responseFalse = putResponse("https://dev.agoraworld.dev/api/0.1/user/checkout/agreement/"+status);
        responseFalse.prettyPrint();
        assertThat(responseFalse.getBody().jsonPath().get("status"), is(false));
        assertThat(responseFalse.getBody().jsonPath().get("agreement_url"), is("https://docs.google.com/document/d/10gJMxqnxiMmJutt56muDMuYwFdMVZIei/edit#heading=h.gjdgxs"));

    }
    public Response putResponse(String url) {
        Response response = given()
                .when()
                .accept("application/json")
                .header("Authorization", String.format("Bearer %s", token))
                .header("CF-Access-Client-Id", "02d193502de091a550e115ab41ea6682.access")
                .header("CF-Access-Client-Secret", "ad69cdaebc5ad6fbfb692c739577deb036721795a3b121c1044cb76310414df2")
                .put(url)
                .then()
                .extract().response();
        return response;
    }
    public Response checkResponse(String url) {
        Response response = given()
                .when()
                .accept("application/json")
                .header("Authorization", String.format("Bearer %s", token))
                .header("CF-Access-Client-Id", "02d193502de091a550e115ab41ea6682.access")
                .header("CF-Access-Client-Secret", "ad69cdaebc5ad6fbfb692c739577deb036721795a3b121c1044cb76310414df2")
                .get(url)
                .then()
                .extract().response();
        return response;
    }
}