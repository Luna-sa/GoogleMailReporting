package com.lunasa.pages.PageObject;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WebDriverSingleton;
import reporting.MyLogger;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractPage {
    private static final int DEFAULT_TIMEOUT = 10;
    private static final String SCREENSHOTS_NAME_TPL = "screenshots/scr";
    protected WebDriver driver;

    protected AbstractPage() {
        this.driver = WebDriverSingleton.getWebDriverInstance();
    }

    public void open(String url) {
        MyLogger.info("Going to URL: " + url);
        driver.get(url);
    }

    public void type(final By locator, String text) {

//        driver.findElement(locator).sendKeys(text);
        waitForElementVisible(locator);
        highlightElement(locator);
        MyLogger.info("Typing text '" + text + "' to input form '" + driver.findElement(locator).getAttribute("name") + "' (Located: " + locator + ")");
        driver.findElement(locator).sendKeys(text);
        takeScreenshot();
        unHighlightElement(locator);
    }

    public void click(final By locator) {
        driver.findElement(locator).click();
    }

    public void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
    }


    protected void waitToBeClickable(By locator) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void waitForTitleContains(String string) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains(string));
    }

    protected void waitForElementEnabled(By locator) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementVisible(By locator) {
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    protected void findElement(By locator) {
        new WebDriverWait(driver, 10);
        driver.findElement(locator);
    }

    public void highlightElement(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='5px solid green'", driver.findElement(locator));
    }

    public void unHighlightElement(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", driver.findElement(locator));
    }

    public boolean isElementDisplayed(By locator) {
        boolean succeed = driver.findElements(locator).size() > 0;
        if (succeed) {
//            System.out.println("Element " + driver.findElement(locator).getText() + " is present.");
            MyLogger.info("Clicking element '" + driver.findElement(locator).getText() + "' (Located: " + locator + ")");
            highlightElement(locator);
            takeScreenshot();
            unHighlightElement(locator);
        } else // System.out.println("Element " + driver.findElement(locator).getText() + " is not present.");
        MyLogger.info("Element " + driver.findElement(locator).getText() + " is not present.");
        return succeed;
    }

    public void takeScreenshot() {
        WebDriver driver = WebDriverSingleton.getWebDriverInstance();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            String screenshotName = SCREENSHOTS_NAME_TPL + System.nanoTime();
            File copy = new File(screenshotName + ".png");
            FileUtils.copyFile(screenshot, copy);
//            System.out.println("Saved screenshot: " + screenshotName);
            MyLogger.info("Saved screenshot: " + screenshotName);
        } catch (IOException e) {
//            System.out.println("Failed to make screenshot");
            MyLogger.error("Failed to make screenshot");
        }
    }


//    public By selectSeveralElements(List<By> locators) {
//        Actions action = new Actions(driver);
//        action.keyDown(Keys.CONTROL);
//        WebElement element;
//        for (By locator : locators) {
//            waitForElementVisible(locator);
//            highlightElement(locator);
//            System.out.println("Clicking element '" + driver.findElement(locator).getText() + "' (Located: " + locator + ")");
//            element = driver.findElement(locator);
//            action.moveToElement(element).click();
//        }
//        takeScreenshot();
//        action.keyUp(Keys.CONTROL).perform();
//        return locators.get(0);
//    }

    public static void kill() {
        WebDriverSingleton.getWebDriverInstance().quit();
    }

}
