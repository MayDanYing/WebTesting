package ru.geekbrains.lesson5;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
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

public class Test02 {
    private final String MAIN_PAGE = "https://meduza.io/";
    private final String PAGE_PODCASTS = "https://meduza.io/podcasts";
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
    public void confirmURL()
    {
        driver.get(PAGE_PODCASTS);
        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://meduza.io/podcasts";
        Assert.assertEquals(actualURL, expectedURL);
        System.out.println("URL is identical");
    }

    @Test
    public void confirmElementsExistence()
    {
        String expectedName = "a";
        By linkMain = By.cssSelector("a[href*='/podcasts']");
        Assert.assertTrue(driver.findElement(linkMain).isDisplayed());
        Assert.assertEquals(expectedName,driver.findElement(linkMain).getTagName());
    }

    @Test /// Тест-кейс №2 Успешное воспроизведение аудио-файлов из рубрики "Подкасты"
    public void playPodcast() {

        Actions actions = new Actions(driver);

        // 2. Перейти на вкладку Подкасты в шапке страницы
        WebElement linkToPodcasts = driver.findElement(By.cssSelector("a[href*='/podcasts']"));
        actions.moveToElement(linkToPodcasts).click().build().perform();

        // 3. Выбрать первую по списку страницу из рубрики Подкасты, содержащую аудиофайл с подкастом.
        By byArticle = By.cssSelector("a[href='/podcasts/meduza-v-kurse']");
        WebElement article = driver.findElement(byArticle);
        Assert.assertTrue(driver.findElement(byArticle).isDisplayed());
        actions.moveToElement(article).click().build().perform();

        // 4.Открываем страницу
        By byArticleOne = By.cssSelector("a[href='/episodes/2020/11/13/delo-kalvi-stalo-dlya-rossiyskogo-biznesa-chem-to-vrode-dela-golunova-kazhetsya-ono-blizitsya-k-kontsu-no-lish-dva-goda-spustya-i-s-menee-optimistichnym-finalom']");
        WebElement articleOne = driver.findElement(byArticleOne);
        Assert.assertTrue(driver.findElement(byArticleOne).isDisplayed());
        actions.moveToElement(articleOne).click().build().perform();

        //5.Нажмем на кнопку воспроизведения
        By byAudio = By.cssSelector("button[class*='PlayButton-root PlayButton-isInAudioPanel']");
        WebElement audio = driver.findElement(byAudio);
        Assert.assertTrue(driver.findElement(byAudio).isDisplayed());
        actions.moveToElement(audio).click().build().perform();
        actions.pause(5000).build().perform();
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
