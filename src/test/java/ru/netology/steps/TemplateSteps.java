package ru.netology.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.mk_cyrl.И;
import io.cucumber.java.ru.*;
import org.junit.jupiter.api.Assertions;
import ru.netology.data.DataHelper;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;
import ru.netology.page.VerificationPage;

import static com.codeborne.selenide.Selenide.open;

public class TemplateSteps {
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static VerificationPage verificationPage;

    @Пусть("открыта страница с формой авторизации {string},")
    public void openAuthPage(String url) {
        loginPage = Selenide.open(url, LoginPage.class);
    }

    @Когда("пользователь залогинен с именем {string} и паролем {string},")
    public void openMainPage(String login, String password) {
       verificationPage = loginPage.validLogin(login, password);
    }

    @Затем("пользователь вводит верный пароль из смс {string} открывается страница с его картами,")
    public void setValidCode(String code) {
        dashboardPage = verificationPage.validVerify(code);
    }

    @И("пользователь переводит {int} рублей с карты с номером {string} на свою {int} карту с главной страницы,")
    public void replenishment(int amount, String numberCard, int id) {
        dashboardPage.replenish(id).transfer(amount, numberCard);
    }

    @Тогда("баланс его {int} карты из списка на главной странице должен стать {int} рублей.")
    public void dashboardCheckBalance(int id, int amount) {
        int actualBalance = dashboardPage.getActualBalance(id);
        Assertions.assertEquals(amount, actualBalance);
    }
}


