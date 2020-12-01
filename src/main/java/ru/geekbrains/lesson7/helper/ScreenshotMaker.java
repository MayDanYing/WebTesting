package ru.geekbrains.lesson7.helper;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotMaker {

    @Attachment(type = "image/png")
    public static byte[] makeScreenshot(WebDriver driver, String filename) {
        byte[] temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        //File destination = new File("./target/" + filename);
        return temp;
    }

//    public static void makeScreenshot(WebDriver driver, String filename) {
//        File temp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        File destination = new File("./target/" + filename);
//        try {
//            FileUtils.copyFile(temp, destination);
//        } catch (IOException exception) {
//            exception.printStackTrace();
//        }
//    }

}
