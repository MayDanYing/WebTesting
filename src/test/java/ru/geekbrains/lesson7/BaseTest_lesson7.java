package ru.geekbrains.lesson7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest_lesson7 {

    private final String MAIN_PAGE = "https://meduza.io/";
    protected WebDriver driver;

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

//    @Test
//    public void confirmTitle()
//    {
//        driver.get(MAIN_PAGE);
//        String title = driver.getTitle();
//        String expectedTitle = "Новости — Meduza";
//        Assert.assertEquals(title, expectedTitle);
//        System.out.println("Title is identical");
//    }

//    @Test
//    public void confirmURL()
//    {
//        driver.get(MAIN_PAGE);
//        String actualURL = driver.getCurrentUrl();
//        String expectedURL = "https://meduza.io/";
//        Assert.assertEquals(actualURL, expectedURL);
//        System.out.println("URL is identical");
//    }

    private void open() {
        //1. Перейти на сайт meduza.io
        driver.get(MAIN_PAGE);
    }

    private void setUpDriver() {
        ChromeOptions options= new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    }
}
