package co.agoraworld.tests.v_0_1.admin.vouchers;

import co.agoraworld.tests.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AdminVoucherTests extends BaseTest {

    @Test
    public void getAllVouchersTest() {
        Response response = getResponse("https://dev.agoraworld.dev/api/0.1/admin/vouchers?page=0&size=10&sort=id,DESC&with_status=FUTURE&voucher_code=nostrud culpa&broadcaster_username=nostrud culpa");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        checkVoucherList(response);
    }

    @Test
    public void updateAVoucherTest() throws JsonProcessingException {
        Response response = putResponseWithBody("https://dev.agoraworld.dev/api/0.1/admin/vouchers/269", "{\n" +
                "  \"count_available_per_user\": 10,\n" +
                "  \"discount\": 3,\n" +
                "  \"discount_type\": \"PERCENTAGES\",\n" +
                "  \"user_cohort\": \"NEW_USERS\",\n" +
                "  \"voucher_product_ids\": [\n" +
                "    85733413,\n" +
                "    36939097\n" +
                "  ],\n" +
                "  \"start_time\": 43542545,\n" +
                "  \"end_time\": 60562480,\n" +
                "  \"min_price_for_apply\": 53725970.229840845,\n" +
                "  \"number_of_vouchers\": 10,\n" +
                "  \"single_use\": true,\n" +
                "  \"broadcaster_id\": 526,\n" +
                "  \"shop_ids\": [\n" +
                "    76410607,\n" +
                "    82391728\n" +
                "  ],\n" +
                "  \"excluded_shop_ids\": [\n" +
                "    80230804,\n" +
                "    1172678\n" +
                "  ]\n" +
                "}");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        String discount_type = response.getBody().jsonPath().get("discount_type");
        assertThat(discount_type, is("PERCENTAGES"));
    }

    @Test
    public void getAllVouchersUserCohortTest() {
        Response response = getResponse("https://dev.agoraworld.dev/api/0.1/admin/vouchers/user_cohorts");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        checkUserCohort(response);
    }


    @Test
    public void createVoucherTest() throws JsonProcessingException {
        String code = "M21";
        checkCreatedVoucher(createAVoucher(code));
    }

    public static Response createAVoucher(String code) throws JsonProcessingException {
        Response response = postResponse("https://dev.agoraworld.dev/api/0.1/admin/vouchers", formAVoucherJson("POUNDS", code));
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        return response;
    }

    public static String formAVoucherJson(String discountType, String code) throws JsonProcessingException {
        Map<String, Object> body = new HashMap<>();
        body.put("code", code);
        body.put("percentage_amount", null);
        body.put("value_amount", 10);
        body.put("voucher_product_ids", emptyList());
        body.put("discount_type", discountType);
        body.put("count_available_per_user", 1);
        body.put("end_time", 1656160560000L);
        body.put("start_time", 1654518960000L);
        body.put("user_cohort", "NEW_CUSTOMERS");
        body.put("min_price_for_apply", "1");
        body.put("number_of_vouchers", 10);
        body.put("single_use", false);
        body.put("broadcaster_id", "526");
        List<Integer> shops = new ArrayList<>();
        shops.add(99667109);
        shops.add(52431612);
        body.put("shop_ids", shops);
        List<Integer> excludedShops = new ArrayList<>();
        excludedShops.add(17490733);
        body.put("excluded_shop_ids", excludedShops);
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(body);
    }

    public void checkVoucherList(Response response) {
        List<String> items = response.getBody().jsonPath().get("items");
        int totalElements = response.getBody().jsonPath().get("total_elements");
        int totalPages = response.getBody().jsonPath().get("total_pages");
        int size = response.getBody().jsonPath().get("size");
        assertThat(items.size(), is(0));
        assertThat(totalPages, is(0));
        assertThat(totalElements, is(0));
        assertThat(size, is(0));
    }

    public void checkUserCohort(Response response) {
        List<String> userCohorts = response.getBody().jsonPath().get();
        assertThat(userCohorts.get(0), is("ALL_USERS"));
        assertThat(userCohorts.get(1), is("NEW_CUSTOMERS"));
    }

    public void checkCreatedVoucher(Response response) {
        int id = response.getBody().jsonPath().get("id");//255;
        String code = response.getBody().jsonPath().get("code");//"MO2";
        int discount = response.getBody().jsonPath().get("discount");//10;
        String discount_type = response.getBody().jsonPath().get("discount_type");//"POUNDS";
        int minPriceForApply = response.getBody().jsonPath().get("min_price_for_apply");//1;
        int countAvailablePerUser = response.getBody().jsonPath().get("count_available_per_user");//1,
        String userCohort = response.getBody().jsonPath().get("user_cohort");//"NEW_CUSTOMERS",
        List<Integer> voucherProductIds = response.getBody().jsonPath().get("voucher_product_ids");
        String status = response.getBody().jsonPath().get("status");//
        boolean archived = response.getBody().jsonPath().get("archived");//
        // long timeCreated = response.getBody().jsonPath().get("time_created");//1654546367300
        long startTime = response.getBody().jsonPath().get("start_time");//1654546367300
        long endTime = response.getBody().jsonPath().get("end_time");//1654546367300
        int numberOfVouchers = response.getBody().jsonPath().get("number_of_vouchers");//10
        int countUsed = response.getBody().jsonPath().get("count_used");//0
        List<Integer> availableForUserIds = response.getBody().jsonPath().get("available_for_user_ids");
        String creationFlow = response.getBody().jsonPath().get("creationFlow");//"ADMIN_PANEL"
        boolean singleUse = response.getBody().jsonPath().get("single_use");//false
        int broadcasterId = response.getBody().jsonPath().get("broadcaster_id");//526
        List<Integer> shopIds = response.getBody().jsonPath().get("shop_ids");//    -99667109
        //    52431612
        List<Integer> excludedShopIds = response.getBody().jsonPath().get("excluded_shop_ids");//    -17490733
        int valueAmount = response.getBody().jsonPath().get("value_amount");
        assertThat(code, is("M15"));
        assertThat(discount, is(10));
        assertThat(discount_type, is("POUNDS"));
        assertThat(minPriceForApply, is(1));
        assertThat(userCohort, is("NEW_CUSTOMERS"));
        assertThat(voucherProductIds, is(emptyList()));
        assertThat(status, is("ACTIVE"));
        assertThat(archived, is(false));
        assertThat(numberOfVouchers, is(10));
        assertThat(countUsed, is(0));
        assertThat(countAvailablePerUser, is(1));
        assertThat(availableForUserIds, is(emptyList()));
        assertThat(singleUse, is(false));
        assertThat(broadcasterId, is(526));
        assertThat(shopIds.get(0), is(99667109));
        assertThat(shopIds.get(1), is(52431612));
        assertThat(excludedShopIds.get(0), is(17490733));
        assertThat(valueAmount, is(10));

    }
}
