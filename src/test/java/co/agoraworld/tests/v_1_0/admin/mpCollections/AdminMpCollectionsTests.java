package co.agoraworld.tests.v_1_0.admin.mpCollections;

import co.agoraworld.tests.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AdminMpCollectionsTests extends BaseTest {
    @Test
    public void getAllMpProductCollectionsTest(){
        Response response = getResponse("https://dev.agoraworld.dev/api/admin/mp_collections?statuses=FUTURE&statuses=ACTIVE&offset=0&limit=20");
        response.prettyPrint();
        checkMpCollectionsResponse(response);
    }
    @Test
    public void getCollectionOffersByIdsTest(){
        Response response = getResponse("https://dev.agoraworld.dev/api/admin/mp_collections/offer?ids=68213498&ids=17804082");
        response.prettyPrint();
        checkCollectionOfferById(response);
    }
    public void checkMpCollectionsResponse(Response response){
        int id = response.getBody().jsonPath().get("items[0].id");
        String code = response.getBody().jsonPath().get("items[0].code");
        String imageUrl = response.getBody().jsonPath().get("items[0].image_url");
        Float timeCreated = response.getBody().jsonPath().get("items[0].time_created");
        Float timeUpdated = response.getBody().jsonPath().get("items[0].time_updated");
        String timeStart = response.getBody().jsonPath().get("items[0].time_start");
        String timeEnd = response.getBody().jsonPath().get("items[0].time_end");
        String offersCount = response.getBody().jsonPath().get("items[0].offers_count");
        boolean enabledForFeed = response.getBody().jsonPath().get("items[0].enabled_for_feed");
        boolean archived = response.getBody().jsonPath().get("archived");
        String status = response.getBody().jsonPath().get("items[0].status");
        int sortOrder = response.getBody().jsonPath().get("sort_order");
        int pagingDataOffset = response.getBody().jsonPath().get("paging_data.offset");
        int pagingDataLimit = response.getBody().jsonPath().get("paging_data.limit");
        boolean pagingDataHasMoreElements = response.getBody().jsonPath().get("paging_data.hasMoreElements");
        int pagingDataId = response.getBody().jsonPath().get("paging_data.id");
        assertThat(id, is(23));
        assertThat(code, is("123"));
        assertThat(imageUrl, is("https://dgj717gkybljd.cloudfront.net/37ce75b4-6ebf-4026-9306-b760b16ae911.jpeg"));
        assertThat(timeCreated, is("1631091568950"));
        assertThat(timeUpdated, is("1631091568950"));
        assertThat(timeStart, is("1631091568950"));
        assertThat(timeEnd, is("1631091568950"));
        assertThat(offersCount, is("23"));
        assertThat(enabledForFeed, is(true));
        assertThat(archived, is(false));
        assertThat(status, is("INACTIVE"));
        assertThat(sortOrder, is(8));
        assertThat(pagingDataOffset, is(0));
        assertThat(pagingDataLimit, is(100));
        assertThat(pagingDataHasMoreElements, is(false));
        assertThat(pagingDataId, is(23));
    }
    public void checkCollectionOfferById(Response response){
        int id = response.getBody().jsonPath().get("id");
        String imageUrl = response.getBody().jsonPath().get("image_url");
        String productName = response.getBody().jsonPath().get("product_name");
        String brandName = response.getBody().jsonPath().get("brand_name");
        String shopName = response.getBody().jsonPath().get("shop_name");
        assertThat(id, is(2));
        assertThat(imageUrl, is("https://dgj717gkybljd.cloudfront.net/37ce75b4-6ebf-4026-9306-b760b16ae911.jpeg"));
        assertThat(productName, is("test"));
        assertThat(brandName, is("Brand"));
        assertThat(shopName, is("testSHop"));
    }
}
