package ru.geekbrains.lesson7;

import io.qameta.allure.Attachment;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
//import ru.geekbrains.lesson6.helper.ScreenshotMaker;
import ru.geekbrains.lesson6.pages.AuthorizationPage;

@Feature("Тест-кейс №3 Успешный ввод почтового адреса в поле авторизации")
public class Test03_authorization extends BaseTest {

    @Test
    public void makeAuthorization() {
        new AuthorizationPage(driver)
                .openLink()
                .enterEmail()
                .confirmEntry();

     //   ScreenshotMaker.makeScreenshot(driver, "authorization.jpg");
       saveScreenshot();


    }
    @Attachment(value = "Page screenshot", type = "image/png")
    public void saveScreenshot() {
      //  ScreenshotMaker.makeScreenshot(driver, "authorization.jpg" );

    }
}
