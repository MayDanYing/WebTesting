package ru.geekbrains.lesson7;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson7.helper.ScreenshotMaker;
import ru.geekbrains.lesson7.pages.GamesPage;

@Feature("Тест-кейс №4 Успешный запуск игры из рубрики Игры")
public class Test04_games_lesson7 extends BaseTest_lesson7 {


    @Test
    public void playGame() {
        new GamesPage(driver)
                .openGamesLink()
                .chooseGame()
                .startGame();


        String fileName = "games.png";
        ScreenshotMaker.makeScreenshot(driver, fileName);

    }
   }
