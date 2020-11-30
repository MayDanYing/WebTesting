package ru.geekbrains.lesson6;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson6.pages.AuthorizationPage;

@Feature("Тест-кейс №3 Успешный ввод почтового адреса в поле авторизации")
public class Test03_authorization extends BaseTest {

    @Test
    public void makeAuthorization() {
        new AuthorizationPage(driver)
                .openLink()
                .enterEmail()
                .confirmEntry();


    }

}
