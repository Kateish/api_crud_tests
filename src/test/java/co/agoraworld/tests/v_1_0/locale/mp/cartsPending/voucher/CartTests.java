package co.agoraworld.tests.v_1_0.locale.mp.cartsPending.voucher;

import co.agoraworld.tests.BaseTest;
import co.agoraworld.tests.pages.LoginPage;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CartTests extends BaseTest {

    @Test
    @Description("Get pending cart")
    public void getPendingCartOKTest(){
        Response response = getResponse("https://dev.agoraworld.dev/api/1.0/:locale/mp/carts/pending");
        response.prettyPrint();
        int id = response.getBody().jsonPath().get("id");
        int subTotalPrice = response.getBody().jsonPath().get("sub_total_price");
        int shippingPrice = response.getBody().jsonPath().get("shipping_price");
        int totalPrice = response.getBody().jsonPath().get("total_price");
        int totalCoins = response.getBody().jsonPath().get("total_coins");
        assertThat(id, is(536));
        assertThat(subTotalPrice, is(0));
        assertThat(shippingPrice, is(0));
        assertThat(totalPrice, is(0));
        assertThat(totalCoins, is(0));

    }

    @Test
    @Description("Update shipping type of cart logistic order")
    public void putShippingTypeOfCardTest(){
        Response response = putResponse("https://dev.agoraworld.dev/api/1.0/:locale/mp/carts/pending/shipping_type");
        response.prettyPrint();
    }

    public Response getResponse(String url) {
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
    public Response putResponse(String url) {
        Response response = given()
                .when()
                .accept("application/json")
                .header("Authorization", String.format("Bearer %s", token))
                .header("CF-Access-Client-Id", "02d193502de091a550e115ab41ea6682.access")
                .header("CF-Access-Client-Secret", "ad69cdaebc5ad6fbfb692c739577deb036721795a3b121c1044cb76310414df2")
                .body("{\n" +
                        "  \"shipping_type_code\": \"some code\",\n" +
                        "  \"shop_id\": 39899822\n" +
                        "}")
                .put(url)
                .then()
                .extract().response();
        return response;
    }
}
