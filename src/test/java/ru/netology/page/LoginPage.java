package ru.netology.page;

import com.codeborne.selenide.SelenideElement;
import com.github.javafaker.Faker;

import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

import java.util.Locale;

public class LoginPage {
    private SelenideElement loginField = $("[data-test-id=login] input");
    private SelenideElement passwordField = $("[data-test-id=password] input");
    private SelenideElement loginButton = $("[data-test-id=action-login]");
    private static Faker faker;

    public VerificationPage validLogin(DataHelper.AuthInfo info) {
        loginField.setValue(info.getLogin());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new VerificationPage();
    }

    public LoginPage invalidLogin(DataHelper.AuthInfo info) {
        faker = new Faker(new Locale("en"));
        loginField.setValue(faker.name().username());
        passwordField.setValue(info.getPassword());
        loginButton.click();
        return new LoginPage();
    }

    public LoginPage invalidpassword(DataHelper.AuthInfo info) {
        faker = new Faker(new Locale("en"));
        loginField.setValue(info.getLogin());
        passwordField.setValue(faker.internet().password());
        loginButton.click();
        return new LoginPage();
    }
}
