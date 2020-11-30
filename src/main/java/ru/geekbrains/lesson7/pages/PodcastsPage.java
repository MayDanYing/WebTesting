package ru.geekbrains.lesson7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.lesson6.base.BaseView;

// Page для Тест-кейса №2 Успешное воспроизведение аудио-файлов из рубрики "Подкасты"
public class PodcastsPage extends BaseView {

    private WebDriver driver;

    //вкладка Подкасты в шапке страницы
    @FindBy(css = "a[href*='/podcasts']")
    private WebElement linkToPodcasts;

    //тема с подкастами "Что случилось"
    @FindBy(css = "a[href='/podcasts/meduza-v-kurse']")
    private WebElement topic;

    //подкаст
    @FindBy(css = "a[href='/episodes/2020/11/13/delo-kalvi-stalo-dlya-rossiyskogo-biznesa-chem-to-vrode-dela-golunova-kazhetsya-ono-blizitsya-k-kontsu-no-lish-dva-goda-spustya-i-s-menee-optimistichnym-finalom']")
    private WebElement articleOne;

    //кнопка воспроизведения
    @FindBy(css = "button[class*='PlayButton-root PlayButton-isInAudioPanel']")
    private WebElement audioButton;


    public PodcastsPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // 2. Перейти на вкладку Подкасты в шапке страницы
    @Step(value = "Open page with Podcasts")
    public PodcastsPage openPodcasts() {
        linkToPodcasts.click();
        return this;
    }

    //3. Открыть тему с подкастами "Что случилось"
    @Step(value = "Open topic on a specific theme")
    public PodcastsPage openTopic() {
        topic.click();
        return this;
    }

    // 4. Выбрать первую по списку страницу из рубрики Подкасты, содержащую аудиофайл с подкастом.
    @Step(value = "Choose an article")
    public PodcastsPage chooseArticle() {
        Actions actions = new Actions(driver);
        actions.moveToElement(articleOne).click().build().perform();
         return this;
    }

    // 5. Нажмем на кнопку воспроизведения
    @Step(value = "Press the buttoon to start podcast")
    public PodcastsPage clickButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(audioButton).click().build().perform();
        return this;
    }


}

