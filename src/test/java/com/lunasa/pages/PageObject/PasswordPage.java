package com.lunasa.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class PasswordPage extends AbstractPage {
    private static final By PASSWORD_LOCATOR = By.name("password");
    private static final By NEXT_BUTTON_LOCATOR = By.id("passwordNext");

    public void enterPassword ()

    {
        //      Enter your password:
        waitToBeClickable(PASSWORD_LOCATOR);
        isElementDisplayed(PASSWORD_LOCATOR);
        type(PASSWORD_LOCATOR,"Rty67ui9");
        implicitlyWait();
        isElementDisplayed(NEXT_BUTTON_LOCATOR);
        waitToBeClickable(NEXT_BUTTON_LOCATOR);
        WebElement passwordNextButton = driver.findElement(NEXT_BUTTON_LOCATOR);
        passwordNextButton.click();
        implicitlyWait();

    }
}
