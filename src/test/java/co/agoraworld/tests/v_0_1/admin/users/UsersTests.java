package co.agoraworld.tests.v_0_1.admin.users;

import co.agoraworld.tests.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.emptyList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class UsersTests extends BaseTest {
    @Test
    public void getListOfUsersTest() {
        Response response = getResponse("https://dev.agoraworld.dev/api/0.1/admin/users/?offset=0&limit=20");
        response.prettyPrint();
    }

    @Test
    public void getUserByIdTest() {
        Response response = getResponse("https://dev.agoraworld.dev/api/0.1/admin/user/108869");
        response.prettyPrint();
        checkUserByIdResponse(response, false);
    }


    @Test
    public void updateAUserTest() throws JsonProcessingException {
//add coins
        Map<String, Object> addCoins = new HashMap();
        addCoins.put("coins", 1);
        addCoins.put("description", "1");
        ObjectMapper mapperCoins = new ObjectMapper();
        String updateUserRequestBodyStringAddCoins = mapperCoins.writerWithDefaultPrettyPrinter()
                .writeValueAsString(addCoins);
        postResponse("https://dev.agoraworld.dev/api/0.1/admin/user/108869/add_coins", updateUserRequestBodyStringAddCoins);

        Map<String, Object> updateUserRequestBody = new HashMap();
        updateUserRequestBody.put("username", "userusername");
        updateUserRequestBody.put("name", "namenamre");
        updateUserRequestBody.put("email", "someemail1@test.com");
        updateUserRequestBody.put("phone", "123456789");
        updateUserRequestBody.put("bio", "culpa magna nisi in velit");
        updateUserRequestBody.put("birthday", "08-08-1991");
        List<String> groups = new ArrayList();
        groups.add("broadcaster");
        updateUserRequestBody.put("groups", groups);
        ObjectMapper mapper = new ObjectMapper();
        String updateUserRequestBodyString = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(updateUserRequestBody);
        Response response = postResponse("https://dev.agoraworld.dev/api/0.1/admin/user/108869", updateUserRequestBodyString);
        response.prettyPrint();
        checkUserByIdResponse(response, false);
    }

    @Test
    public void addCoinsTest() throws JsonProcessingException {
        Map<String, Object> addCoins = new HashMap();
        addCoins.put("coins", 1);
        addCoins.put("description", "1");
        ObjectMapper mapperCoins = new ObjectMapper();
        String updateUserRequestBodyStringAddCoins = mapperCoins.writerWithDefaultPrettyPrinter()
                .writeValueAsString(addCoins);
        postResponse("https://dev.agoraworld.dev/api/0.1/admin/user/108869/add_coins", updateUserRequestBodyStringAddCoins);

    }

    @Test
    public void withdrawCoinsTest() throws JsonProcessingException {
        Map<String, Object> addCoins = new HashMap();
        addCoins.put("coins", 1);
        addCoins.put("description", "1");
        ObjectMapper mapperCoins = new ObjectMapper();
        String updateUserRequestBodyStringAddCoins = mapperCoins.writerWithDefaultPrettyPrinter()
                .writeValueAsString(addCoins);
        postResponse("https://dev.agoraworld.dev/api/0.1/admin/user/108869/withdraw_coins", updateUserRequestBodyStringAddCoins);

    }

    @Test
    public void getCoinOperationsTest() throws JsonProcessingException {
//checking the account where coins withdrawal was the last operation
        Response response = getResponse("https://dev.agoraworld.dev/api/0.1/admin/user/108869/coin_operations");
        response.prettyPrint();
        List lastOperationNegative = response.getBody().jsonPath().get("operation");
        assertThat(lastOperationNegative.get(lastOperationNegative.size() - 1), is(-1));
    }

    @Test
    public void getUserAddressesTest(){
        Response responseEmpty = getResponse("https://dev.agoraworld.dev/api/0.1/admin/user/108869/addresses");
        responseEmpty.prettyPrint();
        Response response = getResponse("https://dev.agoraworld.dev/api/0.1/admin/user/534/addresses");
        response.prettyPrint();
        List addresses = response.getBody().jsonPath().get("");
        assertThat(addresses.size(), is(2));
        checkUserAddresses(response);
    }

    @Test
    public void banUserTest() throws JsonProcessingException {
        //ban
        Map<String, Object> ban = new HashMap();
        ban.put("value", true);
        ObjectMapper mapper = new ObjectMapper();
        String banUserString = mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(ban);
        Response response = postResponse("https://dev.agoraworld.dev/api/0.1/admin/user/108869/ban", banUserString);
        response.prettyPrint();
        //check the flag is true
        checkUserByIdResponse(response, true);
        //unban
        Map<String, Object> unBan = new HashMap();
        unBan.put("value", false);
        ObjectMapper notBanned = new ObjectMapper();
        String unBanUserString = notBanned.writerWithDefaultPrettyPrinter()
                .writeValueAsString(unBan);
        Response responseNotBanned = postResponse("https://dev.agoraworld.dev/api/0.1/admin/user/108869/ban", unBanUserString);
        responseNotBanned.prettyPrint();
        //check the flag is false
        checkUserByIdResponse(responseNotBanned, false);
    }

    public void checkUserAddresses(Response response) {
        int id = response.getBody().jsonPath().get("id[0]");
        boolean archived = response.getBody().jsonPath().get("archived[0]");
        String firstName = response.getBody().jsonPath().get("first_name[0]");
        String lastName = response.getBody().jsonPath().get("last_name[0]");
        String phoneNumber = response.getBody().jsonPath().get("phone_number[0]");
        String email = response.getBody().jsonPath().get("email[0]");
        String country = response.getBody().jsonPath().get("country[0]");
        String zip = response.getBody().jsonPath().get("zip_code[0]");
        String state = response.getBody().jsonPath().get("state[0]");
        String city = response.getBody().jsonPath().get("city[0]");
        String address1 = response.getBody().jsonPath().get("address_line_1[0]");
        String address2 = response.getBody().jsonPath().get("address_line_2[0]");
        int id1 = response.getBody().jsonPath().get("id[1]");
        boolean archived1 = response.getBody().jsonPath().get("archived[1]");
        String firstName1 = response.getBody().jsonPath().get("first_name[1]");
        String lastName1 = response.getBody().jsonPath().get("last_name[1]");
        String phoneNumber1 = response.getBody().jsonPath().get("phone_number[1]");
        String email1 = response.getBody().jsonPath().get("email[1]");
        String country1 = response.getBody().jsonPath().get("country[1]");
        String zip1 = response.getBody().jsonPath().get("zip_code[1]");
        String state1 = response.getBody().jsonPath().get("state[1]");
        String city1 = response.getBody().jsonPath().get("city[1]");
        String address11 = response.getBody().jsonPath().get("address_line_1[1]");
        String address21 = response.getBody().jsonPath().get("address_line_2[1]");
        assertThat(id, is(91));
        assertThat(id1, is(139));
        assertThat(archived, is(false));
        assertThat(archived1, is(false));
        assertThat(firstName, is("Camila"));
        assertThat(firstName1, is("Camila"));
        assertThat(lastName, is("Chateau"));
        assertThat(lastName1, is("Chateau"));
        assertThat(phoneNumber, is("52043704843"));
        assertThat(phoneNumber1, is("9174479983"));
        assertThat(email, is("mail@mail.com"));
        assertThat(email1, is("camila.w.chateau@gmail.com"));
        assertThat(country, is("United Kingdom"));
        assertThat(country1, is("United Kingdom"));
        assertThat(zip, is("1649936"));
        assertThat(zip1, is("N11eb"));
        assertThat(state, is(""));
        assertThat(state1, is(""));
        assertThat(city, is("London"));
        assertThat(city1, is("London"));
        assertThat(address1, is("48 finalists road"));
        assertThat(address11, is("48 Offord Road"));
        assertThat(address2, is(""));
        assertThat(address21, is(""));
    }


    public void checkUserByIdResponse(Response response, boolean bannedState) {
        int id = response.getBody().jsonPath().get("id");
        String userName = response.getBody().jsonPath().get("username");
        Long timeRegistered = response.getBody().jsonPath().get("time_registered");
        int coins = response.getBody().jsonPath().get("coins");
        int coinsExpiringWithinOneMonth = response.getBody().jsonPath().get("coins_expiring_within_one_month");
        String name = response.getBody().jsonPath().get("name");
        String email = response.getBody().jsonPath().get("email");
        String phone = response.getBody().jsonPath().get("phone");
        String bio = response.getBody().jsonPath().get("bio");
        int mediaId = response.getBody().jsonPath().get("media.id");
        String mediaUrl = response.getBody().jsonPath().get("media.url");
        String mediaContentType = response.getBody().jsonPath().get("media.content_type");
        String status = response.getBody().jsonPath().get("status");
        Map<String, String> propertiesTasks = response.getBody().jsonPath().get("properties.tasks[0]");
        Map<String, String> propertiesImmutable = response.getBody().jsonPath().get("properties.immutable");
        String propertiesMutableNoOfVisits = response.getBody().jsonPath().get("properties.mutable.number_of_visits");
        String propertiesMutableStripeCustomerId = response.getBody().jsonPath().get("properties.stripe_customer_id");
        String propertiesMutableSawWelcomeNotification = response.getBody().jsonPath().get("properties.saw_welcome_notification");
        String propertiesMutableDidShowRebrandingPopUp = response.getBody().jsonPath().get("properties.did_show_rebranding_pop_up");
        List<String> groups = response.getBody().jsonPath().get("groups");
        boolean banned = response.getBody().jsonPath().get("banned");
        boolean deleted = response.getBody().jsonPath().get("deleted");
        String amplitudeUserId = response.getBody().jsonPath().get("amplitude_user_id");
        String amplitudeDeviceId = response.getBody().jsonPath().get("amplitude_device_id");
        String inviteCode = response.getBody().jsonPath().get("invite_code");
        List<String> invitedUserIds = response.getBody().jsonPath().get("invited_user_ids");
        int postsBookmarked = response.getBody().jsonPath().get("posts_bookmarked");
        int productsBookmarked = response.getBody().jsonPath().get("products_bookmarked");
        String registrationPlatform = response.getBody().jsonPath().get("registration_platform");
        assertThat(id, is(108869));
        assertThat(userName, is("cotte0622"));
        assertThat(timeRegistered, is(1655037616834L));
        assertThat(coins, is(4));
        assertThat(coinsExpiringWithinOneMonth, is(0));
        assertThat(name, is("Test Name"));
        assertThat(email, is("chuprova_kate@yahoo.com"));
        assertThat(phone, is(""));
        assertThat(bio, is(""));
        assertThat(mediaId, is(797907));
        assertThat(mediaUrl, is(""));
        assertThat(mediaContentType, is("image/jpeg"));
        assertThat(status, is("USERNAME_ADDED"));
        assertThat(propertiesTasks, is(nullValue()));
        assertThat(propertiesImmutable.size(), is(0));
        assertThat(propertiesMutableNoOfVisits, is("1"));
        assertThat(propertiesMutableStripeCustomerId, is(nullValue()));
        assertThat(propertiesMutableSawWelcomeNotification, is(nullValue()));
        assertThat(propertiesMutableDidShowRebrandingPopUp, is(nullValue()));
        assertThat(groups, is(emptyList()));
        assertThat(banned, is(bannedState));
        assertThat(deleted, is(false));
        assertThat(amplitudeUserId, is(""));
        assertThat(amplitudeDeviceId, is(""));
        assertThat(inviteCode, is("cotte0622"));
        assertThat(invitedUserIds, is(emptyList()));
        assertThat(postsBookmarked, is(0));
        assertThat(productsBookmarked, is(0));
        assertThat(registrationPlatform, is("IOS"));
    }

}
