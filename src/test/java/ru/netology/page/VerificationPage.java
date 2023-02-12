package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement codeField = $("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private SelenideElement errorMassage = $("[data-test-id='error-notification']");

    public VerificationPage() {
        codeField.shouldBe(visible);
    }

    public void getErrorMassage(String textError) {
        errorMassage
                .shouldHave(Condition.text(textError))
                .shouldBe(visible);
    }

    public DashboardPage validVerify(String code) {
        codeField.setValue(code);
        verifyButton.click();
        return new DashboardPage();
    }

    public void invalidVerify(DataHelper.VerificationCode invalidVerificationCode) {
        codeField.setValue(invalidVerificationCode.getCode());
        verifyButton.click();
    }
}
