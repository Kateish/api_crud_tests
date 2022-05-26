package co.agoraworld;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URI;
import java.util.Map;

public class APIClient {
    public APIClient(String baseURI) {
    }

    private static Logger Log = LogManager.getLogger(APIClient.class.getName());

    public APIClient() {

    }
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
