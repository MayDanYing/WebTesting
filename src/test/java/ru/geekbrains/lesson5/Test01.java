//package ru.geekbrains.lesson5;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.Assert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.PageLoadStrategy;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Actions;
//import java.util.concurrent.TimeUnit;
//
//public class Test01 {
//    private final String MAIN_PAGE = "https://meduza.io/";
//    private WebDriver driver;
//
//    @BeforeAll
//    public static void setUpDr(){
//    WebDriverManager.chromedriver().setup();
//    }
//
//    @BeforeEach
//    public void openPage() {
//    setUpDriver();
//    open();
//    }
//
//    @AfterEach
//    public void shutDown() {
//    if(driver !=null) {
//        driver.quit();
//    }
//    }
//
//    @Test
//    public void confirmTitle()
//    {
//        driver.get(MAIN_PAGE);
//        String title = driver.getTitle();
//        String expectedTitle = "Новости — Meduza";
//        Assert.assertEquals(title, expectedTitle);
//        System.out.println("Title is identical");
//    }
//
//    @Test
//    public void confirmURL()
//    {
//        driver.get(MAIN_PAGE);
//        String actualURL = driver.getCurrentUrl();
//        String expectedURL = "https://meduza.io/";
//        Assert.assertEquals(actualURL, expectedURL);
//        System.out.println("URL is identical");
//    }
//
//    @Test
//    public void confirmElementsExistence()
//    {
//        String expectedName = "button";
//        By searchElement = By.xpath(".//button[@class='Header-item Header-itemSearch']");
//        Assert.assertTrue(driver.findElement(searchElement).isDisplayed());
//        Assert.assertEquals(expectedName,driver.findElement(searchElement).getTagName());
//    }
//
//    @Test //Тест-кейс №1 Успешный поиск статей по ключевым словам
//    public void searchIconTest() {
//
//    Actions actions = new Actions(driver);
//
//    // 2. Нажать на значок лупы, расположенный в правом верхнем углу главной страницы
//    By bySearchElement = By.xpath(".//button[@class='Header-item Header-itemSearch']");
//    WebElement searchElement = driver.findElement(bySearchElement);
//    Assert.assertTrue(driver.findElement(bySearchElement).isDisplayed());
//    actions.moveToElement(searchElement).click().build().perform();
//
//    //проверяем появилась ли поисковая строка для ввода на странице
//    By bySearchBox = By.xpath(".//input[@class='Search-field']");
//    WebElement searchBox = driver.findElement(bySearchBox);
//    Assert.assertTrue(driver.findElement(bySearchElement).isDisplayed());
//
//    // 3. Ввести любое слово или сочетание слов(через пробел)(В нашем случае вводим "Джо Байден")
//    actions.moveToElement(searchBox).sendKeys("Joe Biden").sendKeys(Keys.ENTER).build().perform();
//
//    // 4. Закрыть поисковую строку нажав на крестик в правом верхнем углу страницы
//    actions.moveToElement(searchElement).click().build().perform();
//
//    //проверяем исчезла ли поисковая строка со страницы
//    Assert.assertTrue(driver.findElements(bySearchBox).size()==0);
//
//}
//
//    private void open() {
//        //1. Перейти на сайт meduza.io
//    driver.get(MAIN_PAGE);
//        }
//
//    private void setUpDriver() {
//        driver  = new ChromeDriver();
//        ChromeOptions options= new ChromeOptions();
//        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
//    }
//
//}
