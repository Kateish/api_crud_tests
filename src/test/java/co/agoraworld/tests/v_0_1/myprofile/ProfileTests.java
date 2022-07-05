package co.agoraworld.tests.v_0_1.myprofile;

import co.agoraworld.tests.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;

public class ProfileTests extends BaseTest {
    @Test
    public void getMyAddressTest() {
        Response response = getResponse("https://dev.agoraworld.dev/api/0.1/myprofile/addresses");
        response.prettyPrint();
        checkEmptyAddress(response);
    }
    @Test
    public void getAllAddressesTest(){
        Response response = getResponse("https://dev.agoraworld.dev/api/0.1/myprofile/addresses");
        response.prettyPrint();
        checkEmptyAddress(response);
    }

    @Test
    public void getMyProfileTest() {
        Response response = getResponse("https://dev.agoraworld.dev/api/0.1/myprofile");
        response.prettyPrint();
        checkProfile(response);
    }

    @Test
    public void updateAddressCheckUpdatesArchiveAddressCheckResult() {
        Map<String, Object> body = new HashMap<>();
        body.put("address_line_1", "Line 1");
        body.put("city", "Venice");
        body.put("country", "voluptate esse");
        body.put("email", "kate.guselnikova+admin@agoraworld.co");
        body.put("first_name", "cillum ipsum deserunt");
        body.put("id", "20833717");
        body.put("last_name", "Duis");
        body.put("phone_number", "do qui laboris deserunt");
        body.put("zip_code", "qui sit cillum");
        body.put("state", "qui sit cillum");
        body.put("address_line_2", "eu nostrud dolore exercitation");

        //add the address
        Response responseAddressAdded = postResponse("https://dev.agoraworld.dev/api/0.1/myprofile/addresses", String.valueOf(body));
        responseAddressAdded.prettyPrint();
        int id = responseAddressAdded.getBody().jsonPath().get("id");

        //check it's added
        Response responseAddressCheck = getResponse("https://dev.agoraworld.dev/api/0.1/myprofile/addresses");
        responseAddressCheck.prettyPrint();
        checkAddress(responseAddressCheck, id);

        //modify the address
        Response response = putResponse("https://dev.agoraworld.dev/api/0.1/myprofile/addresses/"+id, "kate.guselnikova+admin@agoraworld.co");
        response.prettyPrint();

        //check the modification
        Response responseChanged = getResponse("https://dev.agoraworld.dev/api/0.1/myprofile/addresses");
        responseChanged.prettyPrint();
        checkModifiedAddress(responseChanged, id);

        //delete address
        Response responseDeleted = deleteResponse("https://dev.agoraworld.dev/api/0.1/myprofile/addresses/" + id);
        responseDeleted.prettyPrint();
    }
    @Test
    public void UpdateMyProfileTest() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //update name
        Map<String, Object> putAName = new HashMap();
        putAName.put("value", "pariatur veniam Excepteur");
        String putANameString = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(putAName);
        Response responseUpdateName = putResponseWithBody("https://dev.agoraworld.dev/api/0.1/myprofile/name", putANameString);
        responseUpdateName.prettyPrint();
        //update user marketing email
        Map<String, Object> putMarketingEmail = new HashMap();
        putMarketingEmail.put("marketing_email", "in Excepteur id");
        String putMarketingEmailString = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(putMarketingEmail);
        Response responseUpdateUserMarketingEmail = putResponseWithBody("https://dev.agoraworld.dev/api/0.1/myprofile/marketing_email", putMarketingEmailString);
        responseUpdateUserMarketingEmail.prettyPrint();
        //update birthday
        Map<String, Object> putBirthday = new HashMap();
        putBirthday.put("value", "1957-01-21");
        String putBirthdayString = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(putBirthday);
        Response responseUpdateBirthday = putResponseWithBody("https://dev.agoraworld.dev/api/0.1/myprofile/birthday", putBirthdayString);
        responseUpdateBirthday.prettyPrint();
        //update about me
        Map<String, Object> putAboutMe = new HashMap();
        putAboutMe.put("value", "pariatur veniam Excepteur");
        String putAboutMeString = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(putAboutMe);
        Response responseUpdateAboutMe = putResponseWithBody("https://dev.agoraworld.dev/api/0.1/myprofile/bio", putAboutMeString);
        responseUpdateAboutMe.prettyPrint();
        //update username
        Map<String, Object> postUsername = new HashMap();
        postUsername.put("value", "pariatur veniam Excepteur");
        String postUsernameString = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(postUsername);
        Response responseUpdateUserName = postResponse("https://dev.agoraworld.dev/api/0.1/myprofile/username", postUsernameString);
        responseUpdateUserName.prettyPrint();
        //update user property
        Map<String, Object> postUserProp = new HashMap();
        postUserProp.put("property_name", "officia");
        postUserProp.put("value", "eu exerci");
        String postUserPropString = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(postUserProp);
        Response responseUpdateUserProp = postResponse("https://dev.agoraworld.dev/api/0.1/myprofile/update_user_property", postUserPropString);
        responseUpdateUserProp.prettyPrint();
        //update my notifications that I received before X time as not new
        Response responseUpdateMyNotifications = postResponse("https://dev.agoraworld.dev/api/0.1/myprofile/update_user_property", String.valueOf(postUserProp));
        responseUpdateMyNotifications.prettyPrint();
        //update Amplitude credentials
        //Init new device id of OneSignal and push token

        //check the changes

        Response response = getResponse("https://dev.agoraworld.dev/api/0.1/myprofile");
        response.prettyPrint();

    }
    @Test
    public void getMyPostsTest(){
        Response response = getResponse("https://dev.agoraworld.dev/api/0.1/myprofile/posts?offset=0&limit=10&id=78367357");
        response.prettyPrint();
    }

    @Test
    public void getListingOfMyNotificationsTest(){
        Response response = getResponse("https://dev.agoraworld.dev/api/0.1/myprofile/notifications?offset=0&limit=10&beforeTimeId=78367357");
        response.prettyPrint();
    }

    @Test
    public void getCountOfMyNewNotificationsTest(){
        Response response = getResponse("https://dev.agoraworld.dev/api/0.1/myprofile/new_notifications_count_2");
        response.prettyPrint();
        assertThat(response.getBody().jsonPath().get("count"), is(10));
    }


    public void checkEmptyAddress(Response response) {
        List item = response.getBody().jsonPath().get("items");
        assertThat(item.size(), is(0));
    }

    public void checkAddress(Response response, int id) {
        List item = response.getBody().jsonPath().get("items");
        assertThat(item.size(), is(1));
        assertThat(response.getBody().jsonPath().get("items[0].id"), is(id));
    }

    public void checkProfile(Response response) {
        int id = response.getBody().jsonPath().get("id");
        String username = response.getBody().jsonPath().get("username");
        int coins = response.getBody().jsonPath().get("coins");
        int coinsExpiringWithinOneMonth = response.getBody().jsonPath().get("coins_expiring_within_one_month");
        String email = response.getBody().jsonPath().get("email");
        int mediaId = response.getBody().jsonPath().get("media.id");
        String mediaUrl = response.getBody().jsonPath().get("media.url");
        String mediaContentType = response.getBody().jsonPath().get("media.content_type");
        String status = response.getBody().jsonPath().get("status");
        String propertiesTasks = response.getBody().jsonPath().get("properties[0].tasks");
        Map propertiesImmutable = response.getBody().jsonPath().get("properties.immutable");
        String propertiesMutableTcAgreementStatus = response.getBody().jsonPath().get("properties.mutable.tc_agreement_status");
        String propertiesMutableDisplayWelcomeBanner = response.getBody().jsonPath().get("properties.mutable.display_welcome_banner");
        String propertiesMutableHideClaimWelcomeCoinsBanner = response.getBody().jsonPath().get("properties.mutable.hide_claim_welcome_coins_banner");
        List<String> groups = response.getBody().jsonPath().get("groups");
        String inviteCode = response.getBody().jsonPath().get("invite_code");
        int postsBookmarked = response.getBody().jsonPath().get("posts_bookmarked");
        int productsBookmarked = response.getBody().jsonPath().get("products_bookmarked");
        int followeesCount = response.getBody().jsonPath().get("followees_count");
        int followersCount = response.getBody().jsonPath().get("followers_count");
        int postsCount = response.getBody().jsonPath().get("posts_count");
        assertThat(id, is(108794));
        assertThat(username, is(""));
        assertThat(coins, is(5));
        assertThat(coinsExpiringWithinOneMonth, is(0));
        assertThat(email, is("kate.guselnikova+admin@agoraworld.co"));
        assertThat(mediaId, is(797669));
        assertThat(mediaUrl, is(""));
        assertThat(mediaContentType, is("image/jpeg"));
        assertThat(status, is("CREATED"));
        assertThat(propertiesTasks, is(isEmptyOrNullString()));
        assertThat(propertiesImmutable, is(propertiesImmutable));
        assertThat(propertiesMutableTcAgreementStatus, is("false"));
        assertThat(propertiesMutableDisplayWelcomeBanner, is("true"));
        assertThat(propertiesMutableHideClaimWelcomeCoinsBanner, is("true"));
        assertThat(groups.size(), is(0));
        assertThat(inviteCode, is(""));
        assertThat(postsBookmarked, is(0));
        assertThat(productsBookmarked, is(0));
        assertThat(followeesCount, is(0));
        assertThat(followersCount, is(0));
        assertThat(postsCount, is(0));
    }
    public void checkModifiedProfile(Response response) {
        int id = response.getBody().jsonPath().get("id");
        String username = response.getBody().jsonPath().get("username");
        int coins = response.getBody().jsonPath().get("coins");
        int coinsExpiringWithinOneMonth = response.getBody().jsonPath().get("coins_expiring_within_one_month");
        String email = response.getBody().jsonPath().get("email");
        int mediaId = response.getBody().jsonPath().get("media.id");
        String mediaUrl = response.getBody().jsonPath().get("media.url");
        String mediaContentType = response.getBody().jsonPath().get("media.content_type");
        String status = response.getBody().jsonPath().get("status");
        String propertiesTasks = response.getBody().jsonPath().get("properties[0].tasks");
        Map propertiesImmutable = response.getBody().jsonPath().get("properties.immutable");
        String propertiesMutableTcAgreementStatus = response.getBody().jsonPath().get("properties.mutable.tc_agreement_status");
        String propertiesMutableDisplayWelcomeBanner = response.getBody().jsonPath().get("properties.mutable.display_welcome_banner");
        String propertiesMutableHideClaimWelcomeCoinsBanner = response.getBody().jsonPath().get("properties.mutable.hide_claim_welcome_coins_banner");
        List<String> groups = response.getBody().jsonPath().get("groups");
        String inviteCode = response.getBody().jsonPath().get("invite_code");
        int postsBookmarked = response.getBody().jsonPath().get("posts_bookmarked");
        int productsBookmarked = response.getBody().jsonPath().get("products_bookmarked");
        int followeesCount = response.getBody().jsonPath().get("followees_count");
        int followersCount = response.getBody().jsonPath().get("followers_count");
        int postsCount = response.getBody().jsonPath().get("posts_count");
        assertThat(id, is(108794));
        assertThat(username, is(""));
        assertThat(coins, is(5));
        assertThat(coinsExpiringWithinOneMonth, is(0));
        assertThat(email, is("kate.guselnikova+admin@agoraworld.co"));
        assertThat(mediaId, is(797669));
        assertThat(mediaUrl, is(""));
        assertThat(mediaContentType, is("image/jpeg"));
        assertThat(status, is("CREATED"));
        assertThat(propertiesTasks, is(isEmptyOrNullString()));
        assertThat(propertiesImmutable, is(propertiesImmutable));
        assertThat(propertiesMutableTcAgreementStatus, is("false"));
        assertThat(propertiesMutableDisplayWelcomeBanner, is("true"));
        assertThat(propertiesMutableHideClaimWelcomeCoinsBanner, is("true"));
        assertThat(groups.size(), is(0));
        assertThat(inviteCode, is(""));
        assertThat(postsBookmarked, is(0));
        assertThat(productsBookmarked, is(0));
        assertThat(followeesCount, is(0));
        assertThat(followersCount, is(0));
        assertThat(postsCount, is(0));
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

    public Response putResponse(String url, String email) {
        Response response = given()
                .when()
                .accept("application/json")
                .header("Authorization", String.format("Bearer %s", token))
                .header("CF-Access-Client-Id", "02d193502de091a550e115ab41ea6682.access")
                .header("CF-Access-Client-Secret", "ad69cdaebc5ad6fbfb692c739577deb036721795a3b121c1044cb76310414df2")
                .header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"address_line_1\": \"Line 1\",\n" +
                        "  \"city\": \"Venice\",\n" +
                        "  \"country\": \"voluptate esse\",\n" +
                        "  \"email\": " + email + ",\n" +
                        "  \"first_name\": \"New Name\",\n" +
                        "  \"id\": 20833717,\n" +
                        "  \"last_name\": \"New LN\",\n" +
                        "  \"phone_number\": \"886544\",\n" +
                        "  \"zip_code\": \"12345\",\n" +
                        "  \"state\": \"state\",\n" +
                        "  \"address_line_2\": \"line 2\"\n" +
                        "}")
                .put(url)
                .then()
                .extract().response();
        return response;
    }

    public void checkModifiedAddress(Response response, int id) {
        List item = response.getBody().jsonPath().get("items");
        assertThat(item.size(), is(1));
        assertThat(response.getBody().jsonPath().get("items[0].id"), is(id));
    }

    public static Response postResponse(String url, String body) {
        Response response = given()
                .when()
                .accept("application/json")
                .header("Authorization", String.format("Bearer %s", token))
                .header("CF-Access-Client-Id", "02d193502de091a550e115ab41ea6682.access")
                .header("CF-Access-Client-Secret", "ad69cdaebc5ad6fbfb692c739577deb036721795a3b121c1044cb76310414df2")
                .header("Content-Type", "application/json")
                .body(body)
                .filter(new AllureRestAssured())
                .when()
                .log().all()
                .post(url)
                .then()
                .extract().response();
        return response;
    }

    public Response deleteResponse(String url) {
        Response response = given()
                .when()
                .accept("application/json")
                .header("Authorization", String.format("Bearer %s", token))
                .header("CF-Access-Client-Id", "02d193502de091a550e115ab41ea6682.access")
                .header("CF-Access-Client-Secret", "ad69cdaebc5ad6fbfb692c739577deb036721795a3b121c1044cb76310414df2")
                .delete(url)
                .then()
                .extract().response();
        return response;
    }
}
