package ru.geekbrains.lesson7;

import io.qameta.allure.Feature;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import ru.geekbrains.lesson6.pages.PodcastsPage;

@Feature("Тест-кейс №2 Успешное воспроизведение аудио-файлов из рубрики \"Подкасты\"")
public class Test02_playPodcast extends BaseTest {

    @Test
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
