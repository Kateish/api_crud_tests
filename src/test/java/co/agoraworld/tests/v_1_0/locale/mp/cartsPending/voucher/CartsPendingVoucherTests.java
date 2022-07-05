package co.agoraworld.tests.v_1_0.locale.mp.cartsPending.voucher;

import co.agoraworld.tests.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.agoraworld.tests.v_0_1.admin.vouchers.AdminVoucherTests.createAVoucher;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
public class CartsPendingVoucherTests extends BaseTest {
    @Test
    public void applyVoucherToPendingCartVoucherInvalidFailureTest() throws JsonProcessingException {
        Map<String, Object> voucherCodeBody = new HashMap();
        voucherCodeBody.put("voucher_code", "discount_3_gbp");
        ObjectMapper mapper = new ObjectMapper();
        String voucherCodeBodyString = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(voucherCodeBody);
        Response response = putResponseWithBody("https://dev.agoraworld.dev/api/1.0/en_gb/mp/carts/pending/voucher", voucherCodeBodyString);
        response.prettyPrint();
        assertThat(response.getBody().jsonPath().get("voucher_code"), is("TESTER"));
        assertThat(response.getBody().jsonPath().get("voucher_discount"), is(5));
        assertThat(response.getBody().jsonPath().get("voucher_type"), is("POUNDS"));
        assertThat(response.getBody().jsonPath().get("total_discount"), is(5));
    }

    @Test
    public void applyVoucherToPendingCartSuccessTest() throws JsonProcessingException {
        String code = "TESTER";
       // createAVoucher(code);
        Map<String, Object> voucherCodeBody = new HashMap();
        voucherCodeBody.put("voucher_code", code);
        ObjectMapper mapper = new ObjectMapper();
        String voucherCodeBodyString = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(voucherCodeBody);
        Response response = putResponseWithBody("https://dev.agoraworld.dev/api/1.0/en_gb/mp/carts/pending/voucher", voucherCodeBodyString);
        response.prettyPrint();
        assertThat(response.getBody().jsonPath().get("message"), is("This voucher cannot be used on items from these shops"));
    }
    @Test
    public void applyVoucherToPendingCartWrongShopFailureTest() throws JsonProcessingException {
        Map<String, Object> voucherCodeBody = new HashMap();
        voucherCodeBody.put("voucher_code", "discount_3_gbp");
        ObjectMapper mapper = new ObjectMapper();
        String voucherCodeBodyString = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(voucherCodeBody);
        Response response = putResponseWithBody("https://dev.agoraworld.dev/api/1.0/en_gb/mp/carts/pending/voucher", voucherCodeBodyString);
        response.prettyPrint();
        assertThat(response.getBody().jsonPath().get("message"), is("This voucher cannot be used on items from these shops"));
    }
}
