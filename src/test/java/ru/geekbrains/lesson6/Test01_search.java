package ru.geekbrains.lesson6;

import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson6.pages.SearchPage;

public class Test01_search extends BaseTest  {

    @Test //Тест-кейс №1 Успешный поиск статей по ключевым словам
    public void searchSomeSequence() {
        new SearchPage(driver)
                .searchEl()
                .searchBx()
                .closeBx();

    }

}
