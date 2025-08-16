package ru.netology.web.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private final SelenideElement codeField = $("[data-test-id='code'] input");
    private final SelenideElement verifyButton = $("[data-test-id='action-verify']");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification'] .notification__content");

    public void verificationPageVisibility() {
        codeField.shouldBe(visible);
    }

    public void verifyErrorNotification(String expectedText) {
        errorNotification.shouldHave(exactText(expectedText)).shouldBe(visible);
    }

    public ru.netology.web.pages.DashboardPage validVerify(String verificationCode) {
        verify(verificationCode);
        return new ru.netology.web.pages.DashboardPage();
    }

    public void verify(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();
    }
}