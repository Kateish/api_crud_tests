package co.agoraworld.tests.v_1_0.admin.mpBrands;

import co.agoraworld.tests.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AdminMpBrandsTests extends BaseTest {

    @Test
    public void getBrandsByIdTest() {
        Response response = getResponse("https://dev.agoraworld.dev/api/admin/mp_brands/18");
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        checkBrandByIdResponse(response);
    }

    @Test
    public void updateABrandTest() throws JsonProcessingException {
        Map<String, Object> putABrand = new HashMap();
        putABrand.put("logo_url", "cupidatat");
        putABrand.put("shop_id", 33802320);
        putABrand.put("featured", false);
        ObjectMapper mapper = new ObjectMapper();
        String putABrandString = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(putABrand);
        Response response = putResponseWithBody("https://dev.agoraworld.dev/api/1.0/admin/mp_brands/78367357", putABrandString);
        response.prettyPrint();
        response.then().assertThat().statusCode(200);
        //checkBrandByIdResponse(response);
    }

    public void checkBrandByIdResponse(Response response) {
        int id = response.getBody().jsonPath().get("id");
        String name = response.getBody().jsonPath().get("name");
        String logoUrl = response.getBody().jsonPath().get("logo_url");
        int shopId = response.getBody().jsonPath().get("shop_id");
        boolean featured = response.getBody().jsonPath().get("featured");
        assertThat(id, is(18));
        assertThat(name, is("AGORA"));
        assertThat(logoUrl, is("https://dgj717gkybljd.cloudfront.net/659602b2-1848-4f9f-8c01-983e058f0f41.jpeg"));
        assertThat(shopId, is(2002));
        assertThat(featured, is(true));

    }
}
