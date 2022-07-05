package co.agoraworld.tests.v_0_1.admin.userGroups;

import co.agoraworld.tests.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserGroupsTests extends BaseTest {
    @Test
    public void getAllUserGroupsTest(){
        Response response = getResponse("https://dev.agoraworld.dev/api/0.1/admin/user_groups");
        response.prettyPrint();
        checkTheGroups(response);
    }

    @Test
    public void addUserToAGroupTest(){
        Response response = putResponse("https://dev.agoraworld.dev/api/0.1/admin/user_groups/UNRECOGNIZED/user/78367357");
        response.prettyPrint();
    }
    public void checkTheGroups(Response response){
        List<String> items = response.getBody().jsonPath().get("items");
        String item0 = items.get(0);
        String item1 = items.get(1);
        String item2 = items.get(2);
        String item3 = items.get(3);
        String item4 = items.get(4);
        assertThat(item0, is("test"));
        assertThat(item1, is("ambassador"));
        assertThat(item2, is("broadcaster"));
        assertThat(item3, is("moderator"));
        assertThat(item4, is("untrusted"));

    }
}
