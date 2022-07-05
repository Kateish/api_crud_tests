package co.agoraworld.tests.v_1_0.admin;

import co.agoraworld.tests.BaseTest;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AdminBannersTests extends BaseTest {
  @Ignore("500 server error to be resolved")
    public void createBannerTest() {
        String body = "{\n" +
                "  \"destination\": {\n" +
                "    \"type\": \"pariatur esse labore consectetur cill\",\n" +
                "    \"id\": \"est amet commodo consequat culpa\"\n" +
                "  },\n" +
                "  \"enabled\": true,\n" +
                "  \"image_url\": \"nostrud sit\",\n" +
                "  \"name\": \"fugiat quis nostrud velit officia\",\n" +
                "  \"time_end\": 72723069,\n" +
                "  \"time_start\": 8469324,\n" +
                "  \"sort_order\": -4212972\n" +
                "}";
        Response response = postResponse("https://dev.agoraworld.dev/api/1.0/admin/banners", body);
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
       // checkBannerList(response);
    }
    @Test
    public void getAllBannersTest() {
        Response response = getResponse("https://dev.agoraworld.dev/api/1.0/admin/banners?page=0&size=20&sort=sortOrder,ASC&statuses=INACTIVE&statuses=ACTIVE");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        checkBannerList(response);
    }

    @Test
    public void getBannerByIdTest() {
        Response response = getResponse("https://dev.agoraworld.dev/api/admin/banners/22");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        checkBannerByIdResponse(response);
    }

    @Ignore("500 server error to be resolved")
    @Description("Archive banner id 23")
    public void archiveBannerTest() {
        Response response = getResponse("https://dev.agoraworld.dev/api/admin/banners/23/archive");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        Response checkArchivedStatus = getResponse("https://dev.agoraworld.dev/api/admin/banners/23");
        checkArchivedStatus.prettyPrint();
        checkBannerArchived(checkArchivedStatus);
    }
    public void checkBannerArchived(Response response){
        boolean archived = response.getBody().jsonPath().get("archived");
        assertThat(archived, is(true));
    }
    public void checkBannerList(Response response) {
        List<Object> fullList = response.getBody().jsonPath().get("");
        int id = response.getBody().jsonPath().get("id[0]");
        String name = response.getBody().jsonPath().get("name[0]");
        String imageUrl = response.getBody().jsonPath().get("image_url[0]");
        String destinationType = response.getBody().jsonPath().get("destination[0].type");
        String destinationId = response.getBody().jsonPath().get("destination[0].id");
        long timeStart = response.getBody().jsonPath().get("time_start[0]");
        long timeEnd = response.getBody().jsonPath().get("time_end[0]");
        assertThat(fullList.size(), is(3));
        assertThat(id, is(28));
        assertThat(name, is("testing"));
        assertThat(imageUrl, is("https://dgj717gkybljd.cloudfront.net/fb41d486-9a3f-419e-8306-255e19980dce.jpeg"));
        assertThat(timeStart, is(1651675080000L));
        assertThat(timeEnd, is(1683211080000L));
        assertThat(destinationType, is("COLLECTION"));
        assertThat(destinationId, is("10"));

    }

    public void checkBannerByIdResponse(Response response) {
        int id = response.getBody().jsonPath().get("id");
        String name = response.getBody().jsonPath().get("name");
        String imageUrl = response.getBody().jsonPath().get("image_url");
        long startTime = response.getBody().jsonPath().get("start_time");
        String destinationType = response.getBody().jsonPath().get("destination.type");
        String destinationId = response.getBody().jsonPath().get("destination.id");
        long endTime = response.getBody().jsonPath().get("end_time");
        boolean enabled = response.getBody().jsonPath().get("enabled");
        boolean archived = response.getBody().jsonPath().get("archived");
        String status = response.getBody().jsonPath().get("status");
        int sortOrder = response.getBody().jsonPath().get("sort_order");
        assertThat(id, is(22));
        assertThat(name, is("Shop"));
        assertThat(imageUrl, is("https://dgj717gkybljd.cloudfront.net/8117d0cb-a9a4-4b87-8cfb-c84b2e55454d.jpeg"));
        assertThat(startTime, is(1637835840000L));
        assertThat(endTime, is(1643660640000L));
        assertThat(destinationType, is("SHOP"));
        assertThat(destinationId, is("2005"));
        assertThat(enabled, is(true));
        assertThat(archived, is(false));
        assertThat(status, is("INACTIVE"));
        assertThat(sortOrder, is(8));
    }

}
