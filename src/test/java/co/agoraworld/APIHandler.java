package co.agoraworld;

public class APIHandler {
    private Specs client;

    public APIClient client() {
        return client;
    }

    public AgoraAPI agoraAPI(String token) {
        return new AgoraAPI(token);
    }
}
