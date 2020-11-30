package ru.geekbrains.lesson7.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.lesson6.base.BaseView;

//Page для Тест-кейса №4 Успешный запуск игры из рубрики "Игры"
public class GamesPage extends BaseView {
    private WebDriver driver;

    //Вкладка ИГРЫ в шапке страницы
    @FindBy(css = "a[href*='/games']")
    private WebElement linkGames;

    //Выбор игры
    @FindBy(css = "a[href='/games/schitannye-ili-schitanye-sekundy-ranenyy-v-plecho-ili-ranennyy-v-plecho-test-po-odnomu-iz-samyh-slozhnyh-pravil-russkogo-yazyka-n-ili-nn']")
    private WebElement gameOne;

    // 4. Нажать на кнопку "Начать игру"
    @FindBy(xpath = ".//button[@class='Button-module_root__RpsiW Button-module_default__28Vo_ Button-module_gold__ZMYg- ']")
    private WebElement button;

    public GamesPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // 2. Перейти на вкладку ИГРЫ в шапке страницы
    @Step(value = "Open Games page")
    public GamesPage openGamesLink() {
        linkGames.click();
        return this;
    }

    // 3. Выбрать страницу с игрой
    @Step(value = "Choose specific game")
    public GamesPage chooseGame() {
        Actions actions = new Actions(driver);
        actions.moveToElement(gameOne).click().build().perform();
        //gameOne.click();
        return this;
    }

    // 4. Нажать на кнопку "Начать игру"
    @Step(value = "Press button to start a game")
    public GamesPage startGame() {
        Actions actions = new Actions(driver);
        actions.moveToElement(button).click().build().perform();
        return this;
    }
}
