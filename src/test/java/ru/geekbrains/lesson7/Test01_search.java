package ru.geekbrains.lesson7;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson6.pages.SearchPage;

@Feature("Тест-кейс №1 Успешный поиск статей по ключевым словам")
public class Test01_search extends BaseTest {

    @Test
    public void searchSomeSequence() {
        new SearchPage(driver)
                .searchEl()
                .searchBx()
                .closeBx();

    }

}
