package ru.geekbrains.lesson7;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson6.pages.AuthorizationPage;
import ru.geekbrains.lesson7.helper.ScreenshotMaker;

@Feature("Тест-кейс №3 Успешный ввод почтового адреса в поле авторизации")
public class Test03_authorization extends BaseTest {

    @Test
    public void makeAuthorization() {
        new AuthorizationPage(driver)
                .openLink()
                .enterEmail()
                .confirmEntry();

     //   ScreenshotMaker.makeScreenshot(driver, "authorization.jpg");

        String fileName = "screenshot" + System.currentTimeMillis() + ".png";
        ScreenshotMaker.makeScreenshot(driver, fileName);// saveScreenshot();


    }
//    @Attachment(value = "Page screenshot", type = "image/png")
//    public void saveScreenshot() {
//      //  ScreenshotMaker.makeScreenshot(driver, "authorization.jpg" );
//
//    }
}
