package co.agoraworld.tests.v_1_0.locale.mp.cartsPending.offer;

import co.agoraworld.tests.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class OfferTests extends BaseTest {
    @Test
    public void addOfferToPendingCartTest() throws JsonProcessingException {
        Map map = new HashMap();
        map.put("", "");
        ObjectMapper mapper = new ObjectMapper();
        String body = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);
        Response response = postResponse("https://dev.agoraworld.dev/api/1.0/en_gb/mp/carts/pending/offer/2101", body);
        response.prettyPrint();
    }
    @Test
    public void removeOfferFromPendingCartTest() throws JsonProcessingException {
        Map map = new HashMap();
        map.put("", "");
        ObjectMapper mapper = new ObjectMapper();
        String body = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);
        Response response = delete("https://dev.agoraworld.dev/api/1.0/en_gb/mp/carts/pending/offer/2101");
        response.prettyPrint();
    }

    @Test
    public void updateOfferQuantityInPendingCartTest() throws JsonProcessingException {
        Map map = new HashMap();
        map.put("offer_id", "2101");
        map.put("quantity", "2");
        ObjectMapper mapper = new ObjectMapper();
        String body = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);
        Response response = putResponseWithBody("https://dev.agoraworld.dev/api/1.0/en_gb/mp/carts/pending/offer", body);
        response.prettyPrint();
        assertThat(response.getBody().jsonPath().get("logistic_orders[0].items[0].quantity"), is(2));
    }
}
