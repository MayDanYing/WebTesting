package ru.geekbrains.lesson5;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Test03 {
    private final String MAIN_PAGE = "https://meduza.io/";
    private final String EMAIL = "disaj19744@ummoh.com";
    private WebDriver driver;

    @BeforeAll
    public static void setUpDr(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void openPage() {
        setUpDriver();
        open();
    }

    @AfterEach
    public void shutDown() {
        if(driver !=null) {
            driver.quit();
        }
    }
    @Test
    public void confirmTitle()
    {
        driver.get(MAIN_PAGE);
        String title = driver.getTitle();
        String expectedTitle = "Новости — Meduza";
        Assert.assertEquals(title, expectedTitle);
        System.out.println("Title is identical");
    }

    @Test
    public void confirmURL()
    {
        driver.get(MAIN_PAGE);
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://meduza.io/";
        Assert.assertEquals(actualURL, expectedURL);
        System.out.println("URL is identical");
    }

    @Test //Тест-кейс №3 Успешный ввод почтового адреса в поле авторизации
    public void authorizationForm() {

        Actions actions = new Actions(driver);

        //2. Открыть вкладку "Войти", расположенную в правом верхнем углу главной страницы
        By byLink = By.xpath(".//button[@class='Header-item Header-itemAuth']");
        WebElement link = driver.findElement(byLink);
        Assert.assertTrue(driver.findElement(byLink).isDisplayed());
        actions.moveToElement(link).click().build().perform();

        //3. Ввести свой почтовый адрес в поле ввода
        By byBox = By.xpath(".//input[@class='FormInput-root FormInput-medium']");
        WebElement box = driver.findElement(byBox);
        Assert.assertTrue(driver.findElement(byBox).isDisplayed());

        //4.Подтвердить ввод. Совершается отправка письма для подтверждения авторизации на указанный почтовый адрес.
        actions.moveToElement(box).sendKeys(EMAIL).sendKeys(Keys.ENTER).build().perform();
    }

    private void open() {

        //1. Перейти на сайт meduza.io
        driver.get(MAIN_PAGE);
    }

    private void setUpDriver() {
        driver  = new ChromeDriver();
        ChromeOptions options= new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
    }

}
