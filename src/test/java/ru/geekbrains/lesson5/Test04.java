//package ru.geekbrains.lesson5;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.junit.Assert;
//import org.junit.jupiter.api.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.PageLoadStrategy;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.interactions.Actions;
//
//import java.util.concurrent.TimeUnit;
//
//public class Test04 {
//    private final String MAIN_PAGE = "https://meduza.io/";
//    private WebDriver driver;
//
//    @BeforeAll
//    public static void setUpDr(){
//        WebDriverManager.chromedriver().setup();
//    }
//
//    @BeforeEach
//    public void openPage() {
//        setUpDriver();
//        open();
//
//    }
//
//    @AfterEach
//    public void shutDown() {
//        if(driver !=null) {
//            driver.quit();
//        }
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
//
//    @Test //Тест-кейс №4 Успешный запуск игры из рубрики "Игры"
//    public void gamesStart() {
//
//        Actions actions = new Actions(driver);
//
//        // 2. Перейти на вкладку ИГРЫ в шапке страницы
//        By byGames = By.cssSelector("a[href='/games']");
//        WebElement games = driver.findElement(byGames);
//        Assert.assertTrue(driver.findElement(byGames).isDisplayed());
//        actions.moveToElement(games).click().build().perform();
//
//        // 3. Выбрать страницу с игрой
//        By byGameOne = By.cssSelector("a[href='/games/sezon-fiksikov-nachalsya-a-mozhet-nachalsya-test-gde-nado-vospitat-gramotnogo-rebenka']");
//        WebElement gameOne = driver.findElement(byGameOne);
//        Assert.assertTrue(driver.findElement(byGameOne).isDisplayed());
//        actions.moveToElement(gameOne).click().build().perform();
//
//        // 4. Нажать на кнопку "Начать игру"
//        By byStart = By.xpath(".//button[@class='Button-module_root__RpsiW Button-module_default__28Vo_ Button-module_gold__ZMYg- ']");
//        WebElement start = driver.findElement(byStart);
//        Assert.assertTrue(driver.findElement(byStart).isDisplayed());
//        actions.moveToElement(start).click().build().perform();
//    }
//
//    private void open() {
//        //1. Перейти на сайт meduza.io
//        driver.get(MAIN_PAGE);
//    }
//
//    private void setUpDriver() {
//        driver  = new ChromeDriver();
//        ChromeOptions options= new ChromeOptions();
//        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
//        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
//    }
//
//}
