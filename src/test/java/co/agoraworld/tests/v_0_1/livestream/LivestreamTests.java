package co.agoraworld.tests.v_0_1.livestream;

import co.agoraworld.tests.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LivestreamTests extends BaseTest {
    @Test
    public void getMpOffersForLivestream(){
        Response response = getResponse("https://dev.agoraworld.dev/api/0.1/livestream/22/mp_offers");
        response.prettyPrint();

    }
    @Test
    public void getLivestreamById(){
        Response response = getResponse("https://dev.agoraworld.dev/api/0.1/livestream/314");
        response.prettyPrint();
        checkLivestreamById(response);

    }
    @Test
    public void createANewLivestream() throws JsonProcessingException {
        Map<String, Object> livestreamBody = new HashMap();
        livestreamBody.put("status", "status");
        livestreamBody.put("title", "dolor velit fugiat adipisic");
        livestreamBody.put("cover_image_url", "velit");
        livestreamBody.put("time_of_planned_start", 36989487);
        livestreamBody.put("description", "minim nostrud fugiat dolor");
        List<Integer> offerIds = new ArrayList();
        offerIds.add(61659636);
        livestreamBody.put("offer_ids[0]", offerIds);
        ObjectMapper mapper = new ObjectMapper();
        String livestreamBodyString = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(livestreamBody);
        Response response = postResponse("https://dev.agoraworld.dev/api/0.1/livestream", livestreamBodyString);
        response.prettyPrint();
        checkLivestreamById(response);

    }
    //{
    //    "id": 314,
    //    "broadcaster_user": {
    //        "id": 526,
    //        "username": "thebivo",
    //        "name": "Ilya",
    //        "bio": "⛵️",
    //        "media": {
    //            "id": 1165,
    //            "url": "https://dgj717gkybljd.cloudfront.net/6828c08d-aff8-44db-bee0-197d28424c2f.png",
    //            "content_type": ""
    //        },
    //        "followed": false,
    //        "blocked": false
    //    },
    //    "channel_name": "6d2ab7cc-dc91-4774-956d-a3e5ddf20641",
    //    "status": "FUTURE",
    //    "title": "See you after 5 years",
    //    "description": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna ali.",
    //    "cover_image": {
    //        "id": 796529,
    //        "url": "https://dgj717gkybljd.cloudfront.net/c13ea9fd-a74c-4326-8a8f-fb358c38734c.jpeg",
    //        "content_type": "image/jpeg"
    //    },
    //    "time_of_planned_start": 1782989940000,
    //    "duration_mins": 20,
    //    "mp_offers_count": 3,
    //    "is_subscribed": false,
    //    "visible_on_the_app": true
    //}
    public void checkLivestreamById(Response response){
        int id = response.getBody().jsonPath().get("id");
    }
    public void checkMpOffersForLivestream(Response response){
        int mpOfferId = response.getBody().jsonPath().get("mp_offer.id");
        String mpOfferProductSku = response.getBody().jsonPath().get("mp_offer.product.sku");
        String mpOfferProductName = response.getBody().jsonPath().get("mp_offer.product.name");
        String mpOfferProductBrand = response.getBody().jsonPath().get("mp_offer.product.brand");
        //int mpOfferProductBrandId =
        //[
        //  {
        //    "mp_offer": {
        //      "id": 0,
        //      "product": {
        //        "sku": "string",
        //        "name": "string",
        //        "brand": "string",
        //        "brand_id": 0,
        //        "description": "string",
        //        "image_urls": [
        //          "string"
        //        ],
        //        "ean": "string",
        //        "review_ids": [
        //          0
        //        ]
        //      },
        //      "shop": {
        //        "id": 0,
        //        "name": "string",
        //        "email": "string",
        //        "phone": "string",
        //        "logo_url": "string",
        //        "banner_url": "string",
        //        "return_policy": "string"
        //      },
        //      "price": 0,
        //      "discount_price": 0,
        //      "currency": "string",
        //      "coins": 0,
        //      "available_quantity": 0
        //    },
        //    "active": true
        //  }
        //]
    }
}
