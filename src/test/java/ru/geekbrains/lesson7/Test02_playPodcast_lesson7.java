package ru.geekbrains.lesson7;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import ru.geekbrains.lesson7.helper.ScreenshotMaker;
import ru.geekbrains.lesson7.pages.PodcastsPage;

@Feature("Тест-кейс №2 Успешное воспроизведение аудио-файлов из рубрики Подкасты")
public class Test02_playPodcast_lesson7 extends BaseTest_lesson7 {

    @Test
    public void playPodcast() {
        new PodcastsPage(driver)
                .openPodcasts()
                .openTopic()
                .chooseArticle()
                .clickButton();

        String fileName = "podcast.png";
        ScreenshotMaker.makeScreenshot(driver, fileName);
    }


}
