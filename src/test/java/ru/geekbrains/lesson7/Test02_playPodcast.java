package ru.geekbrains.lesson7;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import ru.geekbrains.lesson6.pages.PodcastsPage;

@Feature("Тест-кейс №2 Успешное воспроизведение аудио-файлов из рубрики Подкасты")
public class Test02_playPodcast extends BaseTest {

    @Test
    public void playPodcast() {
        new PodcastsPage(driver)
                .openPodcasts()
                .openTopic()
                .chooseArticle()
                .clickButton();

    }


}
