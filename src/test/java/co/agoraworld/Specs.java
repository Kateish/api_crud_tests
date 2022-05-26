package co.agoraworld;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Specs extends APIClient{
    private static final Logger LOG = LoggerFactory.getLogger(Specs.class);
    public Specs() {
        super();
    }
    private static org.apache.logging.log4j.Logger Log = LogManager.getLogger(Specs.class.getName());

    public static RequestSpecification getSpecificationAdmin(String token) {
        return new RequestSpecBuilder().setBaseUri("https://dev.agoraworld.dev")
                .setAccept("application/json")
                .addHeader("CF-Access-Client-Id", "02d193502de091a550e115ab41ea6682.access")
                .addHeader("CF-Access-Client-Secret", "ad69cdaebc5ad6fbfb692c739577deb036721795a3b121c1044cb76310414df2")
                .addHeader("Authorization", String.format("Bearer %s", token))
                .build();
    }
}
