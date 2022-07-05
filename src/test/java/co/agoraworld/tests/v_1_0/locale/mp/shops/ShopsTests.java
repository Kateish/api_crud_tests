package co.agoraworld.tests.v_1_0.locale.mp.shops;

import co.agoraworld.tests.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;

public class ShopsTests extends BaseTest {

    @Test
    public void getAllShopsTest() throws JsonProcessingException {
        Response response = getResponse("https://dev.agoraworld.dev/api/1.0/en_gb/mp/shops?offset=0&limit=10");
        response.prettyPrint();
        List items = response.getBody().jsonPath().get("items");
        assertEquals(200, response.getStatusCode());
        assertEquals(4, items.size());
    }
    @Test
    public void getShopByIdTest() {
        Response response = getResponse("https://dev.agoraworld.dev/api/1.0/en_gb/mp/shops/2009");
        response.prettyPrint();
        assertEquals(200, response.getStatusCode());
        assertThat(response.getBody().jsonPath().get("id"), is(2009));
        assertThat(response.getBody().jsonPath().get("name"), is("Agora Shop 6"));
        assertThat(response.getBody().jsonPath().get("email"), is("agora.shop6@agoraworld.co"));
        assertThat(response.getBody().jsonPath().get("phone"), is("0923450125"));
        assertThat(response.getBody().jsonPath().get("logo_url"), is("https://dgj717gkybljd.cloudfront.net/756dec88-c5aa-4360-bcce-1f336f2d6032.jpeg"));
        assertThat(response.getBody().jsonPath().get("banner_url"), is("https://dgj717gkybljd.cloudfront.net/f12b0223-289c-4a5f-b476-3b9344a9acc7.jpeg"));
        assertThat(response.getBody().jsonPath().get("return_policy"), is("The return policy is simply a text"));
    }
    @Test
    public void getShopsPreviewsTest() {
        Response response = getResponse("https://dev.agoraworld.dev/api/1.0/en_gb/mp/shops/previews?offset=0&limit=4");
        response.prettyPrint();
        assertEquals(200, response.getStatusCode());
//        assertThat(response.getBody().jsonPath().get("id"), is(2009));
//        assertThat(response.getBody().jsonPath().get("name"), is("Agora Shop 6"));
//        assertThat(response.getBody().jsonPath().get("email"), is("agora.shop6@agoraworld.co"));
//        assertThat(response.getBody().jsonPath().get("phone"), is("0923450125"));
//        assertThat(response.getBody().jsonPath().get("logo_url"), is("https://dgj717gkybljd.cloudfront.net/756dec88-c5aa-4360-bcce-1f336f2d6032.jpeg"));
//        assertThat(response.getBody().jsonPath().get("banner_url"), is("https://dgj717gkybljd.cloudfront.net/f12b0223-289c-4a5f-b476-3b9344a9acc7.jpeg"));
//        assertThat(response.getBody().jsonPath().get("return_policy"), is("The return policy is simply a text"));
    }
}
