package com.lunasa.gmail;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserPF {
    private static final int PAGE_LOAD_DEFAULT_TIMEOUT_SECONDS = 15;
    private static final int COMMAND_DEFAULT_TIMEOUT_SECONDS = 10;
    private static final int WAIT_ELEMENT_TIMEOUT = 10;
    private static final String SCREENSHOTS_NAME_TPL = "screenshots/scr";
    private WebDriver driver;
    private static BrowserPF instance = null;

    private BrowserPF(WebDriver driver) {
        this.driver = driver;
    }

    public static BrowserPF getInstance() {
        if (instance != null) {
            return instance;
        }
        return instance = init();
    }

    private static BrowserPF init() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), DesiredCapabilities.chrome());
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(COMMAND_DEFAULT_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return new BrowserPF(driver);
    }

    public void open(String url) {
        System.out.println("Going to URL: " + url);
        driver.get(url);
    }

    public static void kill() {
        if (instance != null) {
            try {
                instance.driver.quit();
            } finally {
                instance = null;
            }
        }
    }

    public void waitForElementPresent(By locator) {
        new WebDriverWait(driver, WAIT_ELEMENT_TIMEOUT).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
    }

    public void waitForElementEnabled(By locator) {
        new WebDriverWait(driver, WAIT_ELEMENT_TIMEOUT).until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementVisible(By locator) {
        new WebDriverWait(driver, WAIT_ELEMENT_TIMEOUT).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public void highlightElement(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='5px solid green'", driver.findElement(locator));
    }

    public void unHighlightElement(By locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.border='0px'", driver.findElement(locator));
    }

    public void click(final By locator) {
        waitForElementVisible(locator);
        System.out.println("Clicking element '" + driver.findElement(locator).getText() + "' (Located: " + locator + ")");
        highlightElement(locator);
        takeScreenshot();
        unHighlightElement(locator);
        driver.findElement(locator).click();
    }

    public void type(final By locator, String text) {
        waitForElementVisible(locator);
        highlightElement(locator);
        System.out.println("Typing text '" + text + "' to input form '" + driver.findElement(locator).getAttribute("name") + "' (Located: " + locator + ")");
        driver.findElement(locator).sendKeys(text);
        takeScreenshot();
        unHighlightElement(locator);
    }

    public void typeInUploadInput(final By locator, String text) {
        highlightElement(locator);
        System.out.println("Typing text '" + text + "' to input form '" + driver.findElement(locator).getAttribute("name") + "' (Located: " + locator + ")");
        driver.findElement(locator).sendKeys(text);
        takeScreenshot();
        driver.findElement(locator).sendKeys(text);
    }

    public String read(final By locator) {
        waitForElementVisible(locator);
        highlightElement(locator);
        System.out.println("Reading text: " + driver.findElement(locator).getText());
        takeScreenshot();
        unHighlightElement(locator);
        return driver.findElement(locator).getText();
    }

    public void dragAndDrop(final By locator, final By targetLocator) {
        waitForElementVisible(locator);
        waitForElementVisible(targetLocator);
        WebElement element = driver.findElement(locator);
        WebElement target = driver.findElement(targetLocator);
        takeScreenshot();
        System.out.println("Dragging element '" + driver.findElement(locator).getText() + "' (Located: " + locator + ")" +
                "to '" + driver.findElement(targetLocator).getText() + "' (Located: " + targetLocator + ")");
        (new Actions(driver)).dragAndDrop(element, target).perform();
    }

    public By selectSeveralElements(List<By> locators) {
        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL);
        WebElement element;
        for (By locator : locators) {
            waitForElementVisible(locator);
            highlightElement(locator);
            System.out.println("Clicking element '" + driver.findElement(locator).getText() + "' (Located: " + locator + ")");
            element = driver.findElement(locator);
            action.moveToElement(element).click();
        }
        takeScreenshot();
        action.keyUp(Keys.CONTROL).perform();
        return locators.get(0);
    }

    public boolean isDisplayed(By locator) {
        boolean succeed = driver.findElements(locator).size() > 0;
        if (succeed) {
            System.out.println("Element " + driver.findElement(locator).getText() + " is present.");
            highlightElement(locator);
            takeScreenshot();
            unHighlightElement(locator);
        } else System.out.println("Element " + driver.findElement(locator).getText() + " is not present.");
        return succeed;
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void takeScreenshot() {
//        WebDriver driver = WebDriverSingleton.getWebDriverInstance();
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
//            String screenshotName = SCREENSHOTS_NAME_TPL + System.nanoTime();
//            File copy = new File(screenshotName + ".png");
//            FileUtils.copyFile(screenshot, copy);
//            System.out.println("Saved screenshot: " + screenshotName);
//        } catch (IOException e) {
//            System.out.println("Failed to make screenshot");
//        }
    }
}
