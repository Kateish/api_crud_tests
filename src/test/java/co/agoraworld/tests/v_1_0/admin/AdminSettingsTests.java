package co.agoraworld.tests.v_1_0.admin;

import co.agoraworld.tests.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AdminSettingsTests extends BaseTest {

    @Test
    public void getSettingsGroups(){
        Response response = collectionsGetResponse("https://dev.agoraworld.dev/api/admin/settings/groups");
        response.prettyPrint();
        getSettingsGroupsResponseIsOk(response);
    }

    @Test
    public void getSettingsByGroup(){
        Response response = collectionsGetResponse("https://dev.agoraworld.dev/api/admin/settings/groups/CART");
        response.prettyPrint();
        checkSettingsPerAGroup(response);
    }

    @Test
    public void getSettingsByKey(){
        Response response = collectionsGetResponse("https://dev.agoraworld.dev/api/admin/settings?key=MAX_QUANTITY_PER_CART_ITEM");
        response.prettyPrint();
        checkSettingsByKey(response);
    }
    public void getSettingsGroupsResponseIsOk(Response response){
        String key = response.getBody().jsonPath().get("[0].key");
        String key1 = response.getBody().jsonPath().get("[1].key");
        String key2 = response.getBody().jsonPath().get("[2].key");
        String key3 = response.getBody().jsonPath().get("[3].key");
        String key4 = response.getBody().jsonPath().get("[4].key");
        String key5 = response.getBody().jsonPath().get("[5].key");
        String key6= response.getBody().jsonPath().get("[6].key");
        String name = response.getBody().jsonPath().get("[0].name");
        String name1 = response.getBody().jsonPath().get("[1].name");
        String name2 = response.getBody().jsonPath().get("[2].name");
        String name3 = response.getBody().jsonPath().get("[3].name");
        String name4 = response.getBody().jsonPath().get("[4].name");
        String name5 = response.getBody().jsonPath().get("[5].name");
        String name6 = response.getBody().jsonPath().get("[6].name");
        String description = response.getBody().jsonPath().get("[0].description");
        String description1 = response.getBody().jsonPath().get("[1].description");
        String description2 = response.getBody().jsonPath().get("[2].description");
        String description3 = response.getBody().jsonPath().get("[3].description");
        String description4 = response.getBody().jsonPath().get("[4].description");
        String description5 = response.getBody().jsonPath().get("[5].description");
        String description6 = response.getBody().jsonPath().get("[6].description");
        assertThat(key, is("POPULAR_USERS"));
        assertThat(name, is("Popular users"));
        assertThat(description, is("Setting for preparing list of popular users"));
        assertThat(key1, is("DISCOVERY"));
        assertThat(name1, is("Discovery entities setup"));
        assertThat(description1, is("Setting for discovery screen, mostly list of recommended entities"));
        assertThat(key2, is("NOTIFICATION"));
        assertThat(name2, is("Notification"));
        assertThat(description2, is("Setting for notifications"));
        assertThat(key3, is("USER"));
        assertThat(name3, is("User settings"));
        assertThat(description3, is("Settings for users"));
        assertThat(key4, is("LIVESTREAM"));
        assertThat(name4, is("Livestream settings"));
        assertThat(description4, is("Settings for livestreams"));
        assertThat(key5, is("MIRAKL"));
        assertThat(name5, is("Mirakl settings"));
        assertThat(description5, is("Settings for mirakl"));
        assertThat(key6, is("CART"));
        assertThat(name6, is("Cart settings"));
        assertThat(description6, is("Settings for cart"));
    }
    public void checkSettingsPerAGroup(Response response){
        String key = response.getBody().jsonPath().get("[0].key");
        String value = response.getBody().jsonPath().get("[0].value");
        String name = response.getBody().jsonPath().get("[0].name");
        String description = response.getBody().jsonPath().get("[0].description");
        assertThat(key, is("MAX_QUANTITY_PER_CART_ITEM"));
        assertThat(value, is("10"));
        assertThat(name, is("Max quantity per cart item"));
        assertThat(description, is("The maximum quantity allowed to set per offer in the cart"));

    }

    public void checkSettingsByKey(Response response){
        String key = response.getBody().jsonPath().get("key");
        String value = response.getBody().jsonPath().get("value");
        String name = response.getBody().jsonPath().get("name");
        String description = response.getBody().jsonPath().get("description");
        assertThat(key, is("MAX_QUANTITY_PER_CART_ITEM"));
        assertThat(value, is("10"));
        assertThat(name, is("Max quantity per cart item"));
        assertThat(description, is("The maximum quantity allowed to set per offer in the cart"));
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
