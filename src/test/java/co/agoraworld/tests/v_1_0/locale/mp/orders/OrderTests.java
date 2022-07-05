package co.agoraworld.tests.v_1_0.locale.mp.orders;

import co.agoraworld.tests.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class OrderTests extends BaseTest {
    @Test
    public void createNewMPOrderTest() throws JsonProcessingException {
        Map map = new HashMap();
        map.put("cart_id", 536);
        map.put("shipping_address_id", 10);
        ObjectMapper mapper = new ObjectMapper();
        String orderBody = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);
        Response response = postResponse("https://dev.agoraworld.dev/api/1.0/en_gb/mp/orders", orderBody);
        response.prettyPrint();
        assertEquals(200, response.getStatusCode());
    }
    @Test
    public void createNewPaymentForOrderTest() throws JsonProcessingException {
        Map map = new HashMap();
        map.put("", "");
        ObjectMapper mapper = new ObjectMapper();
        String orderBody = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);
        Response response = postResponse("https://dev.agoraworld.dev/api/1.0/en_gb/mp/orders/payment_intent?order_commercial_id=ZIH2TDKNML&payment_method=CREDIT_CARD", orderBody);
        response.prettyPrint();
        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void createEphemeralKeyTest() throws JsonProcessingException {
        Map map = new HashMap();
        map.put("", "");
        ObjectMapper mapper = new ObjectMapper();
        String orderBody = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);
        Response response = postResponse("https://dev.agoraworld.dev/api/1.0/en_gb/mp/orders/ephemeral_key", orderBody);
        response.prettyPrint();
        assertEquals(200, response.getStatusCode());
    }
}
