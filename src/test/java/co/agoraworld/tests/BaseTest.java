package co.agoraworld.tests;

import co.agoraworld.APIHandler;
import co.agoraworld.Constants.v_0_1.AdminConstants;
import co.agoraworld.tests.pages.LoginPage;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
import static io.restassured.RestAssured.given;

public class BaseTest {
    public static APIHandler apiHandler = new APIHandler();
    private static final Logger LOG = LogManager.getLogger(BaseTest.class);
    static ClassSingleton classSingleton = ClassSingleton.getInstance();
    public static String token = classSingleton.getToken();

    public Response post(RequestSpecification specWithToken, Object body, URI url) {
        return RestAssured.given().spec(specWithToken).log().uri()
                .contentType("application/json")
                .body(body)
                .filter(new AllureRestAssured())
                .when()
                .log().all()
                .post(url)
                .then()
                .log().all()
                .extract().response();
    }
    public Response postWithQueryParams(RequestSpecification specWithToken, Map<String, String> queryParams, String url) {
        return RestAssured.given().spec(specWithToken).log().uri()
                .queryParams(queryParams)
                .filter(new AllureRestAssured())
                .when()
                .log().all()
                .post(url)
                .then()
                .log().all()
                .extract().response();
    }
    public static Response postWithoutBody(RequestSpecification specWithToken, String url) {
        return RestAssured.given().spec(specWithToken).log().uri()
                .filter(new AllureRestAssured())
                .when()
                .log().all()
                .post(url)
                .then()
                .log().all()
                .extract().response();
    }

    public static Response postWithoutBody(String url) {
        return RestAssured.given().log().uri()
                .filter(new AllureRestAssured())
                .when()
                .log().all()
                .post(url)
                .then()
                .log().all()
                .extract().response();
    }

    public Response get(RequestSpecification specification, String url) {
        return RestAssured.given().spec(specification).log().uri()
                .filter(new AllureRestAssured())
                .when()
                .log().all()
                .get(url)
                .then()
                .log().all()
                .extract().response();
    }
    public Response put(RequestSpecification specification, String headerName, String headerValue, Object body,  String url) {
        return RestAssured.given().spec(specification)
                .header(headerName, headerValue)
                .contentType("application/json")
                .body(body)
                .filter(new AllureRestAssured())
                .when()
                .log().all()
                .put(url)
                .then()
                .log().all()
                .extract().response();
    }

    public Response patch(RequestSpecification specification, Object body, String url) {
        return RestAssured.given().spec(specification).log().uri()
                .contentType("application/json")
                .body(body)
                .filter(new AllureRestAssured())
                .when()
                .log().all()
                .patch(url)
                .then()
                .log().all()
                .extract().response();
    }

    public Response delete(RequestSpecification specification, String url) {
        return RestAssured.given().spec(specification).log().uri()
                .when()
                .filter(new AllureRestAssured())
                .when()
                .log().all()
                .delete(url)
                .then()
                .log().all()
                .extract().response();
    }
}
