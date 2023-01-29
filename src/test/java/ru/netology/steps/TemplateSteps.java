package ru.netology.steps;

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

    @Пусть("пользователь залогинен с именем {string} и паролем {string},")
    public void openMainPage(String login, String password) {
        open("http://localhost:9999");
        var MainPage = new DashboardPage().MainPage();
    }
    @Когда("пользователь переводит 5 000 рублей с карты с номером {string} на свою 1 карту с главной страницы,")
    public void replenishment(String numberCard) {
        var Replenish = new DashboardPage().replenishCard0001().transfer0001(5000, numberCard);
    }
    @Тогда("баланс его 1 карты из списка на главной странице должен стать 15000 рублей.")
    public void dashboardCheckBalance() {
        var CheckBalance = new DashboardPage();
        int actualBalanceCard0001 = CheckBalance.getCardBalance("0001");
        Assertions.assertEquals(15000, actualBalanceCard0001);
    }
}

