package co.agoraworld.Constants.v_1_0;

public class LocaleConstants {
    //voucher
    public static final String APPLY_VOUCHER_TO_PENDING_CART = "https://dev.agoraworld.dev/api/1.0/:locale/mp/carts/pending/voucher";
    public static final String REMOVE_VOUCHER_TO_PENDING_CART = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/carts/pending/voucher";
    //offer
    public static final String ADD_OFFER_TO_PENDING_CART = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/carts/pending/offer/78367357";
    public static final String REMOVE_OFFER_FROM_PENDING_CART = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/carts/pending/offer/78367357";
    public static final String UPDATE_OFFER_QUANTITY_IN_PENDING_CART = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/carts/pending/offer";
    //cart
    public static final String GET_PENDING_CART = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/carts/pending/offer";
    public static final String UPDATE_SHIPPING_TYPE_OF_CARD_LOGISTIC_ORDER = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/carts/pending/shipping_type";
    //orders
    public static final String CREATE_NEW_MARKETPLACE_ORDER = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/orders";
    public static final String CREATE_NEW_PAYMENT_FOR_ORDER = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/orders/payment_intent?order_commercial_id=nostrud culpa&payment_method=CREDIT_CARD";
    public static final String CREATE_EPHEMERAL_KEY = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/orders/ephemeral_key";
    //shops
    public static final String GET_ALL_SHOPS = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/shops?offset=0&limit=10";
    public static final String GET_SHOP_BY_ID = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/shops/78367357";
    public static final String GET_SHOPS_PREVIEWS = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/shops/previews?offset=0&limit=4";
    //products
    public static final String GET_PRODUCTS = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/products?shop_id=78367357&offset=0&limit=10";
    public static final String GET_PRODUCT_BY_SKU = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/products/nostrud culpa";
    //collections
    public static final String GET_COLLECTION_BY_ID = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/collections/78367357";
    public static final String GET_COLLECTION_OFFERS = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/collections/78367357/offers?offset=0&limit=10";
    public static final String GET_COLLECTIONS_PREVIEWS = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/collections/previews";
    //product collections
    public static final String GET_PROD_COLLECTION_BY_ID = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/product_collections/78367357";
    public static final String GET_PROD_COLLECTION_OFFERS = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/product_collections/78367357/offers?offset=0&limit=10";
    public static final String GET_PROD_COLLECTIONS_PREVIEWS = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/product_collections/previews";
    //offers
    public static final String GET_OFFER_BY_ID = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/offers/78367357";
    public static final String SEARCH_OFFERS = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/offers/search?offset=0&limit=10&search_query=nostrud culpa&shop_id=78367357&collection_id=78367357&category_code=nostrud culpa&f=brands|AGORA|Herbal Essentials,shops|AGORA";
    public static final String RETURN_LIST_OF_FILTERS = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/offers/filters?search_query=nostrud culpa&shop_id=78367357&collection_id=78367357&category_code=nostrud culpa&f=brands|AGORA|Herbal Essentials,shops|AGORA";
    public static final String GET_BEST_SELLERS = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/offers/best_sellers";
    public static final String GET_BEAUTY_BOXES = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/offers/beauty_boxes?offset=0&limit=10";
    //brands
    public static final String GET_BRAND_BY_ID = "https://dev.agoraworld.dev/api/1.0/:locale/mp/brands/78367357";
    public static final String SEARCH_BRANDS = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/brands/search?offset=0&limit=10&search_query=nostrud culpa";
    public static final String GET_FEATURED_BRANDS = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/brands/featured";
    //stripe payment
    public static final String STRIPE_PAYMENT_UPDATE = "https://dev.agoraworld.dev/api/1.0/:locale/mp/webhooks/stripe_payment_updated";
    //get categories
    public static final String GET_CATEGORIES = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/mp/categories?category_code=nostrud culpa&depth=78367357&shop_id=78367357&collection_id=78367357&f=brands|AGORA|Herbal Essentials,shops|AGORA";
    //redemption/vouchers
    public static final String GET_VOUCHER_REDEMPTION_BY_ID = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/redemption/vouchers/nostrud culpa";
    public static final String REDEEM_VOUCHER = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/redemption/vouchers/nostrud culpa/redeem";
    public static final String GET_ALL_AVAILABLE_VOUCHER_REDEMPTIONS = "https://dev.agoraworld.dev/api/1.0/nostrud culpa/redemption/vouchers";

}

