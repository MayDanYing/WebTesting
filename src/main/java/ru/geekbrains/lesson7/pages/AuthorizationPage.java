package ru.geekbrains.lesson7.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.geekbrains.lesson6.base.BaseView;

// Page для Тест-кейса №3 Успешный ввод почтового адреса в поле авторизации
    public class AuthorizationPage extends BaseView {

    private final String EMAIL = "disaj19744@ummoh.com";
    private WebDriver driver;

    //вкладка "Войти", расположенную в правом верхнем углу главной страницы
    @FindBy(xpath = ".//button[@class='Header-item Header-itemAuth']")
    private WebElement link;

    //Поле ввода почтового адреса
    @FindBy(xpath = ".//input[@class='FormInput-root FormInput-medium']")
    private WebElement box;

    public AuthorizationPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    //2. Открыть вкладку "Войти", расположенную в правом верхнем углу главной страницы
    @Step(value = "Open link {link} for login")
    public AuthorizationPage openLink() {
        Assert.assertTrue(driver.findElement((By) link).isDisplayed());
        link.click();
        return this;
    }

    //3. Ввести свой почтовый адрес в поле ввода
    @Step(value = "Enter email {EMAIL}")
    public AuthorizationPage enterEmail() {
        Assert.assertTrue(driver.findElement((By) box).isDisplayed());
        box.sendKeys(EMAIL);
        return this;
    }

    //4.Подтвердить ввод. Совершается отправка письма для подтверждения авторизации на указанный почтовый адрес.
    @Step(value = "Confirm entry")
    public AuthorizationPage confirmEntry() {
        box.sendKeys(Keys.ENTER);
        return this;
    }
//    @Step(value ="make screenshot")
//    public AuthorizationPage makeS() {
//
//        String fileName = "screenshot" + System.currentTimeMillis() + ".png";
//        ScreenshotMaker.makeScreenshot(driver, fileName);// saveScreenshot();
//        return this;
//    }

}
