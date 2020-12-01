package ru.geekbrains.lesson7;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson7.helper.ScreenshotMaker;
import ru.geekbrains.lesson7.pages.SearchPage;

@Feature("Тест-кейс №1 Успешный поиск статей по ключевым словам")
public class Test01_search_lesson7 extends BaseTest_lesson7 {

    @Test
    public void searchSomeSequence() {
        new SearchPage(driver)
                .searchEl()
                .searchBx()
                .closeBx();

        String fileName = "search.png";
        ScreenshotMaker.makeScreenshot(driver, fileName);

    }

}
