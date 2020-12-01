package ru.geekbrains.lesson7;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson7.helper.ScreenshotMaker;
import ru.geekbrains.lesson7.pages.AuthorizationPage;

@Feature("Тест-кейс №3 Успешный ввод почтового адреса в поле авторизации")
public class Test03_authorization_lesson7 extends BaseTest_lesson7 {

    @Test
    public void makeAuthorization() {

        new AuthorizationPage(driver)
                .openLink()
                .enterEmail()
                .confirmEntry();

        String fileName = "login.png";
        ScreenshotMaker.makeScreenshot(driver, fileName);
   }
}
