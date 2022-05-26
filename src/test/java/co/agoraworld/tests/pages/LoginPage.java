package co.agoraworld.tests.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(css = ".panel #signInFormUsername")
    private SelenideElement signInUserName;

    @FindBy(css = ".panel #signInFormPassword")
    private SelenideElement signInPassword;

    @FindBy(xpath = "//input[@name='signInSubmitButton'][1]")
    private SelenideElement signInBtn;

    @FindBy(xpath = "//*[@id='id_token']")
    private SelenideElement token;

    public LoginPage passLogin() {
        signInUserName.setValue("kate-admin");
        signInPassword.setValue("BraveNewW0rld+").sendKeys(Keys.ENTER);
        return this;
    }

    public String cognitoTokens() {
        return token.getText();
    }
}
