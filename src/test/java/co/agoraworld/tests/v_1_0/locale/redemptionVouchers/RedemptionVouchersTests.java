package co.agoraworld.tests.v_1_0.locale.redemptionVouchers;

import co.agoraworld.tests.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RedemptionVouchersTests extends BaseTest {
    @Test
    public void getAllAvailableVouchersTest() {
        Response response = getResponse("https://dev.agoraworld.dev/api/1.0/en_gb/redemption/vouchers");
        response.prettyPrint();
        checkRedemptionVouchers(response);
    }

    @Test
    public void getVoucherRedemptionByIdTest(){
        Response response = getResponse("https://dev.agoraworld.dev/api/1.0/en_gb/redemption/vouchers/discount_3_gbp");
        response.prettyPrint();
        checkRedemptionVoucher(response);
    }

    public void checkRedemptionVouchers(Response response){
        String item1id = response.getBody().jsonPath().get("items[0].id");
        int item1CoinsPrice = response.getBody().jsonPath().get("items[0].coins_price");
        int item1DiscountGbp = response.getBody().jsonPath().get("items[0].discount_gbp");
        int item1MinCartAmountGbp = response.getBody().jsonPath().get("items[0].min_cart_amount_gbp");
        int item1LifetimeDays = response.getBody().jsonPath().get("items[0].lifetime_days");
        String item1DisplayName = response.getBody().jsonPath().get("items[0].display_name");
        String item1ImageUrl = response.getBody().jsonPath().get("items[0].image_url");
        String item1Description = response.getBody().jsonPath().get("items[0].description");
        String item2id = response.getBody().jsonPath().get("items[1].id");
        int item2CoinsPrice = response.getBody().jsonPath().get("items[1].coins_price");
        int item2DiscountGbp = response.getBody().jsonPath().get("items[1].discount_gbp");
        int item2MinCartAmountGbp = response.getBody().jsonPath().get("items[1].min_cart_amount_gbp");
        int item2LifetimeDays = response.getBody().jsonPath().get("items[1].lifetime_days");
        String item2DisplayName = response.getBody().jsonPath().get("items[1].display_name");
        String item2ImageUrl = response.getBody().jsonPath().get("items[1].image_url");
        String item2Description = response.getBody().jsonPath().get("items[1].description");
        String item3id = response.getBody().jsonPath().get("items[2].id");
        int item3CoinsPrice = response.getBody().jsonPath().get("items[2].coins_price");
        int item3DiscountGbp = response.getBody().jsonPath().get("items[2].discount_gbp");
        int item3MinCartAmountGbp = response.getBody().jsonPath().get("items[2].min_cart_amount_gbp");
        int item3LifetimeDays = response.getBody().jsonPath().get("items[2].lifetime_days");
        String item3DisplayName = response.getBody().jsonPath().get("items[2].display_name");
        String item3ImageUrl = response.getBody().jsonPath().get("items[2].image_url");
        String item3Description = response.getBody().jsonPath().get("items[2].description");
        assertThat(item1id, is("discount_3_gbp"));
        assertThat(item2id, is("discount_5_gbp"));
        assertThat(item3id, is("discount_10_gbp"));
        assertThat(item1CoinsPrice, is(150));
        assertThat(item2CoinsPrice, is(250));
        assertThat(item3CoinsPrice, is(500));
        assertThat(item1DiscountGbp, is(3));
        assertThat(item2DiscountGbp, is(5));
        assertThat(item3DiscountGbp, is(10));
        assertThat(item1MinCartAmountGbp, is(10));
        assertThat(item2MinCartAmountGbp, is(10));
        assertThat(item3MinCartAmountGbp, is(20));
        assertThat(item1LifetimeDays, is(30));
        assertThat(item2LifetimeDays, is(30));
        assertThat(item3LifetimeDays, is(30));
        assertThat(item1DisplayName, is("£3 OFF"));
        assertThat(item2DisplayName, is("£5 OFF"));
        assertThat(item3DisplayName, is("£10 OFF"));
        assertThat(item1ImageUrl, is("https://d1mpaliz2esbz9.cloudfront.net/static/redemption/discount_3_gbp.png"));
        assertThat(item2ImageUrl, is("https://d1mpaliz2esbz9.cloudfront.net/static/redemption/discount_5_gbp.png"));
        assertThat(item3ImageUrl, is("https://d1mpaliz2esbz9.cloudfront.net/static/redemption/discount_10_gbp.png"));
        assertThat(item1Description, is("Get £3 off £10 to spend on your favourite products! \n\nYour voucher code will appear in your notifications after you've redeemed this reward. It expires after 30 days so make sure to use it before then! "
        ));
        assertThat(item2Description, is("Get £5 off £10 to spend on your favourite products! \n\nYour voucher code will appear in your notifications after you've redeemed this reward. It expires after 30 days so make sure to use it before then! "
        ));
        assertThat(item3Description, is("Get £10 off £20 to spend on your favourite products! \n\nYour voucher code will appear in your notifications after you've redeemed this reward. It expires after 30 days so make sure to use it before then! "
        ));
    }

    public void checkRedemptionVoucher(Response response){
        String item1id = response.getBody().jsonPath().get("id");
        int item1CoinsPrice = response.getBody().jsonPath().get("coins_price");
        int item1DiscountGbp = response.getBody().jsonPath().get("discount_gbp");
        int item1MinCartAmountGbp = response.getBody().jsonPath().get("min_cart_amount_gbp");
        int item1LifetimeDays = response.getBody().jsonPath().get("lifetime_days");
        String item1DisplayName = response.getBody().jsonPath().get("display_name");
        String item1ImageUrl = response.getBody().jsonPath().get("image_url");
        String item1Description = response.getBody().jsonPath().get("description");
        assertThat(item1id, is("discount_3_gbp"));
        assertThat(item1CoinsPrice, is(150));
        assertThat(item1DiscountGbp, is(3));
        assertThat(item1MinCartAmountGbp, is(10));
        assertThat(item1LifetimeDays, is(30));
        assertThat(item1DisplayName, is("£3 OFF"));
        assertThat(item1ImageUrl, is("https://d1mpaliz2esbz9.cloudfront.net/static/redemption/discount_3_gbp.png"));
        assertThat(item1Description, is("Get £3 off £10 to spend on your favourite products! \n\nYour voucher code will appear in your notifications after you've redeemed this reward. It expires after 30 days so make sure to use it before then! "
        ));
    }
}
