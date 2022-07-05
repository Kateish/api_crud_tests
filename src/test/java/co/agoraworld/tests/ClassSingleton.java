package co.agoraworld.tests;

import co.agoraworld.tests.pages.LoginPage;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterAll;

import static com.codeborne.selenide.Selenide.open;

public final class ClassSingleton {
    private static ClassSingleton INSTANCE;
    public String getLoginToken() {
        LoginPage lpage = open("https://dev-agora.auth.eu-west-2.amazoncognito.com/login?client_id=6vrs3b89tcvl123u358aibgmbp&response_type=token&scope=aws.cognito.signin.user.admin+email+openid+phone+profile&redirect_uri=https://agoraworld.co/cognito/cognito_callback.html", LoginPage.class);
        lpage.passLogin();
        return lpage.cognitoTokens();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String token = getLoginToken();

    private ClassSingleton() {
    }

    public static synchronized ClassSingleton getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new ClassSingleton();
        }

        return INSTANCE;
    }
    @AfterAll
    public void close(){
        Selenide.closeWindow();
    }
}

