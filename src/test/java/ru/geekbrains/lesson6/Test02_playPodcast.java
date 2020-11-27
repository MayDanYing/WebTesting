package ru.geekbrains.lesson6;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.geekbrains.lesson6.pages.PodcastsPage;

public class Test02_playPodcast extends BaseTest {

    @Test // Тест-кейс №2 Успешное воспроизведение аудио-файлов из рубрики "Подкасты"
    public void playPodcast() {
        new PodcastsPage(driver)
                .openPodcasts()
                .openTopic()
                .chooseArticle()
                .clickButton();

    }

    //simple test
    @Test
    public void confirmElementsExistence()
    {
        String expectedName = "a";
        By linkMain = By.cssSelector("a[href*='/podcasts']");
        Assert.assertTrue(driver.findElement(linkMain).isDisplayed());
        Assert.assertEquals(expectedName,driver.findElement(linkMain).getTagName());
    }


}
