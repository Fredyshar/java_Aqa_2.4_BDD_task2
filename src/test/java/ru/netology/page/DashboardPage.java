package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import lombok.val;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {
    private ElementsCollection cards = $$(".list__item div");
    private final String balanceStart = "баланс: ";
    private final String balanceFinish = " р.";
    private SelenideElement refreshButton = $("[data-test-id='action-reload']"); // кнопка обновить
    private SelenideElement buttonReplenishCard0001 = $$("[data-test-id='action-deposit']").first();
    private SelenideElement buttonReplenishCard0002 = $$("[data-test-id='action-deposit']").last();

    public DashboardPage() {
        $("h1").shouldBe(visible);
    }

    public int getCardBalance(String id) {
        val text = cards.find(text(id)).text();
        return extractBalance(text);
    }

    private int extractBalance(String text) {
        val start = text.indexOf(balanceStart);
        val finish = text.indexOf(balanceFinish);
        val value = text.substring(start + balanceStart.length(), finish);
        return Integer.parseInt(value);
    }

    public DashboardPage dashboardPage() {
        refreshButton.click();
        return new DashboardPage();
    }

    public TransferPage replenish(int index) {
        cards.get(index - 1).$("button").click();
        return new TransferPage();
    }
    public int getActualBalance(int index) {
        val text = cards.get(index - 1).text();
        return extractBalance(text);
    }
}
