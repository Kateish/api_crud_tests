package co.agoraworld.tests.v_1_0.locale;

import co.agoraworld.tests.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetActiveBannersTests extends BaseTest {
    @Test
    public void getAllActiveBannersTest(){
        Response response = getResponse("https://dev.agoraworld.dev/api/1.0/en_gb/banners");
        response.prettyPrint();
        checkAllActiveBanners(response);
    }

    public void checkAllActiveBanners(Response response){
        int id0 = response.getBody().jsonPath().get("id[0]");
        int id1 = response.getBody().jsonPath().get("id[1]");
        int id2 = response.getBody().jsonPath().get("id[2]");
        String name0 = response.getBody().jsonPath().get("name[0]");
        String name1 = response.getBody().jsonPath().get("name[1]");
        String name2 = response.getBody().jsonPath().get("name[2]");
        String imageUrl0 = response.getBody().jsonPath().get("image_url[0]");
        String imageUrl1 = response.getBody().jsonPath().get("image_url[1]");
        String imageUrl2 = response.getBody().jsonPath().get("image_url[2]");
        Long timeStart0 = response.getBody().jsonPath().get("time_start[0]");
        Long timeStart1 = response.getBody().jsonPath().get("time_start[1]");
        Long timeStart2 = response.getBody().jsonPath().get("time_start[2]");
        Long timeEnd0 = response.getBody().jsonPath().get("time_end[0]");
        Long timeEnd1 = response.getBody().jsonPath().get("time_end[1]");
        Long timeEnd2 = response.getBody().jsonPath().get("time_end[2]");
        String destinationType0 = response.getBody().jsonPath().get("destination[0].type");
        String destinationType1 = response.getBody().jsonPath().get("destination[1].type");
        String destinationType2 = response.getBody().jsonPath().get("destination[2].type");
        String destinationId0 = response.getBody().jsonPath().get("destination[0].id");
        String destinationId2 = response.getBody().jsonPath().get("destination[2].id");
        assertThat(id0, is(28));
        assertThat(id1, is(27));
        assertThat(id2, is(24));
        assertThat(name0, is("testing"));
        assertThat(name1, is("testing"));
        assertThat(name2, is("shop1"));
        assertThat(imageUrl0, is("https://dgj717gkybljd.cloudfront.net/fb41d486-9a3f-419e-8306-255e19980dce.jpeg"));
        assertThat(imageUrl1, is("https://dgj717gkybljd.cloudfront.net/77383f9a-e970-41c2-86be-96a9b90fc78e.jpeg"));
        assertThat(imageUrl2, is("https://dgj717gkybljd.cloudfront.net/4781b552-e48d-42ee-a3eb-5a0754531b4d.jpeg"));
        assertThat(timeStart0, is(1651675080000L));
        assertThat(timeStart1, is(1651674960000L));
        assertThat(timeStart2, is(1645112160000L));
        assertThat(timeEnd0, is(1683211080000L));
        assertThat(timeEnd1, is(1683211020000L));
        assertThat(timeEnd2, is(1676648160000L));
        assertThat(destinationType0, is("COLLECTION"));
        assertThat(destinationType1, is("REDEMPTION_SCREEN"));
        assertThat(destinationType2, is("SHOP"));
        assertThat(destinationId0, is("10"));
        assertThat(destinationId2, is("1"));
    }
}
