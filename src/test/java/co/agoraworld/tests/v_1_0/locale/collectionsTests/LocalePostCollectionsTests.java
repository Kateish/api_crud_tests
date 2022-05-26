package co.agoraworld.tests.v_1_0.locale.collectionsTests;

import co.agoraworld.tests.BaseTest;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class LocalePostCollectionsTests extends BaseTest {

    @Test
    @Description("Get post collection by ID")
    void getPostCollectionByIdTest() {
        Response response = collectionsGetResponse("https://dev.agoraworld.dev/api/1.0/:locale/post_collections/22");
        response.prettyPrint();
        int value = response.getBody().jsonPath().get("id");
        String type = response.getBody().jsonPath().get("type");
        String name = response.getBody().jsonPath().get("name");
        boolean visible = response.getBody().jsonPath().get("visible");
        String userId = response.getBody().jsonPath().get("posts[0].user[0].id");
        String userName = response.getBody().jsonPath().get("posts[0].user[0].username");
        String lastName = response.getBody().jsonPath().get("posts[0].user[0].name");
        String postType = response.getBody().jsonPath().get("posts[0].post_type[0]");
        assertThat(value, is(22));
        assertThat(type, is("DEFAULT"));
        assertThat(name, is("Comfortably numb"));
        assertThat(visible, is(false));
        assertThat(userId, is(nullValue()));
    }

    public Response collectionsGetResponse(String url) {
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
