package ru.geekbrains.lesson6;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson6.pages.GamesPage;

@Feature("Тест-кейс №4 Успешный запуск игры из рубрики \"Игры\"")
public class Test04_games extends BaseTest {


    @Test
    public void playGame() {
        new GamesPage(driver)
                .openGamesLink()
                .chooseGame()
                .startGame();

    }

}
