package co.agoraworld;

import co.agoraworld.Constants.v_0_1.AdminConstants;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static co.agoraworld.Specs.getSpecificationAdmin;


public class AgoraAPI extends APIHandler {
    private static final Logger LOG = LogManager.getLogger(AgoraAPI.class);
    public String listOfBrandsUrl = AdminConstants.API_0_1 + AdminConstants.ADMIN_BRANDS + AdminConstants.GET_LIST_OF_BRANDS;
    private String token;
    public AgoraAPI(String token){
        this.token = token;
    }
    public Response getListOfBrands(String token) {
        return client().get(getSpecificationAdmin(token), "https://dev.agoraworld.dev/api/1.0/admin/post_collections?visible=true&type=DEFAULT");
    }


}
