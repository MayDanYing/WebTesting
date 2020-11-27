package ru.geekbrains.lesson6;

import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson6.pages.AuthorizationPage;

public class Test03_authorization extends BaseTest {

    @Test // Тест-кейс №3 Успешный ввод почтового адреса в поле авторизации
    public void makeAuthorization() {
        new AuthorizationPage(driver)
                .openLink()
                .enterEmail()
                .confirmEntry();

    }
}
