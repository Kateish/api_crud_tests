package co.agoraworld.Constants.v_0_1;

import co.agoraworld.utils.GetProperties;

public class AdminConstants {
    public static final String BASE_URL = GetProperties.getBaseUrl();
    public static final String API_0_1 = GetProperties.getProperty("api_0_1_entry");
    public static final String API_1_0 = GetProperties.getProperty("api_1_0_entry");
//1.0
    public static final String ADMIN_BRANDS = "/admin/brands";
    public static final String GET_LIST_OF_BRANDS = "/list?offset=0&limit=20";
    public static final String GET_BRAND_BY_ID = "/mp_brands/";
    public static final String SEARCH_FOR_BRANDS = "/brands/search?offset=0&limit=10&search_query=nostrud culpa";
    public static final String GET_FEATURED_BRANDS = "/mp/brands/featured";
    public static final String UPDATE_FEATURED_BRANDS_SORTED_ORDER = "/mp_brands/featured/sort";
    public static final String GET_ALL_BRANDS = "/mp_brands?page=0&size=20&sort=ex pariatur officia sit&sort=reprehenderit voluptate enim nisi";
    public static final String ADMIN_GET_POST_COLLECTION_BY_TYPE = "/admin/post_collections?visible=true&type=DEFAULT";
    public static final String ADMIN_GET_POST_COLLECTION_BY_ID = "/admin/post_collections/20";
    public static final String ADMIN_POST_CREATE_POST_COLLECTION = "/admin/post_collections";
    public static final String ADMIN_PUT_UPDATE_POST_COLLECTION = "/post_collections/:collectionId";
    public static final String ADMIN_PUT_UPDATE_SORT_ORDER = "/admin/post_collections/:collectionId/sort_order/:sortOrder";
//0.1

}
