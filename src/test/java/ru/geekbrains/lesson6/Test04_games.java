package ru.geekbrains.lesson6;

import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson6.pages.GamesPage;

public class Test04_games extends BaseTest {

    //Тест-кейс №4 Успешный запуск игры из рубрики "Игры"
    @Test
    public void playGame() {
        new GamesPage(driver)
                .openGamesLink()
                .chooseGame()
                .startGame();

    }

}
