package co.agoraworld.tests.v_1_0.admin.mpProductCollections.idTests;

import co.agoraworld.tests.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class ProductIdTests extends BaseTest {

    @Test
    public void getCollectionById(){
        Response response = getResponse("https://dev.agoraworld.dev/api/1.0/admin/mp_product_collections/29");
        response.prettyPrint();
        checkCollectionById(response);

    }
    public void checkCollectionById(Response response){
        int value = response.getBody().jsonPath().get("id");
        String type = response.getBody().jsonPath().get("type");
        String name = response.getBody().jsonPath().get("name");
        boolean visible = response.getBody().jsonPath().get("visible");
        String userId = response.getBody().jsonPath().get("posts[0].user[0].id");
        String userName = response.getBody().jsonPath().get("posts[0].user[0].username");
        String lastName = response.getBody().jsonPath().get("posts[0].user[0].name");
        String postType = response.getBody().jsonPath().get("posts[0].post_type[0]");
        assertThat(value, is(22));
        assertThat(type, is("DEFAULT"));
        assertThat(name, is("Comfortably numb"));
        assertThat(visible, is(false));
        assertThat(userId, is(nullValue()));
    }
}
