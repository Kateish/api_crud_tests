package co.agoraworld.tests.v_1_0.locale.mp.collections;

import co.agoraworld.tests.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CollectionsTests extends BaseTest {
    @Test
    public void getCollectionsPreviewsTest() throws JsonProcessingException {
        Response response = getResponse("https://dev.agoraworld.dev/api/1.0/en_gb/mp/collections/previews");
        response.prettyPrint();
        List items = response.getBody().jsonPath().get("items");
        System.out.println(items.size());
        assertEquals(200, response.getStatusCode());
     //   assertEquals(4, items.size());
    }
    @Test
    public void getCollectionByIdTest() throws JsonProcessingException {
        Response response = getResponse("https://dev.agoraworld.dev/api/1.0/en_gb/mp/collections/2");
        response.prettyPrint();
        assertEquals(200, response.getStatusCode());

    }
}
