package co.agoraworld.tests;

import co.agoraworld.APIHandler;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseTest {
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

    public Response delete(String url) {
        Response response = given()
                .when()
                .accept("application/json")
                .header("Authorization", String.format("Bearer %s", token))
                .header("CF-Access-Client-Id", "02d193502de091a550e115ab41ea6682.access")
                .header("CF-Access-Client-Secret", "ad69cdaebc5ad6fbfb692c739577deb036721795a3b121c1044cb76310414df2")
                .header("Content-Type", "application/json")
                .delete(url)
                .then()
                .extract().response();
        return response;
    }

    public Response getResponse(String url) {
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
    public static Response postResponse(String url, String body) {
        Response response = given()
                .when()
                .accept("application/json")
                .header("Authorization", String.format("Bearer %s", token))
                .header("CF-Access-Client-Id", "02d193502de091a550e115ab41ea6682.access")
                .header("CF-Access-Client-Secret", "ad69cdaebc5ad6fbfb692c739577deb036721795a3b121c1044cb76310414df2")
                .header("Content-Type", "application/json")
                .body(body)
                .filter(new AllureRestAssured())
                .when()
                .log().all()
                .post(url)
                .then()
                .extract().response();
        return response;
    }
    public Response putResponse(String url){
        Response response = given()
                .when()
                .accept("application/json")
                .header("Authorization", String.format("Bearer %s", token))
                .header("CF-Access-Client-Id", "02d193502de091a550e115ab41ea6682.access")
                .header("CF-Access-Client-Secret", "ad69cdaebc5ad6fbfb692c739577deb036721795a3b121c1044cb76310414df2")
                .header("Content-Type", "application/json")
                .put(url)
                .then()
                .extract().response();
        return response;
    }
    public Response putResponseWithBody(String url, String body){
        Response response = given()
                .when()
                .accept("application/json")
                .header("Authorization", String.format("Bearer %s", token))
                .header("CF-Access-Client-Id", "02d193502de091a550e115ab41ea6682.access")
                .header("CF-Access-Client-Secret", "ad69cdaebc5ad6fbfb692c739577deb036721795a3b121c1044cb76310414df2")
                .header("Content-Type", "application/json")
                .body(body)
                .put(url)
                .then()
                .extract().response();
        return response;
    }
}
