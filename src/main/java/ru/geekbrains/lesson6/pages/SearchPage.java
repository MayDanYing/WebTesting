package ru.geekbrains.lesson6.pages;
//import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.lesson6.base.BaseView;

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
    public SearchPage searchEl() {
        searchElement.click();
        return this;
    }

    // 3. Ввести любое слово или сочетание слов(через пробел)(В нашем случае вводим "Джо Байден")
    public SearchPage searchBx() {
        searchBox.sendKeys(SEQUENCE);
        searchBox.sendKeys(Keys.ENTER);
        return this;
    }

    // 4. Закрыть поисковую строку нажав на крестик в правом верхнем углу страницы
    public SearchPage closeBx() {
        searchElement.click();
        return this;
    }

}




