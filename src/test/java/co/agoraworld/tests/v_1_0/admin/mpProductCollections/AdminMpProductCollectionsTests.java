package co.agoraworld.tests.v_1_0.admin.mpProductCollections;

import co.agoraworld.tests.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AdminMpProductCollectionsTests extends BaseTest {

    @Test
    public void getAllCollectionsPaginatedTest() {
        Response response = getResponse("https://dev.agoraworld.dev/api/admin/mp_product_collections?statuses=FUTURE&statuses=ACTIVE&offset=0&limit=20");
        response.prettyPrint();
        checkAllCollectionsPaginated(response);
    }
    public String convertWithIteration(Map<String, ?> map) {
        StringBuilder mapAsString = new StringBuilder("{");
        for (String key : map.keySet()) {
            mapAsString.append(key + "=" + map.get(key) + ", ");
        }
        mapAsString.delete(mapAsString.length()-2, mapAsString.length()).append("}");
        return mapAsString.toString();
    }
    @Test
    public void createPostCollectionTest(){
        Map<String, Object> postCollection = new HashMap();
        postCollection.put("\"type\"", "\"DEFAULT\"");
        postCollection.put("\"name\"", "\"enim et quis proident\"");
        postCollection.put("\"visible\"", true);
        List<Integer> postIds = new ArrayList<>();
        postIds.add(72221);
        postIds.add(13947);
        postCollection.put("\"post_ids\"", postIds);
        postCollection.put("\"preview_cover_image_url\"", "\"dolore dolor cu\"");
        postCollection.put("\"full_cover_image_url\"", "\"elit sint do\"");

        String co = convertWithIteration(postCollection);
        System.out.println(co);
        Response response = postResponse("https://dev.agoraworld.dev/api/admin/post_collections", "{\"name\":\"test 12345\",\"visible\":true,\"type\":\"DEFAULT\",\"post_ids\":[72221],\"full_cover_image_url\":\"\",\"preview_cover_image_url\":\"\"}");
        response.prettyPrint();
    }

    @Test
    public void getCollectionByIdTest(){
        Response response = getResponse("https://dev.agoraworld.dev/api/admin/mp_product_collections/10");
        response.prettyPrint();
        checkCollectionByIdResponse(response);
    }
    public void checkAllCollectionsPaginated(Response response){
        int id = response.getBody().jsonPath().get("items[0].id");
        String code = response.getBody().jsonPath().get("items[0].code");
        String imageUrl = response.getBody().jsonPath().get("items[0].image_url");
        float timeCreated = response.getBody().jsonPath().get("items[0].time_created");
        float timeUpdated = response.getBody().jsonPath().get("items[0].time_updated");
        Long timeStart = response.getBody().jsonPath().get("items[0].time_start");
        Long timeEnd = response.getBody().jsonPath().get("items[0].time_end");
        int offersCount = response.getBody().jsonPath().get("items[0].offers_count");
        boolean enabledForFeed = response.getBody().jsonPath().get("items[0].enabled_for_feed");
        boolean archived = response.getBody().jsonPath().get("items[0].archived");
        String status = response.getBody().jsonPath().get("items[0].status");
        int sortOrder = response.getBody().jsonPath().get("items[0].sort_order");
        assertThat(id, is(10));
        assertThat(code, is("karina test"));
        assertThat(imageUrl, is("https://dgj717gkybljd.cloudfront.net/e5425eb7-060a-4033-9056-23c22c27cb97.png"));
        assertThat(timeCreated, is(1.63645747E9F));
        assertThat(timeUpdated, is(1.6388151E9F));
        assertThat(timeStart, is(1636456200000L));
        assertThat(timeEnd, is(1667992020000L));
        assertThat(offersCount, is(8));
        assertThat(enabledForFeed, is(true));
        assertThat(archived, is(false));
        assertThat(status, is("ACTIVE"));
        assertThat(sortOrder, is(1));
    }
    public void checkCollectionByIdResponse(Response response) {
        int id = response.getBody().jsonPath().get("id");
        String code = response.getBody().jsonPath().get("code");
        String imageUrl = response.getBody().jsonPath().get("image_url");
        Long timeStart = response.getBody().jsonPath().get("time_start");
        Long timeEnd = response.getBody().jsonPath().get("time_end");
        List<Object> offersCount = response.getBody().jsonPath().get("offers");
        boolean enabledForFeed = response.getBody().jsonPath().get("enabled_for_feed");
        int offer0Id = response.getBody().jsonPath().get("offers[0].id");
        String offer0ImageUrl = response.getBody().jsonPath().get("offers[0].image_url");
        String offer0ProductName = response.getBody().jsonPath().get("offers[0].product_name");
        String offer0BrandName = response.getBody().jsonPath().get("offers[0].brand_name");
        String offer0ShopName = response.getBody().jsonPath().get("offers[0].shop_name");
        assertThat(id, is(10));
        assertThat(code, is("karina test"));
        assertThat(imageUrl, is("https://dgj717gkybljd.cloudfront.net/e5425eb7-060a-4033-9056-23c22c27cb97.png"));
        assertThat(timeStart, is(1636456200000L));
        assertThat(timeEnd, is(1667992020000L));
        assertThat(offersCount.size(), is(3));
        assertThat(enabledForFeed, is(true));
        assertThat(offer0Id, is(2020));
        assertThat(offer0ImageUrl, is("https://dgj717gkybljd.cloudfront.net/4992715b-d475-4dc6-9fb6-82c83c9b6e65.jpeg"));
        assertThat(offer0ProductName, is("Herbal Essentials Nourishing Cream With Apricot Oil & Aloe Vera 30ml"));
        assertThat(offer0BrandName, is("Herbal Essentials"));
        assertThat(offer0ShopName, is("Agora Shop 2"));
    }


}
