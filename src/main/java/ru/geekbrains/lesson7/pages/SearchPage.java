package ru.geekbrains.lesson7.pages;
//import org.junit.Assert;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.lesson7.base.BaseView;

// Page для Тест-кейса №1 Успешный поиск статей по ключевым словам
public class SearchPage extends BaseView {

    private static String SEQUENCE = "Joe Biden";
    private WebDriver driver;

    //значок лупы, расположенный в правом верхнем углу главной страницы
    @FindBy(xpath = ".//button[@class='Header-item Header-itemSearch']")
    private WebElement searchElement;

    //поисковая строка для ввода на странице
    @FindBy(xpath = ".//input[@class='Search-field']")
    private WebElement searchBox;

    public SearchPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    // 2. Нажать на значок лупы, расположенный в правом верхнем углу главной страницы
    @Step(value = "Open Search page")
    public SearchPage searchEl() {
      //  String expectedName = "button";
      //  Assert.assertTrue(driver.findElement((By) searchElement).isDisplayed());
      //  Assert.assertEquals(expectedName,driver.findElement((By) searchElement).getTagName());
        searchElement.click();
        return this;
    }

    // 3. Ввести любое слово или сочетание слов(через пробел)(В нашем случае вводим "Джо Байден")
    @Step(value = "Enter sequense {SEQUENCE}")
    public SearchPage searchBx() {
     //   Assert.assertTrue(driver.findElement((By) searchBox).isDisplayed());
        searchBox.sendKeys(SEQUENCE);
        searchBox.sendKeys(Keys.ENTER);
        return this;
    }

    // 4. Закрыть поисковую строку нажав на крестик в правом верхнем углу страницы
    @Step(value = "Close page")
    public SearchPage closeBx() {
        searchElement.click();
        //проверяем исчезла ли поисковая строка со страницы
     //   Assert.assertTrue(driver.findElements((By) searchElement).size()==0);
        return this;
    }

}




