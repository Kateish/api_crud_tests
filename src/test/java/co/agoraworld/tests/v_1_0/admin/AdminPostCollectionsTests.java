package co.agoraworld.tests.v_1_0.admin;

import co.agoraworld.tests.BaseTest;
import co.agoraworld.tests.pages.LoginPage;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class AdminPostCollectionsTests extends BaseTest {

    @Test
    void getPostCollectionTest() {
        Response response = collectionsGetResponse("https://dev.agoraworld.dev/api/1.0/admin/post_collections?visible=true&type=DEFAULT");
        response.prettyPrint();
        int value = response.getBody().jsonPath().get("id[0]");
        String type = response.getBody().jsonPath().get("type[0]");
        String name = response.getBody().jsonPath().get("name[0]");
        boolean visible = response.getBody().jsonPath().get("visible[0]");
        String previewCoverImageUrl = response.getBody().jsonPath().get("preview_cover_image_url[0]");
        String fullCoverImageUrl = response.getBody().jsonPath().get("full_cover_image_url[0]");
        int postId = response.getBody().jsonPath().get("posts[0].id[0]");
        String postType = response.getBody().jsonPath().get("posts[0].post_type[0]");
        int userId = response.getBody().jsonPath().get("posts[0].user.id[0]");
        String userName = response.getBody().jsonPath().get("posts[0].user.username[0]");
        String lastName = response.getBody().jsonPath().get("posts[0].user.name[0]");
        String bio = response.getBody().jsonPath().get("posts[0].user.bio[0]");
        int mediaId = response.getBody().jsonPath().get("posts[0].user.media.id[0]");
        String mediaUrl = response.getBody().jsonPath().get("posts[0].user.media.url[0]");
        String mediaContentType = response.getBody().jsonPath().get("posts[0].user.media.content_type[0]");
        assertThat(value, is(23));
        assertThat(type, is("DEFAULT"));
        assertThat(name, is("TEST "));
        assertThat(visible, is(true));
        assertThat(previewCoverImageUrl, is("https://dgj717gkybljd.cloudfront.net/37ce75b4-6ebf-4026-9306-b760b16ae911.jpeg"));
        assertThat(fullCoverImageUrl, is("https://dgj717gkybljd.cloudfront.net/19ad58e4-ce6f-42d7-8ee7-748e395fecb9.jpeg"));
        assertThat(postId, is(72185));
        assertThat(postType, is("VIDEO_POST"));
        assertThat(userId, is(108586));
        assertThat(userName, is("karina.archazhnikova"));
        assertThat(lastName.substring(0, lastName.length() - 1), is("\uD83E\uDDDC\u200D♂️\uD83E\uDDDA\u200D♀️\uD83E\uDDDA\uD83E\uDDDC\uD83E\uDDDE\u200D♀️\uD83E\uDDB9\uD83C\uDFFF\u200D♂"));
        assertThat(bio, is(""));
        assertThat(mediaId, is(796621));
        assertThat(mediaUrl, is("https://dgj717gkybljd.cloudfront.net/996c514b-2816-4e74-919a-989d00b8b11e.jpeg"));
        assertThat(mediaContentType, is("image/jpeg"));
    }

    @Test
    public void getPostCollectionByIdTest() {
        Response response = collectionsGetResponse("https://dev.agoraworld.dev/api/1.0/admin/post_collections/20");
        response.prettyPrint();
        checkPostCollectionByIdResponse(response);
    }

    public void checkPostCollectionByIdResponse(Response response) {
        int id = response.getBody().jsonPath().get("id");
        String type = response.getBody().jsonPath().get("type");
        String name = response.getBody().jsonPath().get("name");
        boolean visible = response.getBody().jsonPath().get("visible");
        int sortOrder = response.getBody().jsonPath().get("sort_order");
        String preview_cover_image_url = response.getBody().jsonPath().get("preview_cover_image_url");
        String full_cover_image_url = response.getBody().jsonPath().get("full_cover_image_url");
        int postId = response.getBody().jsonPath().get("posts[0].id");
        String post_type = response.getBody().jsonPath().get("posts[0].post_type");
        int userId = response.getBody().jsonPath().get("posts[0].user.id");
        String username = response.getBody().jsonPath().get("posts[0].user.username");
        String bio = response.getBody().jsonPath().get("posts[0].user.bio");
        int mediaId = response.getBody().jsonPath().get("posts[0].user.media.id");
        String mediaUrl = response.getBody().jsonPath().get("posts[0].user.media.url");
        String mediaContentType = response.getBody().jsonPath().get("posts[0].user.media.content_type");
        boolean followed = response.getBody().jsonPath().get("posts[0].user.followed");
        boolean blocked = response.getBody().jsonPath().get("posts[0].user.blocked");
        int medias1Id = response.getBody().jsonPath().get("posts[0].medias[0].id");
        String medias1Url = response.getBody().jsonPath().get("posts[0].medias[0].url");
        String medias1ContentType = response.getBody().jsonPath().get("posts[0].medias[0].content_type");
        int medias2Id = response.getBody().jsonPath().get("posts[0].medias[1].id");
        String medias2Url = response.getBody().jsonPath().get("posts[0].medias[1].url");
        String medias2ContentType = response.getBody().jsonPath().get("posts[0].medias[1].content_type");
        int medias3Id = response.getBody().jsonPath().get("posts[0].medias[2].id");
        String medias3Url = response.getBody().jsonPath().get("posts[0].medias[2].url");
        String medias3ContentType = response.getBody().jsonPath().get("posts[0].medias[2].content_type");
        int medias4Id = response.getBody().jsonPath().get("posts[0].medias[3].id");
        String medias4Url = response.getBody().jsonPath().get("posts[0].medias[3].url");
        String medias4ContentType = response.getBody().jsonPath().get("posts[0].medias[3].content_type");
        long timeCreated = response.getBody().jsonPath().get("posts[0].time_created");
        String title = response.getBody().jsonPath().get("posts[0].title");
        String text = response.getBody().jsonPath().get("posts[0].text");
        String enrichedText = response.getBody().jsonPath().get("posts[0].enriched_text");
        int product1Id = response.getBody().jsonPath().get("posts[0].products[0].id");
        String product1Type = response.getBody().jsonPath().get("posts[0].products[0].type");
        String product1Name = response.getBody().jsonPath().get("posts[0].products[0].name");
        String product1Description = response.getBody().jsonPath().get("posts[0].products[0].description");
        int product1MediaId = response.getBody().jsonPath().get("posts[0].products[0].media.id");
        String product1MediaUrl = response.getBody().jsonPath().get("posts[0].products[0].media.url");
        String product1MediaContentType = response.getBody().jsonPath().get("posts[0].products[0].media.content_type");
        int product1MediasId = response.getBody().jsonPath().get("posts[0].products[0].medias[0].id");
        String product1MediasUrl = response.getBody().jsonPath().get("posts[0].products[0].medias[0].url");
        String product1MediasContentType = response.getBody().jsonPath().get("posts[0].products[0].medias[0].content_type");
        String product1Url = response.getBody().jsonPath().get("posts[0].products[0].url");
        String product1AffiliateUrl = response.getBody().jsonPath().get("posts[0].products[0].affiliate_url");
        int product1ProductBrandId = response.getBody().jsonPath().get("posts[0].products[0].product_brand.id");
        String product1ProductBrandCanonicalName = response.getBody().jsonPath().get("posts[0].products[0].product_brand.canonical_name");
        int product1ProductBrandLogoId = response.getBody().jsonPath().get("posts[0].products[0].product_brand.logo.id");
        String product1ProductBrandContentType = response.getBody().jsonPath().get("posts[0].products[0].product_brand.logo.content_type");
        int product1ProductBrandMasterProductsCount = response.getBody().jsonPath().get("posts[0].products[0].product_brand.master_products_count");
        String product1Brand = response.getBody().jsonPath().get("posts[0].products[0].brand");
        int product1StockLevel = response.getBody().jsonPath().get("posts[0].products[0].stock_level");
        boolean product1Bookmarked = response.getBody().jsonPath().get("posts[0].products[0].bookmarked");
        int product1CategoriesId = response.getBody().jsonPath().get("posts[0].products[0].categories[0].id");
        String product1CategoriesName = response.getBody().jsonPath().get("posts[0].products[0].categories[0].name");
        boolean product1CategoriesMaster = response.getBody().jsonPath().get("posts[0].products[0].categories[0].master");
        int product1PostsCount = response.getBody().jsonPath().get("posts[0].products[0].posts_count");
        String product1EnhancedIngredients = response.getBody().jsonPath().get("posts[0].products[0].enhanced_ingredients[0]");
        float product1Rating_avg = response.getBody().jsonPath().get("posts[0].products[0].rating_avg");
        int product1RatingsCount = response.getBody().jsonPath().get("posts[0].products[0].ratings_count");
        String product1Source = response.getBody().jsonPath().get("posts[0].products[0].source");

        assertThat(id, is(20));
        assertThat(type, is("DEFAULT"));
        assertThat(name, is("Best collection"));
        assertThat(visible, is(true));
        assertThat(sortOrder, is(5));
        assertThat(preview_cover_image_url, is(""));
        assertThat(full_cover_image_url, is(""));
        assertThat(postId, is(72200));
        assertThat(post_type, is("VIDEO_POST"));
        assertThat(userId, is(547));
        assertThat(username, is("naremur"));
        assertThat(bio, is("This is my bio "));
        assertThat(mediaId, is(1192));
        assertThat(mediaUrl, is("https://dgj717gkybljd.cloudfront.net/66b80a15-bc00-4862-8418-a29b962ee567.jpeg"));
        assertThat(mediaContentType, is(""));
        assertThat(followed, is(false));
        assertThat(blocked, is(false));
        assertThat(medias1Id, is(797348));
        assertThat(medias1Url, is("https://d2m502y3uehica.cloudfront.net/9e7465d2-e324-44da-86ef-c7887a68e675.mp4"));
        assertThat(medias1ContentType, is("video/mp4"));
        assertThat(medias2Id, is(797349));
        assertThat(medias2Url, is("https://d2m502y3uehica.cloudfront.net/hls/post/72200/9e7465d2-e324-44da-86ef-c7887a68e675hls.m3u8"));
        assertThat(medias2ContentType, is("application/vnd.apple.mpegurl"));
        assertThat(medias3Id, is(797350));
        assertThat(medias3Url, is("https://dgj717gkybljd.cloudfront.net/b169761c-8731-4d62-aa50-1fd512aa0480.jpeg"));
        assertThat(medias3ContentType, is("image/jpeg"));
        assertThat(medias4Id, is(797351));
        assertThat(medias4Url, is("https://dgj717gkybljd.cloudfront.net/23d348ea-dbc1-469e-a859-565b89a1cb7a.gif"));
        assertThat(medias4ContentType, is("image/gif"));
        assertThat(timeCreated, is(1643712850451L));
        assertThat(title, is("hello"));
        assertThat(text, is("is it me you’re looking for?"));
        assertThat(enrichedText, is("is it me you’re looking for?"));
        assertThat(product1Id, is(67115));
        assertThat(product1Type, is("regular"));
        assertThat(product1Name, is("Charlotte Tilbury Magic Cream - 50ml-No Colour"));
        assertThat(product1Description, is("Magic cream by Charlotte Tilbury This item is excluded from promo Moisturising cream Oil-infused formula aims to provide instant results Floods the complexion with moisture to help transform the appearance of tired, dull skin for a glowing, dewy, plumper-looking finish SPF15 Enriched with BioNymph Peptide, hyaluronic acid, rosehip oil, shea butter and vitamins C and E Also contains camellia oil, aloe vera and frangipani flower extract Product is non-returnable for hygiene reasons"));
        assertThat(product1MediaId, is(378993));
        assertThat(product1MediaUrl, is("https://dgj717gkybljd.cloudfront.net/27a132b1-ac82-4336-8bb2-dca40bb93866.jpeg"));
        assertThat(product1MediaContentType, is("image/jpeg"));
        assertThat(product1MediasId, is(378993));
        assertThat(product1MediasUrl, is("https://dgj717gkybljd.cloudfront.net/27a132b1-ac82-4336-8bb2-dca40bb93866.jpeg"));
        assertThat(product1MediasContentType, is("image/jpeg"));
        assertThat(product1Url, is("https://www.asos.com/charlotte-tilbury/charlotte-tilbury-magic-cream-50ml/prd/20838138?browseCountry=GB&browseCurrency=GBP"));
        assertThat(product1AffiliateUrl, is("https://www.awin1.com/pclick.php?p=26745225055&a=662341&m=5678"));
        assertThat(product1ProductBrandId, is(3));
        assertThat(product1ProductBrandCanonicalName, is("Charlotte Tilbury"));
        assertThat(product1ProductBrandLogoId, is(724942));
        assertThat(product1ProductBrandContentType, is("image/jpeg"));
        assertThat(product1ProductBrandMasterProductsCount, is(241));
        assertThat(product1Brand, is("Charlotte Tilbury"));
        assertThat(product1StockLevel, is(0));
        assertThat(product1Bookmarked, is(false));
        assertThat(product1CategoriesId, is(30));
        assertThat(product1CategoriesName, is("Moisturisers"));
        assertThat(product1CategoriesMaster, is(true));
    }

    public Response collectionsGetResponse(String url) {
        Response response = given()
                .when()
                .accept("application/json")
                .header("Authorization", String.format("Bearer %s", token))
                .header("CF-Access-Client-Id", "02d193502de091a550e115ab41ea6682.access")
                .header("CF-Access-Client-Secret", "ad69cdaebc5ad6fbfb692c739577deb036721795a3b121c1044cb76310414df2")
                .get(url)
                .then()
                .extract().response();
        return response;
    }

}
