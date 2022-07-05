package co.agoraworld.tests.v_1_0.locale.mp.products;

import co.agoraworld.tests.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;


public class ProductsTests extends BaseTest {
    @Test
    public void getProductsTest() {
        Response response = getResponse("https://dev.agoraworld.dev/api/1.0/en_gb/mp/products?shop_id=2005&offset=0&limit=10");
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
    @Test
    public void getProductBySkuTest() {
        Response response = getResponse("https://dev.agoraworld.dev/api/1.0/en_gb/mp/products/2a493b9f-c708-4869-b83f-37dc2cc56360");
        response.prettyPrint();
        assertEquals(200, response.getStatusCode());
        assertThat(response.getBody().jsonPath().get("sku"), is("2a493b9f-c708-4869-b83f-37dc2cc56360"));
        assertThat(response.getBody().jsonPath().get("name"), is("Soap dish"));
        assertThat(response.getBody().jsonPath().get("brand"), is("Capitaine Cosmetique"));
        assertThat(response.getBody().jsonPath().get("brand_id"), is(23));
        assertThat(response.getBody().jsonPath().get("description"), is("Soap dish, Le Futé - Capitaine Cosmétique, \n\nWant an eco-friendly soap dish for drying organic soap ?\nDiscover the Le Futé soap dish from Capitaine Cosmétique !\n\nLe Futé is the first soap dish made from recycled fishing nets !\nThis soap dish is made from eco-friendly raw materials, recycled fishing nets and\nplastic. The used nets are collected in the port of Brest through recycling channels.\nCapitaine Cosmétique thus offers us a recycled item that transforms plastic waste\ninto a useful and eco-friendly item. Each soap dish is unique.\nThe Le Futé soap dish allows you to dry the soap between each use to extend its life.\nBy purchasing this soap dish, you are helping to fight marine pollution and protect the\noceans.\nThis soap dish is available in 3 colors.\nDiscover organic self-care cosmetics in our online store :\n- Chemin de Garrigue Regenerating Soap ;\n- Moisturizing body lotion, for the whole family.\n\nAdvice for use\nIdeal for drying soaps between each use to extend their life.\nFor increased effectiveness, feel free to incorporate this care into your organic\nroutine, available in our store.\nCapitaine Cosmétique : organic care made in France\nCapitaine Cosmétique is a French brand committed to a global organic approach. In\nits workshop in Brittany, it develops natural and organic products to take care of itself\nand the planet. Organic solid soaps, regenerating oils - all of these products are\nderived from sustainable sources and are gentle on the environment."));
        assertThat(response.getBody().jsonPath().get("image_urls[0]"), is("https://dgj717gkybljd.cloudfront.net/618c8a7c-ffd5-482c-a125-eea4c1586892.jpeg"));
        assertThat(response.getBody().jsonPath().get("posts[0]"), is(nullValue()));
        assertThat(response.getBody().jsonPath().get("ean"), is("3701230401250"));

    }
}
