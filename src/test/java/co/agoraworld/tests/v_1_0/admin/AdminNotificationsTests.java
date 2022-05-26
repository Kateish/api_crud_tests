package co.agoraworld.tests.v_1_0.admin;

import co.agoraworld.tests.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AdminNotificationsTests extends BaseTest {

    @Test
    public void getAllAdminNotifications() {
        Response response = collectionsGetResponse("https://dev.agoraworld.dev/api/admin/notifications/in_app?offset=0&limit=2");
        response.prettyPrint();
        checkResponseAllAdminNotifications(response);
    }

    @Test
    public void getAdminNotificationById() {
        Response response = collectionsGetResponse("https://dev.agoraworld.dev/api/admin/notifications/in_app/61");
        response.prettyPrint();
        checkNotificationById(response);
    }

    @Test
    public void getAdminNotificationRefEntityTypes() {
        Response response = collectionsGetResponse("https://dev.agoraworld.dev/api/admin/notifications/in_app/ref_entity_types");
        response.prettyPrint();
        checkRefTypes(response);
    }

    public void checkResponseAllAdminNotifications(Response response) {
        int firstItemId = response.getBody().jsonPath().get("items[0].id");
        String firstItemName = response.getBody().jsonPath().get("items[0].name");
        String firstItemMessage = response.getBody().jsonPath().get("items[0].message");
        int firstItemNotificationTime = response.getBody().jsonPath().get("items[0].notification_time");
        List<String> firstItemUser = response.getBody().jsonPath().get("items[0].users"); //[?(@.users empty true)]
        String firstItemStatus = response.getBody().jsonPath().get("items[0].status");
        String firstItemRef_entity_type = response.getBody().jsonPath().get("items[0].ref_entity_type");
        int secondItemId = response.getBody().jsonPath().get("items[1].id");
        String secondItemName = response.getBody().jsonPath().get("items[1].name");
        String secondItemMessage = response.getBody().jsonPath().get("items[1].message");
        long secondItemNotificationTime = response.getBody().jsonPath().get("items[1].notification_time");
        String secondItemUser = response.getBody().jsonPath().get("items[1].users[1]");
        String secondItemStatus = response.getBody().jsonPath().get("items[1].status");
        String secondItemPlatform = response.getBody().jsonPath().get("items[1].platform");
        int pagingDataOffset = response.getBody().jsonPath().get("paging_data.offset");
        int pagingDataLimit = response.getBody().jsonPath().get("paging_data.limit");
        boolean pagingDataHasMoreElements = response.getBody().jsonPath().get("paging_data.hasMoreElements");
        assertThat(firstItemId, is(61));
        assertThat(firstItemName, is("test"));
        assertThat(firstItemMessage, is("try me"));
        assertThat(firstItemNotificationTime, is(0));
        assertThat(firstItemUser, is(empty()));
        assertThat(firstItemStatus, is("SENT"));
        assertThat(firstItemRef_entity_type, is("MP_EDITS"));
        assertThat(secondItemId, is(60));
        assertThat(secondItemName, is("Platform is null"));
        assertThat(secondItemMessage, is("test"));
        assertThat(secondItemNotificationTime, is(1653739140000L));
        assertThat(secondItemUser, is(isEmptyOrNullString()));
        assertThat(secondItemStatus, is("NOT_SENT"));
        assertThat(pagingDataOffset, is(0));
        assertThat(pagingDataLimit, is(2));
        assertThat(pagingDataHasMoreElements, is(true));
    }

    public void checkNotificationById(Response response){
        int id = response.getBody().jsonPath().get("id");
        String name = response.getBody().jsonPath().get("name");
        String message = response.getBody().jsonPath().get("message");
        int notificationTime = response.getBody().jsonPath().get("notification_time");
        String user = response.getBody().jsonPath().get("users[0]");
        String status = response.getBody().jsonPath().get("status");
        String ref_entity_type = response.getBody().jsonPath().get("ref_entity_type");
        int ref_entity_id = response.getBody().jsonPath().get("ref_entity_id");
        String platform = response.getBody().jsonPath().get("platform");
        assertThat(id, is(61));
        assertThat(name, is("test"));
        assertThat(message, is("try me"));
        assertThat(notificationTime, is(0));
        assertThat(user, is(isEmptyOrNullString()));
        assertThat(status, is("SENT"));
        assertThat(ref_entity_type, is("MP_EDITS"));
        assertThat(ref_entity_id, is(0));
        assertThat(platform, is("IOS"));
    }

    public void checkRefTypes(Response response){
        String mpEdits = response.getBody().jsonPath().get("MP_EDITS");
        String collection = response.getBody().jsonPath().get("COLLECTION");
        String shop = response.getBody().jsonPath().get("SHOP");
        String feed = response.getBody().jsonPath().get("FEED");
        assertThat(mpEdits, is("MP Edits"));
        assertThat(collection, is("Collection"));
        assertThat(shop, is("Shop"));
        assertThat(feed, is("Feed"));
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
